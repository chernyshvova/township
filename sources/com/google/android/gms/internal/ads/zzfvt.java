package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfvt extends zzgec<zzfvt, zzfvs> implements zzgfl {
    public static final zzfvt zzg;
    public int zzb;
    public zzfvz zze;
    public zzgcz zzf = zzgcz.zzb;

    static {
        zzfvt zzfvt = new zzfvt();
        zzg = zzfvt;
        zzgec.zzay(zzfvt.class, zzfvt);
    }

    public static zzfvt zze(zzgcz zzgcz, zzgdo zzgdo) throws zzgeo {
        return (zzfvt) zzgec.zzaI(zzg, zzgcz, zzgdo);
    }

    public static zzfvs zzf() {
        return (zzfvs) zzg.zzas();
    }

    public static zzfvt zzg() {
        return zzg;
    }

    public static /* synthetic */ void zzj(zzfvt zzfvt, zzfvz zzfvz) {
        zzfvz.getClass();
        zzfvt.zze = zzfvz;
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
            return zzgec.zzaz(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzfvt();
        } else {
            if (i2 == 4) {
                return new zzfvs((zzfvr) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }

    public final zzfvz zzc() {
        zzfvz zzfvz = this.zze;
        return zzfvz == null ? zzfvz.zzd() : zzfvz;
    }

    public final zzgcz zzd() {
        return this.zzf;
    }
}
