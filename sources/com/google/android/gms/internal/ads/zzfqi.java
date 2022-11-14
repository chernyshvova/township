package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfqi<V> implements zzfqn<V> {
    public static final zzfqn<?> zza = new zzfqi((Object) null);
    public static final Logger zzb = Logger.getLogger(zzfqi.class.getName());
    public final V zzc;

    public zzfqi(V v) {
        this.zzc = v;
    }

    public final boolean cancel(boolean z) {
        return false;
    }

    public final V get() {
        return this.zzc;
    }

    public final V get(long j, TimeUnit timeUnit) throws ExecutionException {
        if (timeUnit != null) {
            return this.zzc;
        }
        throw null;
    }

    public final boolean isCancelled() {
        return false;
    }

    public final boolean isDone() {
        return true;
    }

    public final String toString() {
        String obj = super.toString();
        String valueOf = String.valueOf(this.zzc);
        return GeneratedOutlineSupport.outline20(new StringBuilder(String.valueOf(obj).length() + 27 + valueOf.length()), obj, "[status=SUCCESS, result=[", valueOf, "]]");
    }

    public final void zze(Runnable runnable, Executor executor) {
        zzfke.zzc(runnable, "Runnable was null.");
        zzfke.zzc(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = zzb;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            logger.logp(level, "com.google.common.util.concurrent.ImmediateFuture", "addListener", GeneratedOutlineSupport.outline20(new StringBuilder(valueOf.length() + 57 + valueOf2.length()), "RuntimeException while executing runnable ", valueOf, " with executor ", valueOf2), e);
        }
    }
}
