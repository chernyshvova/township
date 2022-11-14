package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbbv extends zzgec<zzbbv, zzbbu> implements zzgfl {
    public static final zzbbv zzg;
    public int zzb;
    public int zze;
    public int zzf;

    static {
        zzbbv zzbbv = new zzbbv();
        zzg = zzbbv;
        zzgec.zzay(zzbbv.class, zzbbv);
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzbbv();
        } else {
            if (i2 == 4) {
                return new zzbbu((zzaze) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
