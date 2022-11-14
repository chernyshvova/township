package com.google.android.gms.internal.measurement;

import java.util.Collection;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public abstract class zzel<K, V> implements zzfk<K, V> {
    @NullableDecl
    public transient Map<K, Collection<V>> zza;

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfk) {
            return zza().equals(((zzfk) obj).zza());
        }
        return false;
    }

    public int hashCode() {
        return zza().hashCode();
    }

    public String toString() {
        return zza().toString();
    }

    public boolean zza(@NullableDecl Object obj) {
        for (Collection contains : zza().values()) {
            if (contains.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public abstract Map<K, Collection<V>> zzb();

    public Map<K, Collection<V>> zza() {
        Map<K, Collection<V>> map = this.zza;
        if (map != null) {
            return map;
        }
        Map<K, Collection<V>> zzb = zzb();
        this.zza = zzb;
        return zzb;
    }
}
