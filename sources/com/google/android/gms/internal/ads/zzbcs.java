package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbcs extends zzgec<zzbcs, zzbcr> implements zzgfl {
    public static final zzbcs zzk;
    public int zzb;
    public int zze = 1000;
    public zzbck zzf;
    public int zzg;
    public int zzh;
    public int zzi;
    public long zzj;

    static {
        zzbcs zzbcs = new zzbcs();
        zzk = zzbcs;
        zzgec.zzay(zzbcs.class, zzbcs);
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzk, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006ဃ\u0005", new Object[]{"zzb", "zze", zzbap.zzc(), "zzf", "zzg", "zzh", "zzi", "zzj"});
        } else if (i2 == 3) {
            return new zzbcs();
        } else {
            if (i2 == 4) {
                return new zzbcr((zzaze) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzk;
        }
    }
}
