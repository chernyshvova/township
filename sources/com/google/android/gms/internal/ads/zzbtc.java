package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzbtc implements Runnable {
    public final zzbtt zza;
    public final zzbts zzb;
    public final zzbso zzc;

    public zzbtc(zzbtt zzbtt, zzbts zzbts, zzbso zzbso) {
        this.zza = zzbtt;
        this.zzb = zzbts;
        this.zzc = zzbso;
    }

    public final void run() {
        this.zza.zze(this.zzb, this.zzc);
    }
}
