package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
public final class zzp<TResult, TContinuationResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TContinuationResult>, zzr<TResult> {
    public final Executor zza;
    public final SuccessContinuation<TResult, TContinuationResult> zzb;
    public final zzu<TContinuationResult> zzc;

    public zzp(@NonNull Executor executor, @NonNull SuccessContinuation<TResult, TContinuationResult> successContinuation, @NonNull zzu<TContinuationResult> zzu) {
        this.zza = executor;
        this.zzb = successContinuation;
        this.zzc = zzu;
    }

    public final void onCanceled() {
        this.zzc.zza();
    }

    public final void onFailure(@NonNull Exception exc) {
        this.zzc.zza(exc);
    }

    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.zzc.zza(tcontinuationresult);
    }

    public final void zza(@NonNull Task<TResult> task) {
        this.zza.execute(new zzo(this, task));
    }

    public final void zza() {
        throw new UnsupportedOperationException();
    }
}
