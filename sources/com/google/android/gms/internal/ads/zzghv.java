package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzghv extends zzgec<zzghv, zzghu> implements zzgfl {
    public static final zzghv zzh;
    public int zzb;
    public int zze;
    public zzgcz zzf;
    public zzgcz zzg;

    static {
        zzghv zzghv = new zzghv();
        zzh = zzghv;
        zzgec.zzay(zzghv.class, zzghv);
    }

    public zzghv() {
        zzgcz zzgcz = zzgcz.zzb;
        this.zzf = zzgcz;
        this.zzg = zzgcz;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzb", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzghv();
        } else {
            if (i2 == 4) {
                return new zzghu((zzghg) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }
}
