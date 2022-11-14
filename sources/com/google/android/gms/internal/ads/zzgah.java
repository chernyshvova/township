package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgah extends zzgec<zzgah, zzgag> implements zzgfl {
    public static final zzgah zze;
    public int zzb;

    static {
        zzgah zzgah = new zzgah();
        zze = zzgah;
        zzgec.zzay(zzgah.class, zzgah);
    }

    public static zzgah zza(zzgcz zzgcz, zzgdo zzgdo) throws zzgeo {
        return (zzgah) zzgec.zzaI(zze, zzgcz, zzgdo);
    }

    public static zzgah zzc() {
        return zze;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zze, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzb"});
        } else if (i2 == 3) {
            return new zzgah();
        } else {
            if (i2 == 4) {
                return new zzgag((zzgaf) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zze;
        }
    }
}
