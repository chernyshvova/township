package com.google.android.gms.internal.measurement;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzfo<K, V> extends zzfg<Map.Entry<K, V>> {
    public final transient zzfc<K, V> zza;
    public final transient Object[] zzb;
    public final transient int zzc = 0;
    public final transient int zzd;

    public zzfo(zzfc<K, V> zzfc, Object[] objArr, int i, int i2) {
        this.zza = zzfc;
        this.zzb = objArr;
        this.zzd = i2;
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.zza.get(key))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int size() {
        return this.zzd;
    }

    /* renamed from: zza */
    public final zzfx<Map.Entry<K, V>> iterator() {
        return (zzfx) zze().iterator();
    }

    public final boolean zzf() {
        return true;
    }

    public final zzfb<Map.Entry<K, V>> zzh() {
        return new zzfr(this);
    }

    public final int zza(Object[] objArr, int i) {
        return zze().zza(objArr, i);
    }
}
