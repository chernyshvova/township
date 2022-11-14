package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbav extends zzgec<zzbav, zzbau> implements zzgfl {
    public static final zzbav zzg;
    public int zzb;
    public int zze;
    public zzgeh zzf = zzgec.zzaB();

    static {
        zzbav zzbav = new zzbav();
        zzg = zzbav;
        zzgec.zzay(zzbav.class, zzbav);
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u0016", new Object[]{"zzb", "zze", zzbap.zzc(), "zzf"});
        } else if (i2 == 3) {
            return new zzbav();
        } else {
            if (i2 == 4) {
                return new zzbau((zzaze) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
