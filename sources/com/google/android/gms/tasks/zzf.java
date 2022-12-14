package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
public final class zzf implements Runnable {
    public final /* synthetic */ Task zza;
    public final /* synthetic */ zzd zzb;

    public zzf(zzd zzd, Task task) {
        this.zzb = zzd;
        this.zza = task;
    }

    public final void run() {
        try {
            Task task = (Task) this.zzb.zzb.then(this.zza);
            if (task == null) {
                this.zzb.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            task.addOnSuccessListener(TaskExecutors.zza, this.zzb);
            task.addOnFailureListener(TaskExecutors.zza, (OnFailureListener) this.zzb);
            task.addOnCanceledListener(TaskExecutors.zza, (OnCanceledListener) this.zzb);
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
