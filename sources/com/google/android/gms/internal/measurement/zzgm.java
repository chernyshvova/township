package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzgm {
    public static final Class<?> zza = zza("libcore.io.Memory");
    public static final boolean zzb = (zza("org.robolectric.Robolectric") != null);

    public static boolean zza() {
        return zza != null && !zzb;
    }

    public static Class<?> zzb() {
        return zza;
    }

    public static <T> Class<T> zza(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
