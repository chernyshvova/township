package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzgiy {
    public static zzgiy zzb(Class cls) {
        if (System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik")) {
            return new zzgit(cls.getSimpleName());
        }
        return new zzgiv(cls.getSimpleName());
    }

    public abstract void zza(String str);
}
