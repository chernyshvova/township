package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfze extends zzgec<zzfze, zzfzd> implements zzgfl {
    public static final zzfze zzh;
    public zzfys zzb;
    public int zze;
    public int zzf;
    public int zzg;

    static {
        zzfze zzfze = new zzfze();
        zzh = zzfze;
        zzgec.zzay(zzfze.class, zzfze);
    }

    public final boolean zza() {
        return this.zzb != null;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzh, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzb", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzfze();
        } else {
            if (i2 == 4) {
                return new zzfzd((zzfzb) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }

    public final zzfys zzc() {
        zzfys zzfys = this.zzb;
        return zzfys == null ? zzfys.zzf() : zzfys;
    }

    public final zzfyu zzd() {
        zzfyu zzb2 = zzfyu.zzb(this.zze);
        return zzb2 == null ? zzfyu.UNRECOGNIZED : zzb2;
    }

    public final int zze() {
        return this.zzf;
    }

    public final zzfzy zzf() {
        zzfzy zzb2 = zzfzy.zzb(this.zzg);
        return zzb2 == null ? zzfzy.UNRECOGNIZED : zzb2;
    }
}
