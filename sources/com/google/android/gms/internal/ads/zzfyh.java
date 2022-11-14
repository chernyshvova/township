package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfyh extends zzgec<zzfyh, zzfyg> implements zzgfl {
    public static final zzfyh zzg;
    public int zzb;
    public zzfyn zze;
    public zzgcz zzf = zzgcz.zzb;

    static {
        zzfyh zzfyh = new zzfyh();
        zzg = zzfyh;
        zzgec.zzay(zzfyh.class, zzfyh);
    }

    public static zzfyh zze(zzgcz zzgcz, zzgdo zzgdo) throws zzgeo {
        return (zzfyh) zzgec.zzaI(zzg, zzgcz, zzgdo);
    }

    public static zzfyg zzf() {
        return (zzfyg) zzg.zzas();
    }

    public static zzfyh zzg() {
        return zzg;
    }

    public static /* synthetic */ void zzj(zzfyh zzfyh, zzfyn zzfyn) {
        zzfyn.getClass();
        zzfyh.zze = zzfyn;
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
            return new zzfyh();
        } else {
            if (i2 == 4) {
                return new zzfyg((zzfyf) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }

    public final zzfyn zzc() {
        zzfyn zzfyn = this.zze;
        return zzfyn == null ? zzfyn.zze() : zzfyn;
    }

    public final zzgcz zzd() {
        return this.zzf;
    }
}
