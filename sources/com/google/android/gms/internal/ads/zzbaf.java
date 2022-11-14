package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbaf extends zzgec<zzbaf, zzbae> implements zzgfl {
    public static final zzbaf zzk;
    public int zzb;
    public int zze;
    public zzbbz zzf;
    public zzbbz zzg;
    public zzbbz zzh;
    public zzgel<zzbbz> zzi = zzgec.zzaE();
    public int zzj;

    static {
        zzbaf zzbaf = new zzbaf();
        zzk = zzbaf;
        zzgec.zzay(zzbaf.class, zzbaf);
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzk, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005\u001b\u0006င\u0004", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", zzbbz.class, "zzj"});
        } else if (i2 == 3) {
            return new zzbaf();
        } else {
            if (i2 == 4) {
                return new zzbae((zzaze) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzk;
        }
    }
}
