package com.google.android.gms.tasks;

import android.app.Activity;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
public final class zzu<TResult> extends Task<TResult> {
    public final Object zza = new Object();
    public final zzq<TResult> zzb = new zzq<>();
    @GuardedBy("mLock")
    public boolean zzc;
    public volatile boolean zzd;
    @GuardedBy("mLock")
    @Nullable
    public TResult zze;
    @GuardedBy("mLock")
    public Exception zzf;

    @GuardedBy("mLock")
    private final void zzc() {
        if (this.zzc) {
            throw DuplicateTaskCompletionException.m2817of(this);
        }
    }

    @GuardedBy("mLock")
    private final void zzd() {
        if (this.zzd) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    private final void zze() {
        synchronized (this.zza) {
            if (this.zzc) {
                this.zzb.zza(this);
            }
        }
    }

    @NonNull
    public final Task<TResult> addOnCanceledListener(@NonNull OnCanceledListener onCanceledListener) {
        return addOnCanceledListener(TaskExecutors.MAIN_THREAD, onCanceledListener);
    }

    @NonNull
    public final Task<TResult> addOnCompleteListener(@NonNull OnCompleteListener<TResult> onCompleteListener) {
        return addOnCompleteListener(TaskExecutors.MAIN_THREAD, onCompleteListener);
    }

    @NonNull
    public final Task<TResult> addOnFailureListener(@NonNull OnFailureListener onFailureListener) {
        return addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
    }

    @NonNull
    public final Task<TResult> addOnSuccessListener(@NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        return addOnSuccessListener(TaskExecutors.MAIN_THREAD, onSuccessListener);
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Continuation<TResult, TContinuationResult> continuation) {
        return continueWith(TaskExecutors.MAIN_THREAD, continuation);
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Continuation<TResult, Task<TContinuationResult>> continuation) {
        return continueWithTask(TaskExecutors.MAIN_THREAD, continuation);
    }

    @Nullable
    public final Exception getException() {
        Exception exc;
        synchronized (this.zza) {
            exc = this.zzf;
        }
        return exc;
    }

    public final TResult getResult() {
        TResult tresult;
        synchronized (this.zza) {
            zzb();
            zzd();
            if (this.zzf == null) {
                tresult = this.zze;
            } else {
                throw new RuntimeExecutionException(this.zzf);
            }
        }
        return tresult;
    }

    public final boolean isCanceled() {
        return this.zzd;
    }

    public final boolean isComplete() {
        boolean z;
        synchronized (this.zza) {
            z = this.zzc;
        }
        return z;
    }

    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.zza) {
            z = this.zzc && !this.zzd && this.zzf == null;
        }
        return z;
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor executor, SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        zzu zzu = new zzu();
        this.zzb.zza(new zzp(zzv.zza(executor), successContinuation, zzu));
        zze();
        return zzu;
    }

    public final void zza(@Nullable TResult tresult) {
        synchronized (this.zza) {
            zzc();
            this.zzc = true;
            this.zze = tresult;
        }
        this.zzb.zza(this);
    }

    public final boolean zzb(@Nullable TResult tresult) {
        synchronized (this.zza) {
            if (this.zzc) {
                return false;
            }
            this.zzc = true;
            this.zze = tresult;
            this.zzb.zza(this);
            return true;
        }
    }

    @NonNull
    public final Task<TResult> addOnCanceledListener(@NonNull Executor executor, @NonNull OnCanceledListener onCanceledListener) {
        this.zzb.zza(new zzh(zzv.zza(executor), onCanceledListener));
        zze();
        return this;
    }

    @NonNull
    public final Task<TResult> addOnCompleteListener(@NonNull Executor executor, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.zzb.zza(new zzi(zzv.zza(executor), onCompleteListener));
        zze();
        return this;
    }

    @NonNull
    public final Task<TResult> addOnFailureListener(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        this.zzb.zza(new zzl(zzv.zza(executor), onFailureListener));
        zze();
        return this;
    }

    @NonNull
    public final Task<TResult> addOnSuccessListener(@NonNull Executor executor, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        this.zzb.zza(new zzm(zzv.zza(executor), onSuccessListener));
        zze();
        return this;
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Executor executor, @NonNull Continuation<TResult, TContinuationResult> continuation) {
        zzu zzu = new zzu();
        this.zzb.zza(new zzc(zzv.zza(executor), continuation, zzu));
        zze();
        return zzu;
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Executor executor, @NonNull Continuation<TResult, Task<TContinuationResult>> continuation) {
        zzu zzu = new zzu();
        this.zzb.zza(new zzd(zzv.zza(executor), continuation, zzu));
        zze();
        return zzu;
    }

    /* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
    public static class zza extends LifecycleCallback {
        public final List<WeakReference<zzr<?>>> zza = new ArrayList();

        public zza(LifecycleFragment lifecycleFragment) {
            super(lifecycleFragment);
            this.mLifecycleFragment.addCallback("TaskOnStopCallback", this);
        }

        public static zza zza(Activity activity) {
            LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
            zza zza2 = (zza) fragment.getCallbackOrNull("TaskOnStopCallback", zza.class);
            return zza2 == null ? new zza(fragment) : zza2;
        }

        @MainThread
        public void onStop() {
            synchronized (this.zza) {
                for (WeakReference<zzr<?>> weakReference : this.zza) {
                    zzr zzr = (zzr) weakReference.get();
                    if (zzr != null) {
                        zzr.zza();
                    }
                }
                this.zza.clear();
            }
        }

        public final <T> void zza(zzr<T> zzr) {
            synchronized (this.zza) {
                this.zza.add(new WeakReference(zzr));
            }
        }
    }

    @NonNull
    public final Task<TResult> addOnCanceledListener(@NonNull Activity activity, @NonNull OnCanceledListener onCanceledListener) {
        zzh zzh = new zzh(zzv.zza(TaskExecutors.MAIN_THREAD), onCanceledListener);
        this.zzb.zza(zzh);
        zza.zza(activity).zza(zzh);
        zze();
        return this;
    }

    @NonNull
    public final Task<TResult> addOnCompleteListener(@NonNull Activity activity, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        zzi zzi = new zzi(zzv.zza(TaskExecutors.MAIN_THREAD), onCompleteListener);
        this.zzb.zza(zzi);
        zza.zza(activity).zza(zzi);
        zze();
        return this;
    }

    @NonNull
    public final Task<TResult> addOnFailureListener(@NonNull Activity activity, @NonNull OnFailureListener onFailureListener) {
        zzl zzl = new zzl(zzv.zza(TaskExecutors.MAIN_THREAD), onFailureListener);
        this.zzb.zza(zzl);
        zza.zza(activity).zza(zzl);
        zze();
        return this;
    }

    @NonNull
    public final Task<TResult> addOnSuccessListener(@NonNull Activity activity, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        zzm zzm = new zzm(zzv.zza(TaskExecutors.MAIN_THREAD), onSuccessListener);
        this.zzb.zza(zzm);
        zza.zza(activity).zza(zzm);
        zze();
        return this;
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(@NonNull SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        return onSuccessTask(TaskExecutors.MAIN_THREAD, successContinuation);
    }

    public final <X extends Throwable> TResult getResult(@NonNull Class<X> cls) throws Throwable {
        TResult tresult;
        synchronized (this.zza) {
            zzb();
            zzd();
            if (cls.isInstance(this.zzf)) {
                throw ((Throwable) cls.cast(this.zzf));
            } else if (this.zzf == null) {
                tresult = this.zze;
            } else {
                throw new RuntimeExecutionException(this.zzf);
            }
        }
        return tresult;
    }

    public final void zza(@NonNull Exception exc) {
        Preconditions.checkNotNull(exc, "Exception must not be null");
        synchronized (this.zza) {
            zzc();
            this.zzc = true;
            this.zzf = exc;
        }
        this.zzb.zza(this);
    }

    public final boolean zzb(@NonNull Exception exc) {
        Preconditions.checkNotNull(exc, "Exception must not be null");
        synchronized (this.zza) {
            if (this.zzc) {
                return false;
            }
            this.zzc = true;
            this.zzf = exc;
            this.zzb.zza(this);
            return true;
        }
    }

    public final boolean zza() {
        synchronized (this.zza) {
            if (this.zzc) {
                return false;
            }
            this.zzc = true;
            this.zzd = true;
            this.zzb.zza(this);
            return true;
        }
    }

    @GuardedBy("mLock")
    private final void zzb() {
        Preconditions.checkState(this.zzc, "Task is not yet complete");
    }
}
