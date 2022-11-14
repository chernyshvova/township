package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbcb extends zzgec<zzbcb, zzbca> implements zzgfl {
    public static final zzbcb zzh;
    public int zzb;
    public int zze;
    public int zzf;
    public int zzg;

    static {
        zzbcb zzbcb = new zzbcb();
        zzh = zzbcb;
        zzgec.zzay(zzbcb.class, zzbcb);
    }

    public static zzbca zza() {
        return (zzbca) zzh.zzas();
    }

    public static /* synthetic */ void zzd(zzbcb zzbcb, int i) {
        zzbcb.zzb |= 1;
        zzbcb.zze = i;
    }

    public static /* synthetic */ void zze(zzbcb zzbcb, int i) {
        zzbcb.zzb |= 2;
        zzbcb.zzf = i;
    }

    public static /* synthetic */ void zzf(zzbcb zzbcb, int i) {
        zzbcb.zzb |= 4;
        zzbcb.zzg = i;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zzb", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzbcb();
        } else {
            if (i2 == 4) {
                return new zzbca((zzaze) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }
}
