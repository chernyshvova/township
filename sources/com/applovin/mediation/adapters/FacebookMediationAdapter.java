package com.applovin.mediation.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
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
import com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener;
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
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.ads.AdError;
import com.facebook.ads.AdExperienceType;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.BidderTokenProvider;
import com.facebook.ads.BuildConfig;
import com.facebook.ads.C1513Ad;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdExtendedListener;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeAdView;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdExtendedListener;
import com.facebook.internal.security.CertificateUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class FacebookMediationAdapter extends MediationAdapterBase implements MaxInterstitialAdapter, MaxRewardedInterstitialAdapter, MaxRewardedAdapter, MaxAdViewAdapter, MaxSignalProvider {
    public static final AtomicBoolean INITIALIZED = new AtomicBoolean();
    public static MaxAdapter.InitializationStatus sStatus;
    public AdView mAdView;
    public InterstitialAd mInterstitialAd;
    public NativeAd mNativeAd;
    public NativeBannerAd mNativeBannerAd;
    public RewardedVideoAd mRewardedInterAd;
    public RewardedVideoAd mRewardedVideoAd;
    public final AtomicBoolean onInterstitialAdHiddenCalled = new AtomicBoolean();
    public final AtomicBoolean onRewardedAdHiddenCalled = new AtomicBoolean();
    public final AtomicBoolean onRewardedAdVideoCompletedCalled = new AtomicBoolean();

    public class AdViewListener implements AdListener {
        public final MaxAdFormat adFormat;
        public final MaxAdViewAdapterListener listener;

        public AdViewListener(MaxAdFormat maxAdFormat, MaxAdViewAdapterListener maxAdViewAdapterListener) {
            this.adFormat = maxAdFormat;
            this.listener = maxAdViewAdapterListener;
        }

        public void onAdClicked(C1513Ad ad) {
            FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
            facebookMediationAdapter.log(this.adFormat.getLabel() + " ad clicked: " + ad.getPlacementId());
            this.listener.onAdViewAdClicked();
        }

        public void onAdLoaded(C1513Ad ad) {
            FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
            facebookMediationAdapter.log(this.adFormat.getLabel() + " ad loaded: " + ad.getPlacementId());
            this.listener.onAdViewAdLoaded(FacebookMediationAdapter.this.mAdView);
        }

        public void onError(C1513Ad ad, AdError adError) {
            MaxAdapterError access$100 = FacebookMediationAdapter.toMaxError(adError);
            FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
            facebookMediationAdapter.log(this.adFormat.getLabel() + " ad (" + ad.getPlacementId() + ") failed to load with error (" + access$100);
            this.listener.onAdViewAdLoadFailed(access$100);
        }

        public void onLoggingImpression(C1513Ad ad) {
            FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
            facebookMediationAdapter.log(this.adFormat.getLabel() + " ad displayed: " + ad.getPlacementId());
            this.listener.onAdViewAdDisplayed();
        }
    }

    public class InterstitialAdListener implements InterstitialAdExtendedListener {
        public final MaxInterstitialAdapterListener listener;

        public InterstitialAdListener(MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
            this.listener = maxInterstitialAdapterListener;
        }

        public void onAdClicked(C1513Ad ad) {
            FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Interstitial ad clicked: ");
            outline24.append(ad.getPlacementId());
            facebookMediationAdapter.log(outline24.toString());
            this.listener.onInterstitialAdClicked();
        }

        public void onAdLoaded(C1513Ad ad) {
            FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Interstitial ad loaded: ");
            outline24.append(ad.getPlacementId());
            facebookMediationAdapter.log(outline24.toString());
            this.listener.onInterstitialAdLoaded();
        }

        public void onError(C1513Ad ad, AdError adError) {
            MaxAdapterError access$100 = FacebookMediationAdapter.toMaxError(adError);
            FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Interstitial ad (");
            outline24.append(ad.getPlacementId());
            outline24.append(") failed to load with error: ");
            outline24.append(access$100);
            facebookMediationAdapter.log(outline24.toString());
            this.listener.onInterstitialAdLoadFailed(access$100);
        }

        public void onInterstitialActivityDestroyed() {
            FacebookMediationAdapter.this.log("Interstitial ad Activity destroyed");
            if (FacebookMediationAdapter.this.onInterstitialAdHiddenCalled.compareAndSet(false, true)) {
                this.listener.onInterstitialAdHidden();
            }
        }

        public void onInterstitialDismissed(C1513Ad ad) {
            FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Interstitial ad hidden: ");
            outline24.append(ad.getPlacementId());
            facebookMediationAdapter.log(outline24.toString());
            if (FacebookMediationAdapter.this.onInterstitialAdHiddenCalled.compareAndSet(false, true)) {
                this.listener.onInterstitialAdHidden();
            }
        }

        public void onInterstitialDisplayed(C1513Ad ad) {
            FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Interstitial ad displayed: ");
            outline24.append(ad.getPlacementId());
            facebookMediationAdapter.log(outline24.toString());
        }

        public void onLoggingImpression(C1513Ad ad) {
            FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Interstitial ad logging impression: ");
            outline24.append(ad.getPlacementId());
            facebookMediationAdapter.log(outline24.toString());
            this.listener.onInterstitialAdDisplayed();
        }

        public void onRewardedAdCompleted() {
        }

        public void onRewardedAdServerFailed() {
        }

        public void onRewardedAdServerSucceeded() {
        }
    }

    public class MaxFacebookNativeAd extends MaxNativeAd {
        public void prepareViewForInteraction(final MaxNativeAdView maxNativeAdView) {
            final NativeAdBase access$600 = FacebookMediationAdapter.this.mNativeAd != null ? FacebookMediationAdapter.this.mNativeAd : FacebookMediationAdapter.this.mNativeBannerAd;
            if (access$600 == null) {
                FacebookMediationAdapter.this.mo11469e("Failed to register native ad views: native ad is null.");
                return;
            }
            final ArrayList arrayList = new ArrayList();
            if (AppLovinSdkUtils.isValidString(getTitle()) && maxNativeAdView.getTitleTextView() != null) {
                arrayList.add(maxNativeAdView.getTitleTextView());
            }
            if (AppLovinSdkUtils.isValidString(getAdvertiser()) && maxNativeAdView.getAdvertiserTextView() != null) {
                arrayList.add(maxNativeAdView.getAdvertiserTextView());
            }
            if (AppLovinSdkUtils.isValidString(getBody()) && maxNativeAdView.getBodyTextView() != null) {
                arrayList.add(maxNativeAdView.getBodyTextView());
            }
            if (AppLovinSdkUtils.isValidString(getCallToAction()) && maxNativeAdView.getCallToActionButton() != null) {
                arrayList.add(maxNativeAdView.getCallToActionButton());
            }
            if (!(getIcon() == null || maxNativeAdView.getIconImageView() == null)) {
                arrayList.add(maxNativeAdView.getIconImageView());
            }
            if (!(getMediaView() == null || maxNativeAdView.getMediaContentViewGroup() == null)) {
                arrayList.add(maxNativeAdView.getMediaContentViewGroup());
            }
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    NativeAdBase nativeAdBase = access$600;
                    if (!(nativeAdBase instanceof NativeBannerAd)) {
                        ((NativeAd) nativeAdBase).registerViewForInteraction((View) maxNativeAdView, (MediaView) MaxFacebookNativeAd.this.getMediaView(), (MediaView) MaxFacebookNativeAd.this.getIconView(), (List<View>) arrayList);
                    } else if (maxNativeAdView.getIconImageView() != null) {
                        MaxNativeAdView maxNativeAdView = maxNativeAdView;
                        ((NativeBannerAd) access$600).registerViewForInteraction((View) maxNativeAdView, maxNativeAdView.getIconImageView(), (List<View>) arrayList);
                    } else if (MaxFacebookNativeAd.this.getMediaView() != null) {
                        ((NativeBannerAd) access$600).registerViewForInteraction((View) maxNativeAdView, (ImageView) MaxFacebookNativeAd.this.getMediaView(), (List<View>) arrayList);
                    } else {
                        FacebookMediationAdapter.this.mo11469e("Failed to register native ad view for interaction: icon image view and media view are null");
                    }
                }
            });
        }

        public MaxFacebookNativeAd(MaxNativeAd.Builder builder) {
            super(builder);
        }
    }

    public class MaxNativeAdListener implements NativeAdListener {
        public final Context context;
        public final MaxNativeAdAdapterListener listener;
        public final Bundle serverParameters;

        public MaxNativeAdListener(Bundle bundle, Context context2, MaxNativeAdAdapterListener maxNativeAdAdapterListener) {
            this.serverParameters = bundle;
            this.context = context2;
            this.listener = maxNativeAdAdapterListener;
        }

        /* access modifiers changed from: private */
        public void handleNativeAdLoaded(NativeAdBase nativeAdBase, Drawable drawable, MediaView mediaView, Context context2) {
            MaxNativeAd.Builder optionsView = new MaxNativeAd.Builder().setAdFormat(MaxAdFormat.NATIVE).setTitle(nativeAdBase.getAdHeadline()).setAdvertiser(nativeAdBase.getAdvertiserName()).setBody(nativeAdBase.getAdBodyText()).setCallToAction(nativeAdBase.getAdCallToAction()).setIcon(new MaxNativeAd.MaxNativeAdImage(drawable)).setOptionsView(new AdOptionsView(context2, nativeAdBase, (NativeAdLayout) null));
            if (nativeAdBase instanceof NativeBannerAd) {
                ImageView imageView = new ImageView(context2);
                imageView.setImageDrawable(drawable);
                optionsView.setMediaView(imageView);
            } else {
                optionsView.setMediaView(mediaView);
            }
            this.listener.onNativeAdLoaded(new MaxFacebookNativeAd(optionsView), (Bundle) null);
        }

        private boolean hasRequiredAssets(boolean z, NativeAdBase nativeAdBase) {
            if (z) {
                return AppLovinSdkUtils.isValidString(nativeAdBase.getAdHeadline());
            }
            return AppLovinSdkUtils.isValidString(nativeAdBase.getAdHeadline()) && AppLovinSdkUtils.isValidString(nativeAdBase.getAdCallToAction());
        }

        public void onAdClicked(C1513Ad ad) {
            FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Native clicked: ");
            outline24.append(ad.getPlacementId());
            facebookMediationAdapter.log(outline24.toString());
            this.listener.onNativeAdClicked();
        }

        public void onAdLoaded(C1513Ad ad) {
            FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Native ad loaded: ");
            outline24.append(ad.getPlacementId());
            facebookMediationAdapter.log(outline24.toString());
            final NativeAdBase access$600 = FacebookMediationAdapter.this.mNativeAd != null ? FacebookMediationAdapter.this.mNativeAd : FacebookMediationAdapter.this.mNativeBannerAd;
            if (access$600 == null || access$600 != ad) {
                FacebookMediationAdapter.this.log("Native ad failed to load: no fill");
                this.listener.onNativeAdLoadFailed(MaxAdapterError.NO_FILL);
            } else if (access$600.isAdInvalidated()) {
                FacebookMediationAdapter.this.log("Native ad failed to load: ad is no longer valid");
                this.listener.onNativeAdLoadFailed(MaxAdapterError.AD_EXPIRED);
            } else if (!hasRequiredAssets(AppLovinSdkUtils.isValidString(BundleUtils.getString("template", "", this.serverParameters)), access$600)) {
                FacebookMediationAdapter facebookMediationAdapter2 = FacebookMediationAdapter.this;
                facebookMediationAdapter2.mo11469e("Native ad (" + access$600 + ") does not have required assets.");
                this.listener.onNativeAdLoadFailed(new MaxAdapterError((int) MaxAdapterError.ERROR_CODE_MISSING_REQUIRED_NATIVE_AD_ASSETS, "Missing Native Ad Assets"));
            } else {
                AppLovinSdkUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        final MediaView mediaView = new MediaView(MaxNativeAdListener.this.context);
                        Drawable preloadedIconViewDrawable = access$600.getPreloadedIconViewDrawable();
                        final NativeAdBase.Image adIcon = access$600.getAdIcon();
                        if (preloadedIconViewDrawable != null) {
                            MaxNativeAdListener maxNativeAdListener = MaxNativeAdListener.this;
                            maxNativeAdListener.handleNativeAdLoaded(access$600, preloadedIconViewDrawable, mediaView, maxNativeAdListener.context);
                        } else if (adIcon != null) {
                            FacebookMediationAdapter.this.getCachingExecutorService().execute(new Runnable() {
                                public void run() {
                                    Drawable drawable = null;
                                    if (AppLovinSdkUtils.isValidString(adIcon.getUrl())) {
                                        FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
                                        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Adding native ad icon (");
                                        outline24.append(adIcon.getUrl());
                                        outline24.append(") to queue to be fetched");
                                        facebookMediationAdapter.log(outline24.toString());
                                        Future<Drawable> createDrawableFuture = FacebookMediationAdapter.this.createDrawableFuture(adIcon.getUrl(), MaxNativeAdListener.this.context.getResources());
                                        int i = BundleUtils.getInt("image_task_timeout_seconds", 10, MaxNativeAdListener.this.serverParameters);
                                        if (createDrawableFuture != null) {
                                            try {
                                                drawable = createDrawableFuture.get((long) i, TimeUnit.SECONDS);
                                            } catch (Throwable th) {
                                                FacebookMediationAdapter.this.mo11470e("Image fetching tasks failed", th);
                                            }
                                        }
                                    }
                                    C13351 r0 = C13351.this;
                                    MaxNativeAdListener maxNativeAdListener = MaxNativeAdListener.this;
                                    maxNativeAdListener.handleNativeAdLoaded(access$600, drawable, mediaView, maxNativeAdListener.context);
                                }
                            });
                        } else {
                            FacebookMediationAdapter.this.log("No native ad icon (optional) available for the current creative.");
                            MaxNativeAdListener maxNativeAdListener2 = MaxNativeAdListener.this;
                            maxNativeAdListener2.handleNativeAdLoaded(access$600, (Drawable) null, mediaView, maxNativeAdListener2.context);
                        }
                    }
                });
            }
        }

        public void onError(C1513Ad ad, AdError adError) {
            MaxAdapterError access$100 = FacebookMediationAdapter.toMaxError(adError);
            FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Native ad (");
            outline24.append(ad.getPlacementId());
            outline24.append(") failed to load with error (");
            outline24.append(access$100);
            facebookMediationAdapter.log(outline24.toString());
            this.listener.onNativeAdLoadFailed(access$100);
        }

        public void onLoggingImpression(C1513Ad ad) {
            FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Native shown: ");
            outline24.append(ad.getPlacementId());
            facebookMediationAdapter.log(outline24.toString());
            this.listener.onNativeAdDisplayed((Bundle) null);
        }

        public void onMediaDownloaded(C1513Ad ad) {
            FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Native ad successfully downloaded media: ");
            outline24.append(ad.getPlacementId());
            facebookMediationAdapter.log(outline24.toString());
        }
    }

    public class NativeAdViewListener implements NativeAdListener {
        public final WeakReference<Activity> activityRef;
        public final MaxAdFormat adFormat;
        public final MaxAdViewAdapterListener listener;
        public final Bundle serverParameters;

        public NativeAdViewListener(Bundle bundle, MaxAdFormat maxAdFormat, Activity activity, MaxAdViewAdapterListener maxAdViewAdapterListener) {
            this.serverParameters = bundle;
            this.activityRef = new WeakReference<>(activity);
            this.adFormat = maxAdFormat;
            this.listener = maxAdViewAdapterListener;
        }

        private void renderNativeAdView() {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    MaxNativeAdView maxNativeAdView;
                    Activity activity = (Activity) NativeAdViewListener.this.activityRef.get();
                    Context access$700 = FacebookMediationAdapter.this.getContext(activity);
                    MediaView mediaView = new MediaView(access$700);
                    MediaView mediaView2 = new MediaView(access$700);
                    MaxNativeAd build = new MaxNativeAd.Builder().setAdFormat(NativeAdViewListener.this.adFormat).setTitle(FacebookMediationAdapter.this.mNativeAd.getAdHeadline()).setAdvertiser(FacebookMediationAdapter.this.mNativeAd.getAdvertiserName()).setBody(FacebookMediationAdapter.this.mNativeAd.getAdBodyText()).setCallToAction(FacebookMediationAdapter.this.mNativeAd.getAdCallToAction()).setIconView(mediaView).setMediaView(mediaView2).setOptionsView(new AdOptionsView(access$700, FacebookMediationAdapter.this.mNativeAd, (NativeAdLayout) null)).build();
                    String string = BundleUtils.getString("template", "", NativeAdViewListener.this.serverParameters);
                    if (string.contains("vertical")) {
                        if (AppLovinSdk.VERSION_CODE < 9140500) {
                            FacebookMediationAdapter.this.log("Vertical native banners are only supported on MAX SDK 9.14.5 and above. Default native template will be used.");
                        }
                        if (string.equals("vertical")) {
                            maxNativeAdView = FacebookMediationAdapter.this.createMaxNativeAdView(build, NativeAdViewListener.this.adFormat == MaxAdFormat.LEADER ? "vertical_leader_template" : "vertical_media_banner_template", activity);
                        } else {
                            maxNativeAdView = FacebookMediationAdapter.this.createMaxNativeAdView(build, string, activity);
                        }
                    } else if (AppLovinSdk.VERSION_CODE < 9140500) {
                        FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
                        if (!AppLovinSdkUtils.isValidString(string)) {
                            string = "no_body_banner_template";
                        }
                        maxNativeAdView = facebookMediationAdapter.createMaxNativeAdView(build, string, activity);
                    } else {
                        FacebookMediationAdapter facebookMediationAdapter2 = FacebookMediationAdapter.this;
                        if (!AppLovinSdkUtils.isValidString(string)) {
                            string = "media_banner_template";
                        }
                        maxNativeAdView = facebookMediationAdapter2.createMaxNativeAdView(build, string, activity);
                    }
                    ArrayList arrayList = new ArrayList();
                    if (!(build.getIconView() == null || maxNativeAdView.getIconContentView() == null)) {
                        arrayList.add(maxNativeAdView.getIconContentView());
                    }
                    Object mediaContentViewGroup = AppLovinSdk.VERSION_CODE >= 11000000 ? maxNativeAdView.getMediaContentViewGroup() : maxNativeAdView.getMediaContentView();
                    if (!(build.getMediaView() == null || mediaContentViewGroup == null)) {
                        arrayList.add(mediaContentViewGroup);
                    }
                    if (AppLovinSdkUtils.isValidString(build.getTitle()) && maxNativeAdView.getTitleTextView() != null) {
                        arrayList.add(maxNativeAdView.getTitleTextView());
                    }
                    if (AppLovinSdkUtils.isValidString(build.getCallToAction()) && maxNativeAdView.getCallToActionButton() != null) {
                        arrayList.add(maxNativeAdView.getCallToActionButton());
                    }
                    if (AppLovinSdkUtils.isValidString(build.getAdvertiser()) && maxNativeAdView.getAdvertiserTextView() != null) {
                        arrayList.add(maxNativeAdView.getAdvertiserTextView());
                    }
                    if (AppLovinSdkUtils.isValidString(build.getBody()) && maxNativeAdView.getBodyTextView() != null) {
                        arrayList.add(maxNativeAdView.getBodyTextView());
                    }
                    FacebookMediationAdapter.this.mNativeAd.registerViewForInteraction((View) maxNativeAdView, mediaView2, mediaView, (List<View>) arrayList);
                    NativeAdViewListener.this.listener.onAdViewAdLoaded(maxNativeAdView);
                }
            });
        }

        public void onAdClicked(C1513Ad ad) {
            FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Native ");
            outline24.append(this.adFormat.getLabel());
            outline24.append(" clicked: ");
            outline24.append(ad.getPlacementId());
            facebookMediationAdapter.log(outline24.toString());
            this.listener.onAdViewAdClicked();
        }

        public void onAdLoaded(C1513Ad ad) {
            FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Native ");
            outline24.append(this.adFormat.getLabel());
            outline24.append(" ad loaded: ");
            outline24.append(ad.getPlacementId());
            facebookMediationAdapter.log(outline24.toString());
            if (FacebookMediationAdapter.this.mNativeAd == null || FacebookMediationAdapter.this.mNativeAd != ad) {
                FacebookMediationAdapter facebookMediationAdapter2 = FacebookMediationAdapter.this;
                StringBuilder outline242 = GeneratedOutlineSupport.outline24("Native ");
                outline242.append(this.adFormat.getLabel());
                outline242.append(" ad failed to load: no fill");
                facebookMediationAdapter2.log(outline242.toString());
                this.listener.onAdViewAdLoadFailed(MaxAdapterError.NO_FILL);
            } else if (FacebookMediationAdapter.this.mNativeAd.isAdInvalidated()) {
                FacebookMediationAdapter facebookMediationAdapter3 = FacebookMediationAdapter.this;
                StringBuilder outline243 = GeneratedOutlineSupport.outline24("Native ");
                outline243.append(this.adFormat.getLabel());
                outline243.append(" ad failed to load: ad is no longer valid");
                facebookMediationAdapter3.log(outline243.toString());
                this.listener.onAdViewAdLoadFailed(MaxAdapterError.AD_EXPIRED);
            } else if (this.adFormat == MaxAdFormat.MREC) {
                this.listener.onAdViewAdLoaded(NativeAdView.render(FacebookMediationAdapter.this.getContext((Activity) this.activityRef.get()), FacebookMediationAdapter.this.mNativeAd));
            } else if (AppLovinSdk.VERSION_CODE >= 9140000) {
                renderNativeAdView();
            } else {
                FacebookMediationAdapter facebookMediationAdapter4 = FacebookMediationAdapter.this;
                StringBuilder outline244 = GeneratedOutlineSupport.outline24("Native ");
                outline244.append(this.adFormat.getLabel());
                outline244.append(" failed to load: AppLovin SDK version must be at least 9.14.0");
                facebookMediationAdapter4.log(outline244.toString());
                this.listener.onAdViewAdLoadFailed(MaxAdapterError.INVALID_CONFIGURATION);
            }
        }

        public void onError(C1513Ad ad, AdError adError) {
            MaxAdapterError access$100 = FacebookMediationAdapter.toMaxError(adError);
            FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Native ");
            outline24.append(this.adFormat.getLabel());
            outline24.append(" ad (");
            outline24.append(ad.getPlacementId());
            outline24.append(") failed to load with error: ");
            outline24.append(access$100);
            facebookMediationAdapter.log(outline24.toString());
            this.listener.onAdViewAdLoadFailed(access$100);
        }

        public void onLoggingImpression(C1513Ad ad) {
            FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Native ");
            outline24.append(this.adFormat.getLabel());
            outline24.append(" shown: ");
            outline24.append(ad.getPlacementId());
            facebookMediationAdapter.log(outline24.toString());
            this.listener.onAdViewAdDisplayed();
        }

        public void onMediaDownloaded(C1513Ad ad) {
            FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Native ");
            outline24.append(this.adFormat.getLabel());
            outline24.append(" successfully downloaded media: ");
            outline24.append(ad.getPlacementId());
            facebookMediationAdapter.log(outline24.toString());
        }
    }

    public class RewardedAdListener implements RewardedVideoAdExtendedListener {
        public boolean hasGrantedReward;
        public final MaxRewardedAdapterListener listener;

        public RewardedAdListener(MaxRewardedAdapterListener maxRewardedAdapterListener) {
            this.listener = maxRewardedAdapterListener;
        }

        public void onAdClicked(C1513Ad ad) {
            FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Rewarded ad clicked: ");
            outline24.append(ad.getPlacementId());
            facebookMediationAdapter.log(outline24.toString());
            this.listener.onRewardedAdClicked();
        }

        public void onAdLoaded(C1513Ad ad) {
            FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Rewarded ad loaded: ");
            outline24.append(ad.getPlacementId());
            facebookMediationAdapter.log(outline24.toString());
            this.listener.onRewardedAdLoaded();
        }

        public void onError(C1513Ad ad, AdError adError) {
            MaxAdapterError access$100 = FacebookMediationAdapter.toMaxError(adError);
            FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Rewarded ad (");
            outline24.append(ad.getPlacementId());
            outline24.append(") failed to load with error (");
            outline24.append(access$100);
            facebookMediationAdapter.log(outline24.toString());
            this.listener.onRewardedAdLoadFailed(access$100);
        }

        public void onLoggingImpression(C1513Ad ad) {
            FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Rewarded ad logging impression: ");
            outline24.append(ad.getPlacementId());
            facebookMediationAdapter.log(outline24.toString());
            this.listener.onRewardedAdDisplayed();
            this.listener.onRewardedAdVideoStarted();
        }

        public void onRewardedVideoActivityDestroyed() {
            FacebookMediationAdapter.this.log("Rewarded ad Activity destroyed");
            if (FacebookMediationAdapter.this.onRewardedAdVideoCompletedCalled.compareAndSet(false, true)) {
                this.listener.onRewardedAdVideoCompleted();
            }
            if (FacebookMediationAdapter.this.onRewardedAdHiddenCalled.compareAndSet(false, true)) {
                this.listener.onRewardedAdHidden();
            }
        }

        public void onRewardedVideoClosed() {
            FacebookMediationAdapter.this.log("Rewarded ad hidden");
            if (FacebookMediationAdapter.this.onRewardedAdHiddenCalled.compareAndSet(false, true)) {
                if (this.hasGrantedReward || FacebookMediationAdapter.this.shouldAlwaysRewardUser()) {
                    MaxReward reward = FacebookMediationAdapter.this.getReward();
                    FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
                    facebookMediationAdapter.log("Rewarded user with reward: " + reward);
                    this.listener.onUserRewarded(reward);
                }
                this.listener.onRewardedAdHidden();
            }
        }

        public void onRewardedVideoCompleted() {
            FacebookMediationAdapter.this.log("Rewarded ad video completed");
            if (FacebookMediationAdapter.this.onRewardedAdVideoCompletedCalled.compareAndSet(false, true)) {
                this.listener.onRewardedAdVideoCompleted();
                this.hasGrantedReward = true;
            }
        }
    }

    public FacebookMediationAdapter(AppLovinSdk appLovinSdk) {
        super(appLovinSdk);
    }

    /* access modifiers changed from: private */
    public MaxNativeAdView createMaxNativeAdView(MaxNativeAd maxNativeAd, String str, Activity activity) {
        if (AppLovinSdk.VERSION_CODE >= 11010000) {
            return new MaxNativeAdView(maxNativeAd, str, getApplicationContext());
        }
        return new MaxNativeAdView(maxNativeAd, str, activity);
    }

    /* access modifiers changed from: private */
    public Context getContext(@Nullable Activity activity) {
        return activity != null ? activity.getApplicationContext() : getApplicationContext();
    }

    private String getMediationIdentifier() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("APPLOVIN_");
        outline24.append(AppLovinSdk.VERSION);
        outline24.append(CertificateUtil.DELIMITER);
        outline24.append(getAdapterVersion());
        return outline24.toString();
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

    private AdSize toAdSize(MaxAdFormat maxAdFormat) {
        if (maxAdFormat == MaxAdFormat.BANNER) {
            return AdSize.BANNER_HEIGHT_50;
        }
        if (maxAdFormat == MaxAdFormat.LEADER) {
            return AdSize.BANNER_HEIGHT_90;
        }
        if (maxAdFormat == MaxAdFormat.MREC) {
            return AdSize.RECTANGLE_HEIGHT_250;
        }
        throw new IllegalArgumentException("Invalid ad format: " + maxAdFormat);
    }

    public static MaxAdapterError toMaxError(AdError adError) {
        int errorCode = adError.getErrorCode();
        MaxAdapterError maxAdapterError = MaxAdapterError.UNSPECIFIED;
        if (errorCode != 2006) {
            if (errorCode != 2100) {
                if (errorCode != 9001) {
                    if (errorCode != 2008) {
                        if (errorCode != 2009) {
                            switch (errorCode) {
                                case 1000:
                                    maxAdapterError = MaxAdapterError.NO_CONNECTION;
                                    break;
                                case 1001:
                                    maxAdapterError = MaxAdapterError.NO_FILL;
                                    break;
                                case 1002:
                                    break;
                                default:
                                    switch (errorCode) {
                                        case 2000:
                                            break;
                                        case AdError.INTERNAL_ERROR_CODE /*2001*/:
                                            break;
                                        case AdError.CACHE_ERROR_CODE /*2002*/:
                                            break;
                                        case AdError.INTERNAL_ERROR_2003 /*2003*/:
                                        case AdError.INTERNAL_ERROR_2004 /*2004*/:
                                            break;
                                        default:
                                            switch (errorCode) {
                                                case AdError.MEDIAVIEW_MISSING_ERROR_CODE /*6001*/:
                                                case AdError.ICONVIEW_MISSING_ERROR_CODE /*6002*/:
                                                case AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE /*6003*/:
                                                    maxAdapterError = new MaxAdapterError((int) MaxAdapterError.ERROR_CODE_MISSING_REQUIRED_NATIVE_AD_ASSETS, "Missing Native Ad Assets");
                                                    break;
                                                default:
                                                    switch (errorCode) {
                                                        case AdError.SHOW_CALLED_BEFORE_LOAD_ERROR_CODE /*7001*/:
                                                        case AdError.LOAD_CALLED_WHILE_SHOWING_AD /*7002*/:
                                                        case AdError.INCORRECT_STATE_ERROR /*7004*/:
                                                        case AdError.NATIVE_AD_IS_NOT_LOADED /*7007*/:
                                                            break;
                                                        case AdError.CLEAR_TEXT_SUPPORT_NOT_ALLOWED /*7003*/:
                                                            maxAdapterError = MaxAdapterError.INVALID_CONFIGURATION;
                                                            break;
                                                        case AdError.MISSING_DEPENDENCIES_ERROR /*7005*/:
                                                        case AdError.API_NOT_SUPPORTED /*7006*/:
                                                            break;
                                                    }
                                            }
                                    }
                            }
                        }
                        maxAdapterError = MaxAdapterError.TIMEOUT;
                        return new MaxAdapterError(maxAdapterError.getErrorCode(), maxAdapterError.getErrorMessage(), errorCode, adError.getErrorMessage());
                    }
                    maxAdapterError = MaxAdapterError.SERVER_ERROR;
                    return new MaxAdapterError(maxAdapterError.getErrorCode(), maxAdapterError.getErrorMessage(), errorCode, adError.getErrorMessage());
                }
                maxAdapterError = MaxAdapterError.INTERNAL_ERROR;
                return new MaxAdapterError(maxAdapterError.getErrorCode(), maxAdapterError.getErrorMessage(), errorCode, adError.getErrorMessage());
            }
            maxAdapterError = MaxAdapterError.INVALID_LOAD_STATE;
            return new MaxAdapterError(maxAdapterError.getErrorCode(), maxAdapterError.getErrorMessage(), errorCode, adError.getErrorMessage());
        }
        maxAdapterError = MaxAdapterError.INTERNAL_ERROR;
        return new MaxAdapterError(maxAdapterError.getErrorCode(), maxAdapterError.getErrorMessage(), errorCode, adError.getErrorMessage());
    }

    private void updateAdSettings(MaxAdapterParameters maxAdapterParameters) {
        Bundle serverParameters = maxAdapterParameters.getServerParameters();
        if (serverParameters.containsKey("video_autoplay")) {
            AdSettings.setVideoAutoplay(serverParameters.getBoolean("video_autoplay"));
        }
        Boolean privacySetting = getPrivacySetting("isAgeRestrictedUser", maxAdapterParameters);
        if (privacySetting != null) {
            AdSettings.setMixedAudience(privacySetting.booleanValue());
        }
        String string = serverParameters.getString("test_device_ids", (String) null);
        if (!TextUtils.isEmpty(string)) {
            AdSettings.addTestDevices(Arrays.asList(string.split(",")));
        }
        AdSettings.setMediationService(getMediationIdentifier());
    }

    public void collectSignal(MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, Activity activity, MaxSignalCollectionListener maxSignalCollectionListener) {
        log("Collecting signal...");
        maxSignalCollectionListener.onSignalCollected(BidderTokenProvider.getBidderToken(getContext(activity)));
    }

    public String getAdapterVersion() {
        return "6.8.0.15";
    }

    public String getSdkVersion() {
        return getVersionString(BuildConfig.class, "VERSION_NAME");
    }

    public void initialize(MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity, final MaxAdapter.OnCompletionListener onCompletionListener) {
        updateAdSettings(maxAdapterInitializationParameters);
        if (INITIALIZED.compareAndSet(false, true)) {
            sStatus = MaxAdapter.InitializationStatus.INITIALIZING;
            ArrayList<String> stringArrayList = maxAdapterInitializationParameters.getServerParameters().getStringArrayList("placement_ids");
            C13321 r1 = new AudienceNetworkAds.InitListener() {
                public void onInitialized(AudienceNetworkAds.InitResult initResult) {
                    if (initResult.isSuccess()) {
                        FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
                        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Facebook SDK successfully finished initialization: ");
                        outline24.append(initResult.getMessage());
                        facebookMediationAdapter.log(outline24.toString());
                        MaxAdapter.InitializationStatus unused = FacebookMediationAdapter.sStatus = MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS;
                        onCompletionListener.onCompletion(FacebookMediationAdapter.sStatus, (String) null);
                        return;
                    }
                    FacebookMediationAdapter facebookMediationAdapter2 = FacebookMediationAdapter.this;
                    StringBuilder outline242 = GeneratedOutlineSupport.outline24("Facebook SDK failed to finished initialization: ");
                    outline242.append(initResult.getMessage());
                    facebookMediationAdapter2.log(outline242.toString());
                    MaxAdapter.InitializationStatus unused2 = FacebookMediationAdapter.sStatus = MaxAdapter.InitializationStatus.INITIALIZED_FAILURE;
                    onCompletionListener.onCompletion(FacebookMediationAdapter.sStatus, initResult.getMessage());
                }
            };
            if (maxAdapterInitializationParameters.isTesting()) {
                AdSettings.setDebugBuild(true);
            }
            log("Initializing Facebook SDK with placements: " + stringArrayList);
            AudienceNetworkAds.buildInitSettings(getContext(activity)).withMediationService(getMediationIdentifier()).withPlacementIds(stringArrayList).withInitListener(r1).initialize();
            return;
        }
        log("Facebook attempted initialization already - marking initialization as completed");
        onCompletionListener.onCompletion(sStatus, (String) null);
    }

    public void loadAdViewAd(MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, Activity activity, MaxAdViewAdapterListener maxAdViewAdapterListener) {
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        boolean z = maxAdapterResponseParameters.getServerParameters().getBoolean("is_native");
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Loading");
        outline24.append(z ? " native " : " ");
        outline24.append(maxAdFormat.getLabel());
        outline24.append(" ad: ");
        outline24.append(thirdPartyAdPlacementId);
        outline24.append("...");
        log(outline24.toString());
        updateAdSettings(maxAdapterResponseParameters);
        if (z) {
            NativeAd nativeAd = new NativeAd(getContext(activity), thirdPartyAdPlacementId);
            this.mNativeAd = nativeAd;
            nativeAd.loadAd(nativeAd.buildLoadAdConfig().withAdListener(new NativeAdViewListener(maxAdapterResponseParameters.getServerParameters(), maxAdFormat, activity, maxAdViewAdapterListener)).withBid(maxAdapterResponseParameters.getBidResponse()).build());
            return;
        }
        AdView adView = new AdView(getContext(activity), thirdPartyAdPlacementId, toAdSize(maxAdFormat));
        this.mAdView = adView;
        adView.loadAd(adView.buildLoadAdConfig().withAdListener(new AdViewListener(maxAdFormat, maxAdViewAdapterListener)).withBid(maxAdapterResponseParameters.getBidResponse()).build());
    }

    public void loadInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Loading interstitial ad: " + thirdPartyAdPlacementId + "...");
        updateAdSettings(maxAdapterResponseParameters);
        InterstitialAd interstitialAd = new InterstitialAd(activity.getApplicationContext(), thirdPartyAdPlacementId);
        this.mInterstitialAd = interstitialAd;
        InterstitialAd.InterstitialAdLoadConfigBuilder withAdListener = interstitialAd.buildLoadAdConfig().withAdListener(new InterstitialAdListener(maxInterstitialAdapterListener));
        if (!this.mInterstitialAd.isAdLoaded() || this.mInterstitialAd.isAdInvalidated()) {
            log("Loading bidding interstitial ad...");
            this.mInterstitialAd.loadAd(withAdListener.withBid(maxAdapterResponseParameters.getBidResponse()).build());
            return;
        }
        log("An interstitial ad has been loaded already");
        maxInterstitialAdapterListener.onInterstitialAdLoaded();
    }

    public void loadNativeAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxNativeAdAdapterListener maxNativeAdAdapterListener) {
        boolean z = BundleUtils.getBoolean("is_native_banner", maxAdapterResponseParameters.getServerParameters());
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log(GeneratedOutlineSupport.outline20(GeneratedOutlineSupport.outline24("Loading native "), z ? "banner " : "", "ad: ", thirdPartyAdPlacementId, "..."));
        updateAdSettings(maxAdapterResponseParameters);
        Context context = getContext(activity);
        if (z) {
            NativeBannerAd nativeBannerAd = new NativeBannerAd(context, thirdPartyAdPlacementId);
            this.mNativeBannerAd = nativeBannerAd;
            nativeBannerAd.loadAd(nativeBannerAd.buildLoadAdConfig().withAdListener(new MaxNativeAdListener(maxAdapterResponseParameters.getServerParameters(), context, maxNativeAdAdapterListener)).withBid(maxAdapterResponseParameters.getBidResponse()).build());
            return;
        }
        NativeAd nativeAd = new NativeAd(context, thirdPartyAdPlacementId);
        this.mNativeAd = nativeAd;
        nativeAd.loadAd(nativeAd.buildLoadAdConfig().withAdListener(new MaxNativeAdListener(maxAdapterResponseParameters.getServerParameters(), context, maxNativeAdAdapterListener)).withBid(maxAdapterResponseParameters.getBidResponse()).build());
    }

    public void loadRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Loading rewarded: " + thirdPartyAdPlacementId + "...");
        updateAdSettings(maxAdapterResponseParameters);
        RewardedVideoAd rewardedVideoAd = new RewardedVideoAd(activity.getApplicationContext(), thirdPartyAdPlacementId);
        this.mRewardedVideoAd = rewardedVideoAd;
        RewardedVideoAd.RewardedVideoAdLoadConfigBuilder withAdListener = rewardedVideoAd.buildLoadAdConfig().withAdListener(new RewardedAdListener(maxRewardedAdapterListener));
        if (!this.mRewardedVideoAd.isAdLoaded() || this.mRewardedVideoAd.isAdInvalidated()) {
            log("Loading bidding rewarded ad...");
            this.mRewardedVideoAd.loadAd(withAdListener.withBid(maxAdapterResponseParameters.getBidResponse()).build());
            return;
        }
        log("A rewarded ad has been loaded already");
        maxRewardedAdapterListener.onRewardedAdLoaded();
    }

    public void loadRewardedInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, final MaxRewardedInterstitialAdapterListener maxRewardedInterstitialAdapterListener) {
        final String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Loading rewarded interstitial: " + thirdPartyAdPlacementId + "...");
        updateAdSettings(maxAdapterResponseParameters);
        RewardedVideoAd rewardedVideoAd = new RewardedVideoAd(activity.getApplicationContext(), thirdPartyAdPlacementId);
        this.mRewardedInterAd = rewardedVideoAd;
        RewardedVideoAd.RewardedVideoAdLoadConfigBuilder withAdListener = rewardedVideoAd.buildLoadAdConfig().withAdExperience(AdExperienceType.AD_EXPERIENCE_TYPE_REWARDED_INTERSTITIAL).withAdListener(new RewardedVideoAdExtendedListener() {
            public boolean hasGrantedReward;

            public void onAdClicked(C1513Ad ad) {
                FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Rewarded interstitial ad clicked: ");
                outline24.append(thirdPartyAdPlacementId);
                facebookMediationAdapter.log(outline24.toString());
                maxRewardedInterstitialAdapterListener.onRewardedInterstitialAdClicked();
            }

            public void onAdLoaded(C1513Ad ad) {
                FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Rewarded interstitial ad loaded: ");
                outline24.append(thirdPartyAdPlacementId);
                facebookMediationAdapter.log(outline24.toString());
                maxRewardedInterstitialAdapterListener.onRewardedInterstitialAdLoaded();
            }

            public void onError(C1513Ad ad, AdError adError) {
                MaxAdapterError access$100 = FacebookMediationAdapter.toMaxError(adError);
                FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Rewarded interstitial ad (");
                outline24.append(thirdPartyAdPlacementId);
                outline24.append(") failed to load with error: ");
                outline24.append(access$100);
                facebookMediationAdapter.log(outline24.toString());
                maxRewardedInterstitialAdapterListener.onRewardedInterstitialAdLoadFailed(access$100);
            }

            public void onLoggingImpression(C1513Ad ad) {
                FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Rewarded interstitial ad logging impression: ");
                outline24.append(thirdPartyAdPlacementId);
                facebookMediationAdapter.log(outline24.toString());
                maxRewardedInterstitialAdapterListener.onRewardedInterstitialAdDisplayed();
                maxRewardedInterstitialAdapterListener.onRewardedInterstitialAdVideoStarted();
            }

            public void onRewardedVideoActivityDestroyed() {
                FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Rewarded interstitial ad Activity destroyed: ");
                outline24.append(thirdPartyAdPlacementId);
                facebookMediationAdapter.log(outline24.toString());
                if (FacebookMediationAdapter.this.onRewardedAdVideoCompletedCalled.compareAndSet(false, true)) {
                    maxRewardedInterstitialAdapterListener.onRewardedInterstitialAdVideoCompleted();
                }
                if (FacebookMediationAdapter.this.onRewardedAdHiddenCalled.compareAndSet(false, true)) {
                    maxRewardedInterstitialAdapterListener.onRewardedInterstitialAdHidden();
                }
            }

            public void onRewardedVideoClosed() {
                if (FacebookMediationAdapter.this.onRewardedAdHiddenCalled.compareAndSet(false, true)) {
                    if (this.hasGrantedReward || FacebookMediationAdapter.this.shouldAlwaysRewardUser()) {
                        MaxReward reward = FacebookMediationAdapter.this.getReward();
                        FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
                        facebookMediationAdapter.log("Rewarded user with reward: " + reward);
                        maxRewardedInterstitialAdapterListener.onUserRewarded(reward);
                    }
                    FacebookMediationAdapter facebookMediationAdapter2 = FacebookMediationAdapter.this;
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Rewarded interstitial ad hidden: ");
                    outline24.append(thirdPartyAdPlacementId);
                    facebookMediationAdapter2.log(outline24.toString());
                    maxRewardedInterstitialAdapterListener.onRewardedInterstitialAdHidden();
                    return;
                }
                FacebookMediationAdapter facebookMediationAdapter3 = FacebookMediationAdapter.this;
                StringBuilder outline242 = GeneratedOutlineSupport.outline24("Rewarded interstitial ad hidden: ");
                outline242.append(thirdPartyAdPlacementId);
                facebookMediationAdapter3.log(outline242.toString());
            }

            public void onRewardedVideoCompleted() {
                FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Rewarded interstitial ad video completed: ");
                outline24.append(thirdPartyAdPlacementId);
                facebookMediationAdapter.log(outline24.toString());
                if (FacebookMediationAdapter.this.onRewardedAdVideoCompletedCalled.compareAndSet(false, true)) {
                    maxRewardedInterstitialAdapterListener.onRewardedInterstitialAdVideoCompleted();
                    this.hasGrantedReward = true;
                }
            }
        });
        if (!this.mRewardedInterAd.isAdLoaded() || this.mRewardedInterAd.isAdInvalidated()) {
            log("Loading bidding rewarded interstitial ad...");
            this.mRewardedInterAd.loadAd(withAdListener.withBid(maxAdapterResponseParameters.getBidResponse()).build());
            return;
        }
        log("A rewarded interstitial ad has been loaded already");
        maxRewardedInterstitialAdapterListener.onRewardedInterstitialAdLoaded();
    }

    public void onDestroy() {
        InterstitialAd interstitialAd = this.mInterstitialAd;
        if (interstitialAd != null) {
            interstitialAd.destroy();
            this.mInterstitialAd = null;
        }
        RewardedVideoAd rewardedVideoAd = this.mRewardedVideoAd;
        if (rewardedVideoAd != null) {
            rewardedVideoAd.destroy();
            this.mRewardedVideoAd = null;
        }
        RewardedVideoAd rewardedVideoAd2 = this.mRewardedInterAd;
        if (rewardedVideoAd2 != null) {
            rewardedVideoAd2.destroy();
            this.mRewardedInterAd = null;
        }
        AdView adView = this.mAdView;
        if (adView != null) {
            adView.destroy();
            this.mAdView = null;
        }
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd != null) {
            nativeAd.unregisterView();
            this.mNativeAd.destroy();
            this.mNativeAd = null;
        }
        NativeBannerAd nativeBannerAd = this.mNativeBannerAd;
        if (nativeBannerAd != null) {
            nativeBannerAd.unregisterView();
            this.mNativeBannerAd.destroy();
            this.mNativeBannerAd = null;
        }
    }

    public void showInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Showing interstitial ad: ");
        outline24.append(maxAdapterResponseParameters.getThirdPartyAdPlacementId());
        outline24.append("...");
        log(outline24.toString());
        InterstitialAd interstitialAd = this.mInterstitialAd;
        if (interstitialAd == null || !interstitialAd.isAdLoaded()) {
            log("Unable to show interstitial - no ad loaded...");
            maxInterstitialAdapterListener.onInterstitialAdDisplayFailed(MaxAdapterError.AD_NOT_READY);
        } else if (!this.mInterstitialAd.isAdInvalidated()) {
            this.mInterstitialAd.show();
        } else {
            log("Unable to show interstitial - ad expired...");
            maxInterstitialAdapterListener.onInterstitialAdDisplayFailed(MaxAdapterError.AD_EXPIRED);
        }
    }

    public void showRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Showing rewarded ad: ");
        outline24.append(maxAdapterResponseParameters.getThirdPartyAdPlacementId());
        outline24.append("...");
        log(outline24.toString());
        RewardedVideoAd rewardedVideoAd = this.mRewardedVideoAd;
        if (rewardedVideoAd == null || !rewardedVideoAd.isAdLoaded()) {
            log("Unable to show rewarded ad - no ad loaded...");
            maxRewardedAdapterListener.onRewardedAdDisplayFailed(MaxAdapterError.AD_NOT_READY);
        } else if (!this.mRewardedVideoAd.isAdInvalidated()) {
            configureReward(maxAdapterResponseParameters);
            this.mRewardedVideoAd.show();
        } else {
            log("Unable to show rewarded ad - ad expired...");
            maxRewardedAdapterListener.onRewardedAdDisplayFailed(MaxAdapterError.AD_EXPIRED);
        }
    }

    public void showRewardedInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedInterstitialAdapterListener maxRewardedInterstitialAdapterListener) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Showing rewarded interstitial ad: ");
        outline24.append(maxAdapterResponseParameters.getThirdPartyAdPlacementId());
        outline24.append("...");
        log(outline24.toString());
        RewardedVideoAd rewardedVideoAd = this.mRewardedInterAd;
        if (rewardedVideoAd == null || !rewardedVideoAd.isAdLoaded()) {
            log("Unable to show rewarded interstitial ad - no ad loaded...");
            maxRewardedInterstitialAdapterListener.onRewardedInterstitialAdDisplayFailed(MaxAdapterError.AD_NOT_READY);
        } else if (!this.mRewardedInterAd.isAdInvalidated()) {
            configureReward(maxAdapterResponseParameters);
            this.mRewardedInterAd.show();
        } else {
            log("Unable to show rewarded interstitial ad - ad expired...");
            maxRewardedInterstitialAdapterListener.onRewardedInterstitialAdDisplayFailed(MaxAdapterError.AD_EXPIRED);
        }
    }
}
