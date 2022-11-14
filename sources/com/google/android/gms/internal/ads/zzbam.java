package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbam extends zzgec<zzbam, zzbai> implements zzgfl {
    public static final zzbam zzi;
    public int zzb;
    public int zze;
    public zzbcb zzf;
    public String zzg = "";
    public String zzh = "";

    static {
        zzbam zzbam = new zzbam();
        zzi = zzbam;
        zzgec.zzay(zzbam.class, zzbam);
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzi, "\u0001\u0004\u0000\u0001\u0005\b\u0004\u0000\u0000\u0000\u0005ဌ\u0000\u0006ဉ\u0001\u0007ဈ\u0002\bဈ\u0003", new Object[]{"zzb", "zze", zzbal.zzb(), "zzf", "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzbam();
        } else {
            if (i2 == 4) {
                return new zzbai((zzaze) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzi;
        }
    }
}
