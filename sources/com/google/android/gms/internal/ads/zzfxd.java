package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfxd extends zzgec<zzfxd, zzfxc> implements zzgfl {
    public static final zzfxd zzf;
    public int zzb;
    public zzgcz zze = zzgcz.zzb;

    static {
        zzfxd zzfxd = new zzfxd();
        zzf = zzfxd;
        zzgec.zzay(zzfxd.class, zzfxd);
    }

    public static zzfxd zzd(zzgcz zzgcz, zzgdo zzgdo) throws zzgeo {
        return (zzfxd) zzgec.zzaI(zzf, zzgcz, zzgdo);
    }

    public static zzfxc zze() {
        return (zzfxc) zzf.zzas();
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
            return new zzfxd();
        } else {
            if (i2 == 4) {
                return new zzfxc((zzfxb) null);
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
