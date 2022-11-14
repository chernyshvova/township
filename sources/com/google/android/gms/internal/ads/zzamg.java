package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzamg implements Runnable {
    public final zzamm zza;
    public final long zzb;
    public final int zzc;

    public zzamg(zzamm zzamm, long j, int i) {
        this.zza = zzamm;
        this.zzb = j;
        this.zzc = i;
    }

    public final void run() {
        this.zza.zzp(this.zzb, this.zzc);
    }
}
