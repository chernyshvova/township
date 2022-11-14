package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfcd<E, V> implements zzfqn<V> {
    public final E zza;
    public final String zzb;
    public final zzfqn<V> zzc;

    @VisibleForTesting(otherwise = 3)
    public zzfcd(E e, String str, zzfqn<V> zzfqn) {
        this.zza = e;
        this.zzb = str;
        this.zzc = zzfqn;
    }

    public final boolean cancel(boolean z) {
        return this.zzc.cancel(z);
    }

    public final V get() throws InterruptedException, ExecutionException {
        return this.zzc.get();
    }

    public final boolean isCancelled() {
        return this.zzc.isCancelled();
    }

    public final boolean isDone() {
        return this.zzc.isDone();
    }

    public final String toString() {
        String str = this.zzb;
        int identityHashCode = System.identityHashCode(this);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
        sb.append(str);
        sb.append("@");
        sb.append(identityHashCode);
        return sb.toString();
    }

    public final E zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final void zze(Runnable runnable, Executor executor) {
        this.zzc.zze(runnable, executor);
    }

    public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.zzc.get(j, timeUnit);
    }
}
