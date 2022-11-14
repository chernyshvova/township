package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdLoadCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbdg<AdT> extends zzbfg {
    public final AdLoadCallback<AdT> zza;
    public final AdT zzb;

    public zzbdg(AdLoadCallback<AdT> adLoadCallback, AdT adt) {
        this.zza = adLoadCallback;
        this.zzb = adt;
    }

    public final void zzb() {
        AdT adt;
        AdLoadCallback<AdT> adLoadCallback = this.zza;
        if (adLoadCallback != null && (adt = this.zzb) != null) {
            adLoadCallback.onAdLoaded(adt);
        }
    }

    public final void zzc(zzbdd zzbdd) {
        AdLoadCallback<AdT> adLoadCallback = this.zza;
        if (adLoadCallback != null) {
            adLoadCallback.onAdFailedToLoad(zzbdd.zzb());
        }
    }
}
