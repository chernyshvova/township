package com.applovin.mediation.adapters;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import androidx.annotation.NonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.utils.BundleUtils;
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
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;
import com.vungle.warren.log.LogEntry;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class GoogleMediationAdapter extends MediationAdapterBase implements MaxSignalProvider, MaxInterstitialAdapter, MaxRewardedInterstitialAdapter, MaxRewardedAdapter, MaxAdViewAdapter {
    public static final AtomicBoolean initialized = new AtomicBoolean();
    public static MaxAdapter.InitializationStatus status;
    public AdView adView;
    public InterstitialAd interstitialAd;
    public NativeAdView nativeAdView;
    public RewardedAd rewardedAd;
    public RewardedAdListener rewardedAdListener;
    public RewardedInterstitialAd rewardedInterstitialAd;
    public RewardedInterstitialAdListener rewardedInterstitialAdListener;

    public class AdViewListener extends AdListener {
        public final MaxAdFormat adFormat;
        public final MaxAdViewAdapterListener listener;
        public final String placementId;

        public AdViewListener(String str, MaxAdFormat maxAdFormat, MaxAdViewAdapterListener maxAdViewAdapterListener) {
            this.placementId = str;
            this.adFormat = maxAdFormat;
            this.listener = maxAdViewAdapterListener;
        }

        public void onAdClosed() {
            GoogleMediationAdapter googleMediationAdapter = GoogleMediationAdapter.this;
            googleMediationAdapter.log(this.adFormat.getLabel() + " ad closed");
        }

        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
            MaxAdapterError access$200 = GoogleMediationAdapter.toMaxError(loadAdError);
            GoogleMediationAdapter googleMediationAdapter = GoogleMediationAdapter.this;
            googleMediationAdapter.log(this.adFormat.getLabel() + " ad (" + this.placementId + ") failed to load with error code: " + access$200);
            this.listener.onAdViewAdLoadFailed(access$200);
        }

        public void onAdImpression() {
            GoogleMediationAdapter googleMediationAdapter = GoogleMediationAdapter.this;
            googleMediationAdapter.log(this.adFormat.getLabel() + " ad shown: " + this.placementId);
            this.listener.onAdViewAdDisplayed();
        }

        public void onAdLoaded() {
            GoogleMediationAdapter googleMediationAdapter = GoogleMediationAdapter.this;
            googleMediationAdapter.log(this.adFormat.getLabel() + " ad loaded: " + this.placementId);
            ResponseInfo responseInfo = GoogleMediationAdapter.this.adView.getResponseInfo();
            String responseId = responseInfo != null ? responseInfo.getResponseId() : null;
            if (AppLovinSdk.VERSION_CODE < 9150000 || !AppLovinSdkUtils.isValidString(responseId)) {
                this.listener.onAdViewAdLoaded(GoogleMediationAdapter.this.adView);
                return;
            }
            Bundle bundle = new Bundle(1);
            bundle.putString("creative_id", responseId);
            this.listener.onAdViewAdLoaded(GoogleMediationAdapter.this.adView, bundle);
        }

        public void onAdOpened() {
            GoogleMediationAdapter googleMediationAdapter = GoogleMediationAdapter.this;
            googleMediationAdapter.log(this.adFormat.getLabel() + " ad opened");
            this.listener.onAdViewAdClicked();
        }
    }

    public class InterstitialAdListener extends FullScreenContentCallback {
        public final MaxInterstitialAdapterListener listener;
        public final String placementId;

        public InterstitialAdListener(String str, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
            this.placementId = str;
            this.listener = maxInterstitialAdapterListener;
        }

        public void onAdDismissedFullScreenContent() {
            GoogleMediationAdapter googleMediationAdapter = GoogleMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Interstitial ad hidden: ");
            outline24.append(this.placementId);
            googleMediationAdapter.log(outline24.toString());
            this.listener.onInterstitialAdHidden();
        }

        public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
            MaxAdapterError access$200 = GoogleMediationAdapter.toMaxError(adError);
            GoogleMediationAdapter googleMediationAdapter = GoogleMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Interstitial ad (");
            outline24.append(this.placementId);
            outline24.append(") failed to show with error: ");
            outline24.append(access$200);
            googleMediationAdapter.log(outline24.toString());
            this.listener.onInterstitialAdLoadFailed(access$200);
        }

        public void onAdShowedFullScreenContent() {
            GoogleMediationAdapter googleMediationAdapter = GoogleMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Interstitial ad shown: ");
            outline24.append(this.placementId);
            googleMediationAdapter.log(outline24.toString());
            this.listener.onInterstitialAdDisplayed();
        }
    }

    public class NativeAdViewListener extends AdListener implements NativeAd.OnNativeAdLoadedListener {
        public final WeakReference<Activity> activityRef;
        public final MaxAdFormat adFormat;
        public final MaxAdViewAdapterListener listener;
        public final String placementId;
        public final Bundle serverParameters;

        public NativeAdViewListener(String str, MaxAdFormat maxAdFormat, Bundle bundle, Activity activity, MaxAdViewAdapterListener maxAdViewAdapterListener) {
            this.placementId = str;
            this.adFormat = maxAdFormat;
            this.serverParameters = bundle;
            this.activityRef = new WeakReference<>(activity);
            this.listener = maxAdViewAdapterListener;
        }

        private boolean isValidNativeAd(NativeAd nativeAd) {
            if (nativeAd.getHeadline() == null || nativeAd.getBody() == null || nativeAd.getImages() == null || nativeAd.getImages().size() <= 0 || nativeAd.getImages().get(0) == null || nativeAd.getIcon() == null || nativeAd.getCallToAction() == null) {
                return false;
            }
            return true;
        }

        public void onAdClicked() {
            GoogleMediationAdapter googleMediationAdapter = GoogleMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Native ");
            outline24.append(this.adFormat.getLabel());
            outline24.append(" ad clicked");
            googleMediationAdapter.log(outline24.toString());
            this.listener.onAdViewAdClicked();
        }

        public void onAdClosed() {
            GoogleMediationAdapter googleMediationAdapter = GoogleMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Native ");
            outline24.append(this.adFormat.getLabel());
            outline24.append(" ad closed");
            googleMediationAdapter.log(outline24.toString());
            this.listener.onAdViewAdCollapsed();
        }

        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
            MaxAdapterError access$200 = GoogleMediationAdapter.toMaxError(loadAdError);
            GoogleMediationAdapter googleMediationAdapter = GoogleMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Native ");
            outline24.append(this.adFormat.getLabel());
            outline24.append(" ad (");
            outline24.append(this.placementId);
            outline24.append(") failed to load with error: ");
            outline24.append(access$200);
            googleMediationAdapter.log(outline24.toString());
            this.listener.onAdViewAdLoadFailed(access$200);
        }

        public void onAdImpression() {
            GoogleMediationAdapter googleMediationAdapter = GoogleMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Native ");
            outline24.append(this.adFormat.getLabel());
            outline24.append(" ad shown");
            googleMediationAdapter.log(outline24.toString());
            this.listener.onAdViewAdDisplayed();
        }

        public void onAdOpened() {
            GoogleMediationAdapter googleMediationAdapter = GoogleMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Native ");
            outline24.append(this.adFormat.getLabel());
            outline24.append(" ad opened");
            googleMediationAdapter.log(outline24.toString());
            this.listener.onAdViewAdExpanded();
        }

        public void onNativeAdLoaded(@NonNull NativeAd nativeAd) {
            MaxNativeAd.MaxNativeAdImage maxNativeAdImage;
            GoogleMediationAdapter googleMediationAdapter = GoogleMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Native ");
            outline24.append(this.adFormat.getLabel());
            outline24.append(" ad loaded: ");
            outline24.append(this.placementId);
            googleMediationAdapter.log(outline24.toString());
            final Activity activity = (Activity) this.activityRef.get();
            if (activity == null) {
                GoogleMediationAdapter googleMediationAdapter2 = GoogleMediationAdapter.this;
                StringBuilder outline242 = GeneratedOutlineSupport.outline24("Native ");
                outline242.append(this.adFormat.getLabel());
                outline242.append(" ad failed to load: activity reference is null when ad is loaded");
                googleMediationAdapter2.log(outline242.toString());
                this.listener.onAdViewAdLoadFailed(MaxAdapterError.INVALID_LOAD_STATE);
                nativeAd.destroy();
            } else if (!isValidNativeAd(nativeAd)) {
                GoogleMediationAdapter googleMediationAdapter3 = GoogleMediationAdapter.this;
                StringBuilder outline243 = GeneratedOutlineSupport.outline24("Native ");
                outline243.append(this.adFormat.getLabel());
                outline243.append(" ad failed to load: Google native ad is missing one or more required assets");
                googleMediationAdapter3.log(outline243.toString());
                this.listener.onAdViewAdLoadFailed(MaxAdapterError.INVALID_CONFIGURATION);
                nativeAd.destroy();
            } else {
                final MediaView mediaView = new MediaView(activity);
                mediaView.setMediaContent(nativeAd.getMediaContent());
                NativeAd.Image icon = nativeAd.getIcon();
                if (icon.getDrawable() != null) {
                    maxNativeAdImage = new MaxNativeAd.MaxNativeAdImage(icon.getDrawable());
                } else {
                    maxNativeAdImage = new MaxNativeAd.MaxNativeAdImage(icon.getUri());
                }
                final MaxNativeAd build = new MaxNativeAd.Builder().setAdFormat(this.adFormat).setIcon(maxNativeAdImage).setTitle(nativeAd.getHeadline()).setBody(nativeAd.getBody()).setMediaView(mediaView).setCallToAction(nativeAd.getCallToAction()).build();
                final String string = BundleUtils.getString("template", "", this.serverParameters);
                if (string.contains("vertical") && AppLovinSdk.VERSION_CODE < 9140500) {
                    GoogleMediationAdapter.this.log("Vertical native banners are only supported on MAX SDK 9.14.5 and above. Default horizontal native template will be used.");
                }
                final NativeAd nativeAd2 = nativeAd;
                AppLovinSdkUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        MaxNativeAdView maxNativeAdView;
                        if (AppLovinSdk.VERSION_CODE < 9140000) {
                            GoogleMediationAdapter.this.log("Native ads with media views are only supported on MAX SDK version 9.14.0 and above. Default native template will be used.");
                            maxNativeAdView = new MaxNativeAdView(build, activity);
                        } else {
                            maxNativeAdView = new MaxNativeAdView(build, string, activity);
                        }
                        NativeAdView unused = GoogleMediationAdapter.this.nativeAdView = new NativeAdView(maxNativeAdView.getContext());
                        GoogleMediationAdapter.this.nativeAdView.setIconView(maxNativeAdView.getIconContentView());
                        GoogleMediationAdapter.this.nativeAdView.setHeadlineView(maxNativeAdView.getTitleTextView());
                        GoogleMediationAdapter.this.nativeAdView.setBodyView(maxNativeAdView.getBodyTextView());
                        GoogleMediationAdapter.this.nativeAdView.setMediaView(mediaView);
                        GoogleMediationAdapter.this.nativeAdView.setCallToActionView(maxNativeAdView.getCallToActionButton());
                        GoogleMediationAdapter.this.nativeAdView.setNativeAd(nativeAd2);
                        GoogleMediationAdapter.this.nativeAdView.addView(maxNativeAdView);
                        ResponseInfo responseInfo = nativeAd2.getResponseInfo();
                        String responseId = responseInfo != null ? responseInfo.getResponseId() : null;
                        if (AppLovinSdk.VERSION_CODE < 9150000 || !AppLovinSdkUtils.isValidString(responseId)) {
                            NativeAdViewListener nativeAdViewListener = NativeAdViewListener.this;
                            nativeAdViewListener.listener.onAdViewAdLoaded(GoogleMediationAdapter.this.nativeAdView);
                            return;
                        }
                        Bundle bundle = new Bundle(1);
                        bundle.putString("creative_id", responseId);
                        NativeAdViewListener nativeAdViewListener2 = NativeAdViewListener.this;
                        nativeAdViewListener2.listener.onAdViewAdLoaded(GoogleMediationAdapter.this.nativeAdView, bundle);
                    }
                });
            }
        }
    }

    public class RewardedAdListener extends FullScreenContentCallback {
        public boolean hasGrantedReward;
        public final MaxRewardedAdapterListener listener;
        public final String placementId;

        public RewardedAdListener(String str, MaxRewardedAdapterListener maxRewardedAdapterListener) {
            this.placementId = str;
            this.listener = maxRewardedAdapterListener;
        }

        public void onAdDismissedFullScreenContent() {
            this.listener.onRewardedAdVideoCompleted();
            if (this.hasGrantedReward || GoogleMediationAdapter.this.shouldAlwaysRewardUser()) {
                MaxReward reward = GoogleMediationAdapter.this.getReward();
                GoogleMediationAdapter googleMediationAdapter = GoogleMediationAdapter.this;
                googleMediationAdapter.log("Rewarded user with reward: " + reward);
                this.listener.onUserRewarded(reward);
            }
            GoogleMediationAdapter googleMediationAdapter2 = GoogleMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Rewarded ad hidden: ");
            outline24.append(this.placementId);
            googleMediationAdapter2.log(outline24.toString());
            this.listener.onRewardedAdHidden();
        }

        public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
            MaxAdapterError access$200 = GoogleMediationAdapter.toMaxError(adError);
            GoogleMediationAdapter googleMediationAdapter = GoogleMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Rewarded ad (");
            outline24.append(this.placementId);
            outline24.append(") failed to show with error: ");
            outline24.append(access$200);
            googleMediationAdapter.log(outline24.toString());
            this.listener.onRewardedAdDisplayFailed(access$200);
        }

        public void onAdShowedFullScreenContent() {
            GoogleMediationAdapter googleMediationAdapter = GoogleMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Rewarded ad shown: ");
            outline24.append(this.placementId);
            googleMediationAdapter.log(outline24.toString());
            this.listener.onRewardedAdDisplayed();
            this.listener.onRewardedAdVideoStarted();
        }
    }

    public class RewardedInterstitialAdListener extends FullScreenContentCallback {
        public boolean hasGrantedReward;
        public final MaxRewardedInterstitialAdapterListener listener;
        public final String placementId;

        public void onAdDismissedFullScreenContent() {
            this.listener.onRewardedInterstitialAdVideoCompleted();
            if (this.hasGrantedReward || GoogleMediationAdapter.this.shouldAlwaysRewardUser()) {
                MaxReward reward = GoogleMediationAdapter.this.getReward();
                GoogleMediationAdapter googleMediationAdapter = GoogleMediationAdapter.this;
                googleMediationAdapter.log("Rewarded interstitial ad rewarded user with reward: " + reward);
                this.listener.onUserRewarded(reward);
            }
            GoogleMediationAdapter googleMediationAdapter2 = GoogleMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Rewarded interstitial ad hidden: ");
            outline24.append(this.placementId);
            googleMediationAdapter2.log(outline24.toString());
            this.listener.onRewardedInterstitialAdHidden();
        }

        public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
            MaxAdapterError access$200 = GoogleMediationAdapter.toMaxError(adError);
            GoogleMediationAdapter googleMediationAdapter = GoogleMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Rewarded interstitial ad (");
            outline24.append(this.placementId);
            outline24.append(") failed to show with error: ");
            outline24.append(access$200);
            googleMediationAdapter.log(outline24.toString());
            this.listener.onRewardedInterstitialAdDisplayFailed(access$200);
        }

        public void onAdShowedFullScreenContent() {
            GoogleMediationAdapter googleMediationAdapter = GoogleMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Rewarded interstitial ad shown: ");
            outline24.append(this.placementId);
            googleMediationAdapter.log(outline24.toString());
            this.listener.onRewardedInterstitialAdDisplayed();
            this.listener.onRewardedInterstitialAdVideoStarted();
        }

        public RewardedInterstitialAdListener(String str, MaxRewardedInterstitialAdapterListener maxRewardedInterstitialAdapterListener) {
            this.placementId = str;
            this.listener = maxRewardedInterstitialAdapterListener;
        }
    }

    public GoogleMediationAdapter(AppLovinSdk appLovinSdk) {
        super(appLovinSdk);
    }

    private AdRequest createAdRequestWithParameters(MaxAdapterParameters maxAdapterParameters, Activity activity) {
        Boolean privacySetting;
        Boolean privacySetting2;
        AdRequest.Builder builder = new AdRequest.Builder();
        if (maxAdapterParameters instanceof MaxAdapterResponseParameters) {
            String bidResponse = ((MaxAdapterResponseParameters) maxAdapterParameters).getBidResponse();
            if (AppLovinSdkUtils.isValidString(bidResponse)) {
                builder.setAdString(bidResponse);
            }
        }
        Bundle serverParameters = maxAdapterParameters.getServerParameters();
        if (serverParameters.getBoolean("set_mediation_identifier", true)) {
            builder.setRequestAgent(MediationAdapterBase.mediationTag());
        }
        Bundle bundle = new Bundle();
        String string = BundleUtils.getString(LogEntry.LOG_ITEM_EVENT_ID, serverParameters);
        if (AppLovinSdkUtils.isValidString(string)) {
            bundle.putString("placement_req_id", string);
        }
        if (getWrappingSdk().getConfiguration().getConsentDialogState() == AppLovinSdkConfiguration.ConsentDialogState.APPLIES && (privacySetting2 = getPrivacySetting("hasUserConsent", maxAdapterParameters)) != null && !privacySetting2.booleanValue()) {
            bundle.putString("npa", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
        if (AppLovinSdk.VERSION_CODE >= 91100 && (privacySetting = getPrivacySetting("isDoNotSell", maxAdapterParameters)) != null && privacySetting.booleanValue()) {
            bundle.putInt("rdp", 1);
            activity.getPreferences(0).edit().putInt("gad_rdp", 1).commit();
        }
        builder.addNetworkExtrasBundle(AdMobAdapter.class, bundle);
        return builder.build();
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

    private void setRequestConfiguration(MaxAdapterParameters maxAdapterParameters) {
        RequestConfiguration.Builder builder = MobileAds.getRequestConfiguration().toBuilder();
        Boolean privacySetting = getPrivacySetting("isAgeRestrictedUser", maxAdapterParameters);
        if (privacySetting != null) {
            builder.setTagForChildDirectedTreatment(privacySetting.booleanValue() ? 1 : 0);
        }
        String string = maxAdapterParameters.getServerParameters().getString("test_device_ids", (String) null);
        if (!TextUtils.isEmpty(string)) {
            builder.setTestDeviceIds(Arrays.asList(string.split(",")));
        }
        MobileAds.setRequestConfiguration(builder.build());
    }

    private AdFormat toAdFormat(MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters) {
        boolean z = maxAdapterSignalCollectionParameters.getServerParameters().getBoolean("is_native");
        MaxAdFormat adFormat = maxAdapterSignalCollectionParameters.getAdFormat();
        if (z) {
            return AdFormat.NATIVE;
        }
        if (adFormat.isAdViewAd()) {
            return AdFormat.BANNER;
        }
        if (adFormat == MaxAdFormat.INTERSTITIAL) {
            return AdFormat.INTERSTITIAL;
        }
        if (adFormat == MaxAdFormat.REWARDED) {
            return AdFormat.REWARDED;
        }
        if (adFormat == MaxAdFormat.REWARDED_INTERSTITIAL) {
            return AdFormat.REWARDED_INTERSTITIAL;
        }
        throw new IllegalArgumentException("Unsupported ad format: " + adFormat);
    }

    private AdSize toAdSize(MaxAdFormat maxAdFormat, Bundle bundle, Activity activity) {
        if (maxAdFormat == MaxAdFormat.BANNER || maxAdFormat == MaxAdFormat.LEADER) {
            if (!bundle.getBoolean("adaptive_banner", false)) {
                return maxAdFormat == MaxAdFormat.BANNER ? AdSize.BANNER : AdSize.LEADERBOARD;
            }
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, AppLovinSdkUtils.pxToDp(activity, displayMetrics.widthPixels));
        } else if (maxAdFormat == MaxAdFormat.MREC) {
            return AdSize.MEDIUM_RECTANGLE;
        } else {
            throw new IllegalArgumentException("Unsupported ad format: " + maxAdFormat);
        }
    }

    public static MaxAdapterError toMaxError(AdError adError) {
        int code = adError.getCode();
        MaxAdapterError maxAdapterError = MaxAdapterError.UNSPECIFIED;
        if (code != 0) {
            if (code != 1) {
                if (code != 2) {
                    if (code != 3) {
                        switch (code) {
                            case 8:
                                maxAdapterError = MaxAdapterError.INVALID_CONFIGURATION;
                                break;
                            case 9:
                                break;
                            case 10:
                                break;
                        }
                    }
                    maxAdapterError = MaxAdapterError.NO_FILL;
                } else {
                    maxAdapterError = MaxAdapterError.NO_CONNECTION;
                }
            }
            maxAdapterError = MaxAdapterError.BAD_REQUEST;
        } else {
            maxAdapterError = MaxAdapterError.INTERNAL_ERROR;
        }
        return new MaxAdapterError(maxAdapterError.getErrorCode(), maxAdapterError.getErrorMessage(), code, adError.getMessage());
    }

    public static void updateMuteState(MaxAdapterResponseParameters maxAdapterResponseParameters) {
        Bundle serverParameters = maxAdapterResponseParameters.getServerParameters();
        if (serverParameters.containsKey("is_muted")) {
            MobileAds.setAppMuted(serverParameters.getBoolean("is_muted"));
        }
    }

    public void collectSignal(MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, Activity activity, final MaxSignalCollectionListener maxSignalCollectionListener) {
        setRequestConfiguration(maxAdapterSignalCollectionParameters);
        QueryInfo.generate(activity.getApplicationContext(), toAdFormat(maxAdapterSignalCollectionParameters), createAdRequestWithParameters(maxAdapterSignalCollectionParameters, activity), new QueryInfoGenerationCallback() {
            public void onFailure(@NonNull String str) {
                GoogleMediationAdapter googleMediationAdapter = GoogleMediationAdapter.this;
                googleMediationAdapter.log("Signal collection failed with error: " + str);
                maxSignalCollectionListener.onSignalCollectionFailed(str);
            }

            public void onSuccess(@NonNull QueryInfo queryInfo) {
                GoogleMediationAdapter.this.log("Signal collection successful");
                maxSignalCollectionListener.onSignalCollected(queryInfo.getQuery());
            }
        });
    }

    public String getAdapterVersion() {
        return "20.3.0.0";
    }

    public String getSdkVersion() {
        String adapterVersion = getAdapterVersion();
        return adapterVersion.substring(0, adapterVersion.lastIndexOf(46));
    }

    public void initialize(MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity, final MaxAdapter.OnCompletionListener onCompletionListener) {
        log("Initializing Google SDK...");
        checkExistence(MobileAds.class, InterstitialAd.class, RewardedAd.class, AdListener.class);
        if (initialized.compareAndSet(false, true)) {
            status = MaxAdapter.InitializationStatus.INITIALIZING;
            MobileAds.disableMediationAdapterInitialization(activity);
            MobileAds.initialize(activity, new OnInitializationCompleteListener() {
                public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {
                    AdapterStatus adapterStatus = initializationStatus.getAdapterStatusMap().get("com.google.android.gms.ads.MobileAds");
                    AdapterStatus.State initializationState = adapterStatus != null ? adapterStatus.getInitializationState() : null;
                    GoogleMediationAdapter googleMediationAdapter = GoogleMediationAdapter.this;
                    googleMediationAdapter.log("Initialization complete with status " + initializationState);
                    MaxAdapter.InitializationStatus unused = GoogleMediationAdapter.status = AdapterStatus.State.READY == initializationState ? MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS : MaxAdapter.InitializationStatus.INITIALIZED_UNKNOWN;
                    onCompletionListener.onCompletion(GoogleMediationAdapter.status, (String) null);
                }
            });
            return;
        }
        onCompletionListener.onCompletion(status, (String) null);
    }

    public void loadAdViewAd(MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, Activity activity, MaxAdViewAdapterListener maxAdViewAdapterListener) {
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        boolean z = maxAdapterResponseParameters.getServerParameters().getBoolean("is_native");
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Loading ");
        String str = "";
        outline24.append(AppLovinSdkUtils.isValidString(maxAdapterResponseParameters.getBidResponse()) ? "bidding " : str);
        if (z) {
            str = "native ";
        }
        outline24.append(str);
        outline24.append(maxAdFormat.getLabel());
        outline24.append(" ad for placement id: ");
        outline24.append(thirdPartyAdPlacementId);
        outline24.append("...");
        log(outline24.toString());
        setRequestConfiguration(maxAdapterResponseParameters);
        AdRequest createAdRequestWithParameters = createAdRequestWithParameters(maxAdapterResponseParameters, activity);
        if (z) {
            NativeAdOptions.Builder builder = new NativeAdOptions.Builder();
            boolean z2 = true;
            builder.setAdChoicesPlacement(1);
            if (maxAdFormat != MaxAdFormat.MREC) {
                z2 = false;
            }
            builder.setRequestMultipleImages(z2);
            NativeAdViewListener nativeAdViewListener = new NativeAdViewListener(thirdPartyAdPlacementId, maxAdFormat, maxAdapterResponseParameters.getServerParameters(), activity, maxAdViewAdapterListener);
            new AdLoader.Builder(activity, thirdPartyAdPlacementId).withNativeAdOptions(builder.build()).forNativeAd(nativeAdViewListener).withAdListener(nativeAdViewListener).build().loadAd(createAdRequestWithParameters);
            return;
        }
        AdView adView2 = new AdView(activity);
        this.adView = adView2;
        adView2.setAdUnitId(thirdPartyAdPlacementId);
        this.adView.setAdSize(toAdSize(maxAdFormat, maxAdapterResponseParameters.getServerParameters(), activity));
        this.adView.setAdListener(new AdViewListener(thirdPartyAdPlacementId, maxAdFormat, maxAdViewAdapterListener));
        this.adView.loadAd(createAdRequestWithParameters);
    }

    public void loadInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, final MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        final String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log(GeneratedOutlineSupport.outline20(GeneratedOutlineSupport.outline24("Loading "), AppLovinSdkUtils.isValidString(maxAdapterResponseParameters.getBidResponse()) ? "bidding " : "", "interstitial ad: ", thirdPartyAdPlacementId, "..."));
        updateMuteState(maxAdapterResponseParameters);
        setRequestConfiguration(maxAdapterResponseParameters);
        InterstitialAd.load(activity, thirdPartyAdPlacementId, createAdRequestWithParameters(maxAdapterResponseParameters, activity), new InterstitialAdLoadCallback() {
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                MaxAdapterError access$200 = GoogleMediationAdapter.toMaxError(loadAdError);
                GoogleMediationAdapter googleMediationAdapter = GoogleMediationAdapter.this;
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Interstitial ad (");
                outline24.append(thirdPartyAdPlacementId);
                outline24.append(") failed to load with error: ");
                outline24.append(access$200);
                googleMediationAdapter.log(outline24.toString());
                maxInterstitialAdapterListener.onInterstitialAdLoadFailed(access$200);
            }

            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                GoogleMediationAdapter googleMediationAdapter = GoogleMediationAdapter.this;
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Interstitial ad loaded: ");
                outline24.append(thirdPartyAdPlacementId);
                outline24.append("...");
                googleMediationAdapter.log(outline24.toString());
                InterstitialAd unused = GoogleMediationAdapter.this.interstitialAd = interstitialAd;
                GoogleMediationAdapter.this.interstitialAd.setFullScreenContentCallback(new InterstitialAdListener(thirdPartyAdPlacementId, maxInterstitialAdapterListener));
                ResponseInfo responseInfo = GoogleMediationAdapter.this.interstitialAd.getResponseInfo();
                String responseId = responseInfo != null ? responseInfo.getResponseId() : null;
                if (AppLovinSdk.VERSION_CODE < 9150000 || !AppLovinSdkUtils.isValidString(responseId)) {
                    maxInterstitialAdapterListener.onInterstitialAdLoaded();
                    return;
                }
                Bundle bundle = new Bundle(1);
                bundle.putString("creative_id", responseId);
                maxInterstitialAdapterListener.onInterstitialAdLoaded(bundle);
            }
        });
    }

    public void loadRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, final MaxRewardedAdapterListener maxRewardedAdapterListener) {
        final String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log(GeneratedOutlineSupport.outline20(GeneratedOutlineSupport.outline24("Loading "), AppLovinSdkUtils.isValidString(maxAdapterResponseParameters.getBidResponse()) ? "bidding " : "", "rewarded ad: ", thirdPartyAdPlacementId, "..."));
        updateMuteState(maxAdapterResponseParameters);
        setRequestConfiguration(maxAdapterResponseParameters);
        RewardedAd.load((Context) activity, thirdPartyAdPlacementId, createAdRequestWithParameters(maxAdapterResponseParameters, activity), (RewardedAdLoadCallback) new RewardedAdLoadCallback() {
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                MaxAdapterError access$200 = GoogleMediationAdapter.toMaxError(loadAdError);
                GoogleMediationAdapter googleMediationAdapter = GoogleMediationAdapter.this;
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Rewarded ad (");
                outline24.append(thirdPartyAdPlacementId);
                outline24.append(") failed to load with error: ");
                outline24.append(access$200);
                googleMediationAdapter.log(outline24.toString());
                maxRewardedAdapterListener.onRewardedAdLoadFailed(access$200);
            }

            public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                GoogleMediationAdapter googleMediationAdapter = GoogleMediationAdapter.this;
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Rewarded ad loaded: ");
                outline24.append(thirdPartyAdPlacementId);
                outline24.append("...");
                googleMediationAdapter.log(outline24.toString());
                RewardedAd unused = GoogleMediationAdapter.this.rewardedAd = rewardedAd;
                GoogleMediationAdapter googleMediationAdapter2 = GoogleMediationAdapter.this;
                RewardedAdListener unused2 = googleMediationAdapter2.rewardedAdListener = new RewardedAdListener(thirdPartyAdPlacementId, maxRewardedAdapterListener);
                GoogleMediationAdapter.this.rewardedAd.setFullScreenContentCallback(GoogleMediationAdapter.this.rewardedAdListener);
                ResponseInfo responseInfo = GoogleMediationAdapter.this.rewardedAd.getResponseInfo();
                String responseId = responseInfo != null ? responseInfo.getResponseId() : null;
                if (AppLovinSdk.VERSION_CODE < 9150000 || !AppLovinSdkUtils.isValidString(responseId)) {
                    maxRewardedAdapterListener.onRewardedAdLoaded();
                    return;
                }
                Bundle bundle = new Bundle(1);
                bundle.putString("creative_id", responseId);
                maxRewardedAdapterListener.onRewardedAdLoaded(bundle);
            }
        });
    }

    public void loadRewardedInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, final MaxRewardedInterstitialAdapterListener maxRewardedInterstitialAdapterListener) {
        final String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log(GeneratedOutlineSupport.outline20(GeneratedOutlineSupport.outline24("Loading "), AppLovinSdkUtils.isValidString(maxAdapterResponseParameters.getBidResponse()) ? "bidding " : "", "rewarded interstitial ad: ", thirdPartyAdPlacementId, "..."));
        updateMuteState(maxAdapterResponseParameters);
        setRequestConfiguration(maxAdapterResponseParameters);
        RewardedInterstitialAd.load((Context) activity, thirdPartyAdPlacementId, createAdRequestWithParameters(maxAdapterResponseParameters, activity), (RewardedInterstitialAdLoadCallback) new RewardedInterstitialAdLoadCallback() {
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                MaxAdapterError access$200 = GoogleMediationAdapter.toMaxError(loadAdError);
                GoogleMediationAdapter googleMediationAdapter = GoogleMediationAdapter.this;
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Rewarded interstitial ad (");
                outline24.append(thirdPartyAdPlacementId);
                outline24.append(") failed to load with error: ");
                outline24.append(access$200);
                googleMediationAdapter.log(outline24.toString());
                maxRewardedInterstitialAdapterListener.onRewardedInterstitialAdLoadFailed(access$200);
            }

            public void onAdLoaded(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {
                GoogleMediationAdapter googleMediationAdapter = GoogleMediationAdapter.this;
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Rewarded interstitial ad loaded: ");
                outline24.append(thirdPartyAdPlacementId);
                googleMediationAdapter.log(outline24.toString());
                RewardedInterstitialAd unused = GoogleMediationAdapter.this.rewardedInterstitialAd = rewardedInterstitialAd;
                GoogleMediationAdapter googleMediationAdapter2 = GoogleMediationAdapter.this;
                String str = null;
                RewardedInterstitialAdListener unused2 = googleMediationAdapter2.rewardedInterstitialAdListener = new RewardedInterstitialAdListener(thirdPartyAdPlacementId, maxRewardedInterstitialAdapterListener);
                GoogleMediationAdapter.this.rewardedInterstitialAd.setFullScreenContentCallback(GoogleMediationAdapter.this.rewardedInterstitialAdListener);
                ResponseInfo responseInfo = GoogleMediationAdapter.this.rewardedInterstitialAd.getResponseInfo();
                if (responseInfo != null) {
                    str = responseInfo.getResponseId();
                }
                if (AppLovinSdk.VERSION_CODE <= 9150000 || !AppLovinSdkUtils.isValidString(str)) {
                    maxRewardedInterstitialAdapterListener.onRewardedInterstitialAdLoaded();
                    return;
                }
                Bundle bundle = new Bundle(1);
                bundle.putString("creative_id", str);
                maxRewardedInterstitialAdapterListener.onRewardedInterstitialAdLoaded(bundle);
            }
        });
    }

    public void onDestroy() {
        log("Destroy called for adapter " + this);
        InterstitialAd interstitialAd2 = this.interstitialAd;
        if (interstitialAd2 != null) {
            interstitialAd2.setFullScreenContentCallback((FullScreenContentCallback) null);
            this.interstitialAd = null;
        }
        RewardedInterstitialAd rewardedInterstitialAd2 = this.rewardedInterstitialAd;
        if (rewardedInterstitialAd2 != null) {
            rewardedInterstitialAd2.setFullScreenContentCallback((FullScreenContentCallback) null);
            this.rewardedInterstitialAd = null;
            this.rewardedInterstitialAdListener = null;
        }
        RewardedAd rewardedAd2 = this.rewardedAd;
        if (rewardedAd2 != null) {
            rewardedAd2.setFullScreenContentCallback((FullScreenContentCallback) null);
            this.rewardedAd = null;
            this.rewardedAdListener = null;
        }
        AdView adView2 = this.adView;
        if (adView2 != null) {
            adView2.destroy();
            this.adView = null;
        }
        NativeAdView nativeAdView2 = this.nativeAdView;
        if (nativeAdView2 != null) {
            nativeAdView2.destroy();
            this.nativeAdView = null;
        }
    }

    public void showInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Showing interstitial ad: " + thirdPartyAdPlacementId + "...");
        InterstitialAd interstitialAd2 = this.interstitialAd;
        if (interstitialAd2 != null) {
            interstitialAd2.show(activity);
            return;
        }
        log("Interstitial ad failed to show: " + thirdPartyAdPlacementId);
        maxInterstitialAdapterListener.onInterstitialAdDisplayFailed(MaxAdapterError.AD_NOT_READY);
    }

    public void showRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        final String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Showing rewarded ad: " + thirdPartyAdPlacementId + "...");
        if (this.rewardedAd != null) {
            configureReward(maxAdapterResponseParameters);
            this.rewardedAd.show(activity, new OnUserEarnedRewardListener() {
                public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                    GoogleMediationAdapter googleMediationAdapter = GoogleMediationAdapter.this;
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Rewarded ad user earned reward: ");
                    outline24.append(thirdPartyAdPlacementId);
                    googleMediationAdapter.log(outline24.toString());
                    boolean unused = GoogleMediationAdapter.this.rewardedAdListener.hasGrantedReward = true;
                }
            });
            return;
        }
        log("Rewarded ad failed to show: " + thirdPartyAdPlacementId);
        maxRewardedAdapterListener.onRewardedAdDisplayFailed(MaxAdapterError.AD_NOT_READY);
    }

    public void showRewardedInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedInterstitialAdapterListener maxRewardedInterstitialAdapterListener) {
        final String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Showing rewarded interstitial ad: " + thirdPartyAdPlacementId + "...");
        if (this.rewardedInterstitialAd != null) {
            configureReward(maxAdapterResponseParameters);
            this.rewardedInterstitialAd.show(activity, new OnUserEarnedRewardListener() {
                public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                    GoogleMediationAdapter googleMediationAdapter = GoogleMediationAdapter.this;
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Rewarded interstitial ad user earned reward: ");
                    outline24.append(thirdPartyAdPlacementId);
                    googleMediationAdapter.log(outline24.toString());
                    boolean unused = GoogleMediationAdapter.this.rewardedInterstitialAdListener.hasGrantedReward = true;
                }
            });
            return;
        }
        log("Rewarded interstitial ad failed to show: " + thirdPartyAdPlacementId);
        maxRewardedInterstitialAdapterListener.onRewardedInterstitialAdDisplayFailed(MaxAdapterError.AD_NOT_READY);
    }
}
