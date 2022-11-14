package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgfe<K, V> extends LinkedHashMap<K, V> {
    public static final zzgfe zzb;
    public boolean zza = true;

    static {
        zzgfe zzgfe = new zzgfe();
        zzb = zzgfe;
        zzgfe.zza = false;
    }

    public zzgfe() {
    }

    public static <K, V> zzgfe<K, V> zza() {
        return zzb;
    }

    public static int zzf(Object obj) {
        if (obj instanceof byte[]) {
            return zzgem.zzg((byte[]) obj);
        }
        if (!(obj instanceof zzgee)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    private final void zzg() {
        if (!this.zza) {
            throw new UnsupportedOperationException();
        }
    }

    public final void clear() {
        zzg();
        super.clear();
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (this == map) {
            return true;
        }
        if (size() != map.size()) {
            return false;
        }
        for (Map.Entry entry : entrySet()) {
            if (!map.containsKey(entry.getKey())) {
                return false;
            }
            Object value = entry.getValue();
            Object obj2 = map.get(entry.getKey());
            if (!(value instanceof byte[]) || !(obj2 instanceof byte[])) {
                z = value.equals(obj2);
                continue;
            } else {
                z = Arrays.equals((byte[]) value, (byte[]) obj2);
                continue;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        for (Map.Entry entry : entrySet()) {
            i += zzf(entry.getValue()) ^ zzf(entry.getKey());
        }
        return i;
    }

    public final V put(K k, V v) {
        zzg();
        zzgem.zza(k);
        zzgem.zza(v);
        return super.put(k, v);
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        zzg();
        for (Object next : map.keySet()) {
            zzgem.zza(next);
            zzgem.zza(map.get(next));
        }
        super.putAll(map);
    }

    public final V remove(Object obj) {
        zzg();
        return super.remove(obj);
    }

    public final void zzb(zzgfe<K, V> zzgfe) {
        zzg();
        if (!zzgfe.isEmpty()) {
            putAll(zzgfe);
        }
    }

    public final zzgfe<K, V> zzc() {
        return isEmpty() ? new zzgfe<>() : new zzgfe<>(this);
    }

    public final void zzd() {
        this.zza = false;
    }

    public final boolean zze() {
        return this.zza;
    }

    public zzgfe(Map<K, V> map) {
        super(map);
    }
}
