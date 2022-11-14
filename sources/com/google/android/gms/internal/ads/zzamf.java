package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzamf implements Runnable {
    public final zzamm zza;
    public final int zzb;
    public final long zzc;

    public zzamf(zzamm zzamm, int i, long j) {
        this.zza = zzamm;
        this.zzb = i;
        this.zzc = j;
    }

    public final void run() {
        this.zza.zzq(this.zzb, this.zzc);
    }
}
