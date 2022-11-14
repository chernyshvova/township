package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzazl extends zzgec<zzazl, zzazk> implements zzgfl {
    public static final zzazl zzh;
    public int zzb;
    public int zze;
    public zzazr zzf;
    public zzazt zzg;

    static {
        zzazl zzazl = new zzazl();
        zzh = zzazl;
        zzgec.zzay(zzazl.class, zzazl);
    }

    public static zzazk zza() {
        return (zzazk) zzh.zzas();
    }

    public static /* synthetic */ void zzd(zzazl zzazl, zzazp zzazp) {
        zzazl.zze = zzazp.zza();
        zzazl.zzb |= 1;
    }

    public static /* synthetic */ void zze(zzazl zzazl, zzazr zzazr) {
        zzazr.getClass();
        zzazl.zzf = zzazr;
        zzazl.zzb |= 2;
    }

    public static /* synthetic */ void zzf(zzazl zzazl, zzazt zzazt) {
        zzazt.getClass();
        zzazl.zzg = zzazt;
        zzazl.zzb |= 4;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzb", "zze", zzazp.zzc(), "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzazl();
        } else {
            if (i2 == 4) {
                return new zzazk((zzaze) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }
}
