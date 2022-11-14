package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzghm extends zzgec<zzghm, zzghl> implements zzgfl {
    public static final zzghm zzf;
    public int zzb;
    public String zze = "";

    static {
        zzghm zzghm = new zzghm();
        zzf = zzghm;
        zzgec.zzay(zzghm.class, zzghm);
    }

    public static zzghl zza() {
        return (zzghl) zzf.zzas();
    }

    public static /* synthetic */ void zzd(zzghm zzghm, String str) {
        zzghm.zzb |= 1;
        zzghm.zze = str;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzf, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzghm();
        } else {
            if (i2 == 4) {
                return new zzghl((zzghg) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
