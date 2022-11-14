package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzgck<E> extends AbstractList<E> implements zzgel<E> {
    public boolean zza = true;

    public void add(int i, E e) {
        zzcb();
        super.add(i, e);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        zzcb();
        return super.addAll(i, collection);
    }

    public void clear() {
        zzcb();
        super.clear();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public E remove(int i) {
        zzcb();
        return super.remove(i);
    }

    public final boolean removeAll(Collection<?> collection) {
        zzcb();
        return super.removeAll(collection);
    }

    public final boolean retainAll(Collection<?> collection) {
        zzcb();
        return super.retainAll(collection);
    }

    public E set(int i, E e) {
        zzcb();
        return super.set(i, e);
    }

    public final boolean zza() {
        return this.zza;
    }

    public final void zzb() {
        this.zza = false;
    }

    public final void zzcb() {
        if (!this.zza) {
            throw new UnsupportedOperationException();
        }
    }

    public boolean add(E e) {
        zzcb();
        return super.add(e);
    }

    public boolean addAll(Collection<? extends E> collection) {
        zzcb();
        return super.addAll(collection);
    }

    public final boolean remove(Object obj) {
        zzcb();
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }
}
