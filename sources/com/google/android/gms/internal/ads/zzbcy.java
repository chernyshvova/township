package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbcy extends zzgec<zzbcy, zzbcx> implements zzgfl {
    public static final zzbcy zzg;
    public int zzb;
    public boolean zze;
    public int zzf;

    static {
        zzbcy zzbcy = new zzbcy();
        zzg = zzbcy;
        zzgec.zzay(zzbcy.class, zzbcy);
    }

    public static zzbcx zzc() {
        return (zzbcx) zzg.zzas();
    }

    public static /* synthetic */ void zze(zzbcy zzbcy, boolean z) {
        zzbcy.zzb |= 1;
        zzbcy.zze = z;
    }

    public static /* synthetic */ void zzf(zzbcy zzbcy, int i) {
        zzbcy.zzb |= 2;
        zzbcy.zzf = i;
    }

    public final boolean zza() {
        return this.zze;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002င\u0001", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzbcy();
        } else {
            if (i2 == 4) {
                return new zzbcx((zzaze) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
