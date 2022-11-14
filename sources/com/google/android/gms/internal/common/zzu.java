package com.google.android.gms.internal.common;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public abstract class zzu<E> extends zzq<E> implements List<E>, RandomAccess {
    public static final zzy<Object> zza = new zzs(zzw.zza, 0);

    public static <E> zzu<E> zzi() {
        return zzw.zza;
    }

    public static <E> zzu<E> zzj(E e) {
        Object[] objArr = {e};
        zzv.zza(objArr, 1);
        return zzn(objArr, 1);
    }

    public static <E> zzu<E> zzk(E e, E e2) {
        Object[] objArr = {e, e2};
        zzv.zza(objArr, 2);
        return zzn(objArr, 2);
    }

    public static <E> zzu<E> zzl(Iterable<? extends E> iterable) {
        if (iterable == null) {
            throw null;
        } else if (iterable instanceof Collection) {
            return zzm((Collection) iterable);
        } else {
            Iterator<? extends E> it = iterable.iterator();
            if (!it.hasNext()) {
                return zzw.zza;
            }
            Object next = it.next();
            if (!it.hasNext()) {
                return zzj(next);
            }
            zzr zzr = new zzr(4);
            zzr.zzb(next);
            zzr.zzc(it);
            zzr.zzc = true;
            return zzn(zzr.zza, zzr.zzb);
        }
    }

    public static <E> zzu<E> zzm(Collection<? extends E> collection) {
        if (collection instanceof zzq) {
            zzu<E> zze = ((zzq) collection).zze();
            if (!zze.zzf()) {
                return zze;
            }
            Object[] array = zze.toArray();
            return zzn(array, array.length);
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        zzv.zza(array2, length);
        return zzn(array2, length);
    }

    public static <E> zzu<E> zzn(Object[] objArr, int i) {
        if (i == 0) {
            return zzw.zza;
        }
        return new zzw(objArr, i);
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
                        if (zzk.zza(get(i), list.get(i))) {
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
                            if (!zzk.zza(it.next(), it2.next())) {
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

    public final zzx<E> zza() {
        return listIterator(0);
    }

    public final zzu<E> zze() {
        return this;
    }

    public int zzg(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i2] = get(i2);
        }
        return size;
    }

    /* renamed from: zzh */
    public zzu<E> subList(int i, int i2) {
        zzl.zzc(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return zzw.zza;
        }
        return new zzt(this, i, i3);
    }

    /* renamed from: zzo */
    public final zzy<E> listIterator(int i) {
        zzl.zzb(i, size(), "index");
        if (isEmpty()) {
            return zza;
        }
        return new zzs(this, i);
    }
}
