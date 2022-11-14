package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbcw extends zzgec<zzbcw, zzbcv> implements zzgfl {
    public static final zzbcw zzg;
    public int zzb;
    public int zze = 1000;
    public zzbck zzf;

    static {
        zzbcw zzbcw = new zzbcw();
        zzg = zzbcw;
        zzgec.zzay(zzbcw.class, zzbcw);
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001", new Object[]{"zzb", "zze", zzbap.zzc(), "zzf"});
        } else if (i2 == 3) {
            return new zzbcw();
        } else {
            if (i2 == 4) {
                return new zzbcv((zzaze) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
