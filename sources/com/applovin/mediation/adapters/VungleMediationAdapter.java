package com.applovin.mediation.adapters;

import android.app.Activity;
import android.os.Bundle;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxSignalProvider;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkUtils;
import com.vungle.warren.AdConfig;
import com.vungle.warren.BannerAdConfig;
import com.vungle.warren.Banners;
import com.vungle.warren.BuildConfig;
import com.vungle.warren.InitCallback;
import com.vungle.warren.LoadAdCallback;
import com.vungle.warren.PlayAdCallback;
import com.vungle.warren.Plugin;
import com.vungle.warren.Vungle;
import com.vungle.warren.VungleApiClient;
import com.vungle.warren.VungleBanner;
import com.vungle.warren.VungleSettings;
import com.vungle.warren.error.VungleException;
import java.util.concurrent.atomic.AtomicBoolean;

public class VungleMediationAdapter extends MediationAdapterBase implements MaxSignalProvider, MaxInterstitialAdapter, MaxRewardedAdapter, MaxAdViewAdapter {
    public static final AtomicBoolean initialized = new AtomicBoolean();
    public static MaxAdapter.InitializationStatus status;
    public VungleBanner adViewAd;

    public class AdViewAdListener implements PlayAdCallback {
        public final String adFormatLabel;
        public String creativeId;
        public final MaxAdViewAdapterListener listener;

        public AdViewAdListener(String str, MaxAdViewAdapterListener maxAdViewAdapterListener) {
            this.adFormatLabel = str;
            this.listener = maxAdViewAdapterListener;
        }

        public void creativeId(String str) {
            VungleMediationAdapter.this.log(GeneratedOutlineSupport.outline20(new StringBuilder(), this.adFormatLabel, "ad with creative id: ", str, " will be played"));
            this.creativeId = str;
        }

        public void onAdClick(String str) {
            VungleMediationAdapter vungleMediationAdapter = VungleMediationAdapter.this;
            vungleMediationAdapter.log(this.adFormatLabel + " ad clicked");
            this.listener.onAdViewAdClicked();
        }

        public void onAdEnd(String str) {
            VungleMediationAdapter vungleMediationAdapter = VungleMediationAdapter.this;
            vungleMediationAdapter.log(this.adFormatLabel + " ad hidden");
            this.listener.onAdViewAdHidden();
        }

        public void onAdEnd(String str, boolean z, boolean z2) {
        }

        public void onAdLeftApplication(String str) {
            VungleMediationAdapter vungleMediationAdapter = VungleMediationAdapter.this;
            vungleMediationAdapter.log(this.adFormatLabel + " ad left application");
        }

        public void onAdRewarded(String str) {
        }

        public void onAdStart(String str) {
            VungleMediationAdapter vungleMediationAdapter = VungleMediationAdapter.this;
            vungleMediationAdapter.log(this.adFormatLabel + " ad started");
        }

        public void onAdViewed(String str) {
            VungleMediationAdapter vungleMediationAdapter = VungleMediationAdapter.this;
            vungleMediationAdapter.log(this.adFormatLabel + " ad displayed");
            if (AppLovinSdk.VERSION_CODE < 9150000 || !AppLovinSdkUtils.isValidString(this.creativeId)) {
                this.listener.onAdViewAdDisplayed();
                return;
            }
            Bundle bundle = new Bundle(1);
            bundle.putString("creative_id", this.creativeId);
            this.listener.onAdViewAdDisplayed(bundle);
        }

        public void onError(String str, VungleException vungleException) {
            MaxAdapterError access$100 = VungleMediationAdapter.toMaxError(vungleException);
            VungleMediationAdapter vungleMediationAdapter = VungleMediationAdapter.this;
            vungleMediationAdapter.log(this.adFormatLabel + " ad display failed with error: " + access$100);
            this.listener.onAdViewAdDisplayFailed(access$100);
        }
    }

    public class InterstitialAdListener implements PlayAdCallback {
        public String creativeId;
        public final MaxInterstitialAdapterListener listener;

        public InterstitialAdListener(MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
            this.listener = maxInterstitialAdapterListener;
        }

        public void creativeId(String str) {
            VungleMediationAdapter vungleMediationAdapter = VungleMediationAdapter.this;
            vungleMediationAdapter.log("Interstitial ad with creative id: " + str + " will be played");
            this.creativeId = str;
        }

        public void onAdClick(String str) {
            VungleMediationAdapter.this.log("Interstitial ad clicked");
            this.listener.onInterstitialAdClicked();
        }

        public void onAdEnd(String str) {
            VungleMediationAdapter.this.log("Interstitial ad hidden");
            this.listener.onInterstitialAdHidden();
        }

        public void onAdEnd(String str, boolean z, boolean z2) {
        }

        public void onAdLeftApplication(String str) {
            VungleMediationAdapter.this.log("Interstitial ad left application");
        }

        public void onAdRewarded(String str) {
        }

        public void onAdStart(String str) {
            VungleMediationAdapter.this.log("Interstitial ad started");
        }

        public void onAdViewed(String str) {
            VungleMediationAdapter.this.log("Interstitial ad displayed");
            if (AppLovinSdk.VERSION_CODE < 9150000 || !AppLovinSdkUtils.isValidString(this.creativeId)) {
                this.listener.onInterstitialAdDisplayed();
                return;
            }
            Bundle bundle = new Bundle(1);
            bundle.putString("creative_id", this.creativeId);
            this.listener.onInterstitialAdDisplayed(bundle);
        }

        public void onError(String str, VungleException vungleException) {
            MaxAdapterError access$100 = VungleMediationAdapter.toMaxError(vungleException);
            VungleMediationAdapter vungleMediationAdapter = VungleMediationAdapter.this;
            vungleMediationAdapter.log("Interstitial ad failed to display with error: " + access$100);
            this.listener.onInterstitialAdDisplayFailed(access$100);
        }
    }

    public class RewardedAdListener implements PlayAdCallback {
        public String creativeId;
        public boolean hasGrantedReward;
        public final MaxRewardedAdapterListener listener;

        public RewardedAdListener(MaxRewardedAdapterListener maxRewardedAdapterListener) {
            this.listener = maxRewardedAdapterListener;
        }

        public void creativeId(String str) {
            VungleMediationAdapter vungleMediationAdapter = VungleMediationAdapter.this;
            vungleMediationAdapter.log("Rewarded ad with creative id: " + str + " will be played");
            this.creativeId = str;
        }

        public void onAdClick(String str) {
            VungleMediationAdapter.this.log("Rewarded ad clicked");
            this.listener.onRewardedAdClicked();
        }

        public void onAdEnd(String str) {
            VungleMediationAdapter.this.log("Rewarded ad video completed");
            this.listener.onRewardedAdVideoCompleted();
            if (this.hasGrantedReward || VungleMediationAdapter.this.shouldAlwaysRewardUser()) {
                MaxReward reward = VungleMediationAdapter.this.getReward();
                VungleMediationAdapter vungleMediationAdapter = VungleMediationAdapter.this;
                vungleMediationAdapter.log("Rewarded user with reward: " + reward);
                this.listener.onUserRewarded(reward);
            }
            VungleMediationAdapter.this.log("Rewarded ad hidden");
            this.listener.onRewardedAdHidden();
        }

        public void onAdEnd(String str, boolean z, boolean z2) {
        }

        public void onAdLeftApplication(String str) {
            VungleMediationAdapter.this.log("Rewarded ad left application");
        }

        public void onAdRewarded(String str) {
            VungleMediationAdapter.this.log("Rewarded ad user did earn reward");
            this.hasGrantedReward = true;
        }

        public void onAdStart(String str) {
            VungleMediationAdapter.this.log("Rewarded ad started");
        }

        public void onAdViewed(String str) {
            VungleMediationAdapter.this.log("Rewarded ad displayed");
            if (AppLovinSdk.VERSION_CODE < 9150000 || !AppLovinSdkUtils.isValidString(this.creativeId)) {
                this.listener.onRewardedAdDisplayed();
            } else {
                Bundle bundle = new Bundle(1);
                bundle.putString("creative_id", this.creativeId);
                this.listener.onRewardedAdDisplayed(bundle);
            }
            this.listener.onRewardedAdVideoStarted();
        }

        public void onError(String str, VungleException vungleException) {
            MaxAdapterError access$100 = VungleMediationAdapter.toMaxError(vungleException);
            VungleMediationAdapter vungleMediationAdapter = VungleMediationAdapter.this;
            vungleMediationAdapter.log("Rewarded ad failed to display with error: " + access$100);
            this.listener.onRewardedAdDisplayFailed(access$100);
        }
    }

    public VungleMediationAdapter(AppLovinSdk appLovinSdk) {
        super(appLovinSdk);
    }

    private AdConfig createAdConfig(Bundle bundle) {
        AdConfig adConfig = new AdConfig();
        if (bundle.containsKey("ordinal")) {
            adConfig.setOrdinal(bundle.getInt("ordinal"));
        }
        if (bundle.containsKey("immersive_mode")) {
            adConfig.setImmersiveMode(bundle.getBoolean("immersive_mode"));
        }
        if (bundle.containsKey("is_muted")) {
            adConfig.setMuted(bundle.getBoolean("is_muted"));
        }
        return adConfig;
    }

    private Boolean getPrivacySetting(String str, MaxAdapterParameters maxAdapterParameters) {
        try {
            return (Boolean) maxAdapterParameters.getClass().getMethod(str, new Class[0]).invoke(maxAdapterParameters, new Object[0]);
        } catch (Exception e) {
            log("Error getting privacy setting " + str + " with exception: ", e);
            if (AppLovinSdk.VERSION_CODE >= 9140000) {
                return null;
            }
            return Boolean.FALSE;
        }
    }

    private boolean isValidPlacement(MaxAdapterResponseParameters maxAdapterResponseParameters) {
        return Vungle.getValidPlacements().contains(maxAdapterResponseParameters.getThirdPartyAdPlacementId()) || maxAdapterResponseParameters.isTesting();
    }

    private void loadFullscreenAd(MaxAdapterResponseParameters maxAdapterResponseParameters, LoadAdCallback loadAdCallback) {
        AdConfig createAdConfig = createAdConfig(maxAdapterResponseParameters.getServerParameters());
        String bidResponse = maxAdapterResponseParameters.getBidResponse();
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        if (AppLovinSdkUtils.isValidString(bidResponse)) {
            Vungle.loadAd(thirdPartyAdPlacementId, bidResponse, createAdConfig, loadAdCallback);
        } else {
            Vungle.loadAd(thirdPartyAdPlacementId, createAdConfig, loadAdCallback);
        }
    }

    /* access modifiers changed from: private */
    public void showAdViewAd(MaxAdFormat maxAdFormat, BannerAdConfig bannerAdConfig, MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdViewAdapterListener maxAdViewAdapterListener, PlayAdCallback playAdCallback) {
        String bidResponse = maxAdapterResponseParameters.getBidResponse();
        boolean isValidString = AppLovinSdkUtils.isValidString(bidResponse);
        String label = maxAdFormat.getLabel();
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Showing ");
        GeneratedOutlineSupport.outline34(outline24, isValidString ? "bidding " : "", label, " ad for placement: ", thirdPartyAdPlacementId);
        outline24.append("...");
        log(outline24.toString());
        if (isValidString) {
            this.adViewAd = Banners.getBanner(thirdPartyAdPlacementId, bidResponse, bannerAdConfig, playAdCallback);
        } else {
            this.adViewAd = Banners.getBanner(thirdPartyAdPlacementId, bannerAdConfig, playAdCallback);
        }
        if (this.adViewAd != null) {
            log(label + " ad loaded");
            this.adViewAd.setGravity(17);
            maxAdViewAdapterListener.onAdViewAdLoaded(this.adViewAd);
            return;
        }
        MaxAdapterError maxAdapterError = MaxAdapterError.INVALID_LOAD_STATE;
        log(label + " ad failed to load: " + maxAdapterError);
        maxAdViewAdapterListener.onAdViewAdLoadFailed(maxAdapterError);
    }

    private void showFullscreenAd(MaxAdapterResponseParameters maxAdapterResponseParameters, PlayAdCallback playAdCallback) {
        AdConfig createAdConfig = createAdConfig(maxAdapterResponseParameters.getServerParameters());
        String bidResponse = maxAdapterResponseParameters.getBidResponse();
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        if (AppLovinSdkUtils.isValidString(bidResponse)) {
            Vungle.playAd(thirdPartyAdPlacementId, bidResponse, createAdConfig, playAdCallback);
        } else {
            Vungle.playAd(thirdPartyAdPlacementId, createAdConfig, playAdCallback);
        }
    }

    public static MaxAdapterError toMaxError(VungleException vungleException) {
        int exceptionCode = vungleException.getExceptionCode();
        MaxAdapterError maxAdapterError = MaxAdapterError.UNSPECIFIED;
        switch (exceptionCode) {
            case 1:
                maxAdapterError = MaxAdapterError.NO_FILL;
                break;
            case 3:
            case 5:
            case 12:
            case 13:
            case 17:
            case 18:
            case 19:
            case 28:
            case 29:
            case 30:
            case 34:
            case 35:
            case 36:
                maxAdapterError = MaxAdapterError.INVALID_CONFIGURATION;
                break;
            case 4:
            case 37:
                maxAdapterError = MaxAdapterError.AD_EXPIRED;
                break;
            case 6:
            case 7:
            case 9:
            case 16:
                maxAdapterError = MaxAdapterError.NOT_INITIALIZED;
                break;
            case 8:
            case 15:
                maxAdapterError = MaxAdapterError.INVALID_LOAD_STATE;
                break;
            case 10:
            case 25:
                maxAdapterError = MaxAdapterError.INTERNAL_ERROR;
                break;
            case 11:
            case 20:
            case 23:
            case 24:
            case 33:
            case 38:
                maxAdapterError = MaxAdapterError.NO_CONNECTION;
                break;
            case 14:
            case 21:
            case 22:
            case 26:
                maxAdapterError = MaxAdapterError.SERVER_ERROR;
                break;
            case 27:
            case 31:
            case 32:
                maxAdapterError = MaxAdapterError.WEBVIEW_ERROR;
                break;
        }
        return new MaxAdapterError(maxAdapterError.getErrorCode(), maxAdapterError.getErrorMessage(), exceptionCode, vungleException.getLocalizedMessage());
    }

    private void updateUserPrivacySettings(MaxAdapterParameters maxAdapterParameters) {
        Boolean privacySetting;
        Boolean privacySetting2;
        if (getWrappingSdk().getConfiguration().getConsentDialogState() == AppLovinSdkConfiguration.ConsentDialogState.APPLIES && (privacySetting2 = getPrivacySetting("hasUserConsent", maxAdapterParameters)) != null) {
            Vungle.updateConsentStatus(privacySetting2.booleanValue() ? Vungle.Consent.OPTED_IN : Vungle.Consent.OPTED_OUT, "");
        }
        if (AppLovinSdk.VERSION_CODE >= 91100 && (privacySetting = getPrivacySetting("isDoNotSell", maxAdapterParameters)) != null) {
            Vungle.updateCCPAStatus(privacySetting.booleanValue() ? Vungle.Consent.OPTED_OUT : Vungle.Consent.OPTED_IN);
        }
    }

    public static AdConfig.AdSize vungleAdSize(MaxAdFormat maxAdFormat) {
        if (maxAdFormat == MaxAdFormat.BANNER) {
            return AdConfig.AdSize.BANNER;
        }
        if (maxAdFormat == MaxAdFormat.LEADER) {
            return AdConfig.AdSize.BANNER_LEADERBOARD;
        }
        if (maxAdFormat == MaxAdFormat.MREC) {
            return AdConfig.AdSize.VUNGLE_MREC;
        }
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Unsupported ad view ad format: ");
        outline24.append(maxAdFormat.getLabel());
        throw new IllegalArgumentException(outline24.toString());
    }

    public void collectSignal(MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, Activity activity, MaxSignalCollectionListener maxSignalCollectionListener) {
        log("Collecting signal...");
        maxSignalCollectionListener.onSignalCollected(Vungle.getAvailableBidTokens(activity.getApplicationContext()));
    }

    public String getAdapterVersion() {
        return "6.10.3.1";
    }

    public String getSdkVersion() {
        return getVersionString(BuildConfig.class, "VERSION_NAME");
    }

    public void initialize(MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity, final MaxAdapter.OnCompletionListener onCompletionListener) {
        updateUserPrivacySettings(maxAdapterInitializationParameters);
        if (initialized.compareAndSet(false, true)) {
            String string = maxAdapterInitializationParameters.getServerParameters().getString("app_id", (String) null);
            log("Initializing Vungle SDK with app id: " + string + "...");
            status = MaxAdapter.InitializationStatus.INITIALIZING;
            Plugin.addWrapperInfo(VungleApiClient.WrapperFramework.max, getAdapterVersion());
            VungleSettings build = new VungleSettings.Builder().disableBannerRefresh().build();
            Vungle.init(string, activity != null ? activity.getApplicationContext() : getApplicationContext(), (InitCallback) new InitCallback() {
                public void onAutoCacheAdAvailable(String str) {
                    VungleMediationAdapter vungleMediationAdapter = VungleMediationAdapter.this;
                    vungleMediationAdapter.log("Auto-cached ad: " + str);
                }

                public void onError(VungleException vungleException) {
                    VungleMediationAdapter.this.log("Vungle SDK failed to initialize with error: ", vungleException);
                    MaxAdapter.InitializationStatus unused = VungleMediationAdapter.status = MaxAdapter.InitializationStatus.INITIALIZED_FAILURE;
                    onCompletionListener.onCompletion(VungleMediationAdapter.status, vungleException.getLocalizedMessage());
                }

                public void onSuccess() {
                    VungleMediationAdapter.this.log("Vungle SDK initialized");
                    MaxAdapter.InitializationStatus unused = VungleMediationAdapter.status = MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS;
                    onCompletionListener.onCompletion(VungleMediationAdapter.status, (String) null);
                }
            }, build);
            return;
        }
        log("Vungle SDK already initialized");
        onCompletionListener.onCompletion(status, (String) null);
    }

    public void loadAdViewAd(MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, Activity activity, MaxAdViewAdapterListener maxAdViewAdapterListener) {
        MaxAdViewAdapterListener maxAdViewAdapterListener2 = maxAdViewAdapterListener;
        String bidResponse = maxAdapterResponseParameters.getBidResponse();
        boolean isValidString = AppLovinSdkUtils.isValidString(bidResponse);
        final String label = maxAdFormat.getLabel();
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Loading ");
        GeneratedOutlineSupport.outline34(outline24, isValidString ? "bidding " : "", label, " ad for placement: ", thirdPartyAdPlacementId);
        outline24.append("...");
        log(outline24.toString());
        if (!Vungle.isInitialized()) {
            log("Vungle SDK not successfully initialized: failing " + label + " ad load...");
            maxAdViewAdapterListener2.onAdViewAdLoadFailed(MaxAdapterError.NOT_INITIALIZED);
        } else if (!isValidPlacement(maxAdapterResponseParameters)) {
            log(label + " ad failed to load due to an invalid placement id: " + thirdPartyAdPlacementId);
            maxAdViewAdapterListener2.onAdViewAdLoadFailed(MaxAdapterError.INVALID_CONFIGURATION);
        } else {
            final AdViewAdListener adViewAdListener = new AdViewAdListener(label, maxAdViewAdapterListener2);
            BannerAdConfig bannerAdConfig = new BannerAdConfig();
            AdConfig.AdSize vungleAdSize = vungleAdSize(maxAdFormat);
            bannerAdConfig.setAdSize(vungleAdSize);
            Bundle serverParameters = maxAdapterResponseParameters.getServerParameters();
            if (serverParameters.containsKey("is_muted")) {
                bannerAdConfig.setMuted(serverParameters.getBoolean("is_muted"));
            }
            if (isValidString) {
                if (Banners.canPlayAd(thirdPartyAdPlacementId, bidResponse, vungleAdSize)) {
                    showAdViewAd(maxAdFormat, bannerAdConfig, maxAdapterResponseParameters, maxAdViewAdapterListener, adViewAdListener);
                    return;
                }
            } else if (Banners.canPlayAd(thirdPartyAdPlacementId, vungleAdSize)) {
                showAdViewAd(maxAdFormat, bannerAdConfig, maxAdapterResponseParameters, maxAdViewAdapterListener, adViewAdListener);
                return;
            }
            updateUserPrivacySettings(maxAdapterResponseParameters);
            final MaxAdFormat maxAdFormat2 = maxAdFormat;
            final BannerAdConfig bannerAdConfig2 = bannerAdConfig;
            final MaxAdapterResponseParameters maxAdapterResponseParameters2 = maxAdapterResponseParameters;
            final MaxAdViewAdapterListener maxAdViewAdapterListener3 = maxAdViewAdapterListener;
            C13504 r0 = new LoadAdCallback() {
                public void onAdLoad(String str) {
                    VungleMediationAdapter.this.showAdViewAd(maxAdFormat2, bannerAdConfig2, maxAdapterResponseParameters2, maxAdViewAdapterListener3, adViewAdListener);
                }

                public void onError(String str, VungleException vungleException) {
                    MaxAdapterError access$100 = VungleMediationAdapter.toMaxError(vungleException);
                    VungleMediationAdapter vungleMediationAdapter = VungleMediationAdapter.this;
                    StringBuilder sb = new StringBuilder();
                    GeneratedOutlineSupport.outline34(sb, label, " ad for placement ", str, " failed to load with error: ");
                    sb.append(access$100);
                    vungleMediationAdapter.log(sb.toString());
                    maxAdViewAdapterListener3.onAdViewAdLoadFailed(access$100);
                }
            };
            if (isValidString) {
                Banners.loadBanner(thirdPartyAdPlacementId, bidResponse, bannerAdConfig, r0);
            } else {
                Banners.loadBanner(thirdPartyAdPlacementId, bannerAdConfig, (LoadAdCallback) r0);
            }
        }
    }

    public void loadInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, final MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        String bidResponse = maxAdapterResponseParameters.getBidResponse();
        boolean isValidString = AppLovinSdkUtils.isValidString(bidResponse);
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log(GeneratedOutlineSupport.outline20(GeneratedOutlineSupport.outline24("Loading "), isValidString ? "bidding " : "", "interstitial ad for placement: ", thirdPartyAdPlacementId, "..."));
        if (!Vungle.isInitialized()) {
            log("Vungle SDK not successfully initialized: failing interstitial ad load...");
            maxInterstitialAdapterListener.onInterstitialAdLoadFailed(MaxAdapterError.NOT_INITIALIZED);
        } else if (!isValidPlacement(maxAdapterResponseParameters)) {
            log("Interstitial ad failed to load due to an invalid placement id: " + thirdPartyAdPlacementId);
            maxInterstitialAdapterListener.onInterstitialAdLoadFailed(MaxAdapterError.INVALID_CONFIGURATION);
        } else {
            if (isValidString) {
                if (Vungle.canPlayAd(thirdPartyAdPlacementId, bidResponse)) {
                    log("Interstitial ad loaded");
                    maxInterstitialAdapterListener.onInterstitialAdLoaded();
                    return;
                }
            } else if (Vungle.canPlayAd(thirdPartyAdPlacementId)) {
                log("Interstitial ad loaded");
                maxInterstitialAdapterListener.onInterstitialAdLoaded();
                return;
            }
            updateUserPrivacySettings(maxAdapterResponseParameters);
            loadFullscreenAd(maxAdapterResponseParameters, new LoadAdCallback() {
                public void onAdLoad(String str) {
                    VungleMediationAdapter.this.log("Interstitial ad loaded");
                    maxInterstitialAdapterListener.onInterstitialAdLoaded();
                }

                public void onError(String str, VungleException vungleException) {
                    MaxAdapterError access$100 = VungleMediationAdapter.toMaxError(vungleException);
                    VungleMediationAdapter vungleMediationAdapter = VungleMediationAdapter.this;
                    vungleMediationAdapter.log("Interstitial ad for placement " + str + " failed to load with error: " + access$100);
                    maxInterstitialAdapterListener.onInterstitialAdLoadFailed(access$100);
                }
            });
        }
    }

    public void loadRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, final MaxRewardedAdapterListener maxRewardedAdapterListener) {
        String bidResponse = maxAdapterResponseParameters.getBidResponse();
        boolean isValidString = AppLovinSdkUtils.isValidString(bidResponse);
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log(GeneratedOutlineSupport.outline20(GeneratedOutlineSupport.outline24("Loading "), isValidString ? "bidding " : "", "rewarded ad for placement: ", thirdPartyAdPlacementId, "..."));
        if (!Vungle.isInitialized()) {
            log("Vungle SDK not successfully initialized: failing rewarded ad load...");
            maxRewardedAdapterListener.onRewardedAdLoadFailed(MaxAdapterError.NOT_INITIALIZED);
        } else if (!isValidPlacement(maxAdapterResponseParameters)) {
            log("Rewarded ad failed to load due to an invalid placement id: " + thirdPartyAdPlacementId);
            maxRewardedAdapterListener.onRewardedAdLoadFailed(MaxAdapterError.INVALID_CONFIGURATION);
        } else {
            if (isValidString) {
                if (Vungle.canPlayAd(thirdPartyAdPlacementId, bidResponse)) {
                    log("Rewarded ad loaded");
                    maxRewardedAdapterListener.onRewardedAdLoaded();
                    return;
                }
            } else if (Vungle.canPlayAd(thirdPartyAdPlacementId)) {
                log("Rewarded ad loaded");
                maxRewardedAdapterListener.onRewardedAdLoaded();
                return;
            }
            updateUserPrivacySettings(maxAdapterResponseParameters);
            loadFullscreenAd(maxAdapterResponseParameters, new LoadAdCallback() {
                public void onAdLoad(String str) {
                    VungleMediationAdapter.this.log("Rewarded ad loaded");
                    maxRewardedAdapterListener.onRewardedAdLoaded();
                }

                public void onError(String str, VungleException vungleException) {
                    MaxAdapterError access$100 = VungleMediationAdapter.toMaxError(vungleException);
                    VungleMediationAdapter vungleMediationAdapter = VungleMediationAdapter.this;
                    vungleMediationAdapter.log("Rewarded ad for placement " + str + " failed to load with error: " + access$100);
                    maxRewardedAdapterListener.onRewardedAdLoadFailed(access$100);
                }
            });
        }
    }

    public void onDestroy() {
        VungleBanner vungleBanner = this.adViewAd;
        if (vungleBanner != null) {
            vungleBanner.destroyAd();
            this.adViewAd = null;
        }
    }

    public void showInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        String bidResponse = maxAdapterResponseParameters.getBidResponse();
        boolean isValidString = AppLovinSdkUtils.isValidString(bidResponse);
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log(GeneratedOutlineSupport.outline20(GeneratedOutlineSupport.outline24("Showing "), isValidString ? "bidding " : "", "interstitial ad for placement: ", thirdPartyAdPlacementId, "..."));
        if (isValidString) {
            if (Vungle.canPlayAd(thirdPartyAdPlacementId, bidResponse)) {
                showFullscreenAd(maxAdapterResponseParameters, new InterstitialAdListener(maxInterstitialAdapterListener));
                return;
            }
        } else if (Vungle.canPlayAd(thirdPartyAdPlacementId)) {
            showFullscreenAd(maxAdapterResponseParameters, new InterstitialAdListener(maxInterstitialAdapterListener));
            return;
        }
        log("Interstitial ad not ready");
        maxInterstitialAdapterListener.onInterstitialAdDisplayFailed(MaxAdapterError.AD_NOT_READY);
    }

    public void showRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        String bidResponse = maxAdapterResponseParameters.getBidResponse();
        boolean isValidString = AppLovinSdkUtils.isValidString(bidResponse);
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log(GeneratedOutlineSupport.outline20(GeneratedOutlineSupport.outline24("Showing "), isValidString ? "bidding " : "", "rewarded ad for placement: ", thirdPartyAdPlacementId, "..."));
        if (isValidString) {
            if (Vungle.canPlayAd(thirdPartyAdPlacementId, bidResponse)) {
                configureReward(maxAdapterResponseParameters);
                showFullscreenAd(maxAdapterResponseParameters, new RewardedAdListener(maxRewardedAdapterListener));
                return;
            }
        } else if (Vungle.canPlayAd(thirdPartyAdPlacementId)) {
            configureReward(maxAdapterResponseParameters);
            showFullscreenAd(maxAdapterResponseParameters, new RewardedAdListener(maxRewardedAdapterListener));
            return;
        }
        log("Rewarded ad not ready");
        maxRewardedAdapterListener.onRewardedAdDisplayFailed(MaxAdapterError.AD_NOT_READY);
    }
}
