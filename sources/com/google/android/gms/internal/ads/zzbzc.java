package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbzc extends zzbob {
    public final NativeAd.UnconfirmedClickListener zza;

    public zzbzc(NativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        this.zza = unconfirmedClickListener;
    }

    public final void zze(String str) {
        this.zza.onUnconfirmedClickReceived(str);
    }

    public final void zzf() {
        this.zza.onUnconfirmedClickCancelled();
    }
}
