package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfzt extends zzgec<zzfzt, zzfzs> implements zzgfl {
    public static final zzfzt zzf;
    public int zzb;
    public zzfzw zze;

    static {
        zzfzt zzfzt = new zzfzt();
        zzf = zzfzt;
        zzgec.zzay(zzfzt.class, zzfzt);
    }

    public static zzfzt zzd(zzgcz zzgcz, zzgdo zzgdo) throws zzgeo {
        return (zzfzt) zzgec.zzaI(zzf, zzgcz, zzgdo);
    }

    public static zzfzs zze() {
        return (zzfzs) zzf.zzas();
    }

    public static /* synthetic */ void zzh(zzfzt zzfzt, zzfzw zzfzw) {
        zzfzw.getClass();
        zzfzt.zze = zzfzw;
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
            return zzgec.zzaz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzfzt();
        } else {
            if (i2 == 4) {
                return new zzfzs((zzfzr) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }

    public final zzfzw zzc() {
        zzfzw zzfzw = this.zze;
        return zzfzw == null ? zzfzw.zzf() : zzfzw;
    }
}
