package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfys extends zzgec<zzfys, zzfyp> implements zzgfl {
    public static final zzfys zzg;
    public String zzb = "";
    public zzgcz zze = zzgcz.zzb;
    public int zzf;

    static {
        zzfys zzfys = new zzfys();
        zzg = zzfys;
        zzgec.zzay(zzfys.class, zzfys);
    }

    public static zzfyp zze() {
        return (zzfyp) zzg.zzas();
    }

    public static zzfys zzf() {
        return zzg;
    }

    public final String zza() {
        return this.zzb;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzfys();
        } else {
            if (i2 == 4) {
                return new zzfyp((zzfyo) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }

    public final zzgcz zzc() {
        return this.zze;
    }

    public final zzfyr zzd() {
        zzfyr zzb2 = zzfyr.zzb(this.zzf);
        return zzb2 == null ? zzfyr.UNRECOGNIZED : zzb2;
    }
}
