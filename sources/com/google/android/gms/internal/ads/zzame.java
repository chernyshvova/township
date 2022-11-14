package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzame implements Runnable {
    public final zzamm zza;
    public final zzkc zzb;
    public final zzrs zzc;

    public zzame(zzamm zzamm, zzkc zzkc, zzrs zzrs) {
        this.zza = zzamm;
        this.zzb = zzkc;
        this.zzc = zzrs;
    }

    public final void run() {
        this.zza.zzr(this.zzb, this.zzc);
    }
}
