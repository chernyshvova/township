package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzjx {
    public static final zzjx zza = new zzjx();
    public final zzka zzb = new zziw();
    public final ConcurrentMap<Class<?>, zzkb<?>> zzc = new ConcurrentHashMap();

    public static zzjx zza() {
        return zza;
    }

    public final <T> zzkb<T> zza(Class<T> cls) {
        zzia.zza(cls, "messageType");
        zzkb<T> zzkb = (zzkb) this.zzc.get(cls);
        if (zzkb != null) {
            return zzkb;
        }
        zzkb<T> zza2 = this.zzb.zza(cls);
        zzia.zza(cls, "messageType");
        zzia.zza(zza2, "schema");
        zzkb<T> putIfAbsent = this.zzc.putIfAbsent(cls, zza2);
        return putIfAbsent != null ? putIfAbsent : zza2;
    }

    public final <T> zzkb<T> zza(T t) {
        return zza(t.getClass());
    }
}
