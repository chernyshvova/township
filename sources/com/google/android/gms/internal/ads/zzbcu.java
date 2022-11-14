package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbcu extends zzgec<zzbcu, zzbct> implements zzgfl {
    public static final zzbcu zzh;
    public int zzb;
    public int zze = 1000;
    public zzbck zzf;
    public zzbbz zzg;

    static {
        zzbcu zzbcu = new zzbcu();
        zzh = zzbcu;
        zzgec.zzay(zzbcu.class, zzbcu);
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzb", "zze", zzbap.zzc(), "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzbcu();
        } else {
            if (i2 == 4) {
                return new zzbct((zzaze) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }
}
