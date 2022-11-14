package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.LoadAdError;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbho extends zzbew {
    public final /* synthetic */ zzbhp zza;

    public zzbho(zzbhp zzbhp) {
        this.zza = zzbhp;
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zza.zze.zza(this.zza.zzw());
        super.onAdFailedToLoad(loadAdError);
    }

    public final void onAdLoaded() {
        this.zza.zze.zza(this.zza.zzw());
        super.onAdLoaded();
    }
}
