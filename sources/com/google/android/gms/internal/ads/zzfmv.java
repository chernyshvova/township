package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzfmv<E> extends zzfmg<E> implements Set<E> {
    @NullableDecl
    public transient zzfml<E> zza;

    @SafeVarargs
    public static <E> zzfmv<E> zzh(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        Object[] objArr = new Object[11];
        objArr[0] = e;
        objArr[1] = e2;
        objArr[2] = e3;
        objArr[3] = e4;
        objArr[4] = e5;
        objArr[5] = e6;
        System.arraycopy(eArr, 0, objArr, 6, 5);
        return zzo(11, objArr);
    }

    public static int zzi(int i) {
        double d;
        int max = Math.max(i, 2);
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1);
            do {
                highestOneBit += highestOneBit;
                d = (double) highestOneBit;
                Double.isNaN(d);
            } while (d * 0.7d < ((double) max));
            return highestOneBit;
        }
        zzfke.zza(max < 1073741824, "collection too large");
        return 1073741824;
    }

    public static <E> zzfmu<E> zzl(int i) {
        return new zzfmu<>(i);
    }

    public static <E> zzfmv<E> zzo(int i, Object... objArr) {
        if (i == 0) {
            return zzfoe.zza;
        }
        if (i == 1) {
            return new zzfoj(objArr[0]);
        }
        int zzi = zzi(i);
        Object[] objArr2 = new Object[zzi];
        int i2 = zzi - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object obj = objArr[i5];
            zzfnw.zzb(obj, i5);
            int hashCode = obj.hashCode();
            int zza2 = zzfmd.zza(hashCode);
            while (true) {
                int i6 = zza2 & i2;
                Object obj2 = objArr2[i6];
                if (obj2 == null) {
                    objArr[i4] = obj;
                    objArr2[i6] = obj;
                    i3 += hashCode;
                    i4++;
                    break;
                } else if (obj2.equals(obj)) {
                    break;
                } else {
                    zza2++;
                }
            }
        }
        Arrays.fill(objArr, i4, i, (Object) null);
        if (i4 == 1) {
            return new zzfoj(objArr[0], i3);
        }
        if (zzi(i4) < zzi / 2) {
            return zzo(i4, objArr);
        }
        if (zzp(i4, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new zzfoe(objArr, i3, objArr2, i2, i4);
    }

    public static boolean zzp(int i, int i2) {
        return i < (i2 >> 1) + (i2 >> 2);
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzfmv) && zzj() && ((zzfmv) obj).zzj() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() != set.size() || !containsAll(set)) {
                    return false;
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public int hashCode() {
        return zzfoi.zza(this);
    }

    /* renamed from: zza */
    public abstract zzfom<E> iterator();

    public zzfml<E> zze() {
        zzfml<E> zzfml = this.zza;
        if (zzfml != null) {
            return zzfml;
        }
        zzfml<E> zzk = zzk();
        this.zza = zzk;
        return zzk;
    }

    public boolean zzj() {
        return false;
    }

    public zzfml<E> zzk() {
        return zzfml.zzr(toArray());
    }
}
