package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzfnj<K, V> extends AbstractMap<K, V> {
    @NullableDecl
    public transient Set<Map.Entry<K, V>> zza;
    @NullableDecl
    public transient Set<K> zzb;
    @NullableDecl
    public transient Collection<V> zzc;

    public final Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.zza;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<K, V>> zza2 = zza();
        this.zza = zza2;
        return zza2;
    }

    public Set<K> keySet() {
        Set<K> set = this.zzb;
        if (set != null) {
            return set;
        }
        Set<K> zzh = zzh();
        this.zzb = zzh;
        return zzh;
    }

    public final Collection<V> values() {
        Collection<V> collection = this.zzc;
        if (collection != null) {
            return collection;
        }
        zzfni zzfni = new zzfni(this);
        this.zzc = zzfni;
        return zzfni;
    }

    public abstract Set<Map.Entry<K, V>> zza();

    public Set<K> zzh() {
        return new zzfnh(this);
    }
}
