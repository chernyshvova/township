package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbax extends zzgec<zzbax, zzbaw> implements zzgfl {
    public static final zzbax zzi;
    public int zzb;
    public zzbat zze;
    public zzgel<zzbbx> zzf = zzgec.zzaE();
    public int zzg;
    public zzbbz zzh;

    static {
        zzbax zzbax = new zzbax();
        zzi = zzbax;
        zzgec.zzay(zzbax.class, zzbax);
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b\u0003ဌ\u0001\u0004ဉ\u0002", new Object[]{"zzb", "zze", "zzf", zzbbx.class, "zzg", zzbap.zzc(), "zzh"});
        } else if (i2 == 3) {
            return new zzbax();
        } else {
            if (i2 == 4) {
                return new zzbaw((zzaze) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzi;
        }
    }
}
