package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbbf extends zzgec<zzbbf, zzbay> implements zzgfl {
    public static final zzbbf zzg;
    public int zzb;
    public int zze;
    public int zzf;

    static {
        zzbbf zzbbf = new zzbbf();
        zzg = zzbbf;
        zzgec.zzay(zzbbf.class, zzbbf);
    }

    public static zzbay zzf() {
        return (zzbay) zzg.zzas();
    }

    public static zzbbf zzg() {
        return zzg;
    }

    public static /* synthetic */ void zzi(zzbbf zzbbf, zzbbe zzbbe) {
        zzbbf.zze = zzbbe.zza();
        zzbbf.zzb |= 1;
    }

    public static /* synthetic */ void zzj(zzbbf zzbbf, zzbbb zzbbb) {
        zzbbf.zzf = zzbbb.zza();
        zzbbf.zzb |= 2;
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
            return zzgec.zzaz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001", new Object[]{"zzb", "zze", zzbbe.zzc(), "zzf", zzbbb.zzc()});
        } else if (i2 == 3) {
            return new zzbbf();
        } else {
            if (i2 == 4) {
                return new zzbay((zzaze) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }

    public final zzbbe zzc() {
        zzbbe zzb2 = zzbbe.zzb(this.zze);
        return zzb2 == null ? zzbbe.NETWORKTYPE_UNSPECIFIED : zzb2;
    }

    public final boolean zzd() {
        return (this.zzb & 2) != 0;
    }

    public final zzbbb zze() {
        zzbbb zzb2 = zzbbb.zzb(this.zzf);
        return zzb2 == null ? zzbbb.CELLULAR_NETWORK_TYPE_UNSPECIFIED : zzb2;
    }
}
