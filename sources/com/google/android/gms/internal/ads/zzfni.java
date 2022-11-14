package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfni<K, V> extends AbstractCollection<V> {
    public final Map<K, V> zza;

    public zzfni(Map<K, V> map) {
        this.zza = map;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(@NullableDecl Object obj) {
        return this.zza.containsValue(obj);
    }

    public final boolean isEmpty() {
        return this.zza.isEmpty();
    }

    public final Iterator<V> iterator() {
        return new zzfnf(this.zza.entrySet().iterator());
    }

    public final boolean remove(Object obj) {
        try {
            return super.remove(obj);
        } catch (UnsupportedOperationException unused) {
            for (Map.Entry next : this.zza.entrySet()) {
                if (zzfka.zza(obj, next.getValue())) {
                    this.zza.remove(next.getKey());
                    return true;
                }
            }
            return false;
        }
    }

    public final boolean removeAll(Collection<?> collection) {
        if (collection != null) {
            try {
                return super.removeAll(collection);
            } catch (UnsupportedOperationException unused) {
                HashSet hashSet = new HashSet();
                for (Map.Entry next : this.zza.entrySet()) {
                    if (collection.contains(next.getValue())) {
                        hashSet.add(next.getKey());
                    }
                }
                return this.zza.keySet().removeAll(hashSet);
            }
        } else {
            throw null;
        }
    }

    public final boolean retainAll(Collection<?> collection) {
        if (collection != null) {
            try {
                return super.retainAll(collection);
            } catch (UnsupportedOperationException unused) {
                HashSet hashSet = new HashSet();
                for (Map.Entry next : this.zza.entrySet()) {
                    if (collection.contains(next.getValue())) {
                        hashSet.add(next.getKey());
                    }
                }
                return this.zza.keySet().retainAll(hashSet);
            }
        } else {
            throw null;
        }
    }

    public final int size() {
        return this.zza.size();
    }
}
