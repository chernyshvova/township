package com.google.android.gms.ads.mediation;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public interface MediationNativeListener {
    void onAdClicked(@RecentlyNonNull MediationNativeAdapter mediationNativeAdapter);

    void onAdClosed(@RecentlyNonNull MediationNativeAdapter mediationNativeAdapter);

    @Deprecated
    void onAdFailedToLoad(@RecentlyNonNull MediationNativeAdapter mediationNativeAdapter, int i);

    void onAdFailedToLoad(@RecentlyNonNull MediationNativeAdapter mediationNativeAdapter, @RecentlyNonNull AdError adError);

    void onAdImpression(@RecentlyNonNull MediationNativeAdapter mediationNativeAdapter);

    void onAdLeftApplication(@RecentlyNonNull MediationNativeAdapter mediationNativeAdapter);

    void onAdLoaded(@RecentlyNonNull MediationNativeAdapter mediationNativeAdapter, @RecentlyNonNull UnifiedNativeAdMapper unifiedNativeAdMapper);

    void onAdOpened(@RecentlyNonNull MediationNativeAdapter mediationNativeAdapter);

    void onVideoEnd(@RecentlyNonNull MediationNativeAdapter mediationNativeAdapter);

    void zzb(@RecentlyNonNull MediationNativeAdapter mediationNativeAdapter, @RecentlyNonNull NativeCustomTemplateAd nativeCustomTemplateAd);

    void zzc(@RecentlyNonNull MediationNativeAdapter mediationNativeAdapter, @RecentlyNonNull NativeCustomTemplateAd nativeCustomTemplateAd, @RecentlyNonNull String str);
}
