package com.google.android.gms.internal.drive;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

public abstract class zziw<E> extends AbstractList<E> implements zzkp<E> {
    public boolean zznh = true;

    public boolean add(E e) {
        zzbq();
        return super.add(e);
    }

    public boolean addAll(Collection<? extends E> collection) {
        zzbq();
        return super.addAll(collection);
    }

    public void clear() {
        zzbq();
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
        zzbq();
        return super.remove(i);
    }

    public boolean removeAll(Collection<?> collection) {
        zzbq();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        zzbq();
        return super.retainAll(collection);
    }

    public E set(int i, E e) {
        zzbq();
        return super.set(i, e);
    }

    public boolean zzbo() {
        return this.zznh;
    }

    public final void zzbp() {
        this.zznh = false;
    }

    public final void zzbq() {
        if (!this.zznh) {
            throw new UnsupportedOperationException();
        }
    }

    public void add(int i, E e) {
        zzbq();
        super.add(i, e);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        zzbq();
        return super.addAll(i, collection);
    }

    public boolean remove(Object obj) {
        zzbq();
        return super.remove(obj);
    }
}
