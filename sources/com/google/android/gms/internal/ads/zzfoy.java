package com.google.android.gms.internal.ads;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzfoy extends AbstractExecutorService implements zzfqo {
    public final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return zzfrc.zza(runnable, t);
    }

    public final /* bridge */ /* synthetic */ Future submit(Runnable runnable) {
        return (zzfqn) super.submit(runnable);
    }

    public final zzfqn<?> zza(Runnable runnable) {
        return (zzfqn) super.submit(runnable);
    }

    public final <T> zzfqn<T> zzb(Callable<T> callable) {
        return (zzfqn) super.submit(callable);
    }

    public final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new zzfrc(callable);
    }

    public final /* bridge */ /* synthetic */ Future submit(Runnable runnable, Object obj) {
        return (zzfqn) super.submit(runnable, obj);
    }

    public final /* bridge */ /* synthetic */ Future submit(Callable callable) {
        return (zzfqn) super.submit(callable);
    }
}
