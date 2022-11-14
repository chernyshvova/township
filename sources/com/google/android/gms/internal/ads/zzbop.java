package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbop extends zzbnv {
    public final UnifiedNativeAd.OnUnifiedNativeAdLoadedListener zza;

    public zzbop(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
        this.zza = onUnifiedNativeAdLoadedListener;
    }

    public final void zze(zzbof zzbof) {
        this.zza.onUnifiedNativeAdLoaded(new zzbog(zzbof));
    }
}
