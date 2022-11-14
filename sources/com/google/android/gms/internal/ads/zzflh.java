package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzflh<K, V> extends zzflk<K, V> implements Serializable {
    public final transient Map<K, Collection<V>> zza;
    public transient int zzb;

    public zzflh(Map<K, Collection<V>> map) {
        if (map.isEmpty()) {
            this.zza = map;
            return;
        }
        throw new IllegalArgumentException();
    }

    public static /* synthetic */ int zzo(zzflh zzflh) {
        int i = zzflh.zzb;
        zzflh.zzb = i - 1;
        return i;
    }

    public static /* synthetic */ int zzp(zzflh zzflh) {
        int i = zzflh.zzb;
        zzflh.zzb = i + 1;
        return i;
    }

    public static /* synthetic */ int zzq(zzflh zzflh, int i) {
        int i2 = zzflh.zzb + i;
        zzflh.zzb = i2;
        return i2;
    }

    public static /* synthetic */ int zzr(zzflh zzflh, int i) {
        int i2 = zzflh.zzb - i;
        zzflh.zzb = i2;
        return i2;
    }

    public static /* synthetic */ void zzs(zzflh zzflh, Object obj) {
        Collection<V> collection;
        try {
            collection = zzflh.zza.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            collection = null;
        }
        Collection collection2 = collection;
        if (collection2 != null) {
            int size = collection2.size();
            collection2.clear();
            zzflh.zzb -= size;
        }
    }

    public <E> Collection<E> zza(Collection<E> collection) {
        throw null;
    }

    public Collection<V> zzb(@NullableDecl K k, Collection<V> collection) {
        throw null;
    }

    public abstract Collection<V> zzc();

    public final int zzd() {
        return this.zzb;
    }

    public final boolean zze(@NullableDecl K k, @NullableDecl V v) {
        Collection collection = this.zza.get(k);
        if (collection == null) {
            Collection zzc = zzc();
            if (zzc.add(v)) {
                this.zzb++;
                this.zza.put(k, zzc);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        } else if (!collection.add(v)) {
            return false;
        } else {
            this.zzb++;
            return true;
        }
    }

    public final void zzf() {
        for (Collection<V> clear : this.zza.values()) {
            clear.clear();
        }
        this.zza.clear();
        this.zzb = 0;
    }

    public final List<V> zzg(@NullableDecl K k, List<V> list, @NullableDecl zzfle zzfle) {
        if (list instanceof RandomAccess) {
            return new zzfla(this, k, list, zzfle);
        }
        return new zzflg(this, k, list, zzfle);
    }

    public Set<K> zzh() {
        throw null;
    }

    public final Set<K> zzi() {
        Map<K, Collection<V>> map = this.zza;
        if (map instanceof NavigableMap) {
            return new zzfkz(this, (NavigableMap) map);
        }
        if (map instanceof SortedMap) {
            return new zzflc(this, (SortedMap) map);
        }
        return new zzfkx(this, map);
    }

    public final Collection<V> zzj() {
        return new zzflj(this);
    }

    public final Iterator<V> zzk() {
        return new zzfkr(this);
    }

    public Map<K, Collection<V>> zzl() {
        throw null;
    }

    public final Map<K, Collection<V>> zzm() {
        Map<K, Collection<V>> map = this.zza;
        if (map instanceof NavigableMap) {
            return new zzfky(this, (NavigableMap) map);
        }
        if (map instanceof SortedMap) {
            return new zzflb(this, (SortedMap) map);
        }
        return new zzfku(this, map);
    }
}
