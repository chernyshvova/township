package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzjv implements Runnable {
    public final /* synthetic */ zzkl zza;
    public final /* synthetic */ Runnable zzb;

    public zzjv(zzjq zzjq, zzkl zzkl, Runnable runnable) {
        this.zza = zzkl;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzr();
        this.zza.zza(this.zzb);
        this.zza.zzo();
    }
}
