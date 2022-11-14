package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzjm implements Runnable {
    public final /* synthetic */ zzei zza;
    public final /* synthetic */ zzjl zzb;

    public zzjm(zzjl zzjl, zzei zzei) {
        this.zzb = zzjl;
        this.zza = zzei;
    }

    public final void run() {
        synchronized (this.zzb) {
            boolean unused = this.zzb.zzb = false;
            if (!this.zzb.zza.zzaa()) {
                this.zzb.zza.zzq().zzv().zza("Connected to remote service");
                this.zzb.zza.zza(this.zza);
            }
        }
    }
}
