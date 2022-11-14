package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzghw extends zzgec<zzghw, zzght> implements zzgfl {
    public static final zzghw zzl;
    public int zzb;
    public zzghv zze;
    public zzgel<zzgho> zzf = zzgec.zzaE();
    public zzgcz zzg;
    public zzgcz zzh;
    public int zzi;
    public zzgcz zzj;
    public byte zzk = 2;

    static {
        zzghw zzghw = new zzghw();
        zzl = zzghw;
        zzgec.zzay(zzghw.class, zzghw);
    }

    public zzghw() {
        zzgcz zzgcz = zzgcz.zzb;
        this.zzg = zzgcz;
        this.zzh = zzgcz;
        this.zzj = zzgcz;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzk);
        }
        byte b = 1;
        if (i2 == 2) {
            return zzgec.zzaz(zzl, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003\u0006ည\u0004", new Object[]{"zzb", "zze", "zzf", zzgho.class, "zzg", "zzh", "zzi", "zzj"});
        } else if (i2 == 3) {
            return new zzghw();
        } else {
            if (i2 == 4) {
                return new zzght((zzghg) null);
            }
            if (i2 == 5) {
                return zzl;
            }
            if (obj == null) {
                b = 0;
            }
            this.zzk = b;
            return null;
        }
    }
}
