package com.applovin.impl.sdk.nativeAd;

public interface AppLovinNativeAdLoadListener {
    void onNativeAdLoadFailed(int i);

    void onNativeAdLoaded(AppLovinNativeAd appLovinNativeAd);
}
