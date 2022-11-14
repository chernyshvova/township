package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzamd implements Runnable {
    public final zzamm zza;
    public final String zzb;
    public final long zzc;
    public final long zzd;

    public zzamd(zzamm zzamm, String str, long j, long j2) {
        this.zza = zzamm;
        this.zzb = str;
        this.zzc = j;
        this.zzd = j2;
    }

    public final void run() {
        this.zza.zzs(this.zzb, this.zzc, this.zzd);
    }
}
