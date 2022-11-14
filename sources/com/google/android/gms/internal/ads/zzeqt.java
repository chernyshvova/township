package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeqt<T> implements zzgjg<zzeqs<T>> {
    public final zzgju<Executor> zza;
    public final zzgju<Set<zzeqp<? extends zzeqo<T>>>> zzb;

    public zzeqt(zzgju<Executor> zzgju, zzgju<Set<zzeqp<? extends zzeqo<T>>>> zzgju2) {
        this.zza = zzgju;
        this.zzb = zzgju2;
    }

    /* renamed from: zza */
    public final zzeqs<T> zzb() {
        zzfqo zzfqo = zzche.zza;
        zzgjp.zzb(zzfqo);
        return new zzeqs<>(zzfqo, ((zzgjs) this.zzb).zzb());
    }
}
