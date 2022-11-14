package com.google.android.gms.internal.drive;

public final class zzix {
    public static final Class<?> zzni = zzj("libcore.io.Memory");
    public static final boolean zznj = (zzj("org.robolectric.Robolectric") != null);

    public static boolean zzbr() {
        return zzni != null && !zznj;
    }

    public static Class<?> zzbs() {
        return zzni;
    }

    public static <T> Class<T> zzj(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
