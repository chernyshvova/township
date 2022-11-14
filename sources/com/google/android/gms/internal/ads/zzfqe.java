package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfqe extends zzfqg {
    public static <V> zzfqn<V> zza(@NullableDecl V v) {
        if (v == null) {
            return zzfqi.zza;
        }
        return new zzfqi(v);
    }

    public static zzfqn<Void> zzb() {
        return zzfqi.zza;
    }

    public static <V> zzfqn<V> zzc(Throwable th) {
        if (th != null) {
            return new zzfqh(th);
        }
        throw null;
    }

    public static <O> zzfqn<O> zzd(Callable<O> callable, Executor executor) {
        zzfrc zzfrc = new zzfrc(callable);
        executor.execute(zzfrc);
        return zzfrc;
    }

    public static <O> zzfqn<O> zze(zzfpk<O> zzfpk, Executor executor) {
        zzfrc zzfrc = new zzfrc(zzfpk);
        executor.execute(zzfrc);
        return zzfrc;
    }

    public static <V, X extends Throwable> zzfqn<V> zzf(zzfqn<? extends V> zzfqn, Class<X> cls, zzfju<? super X, ? extends V> zzfju, Executor executor) {
        zzfov zzfov = new zzfov(zzfqn, cls, zzfju);
        zzfqn.zze(zzfov, zzfqu.zzc(executor, zzfov));
        return zzfov;
    }

    public static <V, X extends Throwable> zzfqn<V> zzg(zzfqn<? extends V> zzfqn, Class<X> cls, zzfpl<? super X, ? extends V> zzfpl, Executor executor) {
        zzfou zzfou = new zzfou(zzfqn, cls, zzfpl);
        zzfqn.zze(zzfou, zzfqu.zzc(executor, zzfou));
        return zzfou;
    }

    public static <V> zzfqn<V> zzh(zzfqn<V> zzfqn, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        if (zzfqn.isDone()) {
            return zzfqn;
        }
        return zzfqz.zza(zzfqn, j, timeUnit, scheduledExecutorService);
    }

    public static <I, O> zzfqn<O> zzi(zzfqn<I> zzfqn, zzfpl<? super I, ? extends O> zzfpl, Executor executor) {
        int i = zzfpb.zzc;
        if (executor != null) {
            zzfoz zzfoz = new zzfoz(zzfqn, zzfpl);
            zzfqn.zze(zzfoz, zzfqu.zzc(executor, zzfoz));
            return zzfoz;
        }
        throw null;
    }

    public static <I, O> zzfqn<O> zzj(zzfqn<I> zzfqn, zzfju<? super I, ? extends O> zzfju, Executor executor) {
        int i = zzfpb.zzc;
        if (zzfju != null) {
            zzfpa zzfpa = new zzfpa(zzfqn, zzfju);
            zzfqn.zze(zzfpa, zzfqu.zzc(executor, zzfpa));
            return zzfpa;
        }
        throw null;
    }

    public static <V> zzfqn<List<V>> zzk(Iterable<? extends zzfqn<? extends V>> iterable) {
        return new zzfpm(zzfml.zzo(iterable), true);
    }

    @SafeVarargs
    public static <V> zzfqd<V> zzl(zzfqn<? extends V>... zzfqnArr) {
        return new zzfqd<>(false, zzfml.zzq(zzfqnArr), (zzfqb) null);
    }

    public static <V> zzfqd<V> zzm(Iterable<? extends zzfqn<? extends V>> iterable) {
        return new zzfqd<>(false, zzfml.zzo(iterable), (zzfqb) null);
    }

    @SafeVarargs
    public static <V> zzfqd<V> zzn(zzfqn<? extends V>... zzfqnArr) {
        return new zzfqd<>(true, zzfml.zzq(zzfqnArr), (zzfqb) null);
    }

    public static <V> zzfqd<V> zzo(Iterable<? extends zzfqn<? extends V>> iterable) {
        return new zzfqd<>(true, zzfml.zzo(iterable), (zzfqb) null);
    }

    public static <V> void zzp(zzfqn<V> zzfqn, zzfqa<? super V> zzfqa, Executor executor) {
        if (zzfqa != null) {
            zzfqn.zze(new zzfqc(zzfqn, zzfqa), executor);
            return;
        }
        throw null;
    }

    public static <V> V zzq(Future<V> future) throws ExecutionException {
        if (future.isDone()) {
            return zzfre.zza(future);
        }
        throw new IllegalStateException(zzfkm.zzd("Future was expected to be done: %s", future));
    }

    public static <V> V zzr(Future<V> future) {
        try {
            return zzfre.zza(future);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof Error) {
                throw new zzfpt((Error) cause);
            }
            throw new zzfrd(cause);
        }
    }
}
