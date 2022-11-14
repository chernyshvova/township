package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
public final class zzm<TResult> implements zzr<TResult> {
    public final Executor zza;
    public final Object zzb = new Object();
    @GuardedBy("mLock")
    @Nullable
    public OnSuccessListener<? super TResult> zzc;

    public zzm(@NonNull Executor executor, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        this.zza = executor;
        this.zzc = onSuccessListener;
    }

    public final void zza(@NonNull Task<TResult> task) {
        if (task.isSuccessful()) {
            synchronized (this.zzb) {
                if (this.zzc != null) {
                    this.zza.execute(new zzn(this, task));
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
