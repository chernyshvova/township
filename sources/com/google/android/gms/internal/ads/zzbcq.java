package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbcq extends zzgec<zzbcq, zzbcp> implements zzgfl {
    public static final zzbcq zzh;
    public int zzb;
    public int zze = 1000;
    public zzbck zzf;
    public zzbbz zzg;

    static {
        zzbcq zzbcq = new zzbcq();
        zzh = zzbcq;
        zzgec.zzay(zzbcq.class, zzbcq);
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzb", "zze", zzbap.zzc(), "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzbcq();
        } else {
            if (i2 == 4) {
                return new zzbcp((zzaze) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }
}
