package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzbtb implements zzbsn {
    public final zzbtt zza;
    public final zzbts zzb;
    public final zzbso zzc;

    public zzbtb(zzbtt zzbtt, zzbts zzbts, zzbso zzbso) {
        this.zza = zzbtt;
        this.zzb = zzbts;
        this.zzc = zzbso;
    }

    public final void zza() {
        zzr.zza.postDelayed(new zzbtc(this.zza, this.zzb, this.zzc), 10000);
    }
}
