package com.google.android.gms.common.util;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@KeepForSdk
@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class ArrayUtils {
    @RecentlyNonNull
    @KeepForSdk
    public static <T> T[] appendToArray(@RecentlyNonNull T[] tArr, @RecentlyNonNull T t) {
        T[] tArr2;
        if (tArr == null && t == null) {
            throw new IllegalArgumentException("Cannot generate array of generic type w/o class info");
        }
        if (tArr == null) {
            tArr2 = (Object[]) Array.newInstance(t.getClass(), 1);
        } else {
            tArr2 = Arrays.copyOf(tArr, tArr.length + 1);
        }
        tArr2[tArr2.length - 1] = t;
        return tArr2;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static <T> T[] concat(@RecentlyNonNull T[]... tArr) {
        if (tArr.length == 0) {
            return (Object[]) Array.newInstance(tArr.getClass(), 0);
        }
        int i = 0;
        for (T[] length : tArr) {
            i += length.length;
        }
        T[] copyOf = Arrays.copyOf(tArr[0], i);
        int length2 = tArr[0].length;
        for (int i2 = 1; i2 < tArr.length; i2++) {
            T[] tArr2 = tArr[i2];
            int length3 = tArr2.length;
            System.arraycopy(tArr2, 0, copyOf, length2, length3);
            length2 += length3;
        }
        return copyOf;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static byte[] concatByteArrays(@RecentlyNonNull byte[]... bArr) {
        if (bArr.length == 0) {
            return new byte[0];
        }
        int i = 0;
        for (byte[] length : bArr) {
            i += length.length;
        }
        byte[] copyOf = Arrays.copyOf(bArr[0], i);
        int length2 = bArr[0].length;
        for (int i2 = 1; i2 < bArr.length; i2++) {
            byte[] bArr2 = bArr[i2];
            int length3 = bArr2.length;
            System.arraycopy(bArr2, 0, copyOf, length2, length3);
            length2 += length3;
        }
        return copyOf;
    }

    @KeepForSdk
    public static boolean contains(@RecentlyNonNull int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static <T> ArrayList<T> newArrayList() {
        return new ArrayList<>();
    }

    @KeepForSdk
    @RecentlyNullable
    public static <T> T[] removeAll(@RecentlyNonNull T[] tArr, @RecentlyNonNull T... tArr2) {
        int length;
        int i;
        if (tArr == null) {
            return null;
        }
        if (tArr2 == null || (length = tArr2.length) == 0) {
            return Arrays.copyOf(tArr, tArr.length);
        }
        T[] tArr3 = (Object[]) Array.newInstance(tArr2.getClass().getComponentType(), r3);
        if (length == 1) {
            i = 0;
            for (T t : tArr) {
                if (!Objects.equal(tArr2[0], t)) {
                    tArr3[i] = t;
                    i++;
                }
            }
        } else {
            int i2 = 0;
            for (T t2 : tArr) {
                if (!contains(tArr2, t2)) {
                    tArr3[i2] = t2;
                    i2++;
                }
            }
            i = i2;
        }
        if (tArr3 == null) {
            return null;
        }
        if (i == tArr3.length) {
            return tArr3;
        }
        return Arrays.copyOf(tArr3, i);
    }

    @RecentlyNonNull
    @KeepForSdk
    public static <T> ArrayList<T> toArrayList(@RecentlyNonNull T[] tArr) {
        ArrayList<T> arrayList = new ArrayList<>(r0);
        for (T add : tArr) {
            arrayList.add(add);
        }
        return arrayList;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static int[] toPrimitiveArray(@RecentlyNonNull Collection<Integer> collection) {
        int i = 0;
        if (collection == null || collection.size() == 0) {
            return new int[0];
        }
        int[] iArr = new int[collection.size()];
        for (Integer intValue : collection) {
            iArr[i] = intValue.intValue();
            i++;
        }
        return iArr;
    }

    @KeepForSdk
    @RecentlyNullable
    public static Integer[] toWrapperArray(@RecentlyNonNull int[] iArr) {
        if (iArr == null) {
            return null;
        }
        int length = iArr.length;
        Integer[] numArr = new Integer[length];
        for (int i = 0; i < length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        return numArr;
    }

    @KeepForSdk
    public static void writeArray(@RecentlyNonNull StringBuilder sb, @RecentlyNonNull double[] dArr) {
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(Double.toString(dArr[i]));
        }
    }

    @KeepForSdk
    public static void writeStringArray(@RecentlyNonNull StringBuilder sb, @RecentlyNonNull String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append("\"");
            sb.append(strArr[i]);
            sb.append("\"");
        }
    }

    @KeepForSdk
    public static <T> boolean contains(@RecentlyNonNull T[] tArr, @RecentlyNonNull T t) {
        int length = tArr != null ? tArr.length : 0;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            } else if (!Objects.equal(tArr[i], t)) {
                i++;
            } else if (i >= 0) {
                return true;
            }
        }
        return false;
    }

    @KeepForSdk
    public static void writeArray(@RecentlyNonNull StringBuilder sb, @RecentlyNonNull float[] fArr) {
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(Float.toString(fArr[i]));
        }
    }

    @KeepForSdk
    public static void writeArray(@RecentlyNonNull StringBuilder sb, @RecentlyNonNull int[] iArr) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(Integer.toString(iArr[i]));
        }
    }

    @KeepForSdk
    public static void writeArray(@RecentlyNonNull StringBuilder sb, @RecentlyNonNull long[] jArr) {
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(Long.toString(jArr[i]));
        }
    }

    @KeepForSdk
    public static <T> void writeArray(@RecentlyNonNull StringBuilder sb, @RecentlyNonNull T[] tArr) {
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(tArr[i]);
        }
    }

    @KeepForSdk
    public static void writeArray(@RecentlyNonNull StringBuilder sb, @RecentlyNonNull boolean[] zArr) {
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(Boolean.toString(zArr[i]));
        }
    }
}
