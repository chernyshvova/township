package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzfpx<V> extends zzfmc implements Future<V> {
    public boolean cancel(boolean z) {
        return zzb().cancel(z);
    }

    public final V get() throws InterruptedException, ExecutionException {
        return zzb().get();
    }

    public final boolean isCancelled() {
        return zzb().isCancelled();
    }

    public final boolean isDone() {
        return zzb().isDone();
    }

    public /* bridge */ /* synthetic */ Object zza() {
        throw null;
    }

    public abstract Future<? extends V> zzb();

    public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return zzb().get(j, timeUnit);
    }
}
