package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
public final class Tasks {

    /* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
    public interface zza<T> extends OnCanceledListener, OnFailureListener, OnSuccessListener<T> {
    }

    /* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
    public static final class zzb implements zza {
        public final CountDownLatch zza;

        public zzb() {
            this.zza = new CountDownLatch(1);
        }

        public final void onCanceled() {
            this.zza.countDown();
        }

        public final void onFailure(@NonNull Exception exc) {
            this.zza.countDown();
        }

        public final void onSuccess(Object obj) {
            this.zza.countDown();
        }

        public final void zza() throws InterruptedException {
            this.zza.await();
        }

        public final boolean zza(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.zza.await(j, timeUnit);
        }

        public /* synthetic */ zzb(zzy zzy) {
            this();
        }
    }

    /* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
    public static final class zzc implements zza {
        public final Object zza = new Object();
        public final int zzb;
        public final zzu<Void> zzc;
        @GuardedBy("mLock")
        public int zzd;
        @GuardedBy("mLock")
        public int zze;
        @GuardedBy("mLock")
        public int zzf;
        @GuardedBy("mLock")
        public Exception zzg;
        @GuardedBy("mLock")
        public boolean zzh;

        public zzc(int i, zzu<Void> zzu) {
            this.zzb = i;
            this.zzc = zzu;
        }

        @GuardedBy("mLock")
        private final void zza() {
            if (this.zzd + this.zze + this.zzf != this.zzb) {
                return;
            }
            if (this.zzg != null) {
                zzu<Void> zzu = this.zzc;
                int i = this.zze;
                int i2 = this.zzb;
                StringBuilder sb = new StringBuilder(54);
                sb.append(i);
                sb.append(" out of ");
                sb.append(i2);
                sb.append(" underlying tasks failed");
                zzu.zza((Exception) new ExecutionException(sb.toString(), this.zzg));
            } else if (this.zzh) {
                this.zzc.zza();
            } else {
                this.zzc.zza(null);
            }
        }

        public final void onCanceled() {
            synchronized (this.zza) {
                this.zzf++;
                this.zzh = true;
                zza();
            }
        }

        public final void onFailure(@NonNull Exception exc) {
            synchronized (this.zza) {
                this.zze++;
                this.zzg = exc;
                zza();
            }
        }

        public final void onSuccess(Object obj) {
            synchronized (this.zza) {
                this.zzd++;
                zza();
            }
        }
    }

    public static <TResult> TResult await(@NonNull Task<TResult> task) throws ExecutionException, InterruptedException {
        Preconditions.checkNotMainThread();
        Preconditions.checkNotNull(task, "Task must not be null");
        if (task.isComplete()) {
            return zza(task);
        }
        zzb zzb2 = new zzb((zzy) null);
        zza(task, zzb2);
        zzb2.zza();
        return zza(task);
    }

    @NonNull
    @Deprecated
    public static <TResult> Task<TResult> call(@NonNull Callable<TResult> callable) {
        return call(TaskExecutors.MAIN_THREAD, callable);
    }

    @NonNull
    public static <TResult> Task<TResult> forCanceled() {
        zzu zzu = new zzu();
        zzu.zza();
        return zzu;
    }

    @NonNull
    public static <TResult> Task<TResult> forException(@NonNull Exception exc) {
        zzu zzu = new zzu();
        zzu.zza(exc);
        return zzu;
    }

    @NonNull
    public static <TResult> Task<TResult> forResult(TResult tresult) {
        zzu zzu = new zzu();
        zzu.zza(tresult);
        return zzu;
    }

    @NonNull
    public static Task<Void> whenAll(@Nullable Collection<? extends Task<?>> collection) {
        if (collection == null || collection.isEmpty()) {
            return forResult((Object) null);
        }
        for (Task task : collection) {
            if (task == null) {
                throw new NullPointerException("null tasks are not accepted");
            }
        }
        zzu zzu = new zzu();
        zzc zzc2 = new zzc(collection.size(), zzu);
        for (Task zza2 : collection) {
            zza(zza2, zzc2);
        }
        return zzu;
    }

    @NonNull
    public static Task<List<Task<?>>> whenAllComplete(@Nullable Collection<? extends Task<?>> collection) {
        if (collection == null || collection.isEmpty()) {
            return forResult(Collections.emptyList());
        }
        return whenAll(collection).continueWithTask(new zzz(collection));
    }

    @NonNull
    public static <TResult> Task<List<TResult>> whenAllSuccess(@Nullable Collection<? extends Task<?>> collection) {
        if (collection == null || collection.isEmpty()) {
            return forResult(Collections.emptyList());
        }
        return whenAll(collection).continueWith(new zzaa(collection));
    }

    public static <TResult> TResult zza(@NonNull Task<TResult> task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (task.isCanceled()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(task.getException());
    }

    @NonNull
    @Deprecated
    public static <TResult> Task<TResult> call(@NonNull Executor executor, @NonNull Callable<TResult> callable) {
        Preconditions.checkNotNull(executor, "Executor must not be null");
        Preconditions.checkNotNull(callable, "Callback must not be null");
        zzu zzu = new zzu();
        executor.execute(new zzy(zzu, callable));
        return zzu;
    }

    @NonNull
    public static Task<List<Task<?>>> whenAllComplete(@Nullable Task<?>... taskArr) {
        if (taskArr == null || taskArr.length == 0) {
            return forResult(Collections.emptyList());
        }
        return whenAllComplete((Collection<? extends Task<?>>) Arrays.asList(taskArr));
    }

    @NonNull
    public static <TResult> Task<List<TResult>> whenAllSuccess(@Nullable Task<?>... taskArr) {
        if (taskArr == null || taskArr.length == 0) {
            return forResult(Collections.emptyList());
        }
        return whenAllSuccess((Collection<? extends Task<?>>) Arrays.asList(taskArr));
    }

    public static <T> void zza(Task<T> task, zza<? super T> zza2) {
        task.addOnSuccessListener(TaskExecutors.zza, (OnSuccessListener<? super T>) zza2);
        task.addOnFailureListener(TaskExecutors.zza, (OnFailureListener) zza2);
        task.addOnCanceledListener(TaskExecutors.zza, (OnCanceledListener) zza2);
    }

    public static <TResult> TResult await(@NonNull Task<TResult> task, long j, @NonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        Preconditions.checkNotMainThread();
        Preconditions.checkNotNull(task, "Task must not be null");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        if (task.isComplete()) {
            return zza(task);
        }
        zzb zzb2 = new zzb((zzy) null);
        zza(task, zzb2);
        if (zzb2.zza(j, timeUnit)) {
            return zza(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    @NonNull
    public static Task<Void> whenAll(@Nullable Task<?>... taskArr) {
        if (taskArr == null || taskArr.length == 0) {
            return forResult((Object) null);
        }
        return whenAll((Collection<? extends Task<?>>) Arrays.asList(taskArr));
    }
}
