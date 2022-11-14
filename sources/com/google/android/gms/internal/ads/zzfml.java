package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzfml<E> extends zzfmg<E> implements List<E>, RandomAccess {
    public static final zzfon<Object> zza = new zzfmj(zzfny.zza, 0);

    public static <E> zzfml<E> zzi() {
        return zzfny.zza;
    }

    public static <E> zzfml<E> zzj(E e) {
        Object[] objArr = {e};
        zzfnw.zza(objArr, 1);
        return zzs(objArr, 1);
    }

    public static <E> zzfml<E> zzk(E e, E e2) {
        Object[] objArr = {e, e2};
        zzfnw.zza(objArr, 2);
        return zzs(objArr, 2);
    }

    public static <E> zzfml<E> zzl(E e, E e2, E e3) {
        Object[] objArr = {"2011", "1009", "3010"};
        zzfnw.zza(objArr, 3);
        return zzs(objArr, 3);
    }

    public static <E> zzfml<E> zzm(E e, E e2, E e3, E e4, E e5) {
        Object[] objArr = {e, e2, e3, e4, e5};
        zzfnw.zza(objArr, 5);
        return zzs(objArr, 5);
    }

    public static <E> zzfml<E> zzn(E e, E e2, E e3, E e4, E e5, E e6) {
        Object[] objArr = {e, e2, e3, e4, e5, e6};
        zzfnw.zza(objArr, 6);
        return zzs(objArr, 6);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.util.Collection, java.lang.Iterable<? extends E>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <E> com.google.android.gms.internal.ads.zzfml<E> zzo(java.lang.Iterable<? extends E> r0) {
        /*
            if (r0 == 0) goto L_0x0007
            com.google.android.gms.internal.ads.zzfml r0 = zzp(r0)
            return r0
        L_0x0007:
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfml.zzo(java.lang.Iterable):com.google.android.gms.internal.ads.zzfml");
    }

    public static <E> zzfml<E> zzp(Collection<? extends E> collection) {
        if (collection instanceof zzfmg) {
            zzfml<E> zze = ((zzfmg) collection).zze();
            if (!zze.zzf()) {
                return zze;
            }
            Object[] array = zze.toArray();
            return zzs(array, array.length);
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        zzfnw.zza(array2, length);
        return zzs(array2, length);
    }

    public static <E> zzfml<E> zzq(E[] eArr) {
        Object[] objArr = (Object[]) eArr.clone();
        int length = objArr.length;
        zzfnw.zza(objArr, length);
        return zzs(objArr, length);
    }

    public static <E> zzfml<E> zzr(Object[] objArr) {
        return zzs(objArr, objArr.length);
    }

    public static <E> zzfml<E> zzs(Object[] objArr, int i) {
        if (i == 0) {
            return zzfny.zza;
        }
        return new zzfny(objArr, i);
    }

    public static <E> zzfmi<E> zzu() {
        return new zzfmi<>(4);
    }

    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    int i = 0;
                    while (i < size) {
                        if (zzfka.zza(get(i), list.get(i))) {
                            i++;
                        }
                    }
                    return true;
                }
                Iterator it = iterator();
                Iterator it2 = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it2.hasNext()) {
                            if (!zzfka.zza(it.next(), it2.next())) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else if (!it2.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public final int indexOf(@NullableDecl Object obj) {
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

    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    public final int lastIndexOf(@NullableDecl Object obj) {
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

    public final /* bridge */ /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    public final zzfom<E> zza() {
        return listIterator(0);
    }

    @Deprecated
    public final zzfml<E> zze() {
        return this;
    }

    public int zzg(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    /* renamed from: zzh */
    public zzfml<E> subList(int i, int i2) {
        zzfke.zzg(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return zzfny.zza;
        }
        return new zzfmk(this, i, i3);
    }

    /* renamed from: zzt */
    public final zzfon<E> listIterator(int i) {
        zzfke.zzf(i, size(), "index");
        if (isEmpty()) {
            return zza;
        }
        return new zzfmj(this, i);
    }
}
