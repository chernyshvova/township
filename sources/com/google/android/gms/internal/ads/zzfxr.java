package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfxr extends zzgec<zzfxr, zzfxq> implements zzgfl {
    public static final zzfxr zzg;
    public zzfya zzb;
    public zzfxl zze;
    public int zzf;

    static {
        zzfxr zzfxr = new zzfxr();
        zzg = zzfxr;
        zzgec.zzay(zzfxr.class, zzfxr);
    }

    public static zzfxq zze() {
        return (zzfxq) zzg.zzas();
    }

    public static zzfxr zzf() {
        return zzg;
    }

    public static /* synthetic */ void zzh(zzfxr zzfxr, zzfya zzfya) {
        zzfya.getClass();
        zzfxr.zzb = zzfya;
    }

    public static /* synthetic */ void zzi(zzfxr zzfxr, zzfxl zzfxl) {
        zzfxl.getClass();
        zzfxr.zze = zzfxl;
    }

    public final zzfya zza() {
        zzfya zzfya = this.zzb;
        return zzfya == null ? zzfya.zzf() : zzfya;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzfxr();
        } else {
            if (i2 == 4) {
                return new zzfxq((zzfxp) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }

    public final zzfxl zzc() {
        zzfxl zzfxl = this.zze;
        return zzfxl == null ? zzfxl.zzd() : zzfxl;
    }

    public final zzfxi zzd() {
        zzfxi zzb2 = zzfxi.zzb(this.zzf);
        return zzb2 == null ? zzfxi.UNRECOGNIZED : zzb2;
    }
}
