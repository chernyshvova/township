package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfhs extends zzgec<zzfhs, zzfho> implements zzgfl {
    public static final zzfhs zzi;
    public int zzb;
    public int zze;
    public String zzf = "";
    public String zzg = "";
    public zzfhm zzh;

    static {
        zzfhs zzfhs = new zzfhs();
        zzi = zzfhs;
        zzgec.zzay(zzfhs.class, zzfhs);
    }

    public static zzfho zza() {
        return (zzfho) zzi.zzas();
    }

    public static /* synthetic */ void zzd(zzfhs zzfhs, zzfhr zzfhr) {
        zzfhs.zze = zzfhr.zza();
        zzfhs.zzb |= 1;
    }

    public static /* synthetic */ void zze(zzfhs zzfhs, String str) {
        str.getClass();
        zzfhs.zzb |= 2;
        zzfhs.zzf = str;
    }

    public static /* synthetic */ void zzf(zzfhs zzfhs, zzfhm zzfhm) {
        zzfhm.getClass();
        zzfhs.zzh = zzfhm;
        zzfhs.zzb |= 8;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဉ\u0003", new Object[]{"zzb", "zze", zzfhr.zzc(), "zzf", "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzfhs();
        } else {
            if (i2 == 4) {
                return new zzfho((zzfhn) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzi;
        }
    }
}
