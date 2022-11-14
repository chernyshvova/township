package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfvn extends zzgec<zzfvn, zzfvm> implements zzgfl {
    public static final zzfvn zzg;
    public int zzb;
    public zzfvt zze;
    public zzfyh zzf;

    static {
        zzfvn zzfvn = new zzfvn();
        zzg = zzfvn;
        zzgec.zzay(zzfvn.class, zzfvn);
    }

    public static zzfvn zze(zzgcz zzgcz, zzgdo zzgdo) throws zzgeo {
        return (zzfvn) zzgec.zzaI(zzg, zzgcz, zzgdo);
    }

    public static zzfvm zzf() {
        return (zzfvm) zzg.zzas();
    }

    public static /* synthetic */ void zzi(zzfvn zzfvn, zzfvt zzfvt) {
        zzfvt.getClass();
        zzfvn.zze = zzfvt;
    }

    public static /* synthetic */ void zzj(zzfvn zzfvn, zzfyh zzfyh) {
        zzfyh.getClass();
        zzfvn.zzf = zzfyh;
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
            return zzgec.zzaz(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzfvn();
        } else {
            if (i2 == 4) {
                return new zzfvm((zzfvl) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }

    public final zzfvt zzc() {
        zzfvt zzfvt = this.zze;
        return zzfvt == null ? zzfvt.zzg() : zzfvt;
    }

    public final zzfyh zzd() {
        zzfyh zzfyh = this.zzf;
        return zzfyh == null ? zzfyh.zzg() : zzfyh;
    }
}
