package com.google.android.gms.internal.drive;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class zzkl extends zziw<Integer> implements zzkp<Integer>, zzmc, RandomAccess {
    public static final zzkl zzsl;
    public int size;
    public int[] zzsm;

    static {
        zzkl zzkl = new zzkl(new int[0], 0);
        zzsl = zzkl;
        zzkl.zzbp();
    }

    public zzkl() {
        this(new int[10], 0);
    }

    private final void zzo(int i, int i2) {
        int i3;
        zzbq();
        if (i < 0 || i > (i3 = this.size)) {
            throw new IndexOutOfBoundsException(zzq(i));
        }
        int[] iArr = this.zzsm;
        if (i3 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i3 - i);
        } else {
            int[] iArr2 = new int[GeneratedOutlineSupport.outline2(i3, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.zzsm, i, iArr2, i + 1, this.size - i);
            this.zzsm = iArr2;
        }
        this.zzsm[i] = i2;
        this.size++;
        this.modCount++;
    }

    private final void zzp(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzq(i));
        }
    }

    private final String zzq(int i) {
        return GeneratedOutlineSupport.outline11(35, "Index:", i, ", Size:", this.size);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzo(i, ((Integer) obj).intValue());
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        zzbq();
        zzkm.checkNotNull(collection);
        if (!(collection instanceof zzkl)) {
            return super.addAll(collection);
        }
        zzkl zzkl = (zzkl) collection;
        int i = zzkl.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.zzsm;
            if (i3 > iArr.length) {
                this.zzsm = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(zzkl.zzsm, 0, this.zzsm, this.size, zzkl.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzkl)) {
            return super.equals(obj);
        }
        zzkl zzkl = (zzkl) obj;
        if (this.size != zzkl.size) {
            return false;
        }
        int[] iArr = zzkl.zzsm;
        for (int i = 0; i < this.size; i++) {
            if (this.zzsm[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    public final int getInt(int i) {
        zzp(i);
        return this.zzsm[i];
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zzsm[i2];
        }
        return i;
    }

    public final boolean remove(Object obj) {
        zzbq();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Integer.valueOf(this.zzsm[i]))) {
                int[] iArr = this.zzsm;
                System.arraycopy(iArr, i + 1, iArr, i, (this.size - i) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    public final void removeRange(int i, int i2) {
        zzbq();
        if (i2 >= i) {
            int[] iArr = this.zzsm;
            System.arraycopy(iArr, i2, iArr, i, this.size - i2);
            this.size -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzbq();
        zzp(i);
        int[] iArr = this.zzsm;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final int size() {
        return this.size;
    }

    public final void zzam(int i) {
        zzo(this.size, i);
    }

    public final /* synthetic */ zzkp zzr(int i) {
        if (i >= this.size) {
            return new zzkl(Arrays.copyOf(this.zzsm, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public zzkl(int[] iArr, int i) {
        this.zzsm = iArr;
        this.size = i;
    }

    public final /* synthetic */ Object remove(int i) {
        zzbq();
        zzp(i);
        int[] iArr = this.zzsm;
        int i2 = iArr[i];
        int i3 = this.size;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Integer.valueOf(i2);
    }
}
