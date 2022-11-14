package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbzb extends zzbnv {
    public final NativeAd.OnNativeAdLoadedListener zza;

    public zzbzb(NativeAd.OnNativeAdLoadedListener onNativeAdLoadedListener) {
        this.zza = onNativeAdLoadedListener;
    }

    public final void zze(zzbof zzbof) {
        this.zza.onNativeAdLoaded(new zzbyv(zzbof));
    }
}
