package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfzj extends zzgec<zzfzj, zzfzi> implements zzgfl {
    public static final zzfzj zzh;
    public String zzb = "";
    public int zze;
    public int zzf;
    public int zzg;

    static {
        zzfzj zzfzj = new zzfzj();
        zzh = zzfzj;
        zzgec.zzay(zzfzj.class, zzfzj);
    }

    public static zzfzi zza() {
        return (zzfzi) zzh.zzas();
    }

    public static /* synthetic */ void zzd(zzfzj zzfzj, String str) {
        str.getClass();
        zzfzj.zzb = str;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzh, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzb", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzfzj();
        } else {
            if (i2 == 4) {
                return new zzfzi((zzfzg) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }
}
