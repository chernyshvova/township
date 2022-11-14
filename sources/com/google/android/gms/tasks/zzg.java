package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
public final class zzg implements Runnable {
    public final /* synthetic */ zzh zza;

    public zzg(zzh zzh) {
        this.zza = zzh;
    }

    public final void run() {
        synchronized (this.zza.zzb) {
            if (this.zza.zzc != null) {
                this.zza.zzc.onCanceled();
            }
        }
    }
}
