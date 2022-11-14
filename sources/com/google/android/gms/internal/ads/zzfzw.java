package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfzw extends zzgec<zzfzw, zzfzv> implements zzgfl {
    public static final zzfzw zzf;
    public String zzb = "";
    public zzfyx zze;

    static {
        zzfzw zzfzw = new zzfzw();
        zzf = zzfzw;
        zzgec.zzay(zzfzw.class, zzfzw);
    }

    public static zzfzw zze(zzgcz zzgcz, zzgdo zzgdo) throws zzgeo {
        return (zzfzw) zzgec.zzaI(zzf, zzgcz, zzgdo);
    }

    public static zzfzw zzf() {
        return zzf;
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
            return zzgec.zzaz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzfzw();
        } else {
            if (i2 == 4) {
                return new zzfzv((zzfzu) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }

    public final boolean zzc() {
        return this.zze != null;
    }

    public final zzfyx zzd() {
        zzfyx zzfyx = this.zze;
        return zzfyx == null ? zzfyx.zzf() : zzfyx;
    }
}
