package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzce extends zzgec<zzce, zzcd> implements zzgfl {
    public static final zzce zzg;
    public int zzb;
    public zzcg zze;
    public zzcl zzf;

    static {
        zzce zzce = new zzce();
        zzg = zzce;
        zzgec.zzay(zzce.class, zzce);
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzce();
        } else {
            if (i2 == 4) {
                return new zzcd((zzcc) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
