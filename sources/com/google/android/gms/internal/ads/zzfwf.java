package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfwf extends zzgec<zzfwf, zzfwe> implements zzgfl {
    public static final zzfwf zzf;
    public zzfwi zzb;
    public int zze;

    static {
        zzfwf zzfwf = new zzfwf();
        zzf = zzfwf;
        zzgec.zzay(zzfwf.class, zzfwf);
    }

    public static zzfwf zzd(zzgcz zzgcz, zzgdo zzgdo) throws zzgeo {
        return (zzfwf) zzgec.zzaI(zzf, zzgcz, zzgdo);
    }

    public static zzfwe zze() {
        return (zzfwe) zzf.zzas();
    }

    public static /* synthetic */ void zzg(zzfwf zzfwf, zzfwi zzfwi) {
        zzfwi.getClass();
        zzfwf.zzb = zzfwi;
    }

    public final zzfwi zza() {
        zzfwi zzfwi = this.zzb;
        return zzfwi == null ? zzfwi.zzd() : zzfwi;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzfwf();
        } else {
            if (i2 == 4) {
                return new zzfwe((zzfwd) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }

    public final int zzc() {
        return this.zze;
    }
}
