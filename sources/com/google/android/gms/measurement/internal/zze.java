package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zze implements Runnable {
    public final /* synthetic */ long zza;
    public final /* synthetic */ zza zzb;

    public zze(zza zza2, long j) {
        this.zzb = zza2;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzb(this.zza);
    }
}
