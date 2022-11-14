package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgae extends zzgec<zzgae, zzgad> implements zzgfl {
    public static final zzgae zzf;
    public int zzb;
    public zzgcz zze = zzgcz.zzb;

    static {
        zzgae zzgae = new zzgae();
        zzf = zzgae;
        zzgec.zzay(zzgae.class, zzgae);
    }

    public static zzgae zzd(zzgcz zzgcz, zzgdo zzgdo) throws zzgeo {
        return (zzgae) zzgec.zzaI(zzf, zzgcz, zzgdo);
    }

    public static zzgad zze() {
        return (zzgad) zzf.zzas();
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
            return new zzgae();
        } else {
            if (i2 == 4) {
                return new zzgad((zzgac) null);
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
