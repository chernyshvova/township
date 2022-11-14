package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfvw extends zzgec<zzfvw, zzfvv> implements zzgfl {
    public static final zzfvw zzf;
    public zzfvz zzb;
    public int zze;

    static {
        zzfvw zzfvw = new zzfvw();
        zzf = zzfvw;
        zzgec.zzay(zzfvw.class, zzfvw);
    }

    public static zzfvw zzd(zzgcz zzgcz, zzgdo zzgdo) throws zzgeo {
        return (zzfvw) zzgec.zzaI(zzf, zzgcz, zzgdo);
    }

    public static zzfvv zze() {
        return (zzfvv) zzf.zzas();
    }

    public static zzfvw zzf() {
        return zzf;
    }

    public static /* synthetic */ void zzh(zzfvw zzfvw, zzfvz zzfvz) {
        zzfvz.getClass();
        zzfvw.zzb = zzfvz;
    }

    public final zzfvz zza() {
        zzfvz zzfvz = this.zzb;
        return zzfvz == null ? zzfvz.zzd() : zzfvz;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzfvw();
        } else {
            if (i2 == 4) {
                return new zzfvv((zzfvu) null);
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
