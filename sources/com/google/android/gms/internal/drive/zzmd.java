package com.google.android.gms.internal.drive;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class zzmd {
    public static final zzmd zzuw = new zzmd();
    public final zzmg zzux = new zzlf();
    public final ConcurrentMap<Class<?>, zzmf<?>> zzuy = new ConcurrentHashMap();

    public static zzmd zzej() {
        return zzuw;
    }

    public final <T> zzmf<T> zzf(Class<T> cls) {
        zzkm.zza(cls, "messageType");
        zzmf<T> zzmf = (zzmf) this.zzuy.get(cls);
        if (zzmf != null) {
            return zzmf;
        }
        zzmf<T> zze = this.zzux.zze(cls);
        zzkm.zza(cls, "messageType");
        zzkm.zza(zze, "schema");
        zzmf<T> putIfAbsent = this.zzuy.putIfAbsent(cls, zze);
        return putIfAbsent != null ? putIfAbsent : zze;
    }

    public final <T> zzmf<T> zzq(T t) {
        return zzf(t.getClass());
    }
}
