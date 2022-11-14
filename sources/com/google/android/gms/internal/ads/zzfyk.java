package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfyk extends zzgec<zzfyk, zzfyj> implements zzgfl {
    public static final zzfyk zzg;
    public zzfyn zzb;
    public int zze;
    public int zzf;

    static {
        zzfyk zzfyk = new zzfyk();
        zzg = zzfyk;
        zzgec.zzay(zzfyk.class, zzfyk);
    }

    public static zzfyk zzd(zzgcz zzgcz, zzgdo zzgdo) throws zzgeo {
        return (zzfyk) zzgec.zzaI(zzg, zzgcz, zzgdo);
    }

    public static zzfyj zze() {
        return (zzfyj) zzg.zzas();
    }

    public static zzfyk zzf() {
        return zzg;
    }

    public static /* synthetic */ void zzh(zzfyk zzfyk, zzfyn zzfyn) {
        zzfyn.getClass();
        zzfyk.zzb = zzfyn;
    }

    public final zzfyn zza() {
        zzfyn zzfyn = this.zzb;
        return zzfyn == null ? zzfyn.zze() : zzfyn;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzfyk();
        } else {
            if (i2 == 4) {
                return new zzfyj((zzfyi) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }

    public final int zzc() {
        return this.zze;
    }
}
