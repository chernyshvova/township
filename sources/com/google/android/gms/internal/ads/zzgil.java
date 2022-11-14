package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgil extends zzgec<zzgil, zzgik> implements zzgfl {
    public static final zzgil zzh;
    public int zzb;
    public String zze = "";
    public long zzf;
    public boolean zzg;

    static {
        zzgil zzgil = new zzgil();
        zzh = zzgil;
        zzgec.zzay(zzgil.class, zzgil);
    }

    public static zzgik zza() {
        return (zzgik) zzh.zzas();
    }

    public static /* synthetic */ void zzd(zzgil zzgil, String str) {
        zzgil.zzb |= 1;
        zzgil.zze = str;
    }

    public static /* synthetic */ void zze(zzgil zzgil, long j) {
        zzgil.zzb |= 2;
        zzgil.zzf = j;
    }

    public static /* synthetic */ void zzf(zzgil zzgil, boolean z) {
        zzgil.zzb |= 4;
        zzgil.zzg = z;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဇ\u0002", new Object[]{"zzb", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzgil();
        } else {
            if (i2 == 4) {
                return new zzgik((zzghg) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }
}
