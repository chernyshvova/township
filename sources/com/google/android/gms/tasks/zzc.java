package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
public final class zzc<TResult, TContinuationResult> implements zzr<TResult> {
    public final Executor zza;
    public final Continuation<TResult, TContinuationResult> zzb;
    public final zzu<TContinuationResult> zzc;

    public zzc(@NonNull Executor executor, @NonNull Continuation<TResult, TContinuationResult> continuation, @NonNull zzu<TContinuationResult> zzu) {
        this.zza = executor;
        this.zzb = continuation;
        this.zzc = zzu;
    }

    public final void zza(@NonNull Task<TResult> task) {
        this.zza.execute(new zze(this, task));
    }

    public final void zza() {
        throw new UnsupportedOperationException();
    }
}
