package com.facebook.ads.internal.api;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeAdsManager;
import com.facebook.proguard.annotations.DoNotStripAny;

@DoNotStripAny
@Keep
public interface NativeAdsManagerApi {
    void disableAutoRefresh();

    int getUniqueNativeAdCount();

    boolean isLoaded();

    void loadAds();

    void loadAds(NativeAdBase.MediaCacheFlag mediaCacheFlag);

    @Nullable
    NativeAd nextNativeAd();

    @Nullable
    NativeAd nextNativeAd(NativeAdListener nativeAdListener);

    void setExtraHints(String str);

    void setListener(NativeAdsManager.Listener listener);
}
