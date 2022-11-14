package com.google.android.gms.internal.drive;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class zzja extends zziw<Boolean> implements zzkp<Boolean>, zzmc, RandomAccess {
    public static final zzja zzno;
    public int size;
    public boolean[] zznp;

    static {
        zzja zzja = new zzja(new boolean[0], 0);
        zzno = zzja;
        zzja.zzbp();
    }

    public zzja() {
        this(new boolean[10], 0);
    }

    private final void zza(int i, boolean z) {
        int i2;
        zzbq();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzq(i));
        }
        boolean[] zArr = this.zznp;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[GeneratedOutlineSupport.outline2(i2, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.zznp, i, zArr2, i + 1, this.size - i);
            this.zznp = zArr2;
        }
        this.zznp[i] = z;
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
        zza(i, ((Boolean) obj).booleanValue());
    }

    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzbq();
        zzkm.checkNotNull(collection);
        if (!(collection instanceof zzja)) {
            return super.addAll(collection);
        }
        zzja zzja = (zzja) collection;
        int i = zzja.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            boolean[] zArr = this.zznp;
            if (i3 > zArr.length) {
                this.zznp = Arrays.copyOf(zArr, i3);
            }
            System.arraycopy(zzja.zznp, 0, this.zznp, this.size, zzja.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void addBoolean(boolean z) {
        zza(this.size, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzja)) {
            return super.equals(obj);
        }
        zzja zzja = (zzja) obj;
        if (this.size != zzja.size) {
            return false;
        }
        boolean[] zArr = zzja.zznp;
        for (int i = 0; i < this.size; i++) {
            if (this.zznp[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        zzp(i);
        return Boolean.valueOf(this.zznp[i]);
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzkm.zze(this.zznp[i2]);
        }
        return i;
    }

    public final boolean remove(Object obj) {
        zzbq();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Boolean.valueOf(this.zznp[i]))) {
                boolean[] zArr = this.zznp;
                System.arraycopy(zArr, i + 1, zArr, i, (this.size - i) - 1);
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
            boolean[] zArr = this.zznp;
            System.arraycopy(zArr, i2, zArr, i, this.size - i2);
            this.size -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzbq();
        zzp(i);
        boolean[] zArr = this.zznp;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    public final int size() {
        return this.size;
    }

    public final /* synthetic */ zzkp zzr(int i) {
        if (i >= this.size) {
            return new zzja(Arrays.copyOf(this.zznp, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public zzja(boolean[] zArr, int i) {
        this.zznp = zArr;
        this.size = i;
    }

    public final /* synthetic */ Object remove(int i) {
        zzbq();
        zzp(i);
        boolean[] zArr = this.zznp;
        boolean z = zArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Boolean.valueOf(z);
    }
}
