package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfvq extends zzgec<zzfvq, zzfvp> implements zzgfl {
    public static final zzfvq zzf;
    public zzfvw zzb;
    public zzfyk zze;

    static {
        zzfvq zzfvq = new zzfvq();
        zzf = zzfvq;
        zzgec.zzay(zzfvq.class, zzfvq);
    }

    public static zzfvq zzd(zzgcz zzgcz, zzgdo zzgdo) throws zzgeo {
        return (zzfvq) zzgec.zzaI(zzf, zzgcz, zzgdo);
    }

    public static zzfvp zze() {
        return (zzfvp) zzf.zzas();
    }

    public static /* synthetic */ void zzg(zzfvq zzfvq, zzfvw zzfvw) {
        zzfvw.getClass();
        zzfvq.zzb = zzfvw;
    }

    public static /* synthetic */ void zzh(zzfvq zzfvq, zzfyk zzfyk) {
        zzfyk.getClass();
        zzfvq.zze = zzfyk;
    }

    public final zzfvw zza() {
        zzfvw zzfvw = this.zzb;
        return zzfvw == null ? zzfvw.zzf() : zzfvw;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzfvq();
        } else {
            if (i2 == 4) {
                return new zzfvp((zzfvo) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }

    public final zzfyk zzc() {
        zzfyk zzfyk = this.zze;
        return zzfyk == null ? zzfyk.zzf() : zzfyk;
    }
}
