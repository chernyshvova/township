package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzffp {
    public static void zza(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void zzb(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void zzc(zzfep zzfep, zzfem zzfem, zzfeo zzfeo) {
        if (zzfep == zzfep.NONE) {
            throw new IllegalArgumentException("Impression owner is none");
        } else if (zzfem == zzfem.DEFINED_BY_JAVASCRIPT && zzfep == zzfep.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        } else if (zzfeo == zzfeo.DEFINED_BY_JAVASCRIPT && zzfep == zzfep.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
    }
}
