package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
public final class zzi<TResult> implements zzr<TResult> {
    public final Executor zza;
    public final Object zzb = new Object();
    @GuardedBy("mLock")
    @Nullable
    public OnCompleteListener<TResult> zzc;

    public zzi(@NonNull Executor executor, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.zza = executor;
        this.zzc = onCompleteListener;
    }

    public final void zza(@NonNull Task<TResult> task) {
        synchronized (this.zzb) {
            if (this.zzc != null) {
                this.zza.execute(new zzj(this, task));
            }
        }
    }

    public final void zza() {
        synchronized (this.zzb) {
            this.zzc = null;
        }
    }
}
