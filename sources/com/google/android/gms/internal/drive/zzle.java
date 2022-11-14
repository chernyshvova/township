package com.google.android.gms.internal.drive;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class zzle extends zziw<Long> implements zzkp<Long>, zzmc, RandomAccess {
    public static final zzle zztp;
    public int size;
    public long[] zztq;

    static {
        zzle zzle = new zzle(new long[0], 0);
        zztp = zzle;
        zzle.zzbp();
    }

    public zzle() {
        this(new long[10], 0);
    }

    private final void zzk(int i, long j) {
        int i2;
        zzbq();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzq(i));
        }
        long[] jArr = this.zztq;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[GeneratedOutlineSupport.outline2(i2, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.zztq, i, jArr2, i + 1, this.size - i);
            this.zztq = jArr2;
        }
        this.zztq[i] = j;
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
        zzk(i, ((Long) obj).longValue());
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        zzbq();
        zzkm.checkNotNull(collection);
        if (!(collection instanceof zzle)) {
            return super.addAll(collection);
        }
        zzle zzle = (zzle) collection;
        int i = zzle.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.zztq;
            if (i3 > jArr.length) {
                this.zztq = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(zzle.zztq, 0, this.zztq, this.size, zzle.size);
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
        if (!(obj instanceof zzle)) {
            return super.equals(obj);
        }
        zzle zzle = (zzle) obj;
        if (this.size != zzle.size) {
            return false;
        }
        long[] jArr = zzle.zztq;
        for (int i = 0; i < this.size; i++) {
            if (this.zztq[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(getLong(i));
    }

    public final long getLong(int i) {
        zzp(i);
        return this.zztq[i];
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzkm.zzu(this.zztq[i2]);
        }
        return i;
    }

    public final boolean remove(Object obj) {
        zzbq();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Long.valueOf(this.zztq[i]))) {
                long[] jArr = this.zztq;
                System.arraycopy(jArr, i + 1, jArr, i, (this.size - i) - 1);
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
            long[] jArr = this.zztq;
            System.arraycopy(jArr, i2, jArr, i, this.size - i2);
            this.size -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzbq();
        zzp(i);
        long[] jArr = this.zztq;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    public final int size() {
        return this.size;
    }

    public final /* synthetic */ zzkp zzr(int i) {
        if (i >= this.size) {
            return new zzle(Arrays.copyOf(this.zztq, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final void zzv(long j) {
        zzk(this.size, j);
    }

    public zzle(long[] jArr, int i) {
        this.zztq = jArr;
        this.size = i;
    }

    public final /* synthetic */ Object remove(int i) {
        zzbq();
        zzp(i);
        long[] jArr = this.zztq;
        long j = jArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Long.valueOf(j);
    }
}
