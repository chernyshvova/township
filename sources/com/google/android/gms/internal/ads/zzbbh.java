package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbbh extends zzgec<zzbbh, zzbbg> implements zzgfl {
    public static final zzbbh zzg;
    public int zzb;
    public int zze;
    public zzbbz zzf;

    static {
        zzbbh zzbbh = new zzbbh();
        zzg = zzbbh;
        zzgec.zzay(zzbbh.class, zzbbh);
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001", new Object[]{"zzb", "zze", zzbap.zzc(), "zzf"});
        } else if (i2 == 3) {
            return new zzbbh();
        } else {
            if (i2 == 4) {
                return new zzbbg((zzaze) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
