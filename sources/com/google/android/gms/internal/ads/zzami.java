package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzami implements Runnable {
    public final zzamm zza;
    public final Object zzb;
    public final long zzc;

    public zzami(zzamm zzamm, Object obj, long j) {
        this.zza = zzamm;
        this.zzb = obj;
        this.zzc = j;
    }

    public final void run() {
        this.zza.zzn(this.zzb, this.zzc);
    }
}
