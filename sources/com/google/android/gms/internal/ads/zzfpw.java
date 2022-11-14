package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfpw<V> extends zzfpv<V> {
    public final zzfqn<V> zza;

    public zzfpw(zzfqn<V> zzfqn) {
        if (zzfqn != null) {
            this.zza = zzfqn;
            return;
        }
        throw null;
    }

    public final boolean cancel(boolean z) {
        return this.zza.cancel(z);
    }

    public final V get() throws InterruptedException, ExecutionException {
        return this.zza.get();
    }

    public final boolean isCancelled() {
        return this.zza.isCancelled();
    }

    public final boolean isDone() {
        return this.zza.isDone();
    }

    public final String toString() {
        return this.zza.toString();
    }

    public final void zze(Runnable runnable, Executor executor) {
        this.zza.zze(runnable, executor);
    }

    public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.zza.get(j, timeUnit);
    }
}
