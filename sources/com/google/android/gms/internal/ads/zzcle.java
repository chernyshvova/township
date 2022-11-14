package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzcle implements Runnable {
    public final zzciz zza;
    public final boolean zzb;
    public final long zzc;

    public zzcle(zzciz zzciz, boolean z, long j) {
        this.zza = zzciz;
        this.zzb = z;
        this.zzc = j;
    }

    public final void run() {
        this.zza.zzv(this.zzb, this.zzc);
    }
}
