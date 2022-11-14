package com.google.android.gms.internal.drive;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class zzkh extends zziw<Float> implements zzkp<Float>, zzmc, RandomAccess {
    public static final zzkh zzrm;
    public int size;
    public float[] zzrn;

    static {
        zzkh zzkh = new zzkh(new float[0], 0);
        zzrm = zzkh;
        zzkh.zzbp();
    }

    public zzkh() {
        this(new float[10], 0);
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
        zzc(i, ((Float) obj).floatValue());
    }

    public final boolean addAll(Collection<? extends Float> collection) {
        zzbq();
        zzkm.checkNotNull(collection);
        if (!(collection instanceof zzkh)) {
            return super.addAll(collection);
        }
        zzkh zzkh = (zzkh) collection;
        int i = zzkh.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.zzrn;
            if (i3 > fArr.length) {
                this.zzrn = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(zzkh.zzrn, 0, this.zzrn, this.size, zzkh.size);
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
        if (!(obj instanceof zzkh)) {
            return super.equals(obj);
        }
        zzkh zzkh = (zzkh) obj;
        if (this.size != zzkh.size) {
            return false;
        }
        float[] fArr = zzkh.zzrn;
        for (int i = 0; i < this.size; i++) {
            if (Float.floatToIntBits(this.zzrn[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        zzp(i);
        return Float.valueOf(this.zzrn[i]);
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.zzrn[i2]);
        }
        return i;
    }

    public final boolean remove(Object obj) {
        zzbq();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Float.valueOf(this.zzrn[i]))) {
                float[] fArr = this.zzrn;
                System.arraycopy(fArr, i + 1, fArr, i, (this.size - i) - 1);
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
            float[] fArr = this.zzrn;
            System.arraycopy(fArr, i2, fArr, i, this.size - i2);
            this.size -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zzbq();
        zzp(i);
        float[] fArr = this.zzrn;
        float f = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f);
    }

    public final int size() {
        return this.size;
    }

    public final void zzc(float f) {
        zzc(this.size, f);
    }

    public final /* synthetic */ zzkp zzr(int i) {
        if (i >= this.size) {
            return new zzkh(Arrays.copyOf(this.zzrn, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public zzkh(float[] fArr, int i) {
        this.zzrn = fArr;
        this.size = i;
    }

    private final void zzc(int i, float f) {
        int i2;
        zzbq();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzq(i));
        }
        float[] fArr = this.zzrn;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[GeneratedOutlineSupport.outline2(i2, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.zzrn, i, fArr2, i + 1, this.size - i);
            this.zzrn = fArr2;
        }
        this.zzrn[i] = f;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ Object remove(int i) {
        zzbq();
        zzp(i);
        float[] fArr = this.zzrn;
        float f = fArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Float.valueOf(f);
    }
}
