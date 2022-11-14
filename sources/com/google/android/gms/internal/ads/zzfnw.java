package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfnw {
    public static Object[] zza(Object[] objArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            zzb(objArr[i2], i2);
        }
        return objArr;
    }

    public static Object zzb(Object obj, int i) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(GeneratedOutlineSupport.outline9(20, "at index ", i));
    }
}
