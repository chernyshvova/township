package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
public final class zzl<TResult> implements zzr<TResult> {
    public final Executor zza;
    public final Object zzb = new Object();
    @GuardedBy("mLock")
    @Nullable
    public OnFailureListener zzc;

    public zzl(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        this.zza = executor;
        this.zzc = onFailureListener;
    }

    public final void zza(@NonNull Task<TResult> task) {
        if (!task.isSuccessful() && !task.isCanceled()) {
            synchronized (this.zzb) {
                if (this.zzc != null) {
                    this.zza.execute(new zzk(this, task));
                }
            }
        }
    }

    public final void zza() {
        synchronized (this.zzb) {
            this.zzc = null;
        }
    }
}
