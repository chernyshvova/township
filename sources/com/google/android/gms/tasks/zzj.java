package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
public final class zzj implements Runnable {
    public final /* synthetic */ Task zza;
    public final /* synthetic */ zzi zzb;

    public zzj(zzi zzi, Task task) {
        this.zzb = zzi;
        this.zza = task;
    }

    public final void run() {
        synchronized (this.zzb.zzb) {
            if (this.zzb.zzc != null) {
                this.zzb.zzc.onComplete(this.zza);
            }
        }
    }
}
