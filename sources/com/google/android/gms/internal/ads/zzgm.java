package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgm extends zzhg {
    public final long zzi;

    public zzgm(zzfy zzfy, String str, String str2, zzcn zzcn, long j, int i, int i2) {
        super(zzfy, "zu63YSe1kidAeMcutkZVGzck9psTtGHz7PCNeED4MwOFY27ac/4JVy5q1i6kfidt", "NW4aS3lNi8fmvEi+Ve4jL+4aAzt/ssbWQU153xX+T2c=", zzcn, i, 25);
        this.zzi = j;
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.zzf.invoke((Object) null, new Object[0])).longValue();
        synchronized (this.zze) {
            this.zze.zzaa(longValue);
            long j = this.zzi;
            if (j != 0) {
                this.zze.zzk(longValue - j);
                this.zze.zzn(this.zzi);
            }
        }
    }
}
