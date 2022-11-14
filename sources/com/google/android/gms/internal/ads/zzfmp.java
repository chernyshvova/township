package com.google.android.gms.internal.ads;

import com.swrve.sdk.rest.RESTClient;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzfmp<K, V> implements Map<K, V>, Serializable {
    public transient zzfmv<Map.Entry<K, V>> zza;
    public transient zzfmv<K> zzb;
    public transient zzfmg<V> zzc;

    public static <K, V> zzfmp<K, V> zza() {
        return zzfod.zza;
    }

    public static <K, V> zzfmp<K, V> zzb(Map<? extends K, ? extends V> map) {
        Set<Map.Entry<? extends K, ? extends V>> entrySet = map.entrySet();
        zzfmo zzfmo = new zzfmo(entrySet instanceof Collection ? entrySet.size() : 4);
        zzfmo.zzb(entrySet);
        return zzfmo.zzc();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public final boolean containsKey(@NullableDecl Object obj) {
        return get(obj) != null;
    }

    public final boolean containsValue(@NullableDecl Object obj) {
        return values().contains(obj);
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        return entrySet().equals(((Map) obj).entrySet());
    }

    public abstract V get(@NullableDecl Object obj);

    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    public final int hashCode() {
        return zzfoi.zza(entrySet());
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final /* bridge */ /* synthetic */ Set keySet() {
        zzfmv<K> zzfmv = this.zzb;
        if (zzfmv != null) {
            return zzfmv;
        }
        zzfmv<K> zze = zze();
        this.zzb = zze;
        return zze;
    }

    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        zzflm.zzb(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) * 8, 1073741824));
        sb.append('{');
        boolean z = true;
        for (Map.Entry entry : entrySet()) {
            if (!z) {
                sb.append(RESTClient.COMMA_SEPARATOR);
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z = false;
        }
        sb.append('}');
        return sb.toString();
    }

    /* renamed from: zzc */
    public final zzfmv<Map.Entry<K, V>> entrySet() {
        zzfmv<Map.Entry<K, V>> zzfmv = this.zza;
        if (zzfmv != null) {
            return zzfmv;
        }
        zzfmv<Map.Entry<K, V>> zzd = zzd();
        this.zza = zzd;
        return zzd;
    }

    public abstract zzfmv<Map.Entry<K, V>> zzd();

    public abstract zzfmv<K> zze();

    /* renamed from: zzf */
    public final zzfmg<V> values() {
        zzfmg<V> zzfmg = this.zzc;
        if (zzfmg != null) {
            return zzfmg;
        }
        zzfmg<V> zzg = zzg();
        this.zzc = zzg;
        return zzg;
    }

    public abstract zzfmg<V> zzg();
}
