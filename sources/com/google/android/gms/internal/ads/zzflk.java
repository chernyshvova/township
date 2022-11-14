package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzflk<K, V> implements zzfnl<K, V> {
    @NullableDecl
    public transient Set<K> zza;
    @NullableDecl
    public transient Collection<V> zzb;
    @NullableDecl
    public transient Map<K, Collection<V>> zzc;

    public final boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfnl)) {
            return false;
        }
        return zzw().equals(((zzfnl) obj).zzw());
    }

    public final int hashCode() {
        return zzw().hashCode();
    }

    public final String toString() {
        return zzw().toString();
    }

    public boolean zze(@NullableDecl K k, @NullableDecl V v) {
        throw null;
    }

    public abstract Set<K> zzh();

    public abstract Collection<V> zzj();

    public Iterator<V> zzk() {
        throw null;
    }

    public abstract Map<K, Collection<V>> zzl();

    public boolean zzt(@NullableDecl Object obj) {
        for (Collection contains : zzw().values()) {
            if (contains.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public final Set<K> zzu() {
        Set<K> set = this.zza;
        if (set != null) {
            return set;
        }
        Set<K> zzh = zzh();
        this.zza = zzh;
        return zzh;
    }

    public Collection<V> zzv() {
        Collection<V> collection = this.zzb;
        if (collection != null) {
            return collection;
        }
        Collection<V> zzj = zzj();
        this.zzb = zzj;
        return zzj;
    }

    public Map<K, Collection<V>> zzw() {
        Map<K, Collection<V>> map = this.zzc;
        if (map != null) {
            return map;
        }
        Map<K, Collection<V>> zzl = zzl();
        this.zzc = zzl;
        return zzl;
    }
}
