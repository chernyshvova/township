package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbbp extends zzgec<zzbbp, zzbbl> implements zzgfl {
    public static final zzbbp zzl;
    public int zzb;
    public zzgel<zzbbk> zze = zzgec.zzaE();
    public int zzf;
    public int zzg;
    public long zzh;
    public String zzi = "";
    public String zzj = "";
    public long zzk;

    static {
        zzbbp zzbbp = new zzbbp();
        zzl = zzbbp;
        zzgec.zzay(zzbbp.class, zzbbp);
    }

    public static zzbbl zza() {
        return (zzbbl) zzl.zzas();
    }

    public static /* synthetic */ void zzd(zzbbp zzbbp, Iterable iterable) {
        zzgel<zzbbk> zzgel = zzbbp.zze;
        if (!zzgel.zza()) {
            zzbbp.zze = zzgec.zzaF(zzgel);
        }
        zzgcj.zzar(iterable, zzbbp.zze);
    }

    public static /* synthetic */ void zze(zzbbp zzbbp, int i) {
        zzbbp.zzb |= 1;
        zzbbp.zzf = i;
    }

    public static /* synthetic */ void zzf(zzbbp zzbbp, int i) {
        zzbbp.zzb |= 2;
        zzbbp.zzg = i;
    }

    public static /* synthetic */ void zzg(zzbbp zzbbp, long j) {
        zzbbp.zzb |= 4;
        zzbbp.zzh = j;
    }

    public static /* synthetic */ void zzh(zzbbp zzbbp, String str) {
        str.getClass();
        zzbbp.zzb |= 8;
        zzbbp.zzi = str;
    }

    public static /* synthetic */ void zzi(zzbbp zzbbp, String str) {
        str.getClass();
        zzbbp.zzb |= 16;
        zzbbp.zzj = str;
    }

    public static /* synthetic */ void zzj(zzbbp zzbbp, long j) {
        zzbbp.zzb |= 32;
        zzbbp.zzk = j;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzl, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001\u001b\u0002င\u0000\u0003င\u0001\u0004ဂ\u0002\u0005ဈ\u0003\u0006ဈ\u0004\u0007ဂ\u0005", new Object[]{"zzb", "zze", zzbbk.class, "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        } else if (i2 == 3) {
            return new zzbbp();
        } else {
            if (i2 == 4) {
                return new zzbbl((zzaze) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzl;
        }
    }
}
