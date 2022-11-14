package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfxo extends zzgec<zzfxo, zzfxn> implements zzgfl {
    public static final zzfxo zze;
    public zzfxr zzb;

    static {
        zzfxo zzfxo = new zzfxo();
        zze = zzfxo;
        zzgec.zzay(zzfxo.class, zzfxo);
    }

    public static zzfxo zzc(zzgcz zzgcz, zzgdo zzgdo) throws zzgeo {
        return (zzfxo) zzgec.zzaI(zze, zzgcz, zzgdo);
    }

    public static zzfxn zzd() {
        return (zzfxn) zze.zzas();
    }

    public static /* synthetic */ void zzf(zzfxo zzfxo, zzfxr zzfxr) {
        zzfxr.getClass();
        zzfxo.zzb = zzfxr;
    }

    public final zzfxr zza() {
        zzfxr zzfxr = this.zzb;
        return zzfxr == null ? zzfxr.zzf() : zzfxr;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zze, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"zzb"});
        } else if (i2 == 3) {
            return new zzfxo();
        } else {
            if (i2 == 4) {
                return new zzfxn((zzfxm) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zze;
        }
    }
}
