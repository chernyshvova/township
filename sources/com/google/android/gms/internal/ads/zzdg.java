package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdg extends zzgec<zzdg, zzdf> implements zzgfl {
    public static final zzdg zzi;
    public int zzb;
    public zzgcz zze;
    public zzgcz zzf;
    public zzgcz zzg;
    public zzgcz zzh;

    static {
        zzdg zzdg = new zzdg();
        zzi = zzdg;
        zzgec.zzay(zzdg.class, zzdg);
    }

    public zzdg() {
        zzgcz zzgcz = zzgcz.zzb;
        this.zze = zzgcz;
        this.zzf = zzgcz;
        this.zzg = zzgcz;
        this.zzh = zzgcz;
    }

    public static zzdg zzf(byte[] bArr, zzgdo zzgdo) throws zzgeo {
        return (zzdg) zzgec.zzaK(zzi, bArr, zzgdo);
    }

    public static zzdf zzg() {
        return (zzdf) zzi.zzas();
    }

    public static /* synthetic */ void zzi(zzdg zzdg, zzgcz zzgcz) {
        zzdg.zzb |= 1;
        zzdg.zze = zzgcz;
    }

    public static /* synthetic */ void zzj(zzdg zzdg, zzgcz zzgcz) {
        zzdg.zzb |= 2;
        zzdg.zzf = zzgcz;
    }

    public static /* synthetic */ void zzk(zzdg zzdg, zzgcz zzgcz) {
        zzdg.zzb |= 4;
        zzdg.zzg = zzgcz;
    }

    public static /* synthetic */ void zzl(zzdg zzdg, zzgcz zzgcz) {
        zzdg.zzb |= 8;
        zzdg.zzh = zzgcz;
    }

    public final zzgcz zza() {
        return this.zze;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzdg();
        } else {
            if (i2 == 4) {
                return new zzdf((zzcm) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzi;
        }
    }

    public final zzgcz zzc() {
        return this.zzf;
    }

    public final zzgcz zzd() {
        return this.zzg;
    }

    public final zzgcz zze() {
        return this.zzh;
    }
}
