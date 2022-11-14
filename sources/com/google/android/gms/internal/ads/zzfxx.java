package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfxx extends zzgec<zzfxx, zzfxw> implements zzgfl {
    public static final zzfxx zzh;
    public int zzb;
    public zzfxr zze;
    public zzgcz zzf;
    public zzgcz zzg;

    static {
        zzfxx zzfxx = new zzfxx();
        zzh = zzfxx;
        zzgec.zzay(zzfxx.class, zzfxx);
    }

    public zzfxx() {
        zzgcz zzgcz = zzgcz.zzb;
        this.zzf = zzgcz;
        this.zzg = zzgcz;
    }

    public static zzfxx zzf(zzgcz zzgcz, zzgdo zzgdo) throws zzgeo {
        return (zzfxx) zzgec.zzaI(zzh, zzgcz, zzgdo);
    }

    public static zzfxw zzg() {
        return (zzfxw) zzh.zzas();
    }

    public static zzfxx zzh() {
        return zzh;
    }

    public static /* synthetic */ void zzk(zzfxx zzfxx, zzfxr zzfxr) {
        zzfxr.getClass();
        zzfxx.zze = zzfxr;
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
            return zzgec.zzaz(zzh, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"zzb", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzfxx();
        } else {
            if (i2 == 4) {
                return new zzfxw((zzfxv) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }

    public final zzfxr zzc() {
        zzfxr zzfxr = this.zze;
        return zzfxr == null ? zzfxr.zzf() : zzfxr;
    }

    public final zzgcz zzd() {
        return this.zzf;
    }

    public final zzgcz zze() {
        return this.zzg;
    }
}
