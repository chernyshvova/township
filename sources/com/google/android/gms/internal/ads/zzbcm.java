package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbcm extends zzgec<zzbcm, zzbcl> implements zzgfl {
    public static final zzbcm zzi;
    public int zzb;
    public zzbcb zze;
    public int zzf = 1000;
    public zzbck zzg;
    public zzbbz zzh;

    static {
        zzbcm zzbcm = new zzbcm();
        zzi = zzbcm;
        zzgec.zzay(zzbcm.class, zzbcm);
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zzb", "zze", "zzf", zzbap.zzc(), "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzbcm();
        } else {
            if (i2 == 4) {
                return new zzbcl((zzaze) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzi;
        }
    }
}
