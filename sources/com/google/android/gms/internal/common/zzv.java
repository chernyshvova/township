package com.google.android.gms.internal.common;

import com.android.tools.p006r8.GeneratedOutlineSupport;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class zzv {
    public static Object[] zza(Object[] objArr, int i) {
        int i2 = 0;
        while (i2 < i) {
            if (objArr[i2] != null) {
                i2++;
            } else {
                throw new NullPointerException(GeneratedOutlineSupport.outline9(20, "at index ", i2));
            }
        }
        return objArr;
    }
}
