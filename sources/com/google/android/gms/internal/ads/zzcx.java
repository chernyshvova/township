package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcx extends zzgec<zzcx, zzcw> implements zzgfl {
    public static final zzcx zzg;
    public int zzb;
    public int zze;
    public long zzf = -1;

    static {
        zzcx zzcx = new zzcx();
        zzg = zzcx;
        zzgec.zzay(zzcx.class, zzcx);
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဂ\u0001", new Object[]{"zzb", "zze", zzct.zzc(), "zzf"});
        } else if (i2 == 3) {
            return new zzcx();
        } else {
            if (i2 == 4) {
                return new zzcw((zzcm) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
