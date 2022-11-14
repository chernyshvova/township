package com.google.android.gms.internal.measurement;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public abstract class zzfb<E> extends zzey<E> implements List<E>, RandomAccess {
    public static final zzfw<Object> zza = new zzfa(zzfm.zza, 0);

    public static <E> zzfb<E> zza(E e) {
        Object[] objArr = {e};
        for (int i = 0; i <= 0; i++) {
            zzfn.zza(objArr[0], 0);
        }
        return zzb(objArr, 1);
    }

    public static <E> zzfb<E> zzb(Object[] objArr, int i) {
        if (i == 0) {
            return zzfm.zza;
        }
        return new zzfm(objArr, i);
    }

    public static <E> zzfb<E> zzg() {
        return zzfm.zza;
    }

    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == zzeb.zza(this)) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    int i = 0;
                    while (i < size) {
                        if (zzdz.zza(get(i), list.get(i))) {
                            i++;
                        }
                    }
                    return true;
                }
                int size2 = size();
                Iterator it = list.iterator();
                int i2 = 0;
                while (true) {
                    if (i2 < size2) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object obj2 = get(i2);
                        i2++;
                        if (!zzdz.zza(obj2, it.next())) {
                            break;
                        }
                    } else if (!it.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = ((get(i2).hashCode() + (i * 31)) ^ -1) ^ -1;
        }
        return i;
    }

    public int indexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    public /* synthetic */ ListIterator listIterator(int i) {
        zzeb.zzb(i, size());
        if (isEmpty()) {
            return zza;
        }
        return new zzfa(this, i);
    }

    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    public final zzfb<E> zze() {
        return this;
    }

    public static <E> zzfb<E> zza(Object[] objArr) {
        return zzb(objArr, objArr.length);
    }

    /* renamed from: zza */
    public final zzfx<E> iterator() {
        return (zzfw) listIterator();
    }

    public /* synthetic */ ListIterator listIterator() {
        return (zzfw) listIterator(0);
    }

    /* renamed from: zza */
    public zzfb<E> subList(int i, int i2) {
        zzeb.zza(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return zzfm.zza;
        }
        return new zzfd(this, i, i3);
    }

    public int zza(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }
}
