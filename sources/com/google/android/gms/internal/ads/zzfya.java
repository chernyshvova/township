package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfya extends zzgec<zzfya, zzfxz> implements zzgfl {
    public static final zzfya zzg;
    public int zzb;
    public int zze;
    public zzgcz zzf = zzgcz.zzb;

    static {
        zzfya zzfya = new zzfya();
        zzg = zzfya;
        zzgec.zzay(zzfya.class, zzfya);
    }

    public static zzfxz zze() {
        return (zzfxz) zzg.zzas();
    }

    public static zzfya zzf() {
        return zzg;
    }

    public final zzfyc zza() {
        zzfyc zzb2 = zzfyc.zzb(this.zzb);
        return zzb2 == null ? zzfyc.UNRECOGNIZED : zzb2;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzg, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzfya();
        } else {
            if (i2 == 4) {
                return new zzfxz((zzfxy) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }

    public final zzfye zzc() {
        zzfye zzb2 = zzfye.zzb(this.zze);
        return zzb2 == null ? zzfye.UNRECOGNIZED : zzb2;
    }

    public final zzgcz zzd() {
        return this.zzf;
    }
}
