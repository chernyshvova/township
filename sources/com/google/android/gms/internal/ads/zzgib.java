package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgib extends zzgec<zzgib, zzghx> implements zzgfl {
    public static final zzgib zzh;
    public int zzb;
    public int zze;
    public String zzf = "";
    public zzgcz zzg = zzgcz.zzb;

    static {
        zzgib zzgib = new zzgib();
        zzh = zzgib;
        zzgec.zzay(zzgib.class, zzgib);
    }

    public static zzghx zza() {
        return (zzghx) zzh.zzas();
    }

    public static /* synthetic */ void zzd(zzgib zzgib, zzgia zzgia) {
        zzgib.zze = zzgia.zza();
        zzgib.zzb |= 1;
    }

    public static /* synthetic */ void zze(zzgib zzgib, String str) {
        zzgib.zzb |= 2;
        zzgib.zzf = "image/png";
    }

    public static /* synthetic */ void zzf(zzgib zzgib, zzgcz zzgcz) {
        zzgcz.getClass();
        zzgib.zzb |= 4;
        zzgib.zzg = zzgcz;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ည\u0002", new Object[]{"zzb", "zze", zzgia.zzc(), "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzgib();
        } else {
            if (i2 == 4) {
                return new zzghx((zzghg) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }
}
