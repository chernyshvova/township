package com.google.android.gms.internal.ads;

import java.lang.Throwable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfou<V, X extends Throwable> extends zzfow<V, X, zzfpl<? super X, ? extends V>, zzfqn<? extends V>> {
    public zzfou(zzfqn<? extends V> zzfqn, Class<X> cls, zzfpl<? super X, ? extends V> zzfpl) {
        super(zzfqn, cls, zzfpl);
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        zzj((zzfqn) obj);
    }

    public final /* bridge */ /* synthetic */ Object zzb(Object obj, Throwable th) throws Exception {
        zzfpl zzfpl = (zzfpl) obj;
        zzfqn zza = zzfpl.zza(th);
        zzfke.zzd(zza, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzfpl);
        return zza;
    }
}
