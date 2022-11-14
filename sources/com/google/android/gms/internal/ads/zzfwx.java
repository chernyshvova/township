package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfwx extends zzgec<zzfwx, zzfww> implements zzgfl {
    public static final zzfwx zzf;
    public int zzb;
    public zzgcz zze = zzgcz.zzb;

    static {
        zzfwx zzfwx = new zzfwx();
        zzf = zzfwx;
        zzgec.zzay(zzfwx.class, zzfwx);
    }

    public static zzfwx zzd(zzgcz zzgcz, zzgdo zzgdo) throws zzgeo {
        return (zzfwx) zzgec.zzaI(zzf, zzgcz, zzgdo);
    }

    public static zzfww zze() {
        return (zzfww) zzf.zzas();
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
            return zzgec.zzaz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzfwx();
        } else {
            if (i2 == 4) {
                return new zzfww((zzfwv) null);
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
