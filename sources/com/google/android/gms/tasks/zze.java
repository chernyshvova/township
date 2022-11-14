package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
public final class zze implements Runnable {
    public final /* synthetic */ Task zza;
    public final /* synthetic */ zzc zzb;

    public zze(zzc zzc, Task task) {
        this.zzb = zzc;
        this.zza = task;
    }

    public final void run() {
        if (this.zza.isCanceled()) {
            this.zzb.zzc.zza();
            return;
        }
        try {
            this.zzb.zzc.zza(this.zzb.zzb.then(this.zza));
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                this.zzb.zzc.zza((Exception) e.getCause());
            } else {
                this.zzb.zzc.zza((Exception) e);
            }
        } catch (Exception e2) {
            this.zzb.zzc.zza(e2);
        }
    }
}
