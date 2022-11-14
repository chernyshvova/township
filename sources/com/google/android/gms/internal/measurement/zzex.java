package com.google.android.gms.internal.measurement;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.playrix.gplay.billing.Base64;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzex {
    public static int zza(int i, int i2, int i3) {
        return (i & (i3 ^ -1)) | (i2 & i3);
    }

    public static Object zza(int i) {
        if (i < 2 || i > 1073741824 || Integer.highestOneBit(i) != i) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline9(52, "must be power of 2 between 2^1 and 2^30: ", i));
        } else if (i <= 256) {
            return new byte[i];
        } else {
            if (i <= 65536) {
                return new short[i];
            }
            return new int[i];
        }
    }

    public static int zzb(int i) {
        return (i + 1) * (i < 32 ? 4 : 2);
    }

    public static int zza(Object obj, int i) {
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i] & Base64.EQUALS_SIGN_ENC;
        }
        if (obj instanceof short[]) {
            return ((short[]) obj)[i] & 65535;
        }
        return ((int[]) obj)[i];
    }

    public static void zza(Object obj, int i, int i2) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i] = (byte) i2;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i] = (short) i2;
        } else {
            ((int[]) obj)[i] = i2;
        }
    }

    public static int zza(@NullableDecl Object obj, @NullableDecl Object obj2, int i, Object obj3, int[] iArr, Object[] objArr, @NullableDecl Object[] objArr2) {
        int i2;
        int i3;
        int zza = zzez.zza(obj);
        int i4 = zza & i;
        int zza2 = zza(obj3, i4);
        if (zza2 == 0) {
            return -1;
        }
        int i5 = i ^ -1;
        int i6 = zza & i5;
        int i7 = -1;
        while (true) {
            i2 = zza2 - 1;
            i3 = iArr[i2];
            if ((i3 & i5) != i6 || !zzdz.zza(obj, objArr[i2]) || (objArr2 != null && !zzdz.zza(obj2, objArr2[i2]))) {
                int i8 = i3 & i;
                if (i8 == 0) {
                    return -1;
                }
                int i9 = i8;
                i7 = i2;
                zza2 = i9;
            }
        }
        int i10 = i3 & i;
        if (i7 == -1) {
            zza(obj3, i4, i10);
        } else {
            iArr[i7] = zza(iArr[i7], i10, i);
        }
        return i2;
    }
}
