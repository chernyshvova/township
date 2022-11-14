package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzfpz<V> extends zzfpx<V> implements zzfqn<V> {
    public /* bridge */ /* synthetic */ Future zzb() {
        throw null;
    }

    public abstract zzfqn<? extends V> zzc();

    public final void zze(Runnable runnable, Executor executor) {
        zzc().zze(runnable, executor);
    }
}
