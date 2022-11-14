package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzfmg<E> extends AbstractCollection<E> implements Serializable {
    public static final Object[] zza = new Object[0];

    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean contains(@NullableDecl Object obj);

    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public final Object[] toArray() {
        return toArray(zza);
    }

    /* renamed from: zza */
    public abstract zzfom<E> iterator();

    @NullableDecl
    public Object[] zzb() {
        return null;
    }

    public int zzc() {
        throw new UnsupportedOperationException();
    }

    public int zzd() {
        throw new UnsupportedOperationException();
    }

    public zzfml<E> zze() {
        if (isEmpty()) {
            return zzfml.zzi();
        }
        return zzfml.zzr(toArray(zza));
    }

    public abstract boolean zzf();

    public int zzg(Object[] objArr, int i) {
        throw null;
    }

    public final <T> T[] toArray(T[] tArr) {
        if (tArr != null) {
            int size = size();
            int length = tArr.length;
            if (length < size) {
                Object[] zzb = zzb();
                if (zzb != null) {
                    return Arrays.copyOfRange(zzb, zzc(), zzd(), tArr.getClass());
                }
                tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
            } else if (length > size) {
                tArr[size] = null;
            }
            zzg(tArr, 0);
            return tArr;
        }
        throw null;
    }
}
