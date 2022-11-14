package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfwc extends zzgec<zzfwc, zzfwb> implements zzgfl {
    public static final zzfwc zzg;
    public int zzb;
    public zzfwi zze;
    public zzgcz zzf = zzgcz.zzb;

    static {
        zzfwc zzfwc = new zzfwc();
        zzg = zzfwc;
        zzgec.zzay(zzfwc.class, zzfwc);
    }

    public static zzfwc zze(zzgcz zzgcz, zzgdo zzgdo) throws zzgeo {
        return (zzfwc) zzgec.zzaI(zzg, zzgcz, zzgdo);
    }

    public static zzfwb zzf() {
        return (zzfwb) zzg.zzas();
    }

    public static /* synthetic */ void zzi(zzfwc zzfwc, zzfwi zzfwi) {
        zzfwi.getClass();
        zzfwc.zze = zzfwi;
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
            return new zzfwc();
        } else {
            if (i2 == 4) {
                return new zzfwb((zzfwa) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }

    public final zzfwi zzc() {
        zzfwi zzfwi = this.zze;
        return zzfwi == null ? zzfwi.zzd() : zzfwi;
    }

    public final zzgcz zzd() {
        return this.zzf;
    }
}
