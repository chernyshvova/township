package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaul {
    public static void zza(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void zzb(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException((String) obj);
        }
    }

    public static int zzc(int i, int i2, int i3) {
        if (i >= 0 && i < i3) {
            return 0;
        }
        throw new IndexOutOfBoundsException();
    }

    public static void zzd(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void zze(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException((String) obj);
        }
    }

    public static String zzf(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException();
    }
}
