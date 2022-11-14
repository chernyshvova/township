package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzazt extends zzgec<zzazt, zzazs> implements zzgfl {
    public static final zzazt zzh;
    public int zzb;
    public boolean zze;
    public boolean zzf;
    public int zzg;

    static {
        zzazt zzazt = new zzazt();
        zzh = zzazt;
        zzgec.zzay(zzazt.class, zzazt);
    }

    public static zzazs zza() {
        return (zzazs) zzh.zzas();
    }

    public static /* synthetic */ void zzd(zzazt zzazt, boolean z) {
        zzazt.zzb |= 1;
        zzazt.zze = z;
    }

    public static /* synthetic */ void zze(zzazt zzazt, boolean z) {
        zzazt.zzb |= 2;
        zzazt.zzf = z;
    }

    public static /* synthetic */ void zzf(zzazt zzazt, int i) {
        zzazt.zzb |= 4;
        zzazt.zzg = i;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဋ\u0002", new Object[]{"zzb", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzazt();
        } else {
            if (i2 == 4) {
                return new zzazs((zzaze) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }
}
