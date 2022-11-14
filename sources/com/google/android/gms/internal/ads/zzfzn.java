package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfzn extends zzgec<zzfzn, zzfzm> implements zzgfl {
    public static final zzfzn zzf;
    public int zzb;
    public zzfzq zze;

    static {
        zzfzn zzfzn = new zzfzn();
        zzf = zzfzn;
        zzgec.zzay(zzfzn.class, zzfzn);
    }

    public static zzfzn zzd(zzgcz zzgcz, zzgdo zzgdo) throws zzgeo {
        return (zzfzn) zzgec.zzaI(zzf, zzgcz, zzgdo);
    }

    public static zzfzm zze() {
        return (zzfzm) zzf.zzas();
    }

    public static /* synthetic */ void zzh(zzfzn zzfzn, zzfzq zzfzq) {
        zzfzq.getClass();
        zzfzn.zze = zzfzq;
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
            return new zzfzn();
        } else {
            if (i2 == 4) {
                return new zzfzm((zzfzl) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }

    public final zzfzq zzc() {
        zzfzq zzfzq = this.zze;
        return zzfzq == null ? zzfzq.zzd() : zzfzq;
    }
}
