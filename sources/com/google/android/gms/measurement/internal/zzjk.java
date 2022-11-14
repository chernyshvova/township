package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzjk implements Runnable {
    public final /* synthetic */ zzei zza;
    public final /* synthetic */ zzjl zzb;

    public zzjk(zzjl zzjl, zzei zzei) {
        this.zzb = zzjl;
        this.zza = zzei;
    }

    public final void run() {
        synchronized (this.zzb) {
            boolean unused = this.zzb.zzb = false;
            if (!this.zzb.zza.zzaa()) {
                this.zzb.zza.zzq().zzw().zza("Connected to service");
                this.zzb.zza.zza(this.zza);
            }
        }
    }
}
