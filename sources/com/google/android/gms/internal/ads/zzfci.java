package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfci {
    public static final <O> zzfco<O> zza(zzfqn<O> zzfqn, Object obj, zzfcp zzfcp) {
        return new zzfco(zzfcp, obj, (String) null, zzfcp.zza, Collections.emptyList(), zzfqn, (zzfce) null);
    }

    public static final <O> zzfco<O> zzb(Callable<O> callable, Object obj, zzfcp zzfcp) {
        return zzc(callable, zzfcp.zzb, obj, zzfcp);
    }

    public static final <O> zzfco<O> zzc(Callable<O> callable, zzfqo zzfqo, Object obj, zzfcp zzfcp) {
        return new zzfco(zzfcp, obj, (String) null, zzfcp.zza, Collections.emptyList(), zzfqo.zzb(callable), (zzfce) null);
    }

    public static final zzfco zzd(zzfcc zzfcc, zzfqo zzfqo, Object obj, zzfcp zzfcp) {
        return zzc(new zzfch(zzfcc), zzfqo, obj, zzfcp);
    }
}
