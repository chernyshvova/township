package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzhc extends zzhg {
    public zzhc(zzfy zzfy, String str, String str2, zzcn zzcn, int i, int i2) {
        super(zzfy, "FiLUZy/XwdzoXuv+wZ8fpBUMomrb2qDVGXE0AhvrFclxf2680Tj+s03XL4ZGGoFK", "G77t423Wv8U+IX+CBfR4k5CGTg8kBFUl+lsHl5zHfM8=", zzcn, i, 48);
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzF(zzdm.ENUM_FAILURE);
        boolean booleanValue = ((Boolean) this.zzf.invoke((Object) null, new Object[]{this.zzb.zzb()})).booleanValue();
        synchronized (this.zze) {
            if (booleanValue) {
                this.zze.zzF(zzdm.ENUM_TRUE);
            } else {
                this.zze.zzF(zzdm.ENUM_FALSE);
            }
        }
    }
}
