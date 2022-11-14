package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzjz implements Runnable {
    public final /* synthetic */ long zza;
    public final /* synthetic */ zzjx zzb;

    public zzjz(zzjx zzjx, long j) {
        this.zzb = zzjx;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzc(this.zza);
    }
}
