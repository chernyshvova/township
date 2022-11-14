package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfve extends zzgec<zzfve, zzfvd> implements zzgfl {
    public static final zzfve zzg;
    public int zzb;
    public zzgcz zze = zzgcz.zzb;
    public zzfvk zzf;

    static {
        zzfve zzfve = new zzfve();
        zzg = zzfve;
        zzgec.zzay(zzfve.class, zzfve);
    }

    public static zzfve zze(zzgcz zzgcz, zzgdo zzgdo) throws zzgeo {
        return (zzfve) zzgec.zzaI(zzg, zzgcz, zzgdo);
    }

    public static zzfvd zzf() {
        return (zzfvd) zzg.zzas();
    }

    public static /* synthetic */ void zzj(zzfve zzfve, zzfvk zzfvk) {
        zzfvk.getClass();
        zzfve.zzf = zzfvk;
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
            return zzgec.zzaz(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003\t", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzfve();
        } else {
            if (i2 == 4) {
                return new zzfvd((zzfvc) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }

    public final zzgcz zzc() {
        return this.zze;
    }

    public final zzfvk zzd() {
        zzfvk zzfvk = this.zzf;
        return zzfvk == null ? zzfvk.zzd() : zzfvk;
    }
}
