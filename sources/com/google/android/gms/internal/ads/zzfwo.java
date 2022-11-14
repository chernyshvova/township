package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfwo extends zzgec<zzfwo, zzfwn> implements zzgfl {
    public static final zzfwo zzf;
    public int zzb;
    public int zze;

    static {
        zzfwo zzfwo = new zzfwo();
        zzf = zzfwo;
        zzgec.zzay(zzfwo.class, zzfwo);
    }

    public static zzfwo zzc(zzgcz zzgcz, zzgdo zzgdo) throws zzgeo {
        return (zzfwo) zzgec.zzaI(zzf, zzgcz, zzgdo);
    }

    public static zzfwn zzd() {
        return (zzfwn) zzf.zzas();
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
            return zzgec.zzaz(zzf, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzfwo();
        } else {
            if (i2 == 4) {
                return new zzfwn((zzfwm) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
