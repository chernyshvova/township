package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfzq extends zzgec<zzfzq, zzfzp> implements zzgfl {
    public static final zzfzq zze;
    public String zzb = "";

    static {
        zzfzq zzfzq = new zzfzq();
        zze = zzfzq;
        zzgec.zzay(zzfzq.class, zzfzq);
    }

    public static zzfzq zzc(zzgcz zzgcz, zzgdo zzgdo) throws zzgeo {
        return (zzfzq) zzgec.zzaI(zze, zzgcz, zzgdo);
    }

    public static zzfzq zzd() {
        return zze;
    }

    public final String zza() {
        return this.zzb;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zze, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzb"});
        } else if (i2 == 3) {
            return new zzfzq();
        } else {
            if (i2 == 4) {
                return new zzfzp((zzfzo) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zze;
        }
    }
}
