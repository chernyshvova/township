package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfcg {
    public final /* synthetic */ zzfcp zza;
    public final Object zzb;
    public final List<zzfqn<?>> zzc;

    public /* synthetic */ zzfcg(zzfcp zzfcp, Object obj, List list, zzfce zzfce) {
        this.zza = zzfcp;
        this.zzb = obj;
        this.zzc = list;
    }

    public final <O> zzfco<O> zza(Callable<O> callable) {
        zzfqd<V> zzo = zzfqe.zzo(this.zzc);
        zzfqn<C> zza2 = zzo.zza(zzfcf.zza, zzche.zzf);
        zzfcp zzfcp = this.zza;
        return new zzfco(zzfcp, this.zzb, (String) null, zza2, this.zzc, zzo.zza(callable, zzfcp.zzb), (zzfce) null);
    }
}
