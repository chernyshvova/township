package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfvh extends zzgec<zzfvh, zzfvg> implements zzgfl {
    public static final zzfvh zzf;
    public int zzb;
    public zzfvk zze;

    static {
        zzfvh zzfvh = new zzfvh();
        zzf = zzfvh;
        zzgec.zzay(zzfvh.class, zzfvh);
    }

    public static zzfvh zzd(zzgcz zzgcz, zzgdo zzgdo) throws zzgeo {
        return (zzfvh) zzgec.zzaI(zzf, zzgcz, zzgdo);
    }

    public static zzfvg zze() {
        return (zzfvg) zzf.zzas();
    }

    public static /* synthetic */ void zzh(zzfvh zzfvh, zzfvk zzfvk) {
        zzfvk.getClass();
        zzfvh.zze = zzfvk;
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
            return new zzfvh();
        } else {
            if (i2 == 4) {
                return new zzfvg((zzfvf) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }

    public final zzfvk zzc() {
        zzfvk zzfvk = this.zze;
        return zzfvk == null ? zzfvk.zzd() : zzfvk;
    }
}
