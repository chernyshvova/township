package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzghr extends zzgec<zzghr, zzghq> implements zzgfl {
    public static final zzghr zzh;
    public int zzb;
    public zzgcz zze;
    public zzgcz zzf;
    public zzgcz zzg;

    static {
        zzghr zzghr = new zzghr();
        zzh = zzghr;
        zzgec.zzay(zzghr.class, zzghr);
    }

    public zzghr() {
        zzgcz zzgcz = zzgcz.zzb;
        this.zze = zzgcz;
        this.zzf = zzgcz;
        this.zzg = zzgcz;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzb", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzghr();
        } else {
            if (i2 == 4) {
                return new zzghq((zzghg) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }
}
