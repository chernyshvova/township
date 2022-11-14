package com.vungle.warren;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.gms.drive.DriveFile;
import com.vungle.warren.PresentationFactory;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.p037ui.CloseDelegate;
import com.vungle.warren.p037ui.OrientationDelegate;
import com.vungle.warren.p037ui.VungleActivity;
import com.vungle.warren.p037ui.contract.AdContract;
import com.vungle.warren.p037ui.state.BundleOptionsState;
import com.vungle.warren.p037ui.state.OptionsState;
import com.vungle.warren.p037ui.view.FullAdWidget;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AdActivity extends Activity {
    public static final String PRESENTER_STATE = "presenter_state";
    public static final String REQUEST_KEY_EXTRA = "request";
    public static final String TAG = "VungleActivity";
    public static AdContract.AdvertisementPresenter.EventListener bus;
    public BroadcastReceiver broadcastReceiver;
    public PresentationFactory.FullScreenCallback fullscreenCallback = new PresentationFactory.FullScreenCallback() {
        public void onResult(@NonNull Pair<AdContract.AdView, AdContract.AdvertisementPresenter> pair, @Nullable VungleException vungleException) {
            if (vungleException != null) {
                PresentationFactory unused = AdActivity.this.presenterFactory = null;
                AdActivity.this.deliverError(vungleException.getExceptionCode(), AdActivity.this.request);
                AdActivity.this.finish();
                return;
            }
            AdContract.AdvertisementPresenter unused2 = AdActivity.this.presenter = (AdContract.AdvertisementPresenter) pair.second;
            AdActivity.this.presenter.setEventListener(AdActivity.bus);
            AdActivity.this.presenter.attach((AdContract.AdView) pair.first, AdActivity.this.state);
            if (AdActivity.this.pendingStart.getAndSet(false)) {
                AdActivity.this.start();
            }
        }
    };
    public AtomicBoolean pendingStart = new AtomicBoolean(false);
    @Nullable
    public AdContract.AdvertisementPresenter presenter;
    public PresentationFactory presenterFactory;
    public AdRequest request;
    public boolean resumed = false;
    public boolean started = false;
    public OptionsState state;

    private void connectBroadcastReceiver() {
        this.broadcastReceiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                String stringExtra = intent.getStringExtra(AdContract.AdvertisementBus.COMMAND);
                if (((stringExtra.hashCode() == -1884364225 && stringExtra.equals(AdContract.AdvertisementBus.STOP_ALL)) ? (char) 0 : 65535) != 0) {
                    VungleLogger.warn(AdActivity.class.getSimpleName() + "#connectBroadcastReceiver", String.format("Receiving Invalid Broadcast: %1$s", new Object[]{stringExtra}));
                    return;
                }
                AdActivity.this.finish();
            }
        };
        LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(this.broadcastReceiver, new IntentFilter(AdContract.AdvertisementBus.ACTION));
    }

    @NonNull
    public static Intent createIntent(Context context, AdRequest adRequest) {
        Intent intent = new Intent(context, VungleActivity.class);
        intent.addFlags(DriveFile.MODE_READ_ONLY);
        Bundle bundle = new Bundle();
        bundle.putSerializable("request", adRequest);
        intent.putExtras(bundle);
        return intent;
    }

    /* access modifiers changed from: private */
    public void deliverError(int i, AdRequest adRequest) {
        VungleException vungleException = new VungleException(i);
        AdContract.AdvertisementPresenter.EventListener eventListener = bus;
        if (eventListener != null) {
            eventListener.onError(vungleException, adRequest.getPlacementId());
        }
        VungleLogger.error(AdActivity.class.getSimpleName() + "#deliverError", vungleException.getLocalizedMessage());
    }

    @VisibleForTesting
    public static AdContract.AdvertisementPresenter.EventListener getEventListener() {
        return bus;
    }

    @VisibleForTesting
    @Nullable
    public static AdRequest getRequest(@NonNull Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            return (AdRequest) extras.getSerializable("request");
        }
        return null;
    }

    public static void setEventListener(AdContract.AdvertisementPresenter.EventListener eventListener) {
        bus = eventListener;
    }

    /* access modifiers changed from: private */
    public void start() {
        if (this.presenter == null) {
            this.pendingStart.set(true);
        } else if (!this.started && this.resumed && hasWindowFocus()) {
            this.presenter.start();
            this.started = true;
        }
    }

    private void stop() {
        if (this.presenter != null && this.started) {
            this.presenter.stop(isChangingConfigurations() | (isFinishing() ? (char) 2 : 0) ? 1 : 0);
            this.started = false;
        }
        this.pendingStart.set(false);
    }

    public abstract boolean canRotate();

    @SuppressLint({"ResourceType"})
    public void onBackPressed() {
        AdContract.AdvertisementPresenter advertisementPresenter = this.presenter;
        if (advertisementPresenter != null) {
            advertisementPresenter.handleExit();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i = configuration.orientation;
        if (i == 2) {
            Log.d(TAG, "landscape");
        } else if (i == 1) {
            Log.d(TAG, "portrait");
        }
        AdContract.AdvertisementPresenter advertisementPresenter = this.presenter;
        if (advertisementPresenter != null) {
            advertisementPresenter.onViewConfigurationChanged();
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void onCreate(@Nullable Bundle bundle) {
        AdRequest adRequest;
        OptionsState optionsState;
        Bundle bundle2 = bundle;
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(16777216, 16777216);
        this.request = getRequest(getIntent());
        ServiceLocator instance = ServiceLocator.getInstance(this);
        if (!((VungleStaticApi) instance.getService(VungleStaticApi.class)).isInitialized() || bus == null || (adRequest = this.request) == null || TextUtils.isEmpty(adRequest.getPlacementId())) {
            finish();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        VungleLogger.verbose(true, TAG, AdLoader.TT_DOWNLOAD_CONTEXT, String.format("Creating ad, request = %1$s, at: %2$d", new Object[]{this.request, Long.valueOf(currentTimeMillis)}));
        try {
            FullAdWidget fullAdWidget = new FullAdWidget(this, getWindow());
            this.presenterFactory = (PresentationFactory) instance.getService(PresentationFactory.class);
            if (bundle2 == null) {
                optionsState = null;
            } else {
                optionsState = (OptionsState) bundle2.getParcelable(PRESENTER_STATE);
            }
            OptionsState optionsState2 = optionsState;
            this.state = optionsState2;
            PresentationFactory presentationFactory = this.presenterFactory;
            AdRequest adRequest2 = this.request;
            C18591 r5 = new CloseDelegate() {
                public void close() {
                    AdActivity.this.finish();
                }
            };
            C18602 r3 = new OrientationDelegate() {
                public void setOrientation(int i) {
                    AdActivity.this.setRequestedOrientation(i);
                }
            };
            PresentationFactory.FullScreenCallback fullScreenCallback = this.fullscreenCallback;
            FullAdWidget fullAdWidget2 = fullAdWidget;
            String str = AdLoader.TT_DOWNLOAD_CONTEXT;
            presentationFactory.getFullScreenPresentation(this, adRequest2, fullAdWidget, optionsState2, r5, r3, bundle, fullScreenCallback);
            setContentView(fullAdWidget2, fullAdWidget2.getLayoutParams());
            connectBroadcastReceiver();
            String str2 = str;
            VungleLogger.verbose(true, TAG, str2, String.format("Ad created, request = %1$s, elapsed time: %2$dms", new Object[]{this.request, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)}));
        } catch (InstantiationException unused) {
            deliverError(10, this.request);
            finish();
        }
    }

    public void onDestroy() {
        LocalBroadcastManager.getInstance(getApplicationContext()).unregisterReceiver(this.broadcastReceiver);
        AdContract.AdvertisementPresenter advertisementPresenter = this.presenter;
        if (advertisementPresenter != null) {
            advertisementPresenter.detach(isChangingConfigurations() | true ? 1 : 0);
        } else {
            PresentationFactory presentationFactory = this.presenterFactory;
            if (presentationFactory != null) {
                presentationFactory.destroy();
                this.presenterFactory = null;
                deliverError(25, this.request);
            }
        }
        super.onDestroy();
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        AdRequest request2 = getRequest(getIntent());
        AdRequest request3 = getRequest(intent);
        String str = null;
        String placementId = request2 != null ? request2.getPlacementId() : null;
        if (request3 != null) {
            str = request3.getPlacementId();
        }
        if (placementId != null && str != null && !placementId.equals(str)) {
            Log.d(TAG, "Tried to play another placement " + str + " while playing " + placementId);
            deliverError(15, request3);
            StringBuilder sb = new StringBuilder();
            sb.append(AdActivity.class.getSimpleName());
            sb.append("#onNewIntent");
            VungleLogger.warn(sb.toString(), String.format("Tried to play another placement %1$s while playing %2$s", new Object[]{str, placementId}));
        }
    }

    public void onPause() {
        super.onPause();
        this.resumed = false;
        stop();
    }

    public void onRestoreInstanceState(Bundle bundle) {
        AdContract.AdvertisementPresenter advertisementPresenter;
        super.onRestoreInstanceState(bundle);
        Log.d(TAG, "onRestoreInstanceState(" + bundle + ")");
        if (bundle != null && (advertisementPresenter = this.presenter) != null) {
            advertisementPresenter.restoreFromSave((OptionsState) bundle.getParcelable(PRESENTER_STATE));
        }
    }

    public void onResume() {
        super.onResume();
        this.resumed = true;
        start();
    }

    public void onSaveInstanceState(Bundle bundle) {
        Log.d(TAG, "onSaveInstanceState");
        BundleOptionsState bundleOptionsState = new BundleOptionsState();
        AdContract.AdvertisementPresenter advertisementPresenter = this.presenter;
        if (advertisementPresenter != null) {
            advertisementPresenter.generateSaveState(bundleOptionsState);
            bundle.putParcelable(PRESENTER_STATE, bundleOptionsState);
        }
        PresentationFactory presentationFactory = this.presenterFactory;
        if (presentationFactory != null) {
            presentationFactory.saveState(bundle);
        }
        super.onSaveInstanceState(bundle);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            start();
        } else {
            stop();
        }
    }

    public void setRequestedOrientation(int i) {
        if (canRotate()) {
            super.setRequestedOrientation(i);
        }
    }
}
