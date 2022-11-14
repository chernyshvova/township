package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbck extends zzgec<zzbck, zzbcg> implements zzgfl {
    public static final zzbck zzf;
    public int zzb;
    public int zze;

    static {
        zzbck zzbck = new zzbck();
        zzf = zzbck;
        zzgec.zzay(zzbck.class, zzbck);
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzf, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"zzb", "zze", zzbcj.zzb()});
        } else if (i2 == 3) {
            return new zzbck();
        } else {
            if (i2 == 4) {
                return new zzbcg((zzaze) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
