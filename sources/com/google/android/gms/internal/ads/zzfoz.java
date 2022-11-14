package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfoz<I, O> extends zzfpb<I, O, zzfpl<? super I, ? extends O>, zzfqn<? extends O>> {
    public zzfoz(zzfqn<? extends I> zzfqn, zzfpl<? super I, ? extends O> zzfpl) {
        super(zzfqn, zzfpl);
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        zzj((zzfqn) obj);
    }

    public final /* bridge */ /* synthetic */ Object zzb(Object obj, Object obj2) throws Exception {
        zzfpl zzfpl = (zzfpl) obj;
        zzfqn zza = zzfpl.zza(obj2);
        zzfke.zzd(zza, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzfpl);
        return zza;
    }
}
