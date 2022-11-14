package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzps implements Runnable {
    public final zzpy zza;
    public final int zzb;
    public final long zzc;
    public final long zzd;

    public zzps(zzpy zzpy, int i, long j, long j2) {
        this.zza = zzpy;
        this.zzb = i;
        this.zzc = j;
        this.zzd = j2;
    }

    public final void run() {
        this.zza.zzp(this.zzb, this.zzc, this.zzd);
    }
}
