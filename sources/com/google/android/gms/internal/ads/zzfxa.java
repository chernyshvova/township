package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfxa extends zzgec<zzfxa, zzfwz> implements zzgfl {
    public static final zzfxa zzf;
    public int zzb;
    public int zze;

    static {
        zzfxa zzfxa = new zzfxa();
        zzf = zzfxa;
        zzgec.zzay(zzfxa.class, zzfxa);
    }

    public static zzfxa zzc(zzgcz zzgcz, zzgdo zzgdo) throws zzgeo {
        return (zzfxa) zzgec.zzaI(zzf, zzgcz, zzgdo);
    }

    public static zzfwz zzd() {
        return (zzfwz) zzf.zzas();
    }

    public final int zza() {
        return this.zzb;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzfxa();
        } else {
            if (i2 == 4) {
                return new zzfwz((zzfwy) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
