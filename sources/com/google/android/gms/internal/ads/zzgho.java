package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgho extends zzgec<zzgho, zzghn> implements zzgfl {
    public static final zzgho zzh;
    public int zzb;
    public zzgcz zze;
    public zzgcz zzf;
    public byte zzg = 2;

    static {
        zzgho zzgho = new zzgho();
        zzh = zzgho;
        zzgec.zzay(zzgho.class, zzgho);
    }

    public zzgho() {
        zzgcz zzgcz = zzgcz.zzb;
        this.zze = zzgcz;
        this.zzf = zzgcz;
    }

    public static zzghn zza() {
        return (zzghn) zzh.zzas();
    }

    public static /* synthetic */ void zzd(zzgho zzgho, zzgcz zzgcz) {
        zzgho.zzb |= 1;
        zzgho.zze = zzgcz;
    }

    public static /* synthetic */ void zze(zzgho zzgho, zzgcz zzgcz) {
        zzgho.zzb |= 2;
        zzgho.zzf = zzgcz;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzg);
        }
        byte b = 1;
        if (i2 == 2) {
            return zzgec.zzaz(zzh, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔊ\u0000\u0002ည\u0001", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzgho();
        } else {
            if (i2 == 4) {
                return new zzghn((zzghg) null);
            }
            if (i2 == 5) {
                return zzh;
            }
            if (obj == null) {
                b = 0;
            }
            this.zzg = b;
            return null;
        }
    }
}
