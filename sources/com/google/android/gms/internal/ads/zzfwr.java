package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfwr extends zzgec<zzfwr, zzfwq> implements zzgfl {
    public static final zzfwr zzf;
    public int zzb;
    public zzgcz zze = zzgcz.zzb;

    static {
        zzfwr zzfwr = new zzfwr();
        zzf = zzfwr;
        zzgec.zzay(zzfwr.class, zzfwr);
    }

    public static zzfwr zzd(zzgcz zzgcz, zzgdo zzgdo) throws zzgeo {
        return (zzfwr) zzgec.zzaI(zzf, zzgcz, zzgdo);
    }

    public static zzfwq zze() {
        return (zzfwq) zzf.zzas();
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
            return zzgec.zzaz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzfwr();
        } else {
            if (i2 == 4) {
                return new zzfwq((zzfwp) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }

    public final zzgcz zzc() {
        return this.zze;
    }
}
