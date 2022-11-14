package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfwu extends zzgec<zzfwu, zzfwt> implements zzgfl {
    public static final zzfwu zzf;
    public int zzb;
    public int zze;

    static {
        zzfwu zzfwu = new zzfwu();
        zzf = zzfwu;
        zzgec.zzay(zzfwu.class, zzfwu);
    }

    public static zzfwu zzc(zzgcz zzgcz, zzgdo zzgdo) throws zzgeo {
        return (zzfwu) zzgec.zzaI(zzf, zzgcz, zzgdo);
    }

    public static zzfwt zzd() {
        return (zzfwt) zzf.zzas();
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
            return zzgec.zzaz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zze", "zzb"});
        } else if (i2 == 3) {
            return new zzfwu();
        } else {
            if (i2 == 4) {
                return new zzfwt((zzfws) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
