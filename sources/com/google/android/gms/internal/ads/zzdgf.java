package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzdgf<ListenerT> {
    @GuardedBy("this")
    public final Map<ListenerT, Executor> zza = new HashMap();

    public zzdgf(Set<zzdhz<ListenerT>> set) {
        zzi(set);
    }

    public final synchronized void zzg(zzdhz<ListenerT> zzdhz) {
        zzh(zzdhz.zza, zzdhz.zzb);
    }

    public final synchronized void zzh(ListenerT listenert, Executor executor) {
        this.zza.put(listenert, executor);
    }

    public final synchronized void zzi(Set<zzdhz<ListenerT>> set) {
        for (zzdhz<ListenerT> zzg : set) {
            zzg(zzg);
        }
    }

    public final synchronized void zzr(zzdge<ListenerT> zzdge) {
        for (Map.Entry next : this.zza.entrySet()) {
            ((Executor) next.getValue()).execute(new zzdgd(zzdge, next.getKey()));
        }
    }
}
