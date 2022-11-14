package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzfcp<E> {
    public static final zzfqn<?> zza = zzfqe.zza(null);
    public final zzfqo zzb;
    public final ScheduledExecutorService zzc;
    public final zzfcq<E> zzd;

    public zzfcp(zzfqo zzfqo, ScheduledExecutorService scheduledExecutorService, zzfcq<E> zzfcq) {
        this.zzb = zzfqo;
        this.zzc = scheduledExecutorService;
        this.zzd = zzfcq;
    }

    public final <I> zzfco<I> zza(E e, zzfqn<I> zzfqn) {
        return new zzfco(this, e, (String) null, zzfqn, Collections.singletonList(zzfqn), zzfqn, (zzfce) null);
    }

    public final zzfcg zzb(E e, zzfqn<?>... zzfqnArr) {
        return new zzfcg(this, e, Arrays.asList(zzfqnArr), (zzfce) null);
    }

    public abstract String zzc(E e);
}
