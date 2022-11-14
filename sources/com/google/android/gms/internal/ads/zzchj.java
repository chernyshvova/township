package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzs;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzchj<T> implements zzfqn<T> {
    public final zzfqv<T> zza = zzfqv.zza();

    public static final boolean zza(boolean z) {
        if (!z) {
            zzs.zzg().zzh(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture");
        }
        return z;
    }

    public boolean cancel(boolean z) {
        return this.zza.cancel(z);
    }

    public final T get() throws ExecutionException, InterruptedException {
        return this.zza.get();
    }

    public final boolean isCancelled() {
        return this.zza.isCancelled();
    }

    public final boolean isDone() {
        return this.zza.isDone();
    }

    public final boolean zzc(@Nullable T t) {
        boolean zzh = this.zza.zzh(t);
        zza(zzh);
        return zzh;
    }

    public final boolean zzd(Throwable th) {
        boolean zzi = this.zza.zzi(th);
        zza(zzi);
        return zzi;
    }

    public final void zze(Runnable runnable, Executor executor) {
        this.zza.zze(runnable, executor);
    }

    public final T get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.zza.get(j, timeUnit);
    }
}
