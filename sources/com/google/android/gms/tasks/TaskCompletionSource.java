package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
public class TaskCompletionSource<TResult> {
    public final zzu<TResult> zza = new zzu<>();

    public TaskCompletionSource() {
    }

    @NonNull
    public Task<TResult> getTask() {
        return this.zza;
    }

    public void setException(@NonNull Exception exc) {
        this.zza.zza(exc);
    }

    public void setResult(@Nullable TResult tresult) {
        this.zza.zza(tresult);
    }

    public boolean trySetException(@NonNull Exception exc) {
        return this.zza.zzb(exc);
    }

    public boolean trySetResult(@Nullable TResult tresult) {
        return this.zza.zzb(tresult);
    }

    public TaskCompletionSource(@NonNull CancellationToken cancellationToken) {
        cancellationToken.onCanceledRequested(new zzs(this));
    }
}
