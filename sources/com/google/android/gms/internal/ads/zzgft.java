package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgft<E> extends zzgck<E> implements RandomAccess {
    public static final zzgft<Object> zza;
    public E[] zzb;
    public int zzc;

    static {
        zzgft<Object> zzgft = new zzgft<>(new Object[0], 0);
        zza = zzgft;
        zzgft.zzb();
    }

    public zzgft() {
        this(new Object[10], 0);
    }

    public static <E> zzgft<E> zzd() {
        return zza;
    }

    private final void zzf(int i) {
        if (i < 0 || i >= this.zzc) {
            throw new IndexOutOfBoundsException(zzg(i));
        }
    }

    private final String zzg(int i) {
        return GeneratedOutlineSupport.outline11(35, "Index:", i, ", Size:", this.zzc);
    }

    public final void add(int i, E e) {
        int i2;
        zzcb();
        if (i < 0 || i > (i2 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzg(i));
        }
        E[] eArr = this.zzb;
        if (i2 < eArr.length) {
            System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
        } else {
            E[] eArr2 = new Object[GeneratedOutlineSupport.outline2(i2, 3, 2, 1)];
            System.arraycopy(eArr, 0, eArr2, 0, i);
            System.arraycopy(this.zzb, i, eArr2, i + 1, this.zzc - i);
            this.zzb = eArr2;
        }
        this.zzb[i] = e;
        this.zzc++;
        this.modCount++;
    }

    public final E get(int i) {
        zzf(i);
        return this.zzb[i];
    }

    public final E remove(int i) {
        zzcb();
        zzf(i);
        E[] eArr = this.zzb;
        E e = eArr[i];
        int i2 = this.zzc;
        if (i < i2 - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (i2 - i) - 1);
        }
        this.zzc--;
        this.modCount++;
        return e;
    }

    public final E set(int i, E e) {
        zzcb();
        zzf(i);
        E[] eArr = this.zzb;
        E e2 = eArr[i];
        eArr[i] = e;
        this.modCount++;
        return e2;
    }

    public final int size() {
        return this.zzc;
    }

    public final /* bridge */ /* synthetic */ zzgel zze(int i) {
        if (i >= this.zzc) {
            return new zzgft(Arrays.copyOf(this.zzb, i), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    public zzgft(E[] eArr, int i) {
        this.zzb = eArr;
        this.zzc = i;
    }

    public final boolean add(E e) {
        zzcb();
        int i = this.zzc;
        E[] eArr = this.zzb;
        if (i == eArr.length) {
            this.zzb = Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.zzb;
        int i2 = this.zzc;
        this.zzc = i2 + 1;
        eArr2[i2] = e;
        this.modCount++;
        return true;
    }
}
