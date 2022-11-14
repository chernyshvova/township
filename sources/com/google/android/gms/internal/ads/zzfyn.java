package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfyn extends zzgec<zzfyn, zzfym> implements zzgfl {
    public static final zzfyn zzf;
    public int zzb;
    public int zze;

    static {
        zzfyn zzfyn = new zzfyn();
        zzf = zzfyn;
        zzgec.zzay(zzfyn.class, zzfyn);
    }

    public static zzfym zzd() {
        return (zzfym) zzf.zzas();
    }

    public static zzfyn zze() {
        return zzf;
    }

    public final zzfye zza() {
        zzfye zzb2 = zzfye.zzb(this.zzb);
        return zzb2 == null ? zzfye.UNRECOGNIZED : zzb2;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzfyn();
        } else {
            if (i2 == 4) {
                return new zzfym((zzfyl) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }

    public final int zzc() {
        return this.zze;
    }
}
