package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfvk extends zzgec<zzfvk, zzfvj> implements zzgfl {
    public static final zzfvk zze;
    public int zzb;

    static {
        zzfvk zzfvk = new zzfvk();
        zze = zzfvk;
        zzgec.zzay(zzfvk.class, zzfvk);
    }

    public static zzfvj zzc() {
        return (zzfvj) zze.zzas();
    }

    public static zzfvk zzd() {
        return zze;
    }

    public final int zza() {
        return this.zzb;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zze, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzb"});
        } else if (i2 == 3) {
            return new zzfvk();
        } else {
            if (i2 == 4) {
                return new zzfvj((zzfvi) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zze;
        }
    }
}
