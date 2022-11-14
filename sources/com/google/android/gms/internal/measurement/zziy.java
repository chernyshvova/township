package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zziy implements zzjg {
    public zzjg[] zza;

    public zziy(zzjg... zzjgArr) {
        this.zza = zzjgArr;
    }

    public final boolean zza(Class<?> cls) {
        for (zzjg zza2 : this.zza) {
            if (zza2.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzjh zzb(Class<?> cls) {
        for (zzjg zzjg : this.zza) {
            if (zzjg.zza(cls)) {
                return zzjg.zzb(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
