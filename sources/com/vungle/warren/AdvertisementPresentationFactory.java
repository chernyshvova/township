package com.vungle.warren;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.vungle.warren.AdConfig;
import com.vungle.warren.PresentationFactory;
import com.vungle.warren.analytics.JobDelegateAnalytics;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.model.Placement;
import com.vungle.warren.omsdk.OMTracker;
import com.vungle.warren.p037ui.CloseDelegate;
import com.vungle.warren.p037ui.JavascriptBridge;
import com.vungle.warren.p037ui.OrientationDelegate;
import com.vungle.warren.p037ui.contract.AdContract;
import com.vungle.warren.p037ui.contract.WebAdContract;
import com.vungle.warren.p037ui.presenter.LocalAdPresenter;
import com.vungle.warren.p037ui.presenter.MRAIDAdPresenter;
import com.vungle.warren.p037ui.state.OptionsState;
import com.vungle.warren.p037ui.view.FullAdWidget;
import com.vungle.warren.p037ui.view.LocalAdView;
import com.vungle.warren.p037ui.view.MRAIDAdView;
import com.vungle.warren.p037ui.view.VungleWebClient;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.tasks.JobRunner;
import com.vungle.warren.utility.HandlerScheduler;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;

public class AdvertisementPresentationFactory implements PresentationFactory {
    public static final String EXTRA_ADVERTISEMENT = "ADV_FACTORY_ADVERTISEMENT";
    public static final String TAG = "AdvertisementPresentationFactory";
    public final AdLoader adLoader;
    public VungleApiClient apiClient;
    public Advertisement currentAdvertisement;
    public final JobRunner jobRunner;
    public final OMTracker.Factory omTrackerFactory;
    public BaseTask.OnModelLoadListener onModelLoadListener = new BaseTask.OnModelLoadListener() {
        public void onLoad(Advertisement advertisement, Placement placement) {
            Advertisement unused = AdvertisementPresentationFactory.this.currentAdvertisement = advertisement;
        }
    };
    public Repository repository;
    public final SessionData sessionData;
    public BaseTask task;
    public final ExecutorService taskExecutor;
    public VungleStaticApi vungleStaticApi;

    public static abstract class BaseTask extends AsyncTask<Void, Void, PresentationResultHolder> {
        public AtomicReference<Advertisement> adRef = new AtomicReference<>();
        public OnModelLoadListener onDataLoadedListener;
        public AtomicReference<Placement> plRef = new AtomicReference<>();
        public final Repository repository;
        public final VungleStaticApi vungleStaticApi;

        public interface OnModelLoadListener {
            void onLoad(Advertisement advertisement, Placement placement);
        }

        public BaseTask(Repository repository2, VungleStaticApi vungleStaticApi2, OnModelLoadListener onModelLoadListener) {
            this.repository = repository2;
            this.vungleStaticApi = vungleStaticApi2;
            this.onDataLoadedListener = onModelLoadListener;
        }

        public void clear() {
            this.onDataLoadedListener = null;
        }

        public Pair<Advertisement, Placement> loadPresentationData(AdRequest adRequest, Bundle bundle) throws VungleException {
            if (!this.vungleStaticApi.isInitialized()) {
                throw new VungleException(9);
            } else if (adRequest == null || TextUtils.isEmpty(adRequest.getPlacementId())) {
                throw new VungleException(10);
            } else {
                Placement placement = this.repository.load(adRequest.getPlacementId(), Placement.class).get();
                if (placement == null) {
                    Log.e(AdvertisementPresentationFactory.TAG, "No Placement for ID");
                    throw new VungleException(13);
                } else if (!placement.isMultipleHBPEnabled() || adRequest.getEventId() != null) {
                    this.plRef.set(placement);
                    Advertisement advertisement = null;
                    if (bundle == null) {
                        advertisement = this.repository.findValidAdvertisementForPlacement(adRequest.getPlacementId(), adRequest.getEventId()).get();
                    } else {
                        String string = bundle.getString(AdvertisementPresentationFactory.EXTRA_ADVERTISEMENT);
                        if (!TextUtils.isEmpty(string)) {
                            advertisement = this.repository.load(string, Advertisement.class).get();
                        }
                    }
                    if (advertisement != null) {
                        this.adRef.set(advertisement);
                        File file = this.repository.getAdvertisementAssetDirectory(advertisement.getId()).get();
                        if (file != null && file.isDirectory()) {
                            return new Pair<>(advertisement, placement);
                        }
                        Log.e(AdvertisementPresentationFactory.TAG, "Advertisement assets dir is missing");
                        throw new VungleException(26);
                    }
                    throw new VungleException(10);
                } else {
                    throw new VungleException(36);
                }
            }
        }

        public void onPostExecute(PresentationResultHolder presentationResultHolder) {
            super.onPostExecute(presentationResultHolder);
            OnModelLoadListener onModelLoadListener = this.onDataLoadedListener;
            if (onModelLoadListener != null) {
                onModelLoadListener.onLoad(this.adRef.get(), this.plRef.get());
            }
        }
    }

    public static class FullScreenPresentationTask extends BaseTask {
        public final AdLoader adLoader;
        public Advertisement advertisement;
        public final VungleApiClient apiClient;
        public final CloseDelegate closeDelegate;
        @SuppressLint({"StaticFieldLeak"})
        public Context context;
        @SuppressLint({"StaticFieldLeak"})
        public FullAdWidget fullAdWidget;
        public final PresentationFactory.FullScreenCallback fullscreenCallback;
        public final JobRunner jobRunner;
        public final OMTracker.Factory omTrackerFactory;
        public final OptionsState optionsState;
        public final OrientationDelegate orientationDelegate;
        public final AdRequest request;
        public final Bundle savedState;
        public final SessionData sessionData;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FullScreenPresentationTask(Context context2, AdLoader adLoader2, AdRequest adRequest, Repository repository, VungleStaticApi vungleStaticApi, JobRunner jobRunner2, VungleApiClient vungleApiClient, SessionData sessionData2, FullAdWidget fullAdWidget2, OptionsState optionsState2, OrientationDelegate orientationDelegate2, CloseDelegate closeDelegate2, PresentationFactory.FullScreenCallback fullScreenCallback, BaseTask.OnModelLoadListener onModelLoadListener, Bundle bundle, OMTracker.Factory factory) {
            super(repository, vungleStaticApi, onModelLoadListener);
            Repository repository2 = repository;
            VungleStaticApi vungleStaticApi2 = vungleStaticApi;
            this.request = adRequest;
            this.fullAdWidget = fullAdWidget2;
            this.optionsState = optionsState2;
            this.context = context2;
            this.fullscreenCallback = fullScreenCallback;
            this.savedState = bundle;
            this.jobRunner = jobRunner2;
            this.apiClient = vungleApiClient;
            this.orientationDelegate = orientationDelegate2;
            this.closeDelegate = closeDelegate2;
            this.adLoader = adLoader2;
            this.sessionData = sessionData2;
            this.omTrackerFactory = factory;
        }

        public void clear() {
            super.clear();
            this.context = null;
            this.fullAdWidget = null;
        }

        public PresentationResultHolder doInBackground(Void... voidArr) {
            try {
                Pair<Advertisement, Placement> loadPresentationData = loadPresentationData(this.request, this.savedState);
                Advertisement advertisement2 = (Advertisement) loadPresentationData.first;
                this.advertisement = advertisement2;
                Placement placement = (Placement) loadPresentationData.second;
                if (!this.adLoader.canRenderAd(advertisement2)) {
                    Log.e(AdvertisementPresentationFactory.TAG, "Advertisement is null or assets are missing");
                    return new PresentationResultHolder(new VungleException(10));
                } else if (placement.getPlacementAdType() != 0) {
                    return new PresentationResultHolder(new VungleException(29));
                } else {
                    JobDelegateAnalytics jobDelegateAnalytics = new JobDelegateAnalytics(this.jobRunner);
                    Cookie cookie = this.repository.load("appId", Cookie.class).get();
                    if (cookie != null && !TextUtils.isEmpty(cookie.getString("appId"))) {
                        cookie.getString("appId");
                    }
                    VungleWebClient vungleWebClient = new VungleWebClient(this.advertisement, placement);
                    File file = this.repository.getAdvertisementAssetDirectory(this.advertisement.getId()).get();
                    if (file == null || !file.isDirectory()) {
                        Log.e(AdvertisementPresentationFactory.TAG, "Advertisement assets dir is missing");
                        return new PresentationResultHolder(new VungleException(26));
                    }
                    int adType = this.advertisement.getAdType();
                    if (adType != 0) {
                        boolean z = true;
                        if (adType != 1) {
                            return new PresentationResultHolder(new VungleException(10));
                        }
                        OMTracker.Factory factory = this.omTrackerFactory;
                        if (!this.apiClient.getOmEnabled() || !this.advertisement.getOmEnabled()) {
                            z = false;
                        }
                        OMTracker make = factory.make(z);
                        vungleWebClient.setWebViewObserver(make);
                        return new PresentationResultHolder(new MRAIDAdView(this.context, this.fullAdWidget, this.orientationDelegate, this.closeDelegate), new MRAIDAdPresenter(this.advertisement, placement, this.repository, new HandlerScheduler(), jobDelegateAnalytics, vungleWebClient, this.optionsState, file, this.sessionData, make, this.request.getImpression()), vungleWebClient);
                    }
                    return new PresentationResultHolder(new LocalAdView(this.context, this.fullAdWidget, this.orientationDelegate, this.closeDelegate), new LocalAdPresenter(this.advertisement, placement, this.repository, new HandlerScheduler(), jobDelegateAnalytics, vungleWebClient, this.optionsState, file, this.sessionData, this.request.getImpression()), vungleWebClient);
                }
            } catch (VungleException e) {
                return new PresentationResultHolder(e);
            }
        }

        public void onPostExecute(PresentationResultHolder presentationResultHolder) {
            super.onPostExecute(presentationResultHolder);
            if (!isCancelled() && this.fullscreenCallback != null) {
                if (presentationResultHolder.exception != null) {
                    Log.e(AdvertisementPresentationFactory.TAG, "Exception on creating presenter", presentationResultHolder.exception);
                    this.fullscreenCallback.onResult(new Pair((Object) null, (Object) null), presentationResultHolder.exception);
                    return;
                }
                this.fullAdWidget.linkWebView(presentationResultHolder.webClient, new JavascriptBridge(presentationResultHolder.advertisementPresenter));
                this.fullscreenCallback.onResult(new Pair(presentationResultHolder.adView, presentationResultHolder.advertisementPresenter), presentationResultHolder.exception);
            }
        }
    }

    public static class NativeViewPresentationTask extends BaseTask {
        public final AdConfig adConfig;
        public final AdLoader adLoader;
        public final VungleApiClient apiClient;
        public final JobRunner jobRunner;
        public final OMTracker.Factory omTrackerFactory;
        public final AdRequest request;
        public final Bundle savedState;
        public final SessionData sessionData;
        public final PresentationFactory.ViewCallback viewCallback;

        public NativeViewPresentationTask(AdRequest adRequest, AdConfig adConfig2, AdLoader adLoader2, Repository repository, VungleStaticApi vungleStaticApi, JobRunner jobRunner2, PresentationFactory.ViewCallback viewCallback2, Bundle bundle, SessionData sessionData2, BaseTask.OnModelLoadListener onModelLoadListener, VungleApiClient vungleApiClient, OMTracker.Factory factory) {
            super(repository, vungleStaticApi, onModelLoadListener);
            this.request = adRequest;
            this.adConfig = adConfig2;
            this.viewCallback = viewCallback2;
            this.savedState = bundle;
            this.jobRunner = jobRunner2;
            this.adLoader = adLoader2;
            this.sessionData = sessionData2;
            this.apiClient = vungleApiClient;
            this.omTrackerFactory = factory;
        }

        public PresentationResultHolder doInBackground(Void... voidArr) {
            try {
                Pair<Advertisement, Placement> loadPresentationData = loadPresentationData(this.request, this.savedState);
                Advertisement advertisement = (Advertisement) loadPresentationData.first;
                boolean z = true;
                if (advertisement.getAdType() != 1) {
                    Log.e(AdvertisementPresentationFactory.TAG, "Invalid Ad Type for Native Ad.");
                    return new PresentationResultHolder(new VungleException(10));
                }
                Placement placement = (Placement) loadPresentationData.second;
                if (!this.adLoader.canPlayAd(advertisement)) {
                    Log.e(AdvertisementPresentationFactory.TAG, "Advertisement is null or assets are missing");
                    return new PresentationResultHolder(new VungleException(10));
                }
                JobDelegateAnalytics jobDelegateAnalytics = new JobDelegateAnalytics(this.jobRunner);
                VungleWebClient vungleWebClient = new VungleWebClient(advertisement, placement);
                File file = this.repository.getAdvertisementAssetDirectory(advertisement.getId()).get();
                if (file == null || !file.isDirectory()) {
                    Log.e(AdvertisementPresentationFactory.TAG, "Advertisement assets dir is missing");
                    return new PresentationResultHolder(new VungleException(26));
                } else if ("mrec".equals(advertisement.getTemplateType()) && this.adConfig.getAdSize() != AdConfig.AdSize.VUNGLE_MREC) {
                    Log.e(AdvertisementPresentationFactory.TAG, "Corresponding AdConfig#setAdSize must be passed for the type/size of native ad");
                    return new PresentationResultHolder(new VungleException(28));
                } else if (placement.getPlacementAdType() == 0) {
                    return new PresentationResultHolder(new VungleException(10));
                } else {
                    advertisement.configure(this.adConfig);
                    try {
                        this.repository.save(advertisement);
                        OMTracker.Factory factory = this.omTrackerFactory;
                        if (!this.apiClient.getOmEnabled() || !advertisement.getOmEnabled()) {
                            z = false;
                        }
                        OMTracker make = factory.make(z);
                        vungleWebClient.setWebViewObserver(make);
                        return new PresentationResultHolder((AdContract.AdView) null, new MRAIDAdPresenter(advertisement, placement, this.repository, new HandlerScheduler(), jobDelegateAnalytics, vungleWebClient, (OptionsState) null, file, this.sessionData, make, this.request.getImpression()), vungleWebClient);
                    } catch (DatabaseHelper.DBException unused) {
                        return new PresentationResultHolder(new VungleException(26));
                    }
                }
            } catch (VungleException e) {
                return new PresentationResultHolder(e);
            }
        }

        public void onPostExecute(PresentationResultHolder presentationResultHolder) {
            PresentationFactory.ViewCallback viewCallback2;
            super.onPostExecute(presentationResultHolder);
            if (!isCancelled() && (viewCallback2 = this.viewCallback) != null) {
                viewCallback2.onResult(new Pair((WebAdContract.WebAdPresenter) presentationResultHolder.advertisementPresenter, presentationResultHolder.webClient), presentationResultHolder.exception);
            }
        }
    }

    public AdvertisementPresentationFactory(@NonNull AdLoader adLoader2, @NonNull VungleStaticApi vungleStaticApi2, @NonNull Repository repository2, @NonNull VungleApiClient vungleApiClient, @NonNull JobRunner jobRunner2, @NonNull RuntimeValues runtimeValues, @NonNull OMTracker.Factory factory, @NonNull ExecutorService executorService) {
        this.vungleStaticApi = vungleStaticApi2;
        this.repository = repository2;
        this.apiClient = vungleApiClient;
        this.jobRunner = jobRunner2;
        this.adLoader = adLoader2;
        this.sessionData = runtimeValues.sessionData.get();
        this.omTrackerFactory = factory;
        this.taskExecutor = executorService;
    }

    private void cancelTask() {
        BaseTask baseTask = this.task;
        if (baseTask != null) {
            baseTask.cancel(true);
            this.task.clear();
        }
    }

    public void destroy() {
        cancelTask();
    }

    public void getFullScreenPresentation(@NonNull Context context, @NonNull AdRequest adRequest, @NonNull FullAdWidget fullAdWidget, @Nullable OptionsState optionsState, @NonNull CloseDelegate closeDelegate, @NonNull OrientationDelegate orientationDelegate, @Nullable Bundle bundle, @NonNull PresentationFactory.FullScreenCallback fullScreenCallback) {
        cancelTask();
        AdLoader adLoader2 = this.adLoader;
        Repository repository2 = this.repository;
        VungleStaticApi vungleStaticApi2 = this.vungleStaticApi;
        JobRunner jobRunner2 = this.jobRunner;
        VungleApiClient vungleApiClient = this.apiClient;
        SessionData sessionData2 = this.sessionData;
        FullScreenPresentationTask fullScreenPresentationTask = new FullScreenPresentationTask(context, adLoader2, adRequest, repository2, vungleStaticApi2, jobRunner2, vungleApiClient, sessionData2, fullAdWidget, optionsState, orientationDelegate, closeDelegate, fullScreenCallback, this.onModelLoadListener, bundle, this.omTrackerFactory);
        this.task = fullScreenPresentationTask;
        fullScreenPresentationTask.executeOnExecutor(this.taskExecutor, new Void[0]);
    }

    public void getNativeViewPresentation(@NonNull AdRequest adRequest, @Nullable AdConfig adConfig, @NonNull CloseDelegate closeDelegate, @NonNull PresentationFactory.ViewCallback viewCallback) {
        cancelTask();
        NativeViewPresentationTask nativeViewPresentationTask = new NativeViewPresentationTask(adRequest, adConfig, this.adLoader, this.repository, this.vungleStaticApi, this.jobRunner, viewCallback, (Bundle) null, this.sessionData, this.onModelLoadListener, this.apiClient, this.omTrackerFactory);
        this.task = nativeViewPresentationTask;
        nativeViewPresentationTask.executeOnExecutor(this.taskExecutor, new Void[0]);
    }

    public void saveState(Bundle bundle) {
        Advertisement advertisement = this.currentAdvertisement;
        bundle.putString(EXTRA_ADVERTISEMENT, advertisement == null ? null : advertisement.getId());
    }

    public static class PresentationResultHolder {
        public AdContract.AdView adView;
        public AdContract.AdvertisementPresenter advertisementPresenter;
        public VungleException exception;
        public VungleWebClient webClient;

        public PresentationResultHolder(VungleException vungleException) {
            this.exception = vungleException;
        }

        public PresentationResultHolder(AdContract.AdView adView2, AdContract.AdvertisementPresenter advertisementPresenter2, VungleWebClient vungleWebClient) {
            this.adView = adView2;
            this.advertisementPresenter = advertisementPresenter2;
            this.webClient = vungleWebClient;
        }
    }
}
