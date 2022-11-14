package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgfb implements zzgfi {
    public final zzgfi[] zza;

    public zzgfb(zzgfi... zzgfiArr) {
        this.zza = zzgfiArr;
    }

    public final boolean zzb(Class<?> cls) {
        zzgfi[] zzgfiArr = this.zza;
        for (int i = 0; i < 2; i++) {
            if (zzgfiArr[i].zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzgfh zzc(Class<?> cls) {
        zzgfi[] zzgfiArr = this.zza;
        for (int i = 0; i < 2; i++) {
            zzgfi zzgfi = zzgfiArr[i];
            if (zzgfi.zzb(cls)) {
                return zzgfi.zzc(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
