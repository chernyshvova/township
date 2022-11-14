package com.applovin.mediation.adapters;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.adview.AppLovinIncentivizedInterstitial;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.adview.AppLovinRewardedInterstitialAd;
import com.applovin.impl.mediation.MaxRewardImpl;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAd;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdEventListener;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdImpl;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdLoadListener;
import com.applovin.impl.sdk.p025ad.C1064g;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxRewardedInterstitialAdapter;
import com.applovin.mediation.adapter.MaxSignalProvider;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinEventParameters;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.Map;

public class AppLovinMediationAdapter extends MediationAdapterBase implements MaxAdViewAdapter, MaxInterstitialAdapter, MaxRewardedAdapter, MaxRewardedInterstitialAdapter, MaxSignalProvider {
    public AppLovinAdView mLoadedAdView;
    public AppLovinAd mLoadedInterstitialAd;
    public AppLovinAd mLoadedRewardedAd;
    public AppLovinAd mLoadedRewardedInterstitialAd;
    public AppLovinNativeAd mNativeAd;
    public MaxReward mPendingReward;

    public class InterstitialListenerWrapper implements C1064g, AppLovinAdClickListener {
        public final MaxInterstitialAdapterListener listener;

        public InterstitialListenerWrapper(MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
            this.listener = maxInterstitialAdapterListener;
        }

        public void adClicked(AppLovinAd appLovinAd) {
            AppLovinMediationAdapter.this.log("Interstitial ad clicked");
            this.listener.onInterstitialAdClicked();
        }

        public void adDisplayed(AppLovinAd appLovinAd) {
            AppLovinMediationAdapter.this.log("Interstitial ad shown");
            this.listener.onInterstitialAdDisplayed();
        }

        public void adHidden(AppLovinAd appLovinAd) {
            AppLovinMediationAdapter.this.log("Interstitial ad hidden");
            this.listener.onInterstitialAdHidden();
        }

        public void onAdDisplayFailed(String str) {
            AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
            appLovinMediationAdapter.log("Interstitial ad failed to display with error: " + str);
            this.listener.onInterstitialAdDisplayFailed(new MaxAdapterError((int) MaxAdapterError.ERROR_CODE_UNSPECIFIED, str));
        }
    }

    public class MaxAppLovinNativeAd extends MaxNativeAd {
        public MaxAppLovinNativeAd(MaxNativeAd.Builder builder) {
            super(builder);
        }

        public void prepareViewForInteraction(MaxNativeAdView maxNativeAdView) {
            AppLovinNativeAdImpl appLovinNativeAdImpl = (AppLovinNativeAdImpl) AppLovinMediationAdapter.this.mNativeAd;
            if (appLovinNativeAdImpl == null) {
                AppLovinMediationAdapter.this.mo11469e("Failed to register native ad view for interaction. Native ad is null");
                return;
            }
            ArrayList arrayList = new ArrayList(4);
            if (StringUtils.isValidString(getTitle()) && maxNativeAdView.getTitleTextView() != null) {
                arrayList.add(maxNativeAdView.getTitleTextView());
            }
            if (StringUtils.isValidString(getBody()) && maxNativeAdView.getBodyTextView() != null) {
                arrayList.add(maxNativeAdView.getBodyTextView());
            }
            if (StringUtils.isValidString(getCallToAction()) && maxNativeAdView.getCallToActionButton() != null) {
                arrayList.add(maxNativeAdView.getCallToActionButton());
            }
            if (!(getIcon() == null || maxNativeAdView.getIconImageView() == null)) {
                arrayList.add(maxNativeAdView.getIconImageView());
            }
            appLovinNativeAdImpl.registerViewsForInteraction(arrayList);
        }
    }

    public abstract class RewardListenerWrapper implements AppLovinAdRewardListener {
        public boolean isFullyWatched;

        public RewardListenerWrapper() {
        }

        public void userOverQuota(AppLovinAd appLovinAd, Map<String, String> map) {
            AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
            appLovinMediationAdapter.log("User is over quota: " + map);
            MaxReward unused = AppLovinMediationAdapter.this.mPendingReward = null;
        }

        public void userRewardRejected(AppLovinAd appLovinAd, Map<String, String> map) {
            AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
            appLovinMediationAdapter.log("Reward rejected: " + map);
            MaxReward unused = AppLovinMediationAdapter.this.mPendingReward = null;
        }

        public void userRewardVerified(AppLovinAd appLovinAd, Map<String, String> map) {
            String str = map.get("currency");
            String str2 = map.get(AppLovinEventParameters.REVENUE_AMOUNT);
            if (!StringUtils.isValidString(str) || !StringUtils.isValidString(str2)) {
                MaxReward unused = AppLovinMediationAdapter.this.mPendingReward = MaxRewardImpl.createDefault();
            } else {
                int i = 0;
                try {
                    i = (int) Double.parseDouble(str2);
                } catch (NumberFormatException e) {
                    AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                    appLovinMediationAdapter.log("Failed to parse AppLovin reward amount: " + str2, e);
                }
                MaxReward unused2 = AppLovinMediationAdapter.this.mPendingReward = MaxRewardImpl.create(i, str);
            }
            AppLovinMediationAdapter appLovinMediationAdapter2 = AppLovinMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Rewarded verified: ");
            outline24.append(AppLovinMediationAdapter.this.mPendingReward);
            appLovinMediationAdapter2.log(outline24.toString());
        }

        public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
            AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
            appLovinMediationAdapter.log("Reward validation request failed with code: " + i);
            MaxReward unused = AppLovinMediationAdapter.this.mPendingReward = null;
        }
    }

    public class RewardedAdListenerWrapper extends RewardListenerWrapper implements C1064g, AppLovinAdClickListener, AppLovinAdVideoPlaybackListener {
        public final MaxRewardedAdapterListener listener;

        public RewardedAdListenerWrapper(MaxRewardedAdapterListener maxRewardedAdapterListener) {
            super();
            this.listener = maxRewardedAdapterListener;
        }

        public void adClicked(AppLovinAd appLovinAd) {
            AppLovinMediationAdapter.this.log("Rewarded ad clicked");
            this.listener.onRewardedAdClicked();
        }

        public void adDisplayed(AppLovinAd appLovinAd) {
            AppLovinMediationAdapter.this.log("Rewarded ad shown");
            this.listener.onRewardedAdDisplayed();
        }

        public void adHidden(AppLovinAd appLovinAd) {
            if ((this.isFullyWatched && AppLovinMediationAdapter.this.mPendingReward != null) || AppLovinMediationAdapter.this.shouldAlwaysRewardUser()) {
                AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Rewarded user with reward: ");
                outline24.append(AppLovinMediationAdapter.this.mPendingReward);
                appLovinMediationAdapter.log(outline24.toString());
                this.listener.onUserRewarded(AppLovinMediationAdapter.this.mPendingReward);
                MaxReward unused = AppLovinMediationAdapter.this.mPendingReward = null;
            }
            AppLovinMediationAdapter.this.log("Rewarded ad hidden");
            this.listener.onRewardedAdHidden();
        }

        public void onAdDisplayFailed(String str) {
            AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
            appLovinMediationAdapter.log("Rewarded ad failed to display with error: " + str);
            this.listener.onRewardedAdDisplayFailed(new MaxAdapterError((int) MaxAdapterError.ERROR_CODE_UNSPECIFIED, str));
        }

        public void videoPlaybackBegan(AppLovinAd appLovinAd) {
            AppLovinMediationAdapter.this.log("Rewarded ad video started");
            this.listener.onRewardedAdVideoStarted();
        }

        public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
            AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
            appLovinMediationAdapter.log("Rewarded ad video ended at " + d + "% and is fully watched: " + z);
            this.isFullyWatched = z;
            this.listener.onRewardedAdVideoCompleted();
        }
    }

    public class RewardedInterstitialAdListenerWrapper extends RewardListenerWrapper implements C1064g, AppLovinAdClickListener, AppLovinAdVideoPlaybackListener {
        public final MaxRewardedInterstitialAdapterListener listener;

        public RewardedInterstitialAdListenerWrapper(MaxRewardedInterstitialAdapterListener maxRewardedInterstitialAdapterListener) {
            super();
            this.listener = maxRewardedInterstitialAdapterListener;
        }

        public void adClicked(AppLovinAd appLovinAd) {
            AppLovinMediationAdapter.this.log("Rewarded interstitial ad clicked");
            this.listener.onRewardedInterstitialAdClicked();
        }

        public void adDisplayed(AppLovinAd appLovinAd) {
            AppLovinMediationAdapter.this.log("Rewarded interstitial ad shown");
            this.listener.onRewardedInterstitialAdDisplayed();
        }

        public void adHidden(AppLovinAd appLovinAd) {
            if ((this.isFullyWatched && AppLovinMediationAdapter.this.mPendingReward != null) || AppLovinMediationAdapter.this.shouldAlwaysRewardUser()) {
                AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Rewarded interstitial user with reward: ");
                outline24.append(AppLovinMediationAdapter.this.mPendingReward);
                appLovinMediationAdapter.log(outline24.toString());
                this.listener.onUserRewarded(AppLovinMediationAdapter.this.mPendingReward);
                MaxReward unused = AppLovinMediationAdapter.this.mPendingReward = null;
            }
            AppLovinMediationAdapter.this.log("Rewarded interstitial ad hidden");
            this.listener.onRewardedInterstitialAdHidden();
        }

        public void onAdDisplayFailed(String str) {
            AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
            appLovinMediationAdapter.log("Rewarded interstitial ad failed to display with error: " + str);
            this.listener.onRewardedInterstitialAdDisplayFailed(new MaxAdapterError((int) MaxAdapterError.ERROR_CODE_UNSPECIFIED, str));
        }

        public void videoPlaybackBegan(AppLovinAd appLovinAd) {
            AppLovinMediationAdapter.this.log("Rewarded interstitial ad video started");
            this.listener.onRewardedInterstitialAdVideoStarted();
        }

        public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
            AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
            appLovinMediationAdapter.log("Rewarded interstitial ad video ended at " + d + "% and is fully watched: " + z);
            this.isFullyWatched = z;
            this.listener.onRewardedInterstitialAdVideoCompleted();
        }
    }

    public AppLovinMediationAdapter(AppLovinSdk appLovinSdk) {
        super(appLovinSdk);
    }

    /* access modifiers changed from: private */
    public boolean hasRequiredAssets(boolean z, AppLovinNativeAd appLovinNativeAd) {
        return z ? StringUtils.isValidString(appLovinNativeAd.getTitle()) : StringUtils.isValidString(appLovinNativeAd.getTitle()) && StringUtils.isValidString(appLovinNativeAd.getCallToAction());
    }

    private void loadFullscreenAd(String str, MaxAdapterResponseParameters maxAdapterResponseParameters, final MaxAdFormat maxAdFormat, final MaxAdapterListener maxAdapterListener) {
        StringBuilder sb;
        C13292 r0 = new AppLovinAdLoadListener() {
            public void adReceived(AppLovinAd appLovinAd) {
                AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                appLovinMediationAdapter.log(maxAdFormat.getLabel() + " ad loaded");
                MaxAdFormat maxAdFormat = maxAdFormat;
                if (maxAdFormat == MaxAdFormat.INTERSTITIAL) {
                    AppLovinAd unused = AppLovinMediationAdapter.this.mLoadedInterstitialAd = appLovinAd;
                    ((MaxInterstitialAdapterListener) maxAdapterListener).onInterstitialAdLoaded();
                } else if (maxAdFormat == MaxAdFormat.REWARDED) {
                    AppLovinAd unused2 = AppLovinMediationAdapter.this.mLoadedRewardedAd = appLovinAd;
                    ((MaxRewardedAdapterListener) maxAdapterListener).onRewardedAdLoaded();
                } else if (maxAdFormat == MaxAdFormat.REWARDED_INTERSTITIAL) {
                    AppLovinAd unused3 = AppLovinMediationAdapter.this.mLoadedRewardedInterstitialAd = appLovinAd;
                    ((MaxRewardedInterstitialAdapterListener) maxAdapterListener).onRewardedInterstitialAdLoaded();
                } else {
                    throw new IllegalStateException("Non-fullscreen ad loaded for fullscreen ad adapter");
                }
            }

            public void failedToReceiveAd(int i) {
                AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                appLovinMediationAdapter.log(maxAdFormat.getLabel() + " ad failed to load with error code: " + i);
                MaxAdFormat maxAdFormat = maxAdFormat;
                if (maxAdFormat == MaxAdFormat.INTERSTITIAL) {
                    ((MaxInterstitialAdapterListener) maxAdapterListener).onInterstitialAdLoadFailed(AppLovinMediationAdapter.toMaxError(i));
                } else if (maxAdFormat == MaxAdFormat.REWARDED) {
                    ((MaxRewardedAdapterListener) maxAdapterListener).onRewardedAdLoadFailed(AppLovinMediationAdapter.toMaxError(i));
                } else if (maxAdFormat == MaxAdFormat.REWARDED_INTERSTITIAL) {
                    ((MaxRewardedInterstitialAdapterListener) maxAdapterListener).onRewardedInterstitialAdLoadFailed(AppLovinMediationAdapter.toMaxError(i));
                } else {
                    throw new IllegalStateException("Non-fullscreen ad failed to load for fullscreen ad adapter");
                }
            }
        };
        if (StringUtils.isValidString(maxAdapterResponseParameters.getBidResponse())) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Loading bidding ");
            outline24.append(maxAdFormat.getLabel());
            outline24.append(" ad...");
            log(outline24.toString());
            getWrappingSdk().getAdService().loadNextAdForAdToken(maxAdapterResponseParameters.getBidResponse(), r0);
            return;
        }
        if (StringUtils.isValidString(maxAdapterResponseParameters.getThirdPartyAdPlacementId())) {
            str = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
            sb = GeneratedOutlineSupport.outline24("Loading mediated ");
            sb.append(maxAdFormat.getLabel());
            sb.append(" ad: ");
            sb.append(str);
            sb.append("...");
        } else {
            sb = GeneratedOutlineSupport.outline24("Loading mediated ");
            sb.append(maxAdFormat.getLabel());
            sb.append(" ad...");
        }
        log(sb.toString());
        getWrappingSdk().getAdService().loadNextAdForZoneId(str, r0);
    }

    public static MaxAdapterError toMaxError(int i) {
        int i2 = 204;
        if (i == -1009) {
            i2 = MaxAdapterError.ERROR_CODE_NO_CONNECTION;
        } else if (i != 204) {
            i2 = i == -1 ? MaxAdapterError.ERROR_CODE_INTERNAL_ERROR : i >= 500 ? MaxAdapterError.ERROR_CODE_SERVER_ERROR : MaxAdapterError.ERROR_CODE_UNSPECIFIED;
        }
        return new MaxAdapterError(i2, i);
    }

    public static MaxAdapterError toMaxError(AppLovinAdViewDisplayErrorCode appLovinAdViewDisplayErrorCode) {
        return MaxAdapterError.UNSPECIFIED;
    }

    public void collectSignal(MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, Activity activity, MaxSignalCollectionListener maxSignalCollectionListener) {
        log("Collecting signal...");
        maxSignalCollectionListener.onSignalCollected(getWrappingSdk().getAdService().getBidToken());
    }

    public String getAdapterVersion() {
        return getSdkVersion();
    }

    public String getSdkVersion() {
        return AppLovinSdk.VERSION;
    }

    public void initialize(MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity, MaxAdapter.OnCompletionListener onCompletionListener) {
        onCompletionListener.onCompletion(MaxAdapter.InitializationStatus.DOES_NOT_APPLY, (String) null);
    }

    public void loadAdViewAd(MaxAdapterResponseParameters maxAdapterResponseParameters, final MaxAdFormat maxAdFormat, final Activity activity, final MaxAdViewAdapterListener maxAdViewAdapterListener) {
        C13241 r0 = new AppLovinAdLoadListener() {
            public void adReceived(final AppLovinAd appLovinAd) {
                AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                appLovinMediationAdapter.log(maxAdFormat.getLabel() + " ad loaded");
                AppLovinSdkUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        AppLovinAdView unused = AppLovinMediationAdapter.this.mLoadedAdView = new AppLovinAdView(AppLovinMediationAdapter.this.getWrappingSdk(), appLovinAd.getSize(), (Context) activity);
                        AppLovinMediationAdapter.this.mLoadedAdView.setAdDisplayListener(new AppLovinAdDisplayListener() {
                            public void adDisplayed(AppLovinAd appLovinAd) {
                                AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                                appLovinMediationAdapter.log(maxAdFormat.getLabel() + " ad shown");
                                maxAdViewAdapterListener.onAdViewAdDisplayed();
                            }

                            public void adHidden(AppLovinAd appLovinAd) {
                                AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                                appLovinMediationAdapter.log(maxAdFormat.getLabel() + " ad hidden");
                                maxAdViewAdapterListener.onAdViewAdHidden();
                            }
                        });
                        AppLovinMediationAdapter.this.mLoadedAdView.setAdClickListener(new AppLovinAdClickListener() {
                            public void adClicked(AppLovinAd appLovinAd) {
                                AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                                appLovinMediationAdapter.log(maxAdFormat.getLabel() + " ad clicked");
                                maxAdViewAdapterListener.onAdViewAdClicked();
                            }
                        });
                        AppLovinMediationAdapter.this.mLoadedAdView.setAdViewEventListener(new AppLovinAdViewEventListener() {
                            public void adClosedFullscreen(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
                                AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                                appLovinMediationAdapter.log(maxAdFormat.getLabel() + " ad collapsed");
                                maxAdViewAdapterListener.onAdViewAdCollapsed();
                            }

                            public void adFailedToDisplay(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, AppLovinAdViewDisplayErrorCode appLovinAdViewDisplayErrorCode) {
                                MaxAdapterError access$100 = AppLovinMediationAdapter.toMaxError(appLovinAdViewDisplayErrorCode);
                                AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                                appLovinMediationAdapter.log(maxAdFormat.getLabel() + " ad failed to display with error: " + access$100);
                                maxAdViewAdapterListener.onAdViewAdDisplayFailed(access$100);
                            }

                            public void adLeftApplication(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
                            }

                            public void adOpenedFullscreen(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
                                AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                                appLovinMediationAdapter.log(maxAdFormat.getLabel() + " ad expanded");
                                maxAdViewAdapterListener.onAdViewAdExpanded();
                            }
                        });
                        C13241 r0 = C13241.this;
                        maxAdViewAdapterListener.onAdViewAdLoaded(AppLovinMediationAdapter.this.mLoadedAdView);
                        AppLovinMediationAdapter.this.mLoadedAdView.renderAd(appLovinAd);
                    }
                });
            }

            public void failedToReceiveAd(int i) {
                AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                appLovinMediationAdapter.log(maxAdFormat.getLabel() + " ad failed to load with error code: " + i);
                maxAdViewAdapterListener.onAdViewAdLoadFailed(AppLovinMediationAdapter.toMaxError(i));
            }
        };
        if (StringUtils.isValidString(maxAdapterResponseParameters.getBidResponse())) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Loading bidding ");
            outline24.append(maxAdFormat.getLabel());
            outline24.append(" ad...");
            log(outline24.toString());
            getWrappingSdk().getAdService().loadNextAdForAdToken(maxAdapterResponseParameters.getBidResponse(), r0);
        } else if (StringUtils.isValidString(maxAdapterResponseParameters.getThirdPartyAdPlacementId())) {
            String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
            StringBuilder outline242 = GeneratedOutlineSupport.outline24("Loading mediated ");
            outline242.append(maxAdFormat.getLabel());
            outline242.append(" ad: ");
            outline242.append(thirdPartyAdPlacementId);
            outline242.append("...");
            log(outline242.toString());
            getWrappingSdk().getAdService().loadNextAdForZoneId(thirdPartyAdPlacementId, r0);
        } else {
            AppLovinAdSize appLovinAdSize = null;
            if (maxAdFormat == MaxAdFormat.BANNER) {
                appLovinAdSize = AppLovinAdSize.BANNER;
            } else if (maxAdFormat == MaxAdFormat.MREC) {
                appLovinAdSize = AppLovinAdSize.MREC;
            } else if (maxAdFormat == MaxAdFormat.LEADER) {
                appLovinAdSize = AppLovinAdSize.LEADER;
            }
            if (appLovinAdSize != null) {
                StringBuilder outline243 = GeneratedOutlineSupport.outline24("Loading mediated ");
                outline243.append(maxAdFormat.getLabel());
                outline243.append(" ad...");
                log(outline243.toString());
                getWrappingSdk().getAdService().loadNextAd(appLovinAdSize, r0);
                return;
            }
            log("Failed to load ad for format: " + maxAdFormat);
            maxAdViewAdapterListener.onAdViewAdLoadFailed(MaxAdapterError.INTERNAL_ERROR);
        }
    }

    public void loadInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        loadFullscreenAd("inter_regular", maxAdapterResponseParameters, MaxAdFormat.INTERSTITIAL, maxInterstitialAdapterListener);
    }

    public void loadNativeAd(final MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, final MaxNativeAdAdapterListener maxNativeAdAdapterListener) {
        if (TextUtils.isEmpty(maxAdapterResponseParameters.getBidResponse())) {
            maxNativeAdAdapterListener.onNativeAdLoadFailed(MaxAdapterError.INVALID_CONFIGURATION);
            return;
        }
        mo11468d("Loading bidding native ad...");
        getWrappingSdk().coreSdk.mo11006v().loadNextAdForAdToken(maxAdapterResponseParameters.getBidResponse(), new AppLovinNativeAdLoadListener() {
            public void onNativeAdLoadFailed(int i) {
                AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                appLovinMediationAdapter.mo11468d("Native ad failed to load with error code: " + i);
                maxNativeAdAdapterListener.onNativeAdLoadFailed(AppLovinMediationAdapter.toMaxError(i));
            }

            public void onNativeAdLoaded(AppLovinNativeAd appLovinNativeAd) {
                AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                appLovinMediationAdapter.mo11468d("Native ad loaded: " + appLovinNativeAd);
                if (!AppLovinMediationAdapter.this.hasRequiredAssets(StringUtils.isValidString(BundleUtils.getString("template", "", maxAdapterResponseParameters.getServerParameters())), appLovinNativeAd)) {
                    AppLovinMediationAdapter appLovinMediationAdapter2 = AppLovinMediationAdapter.this;
                    appLovinMediationAdapter2.mo11469e("Native ad does not have required assets: " + appLovinNativeAd);
                    maxNativeAdAdapterListener.onNativeAdLoadFailed(MaxAdapterError.MISSING_REQUIRED_NATIVE_AD_ASSETS);
                    return;
                }
                ((AppLovinNativeAdImpl) appLovinNativeAd).setEventListener(new AppLovinNativeAdEventListener() {
                    public void onNativeAdClicked(AppLovinNativeAd appLovinNativeAd) {
                        AppLovinMediationAdapter.this.mo11468d("Native ad clicked");
                        maxNativeAdAdapterListener.onNativeAdClicked();
                    }
                });
                AppLovinNativeAd unused = AppLovinMediationAdapter.this.mNativeAd = appLovinNativeAd;
                maxNativeAdAdapterListener.onNativeAdLoaded(new MaxAppLovinNativeAd(new MaxNativeAd.Builder().setAdFormat(MaxAdFormat.NATIVE).setTitle(appLovinNativeAd.getTitle()).setBody(appLovinNativeAd.getBody()).setAdvertiser(appLovinNativeAd.getAdvertiser()).setCallToAction(appLovinNativeAd.getCallToAction()).setIcon(new MaxNativeAd.MaxNativeAdImage(appLovinNativeAd.getIconUri())).setMediaView(appLovinNativeAd.getMediaView()).setOptionsView(appLovinNativeAd.getOptionsView())), (Bundle) null);
            }
        });
    }

    public void loadRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        loadFullscreenAd("inter_videoa", maxAdapterResponseParameters, MaxAdFormat.REWARDED, maxRewardedAdapterListener);
    }

    public void loadRewardedInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedInterstitialAdapterListener maxRewardedInterstitialAdapterListener) {
        loadFullscreenAd("inter_autorew", maxAdapterResponseParameters, MaxAdFormat.REWARDED_INTERSTITIAL, maxRewardedInterstitialAdapterListener);
    }

    public void onDestroy() {
        this.mLoadedInterstitialAd = null;
        this.mLoadedRewardedAd = null;
        this.mLoadedRewardedInterstitialAd = null;
        AppLovinAdView appLovinAdView = this.mLoadedAdView;
        if (appLovinAdView != null) {
            appLovinAdView.destroy();
            this.mLoadedAdView = null;
        }
        AppLovinNativeAd appLovinNativeAd = this.mNativeAd;
        if (appLovinNativeAd != null) {
            ((AppLovinNativeAdImpl) appLovinNativeAd).setEventListener((AppLovinNativeAdEventListener) null);
            this.mNativeAd.unregisterViewsForInteraction();
            this.mNativeAd.getMediaView().destroy();
            this.mNativeAd = null;
        }
    }

    public void showInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Showing interstitial: ");
        outline24.append(maxAdapterResponseParameters.getThirdPartyAdPlacementId());
        outline24.append("...");
        log(outline24.toString());
        AppLovinInterstitialAdDialog create = AppLovinInterstitialAd.create(getWrappingSdk(), activity);
        InterstitialListenerWrapper interstitialListenerWrapper = new InterstitialListenerWrapper(maxInterstitialAdapterListener);
        create.setAdDisplayListener(interstitialListenerWrapper);
        create.setAdClickListener(interstitialListenerWrapper);
        create.showAndRender(this.mLoadedInterstitialAd);
    }

    public void showInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Showing interstitial ad view: ");
        outline24.append(maxAdapterResponseParameters.getThirdPartyAdPlacementId());
        outline24.append("...");
        log(outline24.toString());
        AppLovinInterstitialAdDialog create = AppLovinInterstitialAd.create(getWrappingSdk(), activity);
        InterstitialListenerWrapper interstitialListenerWrapper = new InterstitialListenerWrapper(maxInterstitialAdapterListener);
        create.setAdDisplayListener(interstitialListenerWrapper);
        create.setAdClickListener(interstitialListenerWrapper);
        create.showAndRender(this.mLoadedInterstitialAd, viewGroup, lifecycle);
    }

    public void showRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Showing rewarded ad: ");
        outline24.append(maxAdapterResponseParameters.getThirdPartyAdPlacementId());
        outline24.append("...");
        log(outline24.toString());
        configureReward(maxAdapterResponseParameters);
        AppLovinIncentivizedInterstitial create = AppLovinIncentivizedInterstitial.create(getWrappingSdk());
        RewardedAdListenerWrapper rewardedAdListenerWrapper = new RewardedAdListenerWrapper(maxRewardedAdapterListener);
        create.show(this.mLoadedRewardedAd, activity, rewardedAdListenerWrapper, rewardedAdListenerWrapper, rewardedAdListenerWrapper, rewardedAdListenerWrapper);
    }

    public void showRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Showing rewarded ad view: ");
        outline24.append(maxAdapterResponseParameters.getThirdPartyAdPlacementId());
        outline24.append("...");
        log(outline24.toString());
        configureReward(maxAdapterResponseParameters);
        AppLovinIncentivizedInterstitial create = AppLovinIncentivizedInterstitial.create(getWrappingSdk());
        RewardedAdListenerWrapper rewardedAdListenerWrapper = new RewardedAdListenerWrapper(maxRewardedAdapterListener);
        create.show(this.mLoadedRewardedAd, viewGroup, lifecycle, activity, rewardedAdListenerWrapper, rewardedAdListenerWrapper, rewardedAdListenerWrapper, rewardedAdListenerWrapper);
    }

    public void showRewardedInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedInterstitialAdapterListener maxRewardedInterstitialAdapterListener) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Showing rewarded interstitial ad: ");
        outline24.append(maxAdapterResponseParameters.getThirdPartyAdPlacementId());
        outline24.append("...");
        log(outline24.toString());
        RewardedInterstitialAdListenerWrapper rewardedInterstitialAdListenerWrapper = new RewardedInterstitialAdListenerWrapper(maxRewardedInterstitialAdapterListener);
        if (this.mLoadedRewardedInterstitialAd.getType() == AppLovinAdType.AUTO_INCENTIVIZED) {
            configureReward(maxAdapterResponseParameters);
            AppLovinRewardedInterstitialAd appLovinRewardedInterstitialAd = new AppLovinRewardedInterstitialAd(getWrappingSdk());
            appLovinRewardedInterstitialAd.setAdDisplayListener(rewardedInterstitialAdListenerWrapper);
            appLovinRewardedInterstitialAd.setAdClickListener(rewardedInterstitialAdListenerWrapper);
            appLovinRewardedInterstitialAd.setAdVideoPlaybackListener(rewardedInterstitialAdListenerWrapper);
            appLovinRewardedInterstitialAd.show(this.mLoadedRewardedInterstitialAd, activity, rewardedInterstitialAdListenerWrapper);
            return;
        }
        log("Rewarded interstitial is regular interstitial");
        AppLovinInterstitialAdDialog create = AppLovinInterstitialAd.create(getWrappingSdk(), activity);
        create.setAdDisplayListener(rewardedInterstitialAdListenerWrapper);
        create.setAdClickListener(rewardedInterstitialAdListenerWrapper);
        create.setAdVideoPlaybackListener(rewardedInterstitialAdListenerWrapper);
        create.showAndRender(this.mLoadedRewardedInterstitialAd);
    }
}
