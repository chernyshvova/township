package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
public final class zzn implements Runnable {
    public final /* synthetic */ Task zza;
    public final /* synthetic */ zzm zzb;

    public zzn(zzm zzm, Task task) {
        this.zzb = zzm;
        this.zza = task;
    }

    public final void run() {
        synchronized (this.zzb.zzb) {
            if (this.zzb.zzc != null) {
                this.zzb.zzc.onSuccess(this.zza.getResult());
            }
        }
    }
}
