package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbat extends zzgec<zzbat, zzbas> implements zzgfl {
    public static final zzbat zzi;
    public int zzb;
    public String zze = "";
    public int zzf;
    public zzgeh zzg = zzgec.zzaB();
    public zzbbz zzh;

    static {
        zzbat zzbat = new zzbat();
        zzi = zzbat;
        zzgec.zzay(zzbat.class, zzbat);
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဌ\u0001\u0003\u0016\u0004ဉ\u0002", new Object[]{"zzb", "zze", "zzf", zzbap.zzc(), "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzbat();
        } else {
            if (i2 == 4) {
                return new zzbas((zzaze) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzi;
        }
    }
}
