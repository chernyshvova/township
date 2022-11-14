package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzbtq implements Runnable {
    public final zzbtr zza;
    public final zzbso zzb;

    public zzbtq(zzbtr zzbtr, zzbso zzbso) {
        this.zza = zzbtr;
        this.zzb = zzbso;
    }

    public final void run() {
        zzbso zzbso = this.zzb;
        zzbso.zzm("/result", zzbpr.zzp);
        zzbso.zzi();
    }
}
