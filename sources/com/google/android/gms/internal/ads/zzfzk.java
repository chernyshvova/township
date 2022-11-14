package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfzk extends zzgec<zzfzk, zzfzh> implements zzgfl {
    public static final zzfzk zzf;
    public int zzb;
    public zzgel<zzfzj> zze = zzgec.zzaE();

    static {
        zzfzk zzfzk = new zzfzk();
        zzf = zzfzk;
        zzgec.zzay(zzfzk.class, zzfzk);
    }

    public static zzfzh zza() {
        return (zzfzh) zzf.zzas();
    }

    public static /* synthetic */ void zze(zzfzk zzfzk, zzfzj zzfzj) {
        zzfzj.getClass();
        zzgel<zzfzj> zzgel = zzfzk.zze;
        if (!zzgel.zza()) {
            zzfzk.zze = zzgec.zzaF(zzgel);
        }
        zzfzk.zze.add(zzfzj);
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzb", "zze", zzfzj.class});
        } else if (i2 == 3) {
            return new zzfzk();
        } else {
            if (i2 == 4) {
                return new zzfzh((zzfzg) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
