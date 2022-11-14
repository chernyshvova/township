package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbbt extends zzgec<zzbbt, zzbbs> implements zzgfl {
    public static final zzbbt zzg;
    public int zzb;
    public int zze;
    public int zzf;

    static {
        zzbbt zzbbt = new zzbbt();
        zzg = zzbbt;
        zzgec.zzay(zzbbt.class, zzbbt);
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzbbt();
        } else {
            if (i2 == 4) {
                return new zzbbs((zzaze) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
