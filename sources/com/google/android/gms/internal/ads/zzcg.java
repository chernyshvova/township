package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcg extends zzgec<zzcg, zzcf> implements zzgfl {
    public static final zzcg zzf;
    public int zzb;
    public int zze = 2;

    static {
        zzcg zzcg = new zzcg();
        zzf = zzcg;
        zzgec.zzay(zzcg.class, zzcg);
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzf, "\u0001\u0001\u0000\u0001\u001b\u001b\u0001\u0000\u0000\u0000\u001bဌ\u0000", new Object[]{"zzb", "zze", zzcj.zzb()});
        } else if (i2 == 3) {
            return new zzcg();
        } else {
            if (i2 == 4) {
                return new zzcf((zzcc) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
