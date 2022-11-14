package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzazr extends zzgec<zzazr, zzazq> implements zzgfl {
    public static final zzazr zzg;
    public int zzb;
    public boolean zze;
    public int zzf;

    static {
        zzazr zzazr = new zzazr();
        zzg = zzazr;
        zzgec.zzay(zzazr.class, zzazr);
    }

    public static zzazq zza() {
        return (zzazq) zzg.zzas();
    }

    public static /* synthetic */ void zzd(zzazr zzazr, boolean z) {
        zzazr.zzb |= 1;
        zzazr.zze = z;
    }

    public static /* synthetic */ void zze(zzazr zzazr, int i) {
        zzazr.zzb |= 2;
        zzazr.zzf = i;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဋ\u0001", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzazr();
        } else {
            if (i2 == 4) {
                return new zzazq((zzaze) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
