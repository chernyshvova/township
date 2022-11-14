package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbah extends zzgec<zzbah, zzbag> implements zzgfl {
    public static final zzbah zzm;
    public int zzb;
    public String zze = "";
    public zzbbz zzf;
    public int zzg;
    public zzbcb zzh;
    public int zzi;
    public int zzj = 1000;
    public int zzk = 1000;
    public int zzl = 1000;

    static {
        zzbah zzbah = new zzbah();
        zzm = zzbah;
        zzgec.zzay(zzbah.class, zzbah);
    }

    public static zzbah zza() {
        return zzm;
    }

    public static /* synthetic */ void zzd(zzbah zzbah, String str) {
        zzbah.zzb |= 1;
        zzbah.zze = str;
    }

    public static /* synthetic */ void zze(zzbah zzbah, zzbcb zzbcb) {
        zzbcb.getClass();
        zzbah.zzh = zzbcb;
        zzbah.zzb |= 8;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzm, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဉ\u0001\u0003င\u0002\u0004ဉ\u0003\u0005င\u0004\u0006ဌ\u0005\u0007ဌ\u0006\bဌ\u0007", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzbap.zzc(), "zzk", zzbap.zzc(), "zzl", zzbap.zzc()});
        } else if (i2 == 3) {
            return new zzbah();
        } else {
            if (i2 == 4) {
                return new zzbag((zzaze) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzm;
        }
    }
}
