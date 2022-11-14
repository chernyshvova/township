package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbad extends zzgec<zzbad, zzbac> implements zzgfl {
    public static final zzbad zzj;
    public int zzb;
    public String zze = "";
    public zzgel<zzazz> zzf = zzgec.zzaE();
    public int zzg = 1000;
    public int zzh = 1000;
    public int zzi = 1000;

    static {
        zzbad zzbad = new zzbad();
        zzj = zzbad;
        zzgec.zzay(zzbad.class, zzbad);
    }

    public static zzbad zza() {
        return zzj;
    }

    public static /* synthetic */ void zzd(zzbad zzbad, String str) {
        str.getClass();
        zzbad.zzb |= 1;
        zzbad.zze = str;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဌ\u0001\u0004ဌ\u0002\u0005ဌ\u0003", new Object[]{"zzb", "zze", "zzf", zzazz.class, "zzg", zzbap.zzc(), "zzh", zzbap.zzc(), "zzi", zzbap.zzc()});
        } else if (i2 == 3) {
            return new zzbad();
        } else {
            if (i2 == 4) {
                return new zzbac((zzaze) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzj;
        }
    }
}
