package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzfng<K, V> extends zzfoh<Map.Entry<K, V>> {
    public final void clear() {
        zza().clear();
    }

    public boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object zza = zzfnk.zza(zza(), key);
        if (!zzfka.zza(zza, entry.getValue())) {
            return false;
        }
        if (zza != null || zza().containsKey(key)) {
            return true;
        }
        return false;
    }

    public final boolean isEmpty() {
        return zza().isEmpty();
    }

    public boolean remove(Object obj) {
        if (contains(obj)) {
            return zza().keySet().remove(((Map.Entry) obj).getKey());
        }
        return false;
    }

    public final boolean removeAll(Collection<?> collection) {
        if (collection != null) {
            try {
                return zzfoi.zzc(this, collection);
            } catch (UnsupportedOperationException unused) {
                return zzfoi.zzb(this, collection.iterator());
            }
        } else {
            throw null;
        }
    }

    public final boolean retainAll(Collection<?> collection) {
        int i;
        if (collection != null) {
            try {
                return super.retainAll(collection);
            } catch (UnsupportedOperationException unused) {
                int size = collection.size();
                if (size < 3) {
                    zzflm.zzb(size, "expectedSize");
                    i = size + 1;
                } else {
                    i = size < 1073741824 ? (int) ((((float) size) / 0.75f) + 1.0f) : Integer.MAX_VALUE;
                }
                HashSet hashSet = new HashSet(i);
                for (Object next : collection) {
                    if (contains(next)) {
                        hashSet.add(((Map.Entry) next).getKey());
                    }
                }
                return zza().keySet().retainAll(hashSet);
            }
        } else {
            throw null;
        }
    }

    public final int size() {
        return zza().size();
    }

    public abstract Map<K, V> zza();
}
