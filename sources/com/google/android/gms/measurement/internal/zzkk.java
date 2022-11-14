package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzkk implements Runnable {
    public final /* synthetic */ zzks zza;
    public final /* synthetic */ zzkl zzb;

    public zzkk(zzkl zzkl, zzks zzks) {
        this.zzb = zzkl;
        this.zza = zzks;
    }

    public final void run() {
        this.zzb.zza(this.zza);
        this.zzb.zza();
    }
}
