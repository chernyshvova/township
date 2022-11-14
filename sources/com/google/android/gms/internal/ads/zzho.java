package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzho extends zzgec<zzho, zzhn> implements zzgfl {
    public static final zzho zzh;
    public int zzb;
    public zzhr zze;
    public zzgcz zzf;
    public zzgcz zzg;

    static {
        zzho zzho = new zzho();
        zzh = zzho;
        zzgec.zzay(zzho.class, zzho);
    }

    public zzho() {
        zzgcz zzgcz = zzgcz.zzb;
        this.zzf = zzgcz;
        this.zzg = zzgcz;
    }

    public static zzho zze(zzgcz zzgcz, zzgdo zzgdo) throws zzgeo {
        return (zzho) zzgec.zzaI(zzh, zzgcz, zzgdo);
    }

    public final zzhr zza() {
        zzhr zzhr = this.zze;
        return zzhr == null ? zzhr.zzj() : zzhr;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzb", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzho();
        } else {
            if (i2 == 4) {
                return new zzhn((zzhm) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }

    public final zzgcz zzc() {
        return this.zzf;
    }

    public final zzgcz zzd() {
        return this.zzg;
    }
}
