package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzim implements Runnable {
    public final /* synthetic */ long zza;
    public final /* synthetic */ zzii zzb;

    public zzim(zzii zzii, long j) {
        this.zzb = zzii;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzd().zza(this.zza);
        this.zzb.zza = null;
    }
}
