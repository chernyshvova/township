package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdr extends zzgec<zzdr, zzdq> implements zzgfl {
    public static final zzdr zzh;
    public int zzb;
    public long zze;
    public String zzf = "";
    public zzgcz zzg = zzgcz.zzb;

    static {
        zzdr zzdr = new zzdr();
        zzh = zzdr;
        zzgec.zzay(zzdr.class, zzdr);
    }

    public static zzdr zzd() {
        return zzh;
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzh, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0003ဈ\u0001\u0004ည\u0002", new Object[]{"zzb", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzdr();
        } else {
            if (i2 == 4) {
                return new zzdq((zzcm) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }

    public final long zzc() {
        return this.zze;
    }
}
