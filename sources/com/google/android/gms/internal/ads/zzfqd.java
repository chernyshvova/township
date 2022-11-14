package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfqd<V> {
    public final boolean zza;
    public final zzfml<zzfqn<? extends V>> zzb;

    public /* synthetic */ zzfqd(boolean z, zzfml zzfml, zzfqb zzfqb) {
        this.zza = z;
        this.zzb = zzfml;
    }

    public final <C> zzfqn<C> zza(Callable<C> callable, Executor executor) {
        return new zzfpr(this.zzb, this.zza, executor, callable);
    }
}
