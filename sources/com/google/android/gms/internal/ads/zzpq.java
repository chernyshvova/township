package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzpq implements Runnable {
    public final zzpy zza;
    public final zzkc zzb;
    public final zzrs zzc;

    public zzpq(zzpy zzpy, zzkc zzkc, zzrs zzrs) {
        this.zza = zzpy;
        this.zzb = zzkc;
        this.zzc = zzrs;
    }

    public final void run() {
        this.zza.zzr(this.zzb, this.zzc);
    }
}
