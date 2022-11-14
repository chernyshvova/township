package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzazu extends zzgec<zzazu, zzazm> implements zzgfl {
    public static final zzazu zze;
    public zzgel<zzazl> zzb = zzgec.zzaE();

    static {
        zzazu zzazu = new zzazu();
        zze = zzazu;
        zzgec.zzay(zzazu.class, zzazu);
    }

    public static zzazm zza() {
        return (zzazm) zze.zzas();
    }

    public static /* synthetic */ void zzd(zzazu zzazu, zzazl zzazl) {
        zzazl.getClass();
        zzgel<zzazl> zzgel = zzazu.zzb;
        if (!zzgel.zza()) {
            zzazu.zzb = zzgec.zzaF(zzgel);
        }
        zzazu.zzb.add(zzazl);
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzb", zzazl.class});
        } else if (i2 == 3) {
            return new zzazu();
        } else {
            if (i2 == 4) {
                return new zzazm((zzaze) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zze;
        }
    }
}
