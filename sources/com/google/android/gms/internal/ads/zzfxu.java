package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfxu extends zzgec<zzfxu, zzfxt> implements zzgfl {
    public static final zzfxu zzg;
    public int zzb;
    public zzfxx zze;
    public zzgcz zzf = zzgcz.zzb;

    static {
        zzfxu zzfxu = new zzfxu();
        zzg = zzfxu;
        zzgec.zzay(zzfxu.class, zzfxu);
    }

    public static zzfxu zze(zzgcz zzgcz, zzgdo zzgdo) throws zzgeo {
        return (zzfxu) zzgec.zzaI(zzg, zzgcz, zzgdo);
    }

    public static zzfxt zzf() {
        return (zzfxt) zzg.zzas();
    }

    public static /* synthetic */ void zzi(zzfxu zzfxu, zzfxx zzfxx) {
        zzfxx.getClass();
        zzfxu.zze = zzfxx;
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
            return new zzfxu();
        } else {
            if (i2 == 4) {
                return new zzfxt((zzfxs) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }

    public final zzfxx zzc() {
        zzfxx zzfxx = this.zze;
        return zzfxx == null ? zzfxx.zzh() : zzfxx;
    }

    public final zzgcz zzd() {
        return this.zzf;
    }
}
