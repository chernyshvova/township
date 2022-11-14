package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgfs {
    public static final zzgfs zza = new zzgfs();
    public final zzggb zzb = new zzgfc();
    public final ConcurrentMap<Class<?>, zzgga<?>> zzc = new ConcurrentHashMap();

    public static zzgfs zza() {
        return zza;
    }

    public final <T> zzgga<T> zzb(Class<T> cls) {
        zzgem.zzb(cls, "messageType");
        zzgga<T> zzgga = (zzgga) this.zzc.get(cls);
        if (zzgga == null) {
            zzgga = this.zzb.zza(cls);
            zzgem.zzb(cls, "messageType");
            zzgem.zzb(zzgga, "schema");
            zzgga<T> putIfAbsent = this.zzc.putIfAbsent(cls, zzgga);
            return putIfAbsent == null ? zzgga : putIfAbsent;
        }
    }
}
