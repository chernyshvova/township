package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdv extends zzgec<zzdv, zzdu> implements zzgfl {
    public static final zzdv zzi;
    public int zzb;
    public zzgel<zzgcz> zze = zzgec.zzaE();
    public zzgcz zzf = zzgcz.zzb;
    public int zzg = 1;
    public int zzh = 1;

    static {
        zzdv zzdv = new zzdv();
        zzi = zzdv;
        zzgec.zzay(zzdv.class, zzdv);
    }

    public static zzdu zza() {
        return (zzdu) zzi.zzas();
    }

    public static /* synthetic */ void zzd(zzdv zzdv, zzgcz zzgcz) {
        zzgel<zzgcz> zzgel = zzdv.zze;
        if (!zzgel.zza()) {
            zzdv.zze = zzgec.zzaF(zzgel);
        }
        zzdv.zze.add(zzgcz);
    }

    public static /* synthetic */ void zze(zzdv zzdv, zzgcz zzgcz) {
        zzdv.zzb |= 1;
        zzdv.zzf = zzgcz;
    }

    public static /* synthetic */ void zzf(zzdv zzdv, zzdj zzdj) {
        zzdv.zzh = zzdj.zza();
        zzdv.zzb |= 4;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002ည\u0000\u0003ဌ\u0001\u0004ဌ\u0002", new Object[]{"zzb", "zze", "zzf", "zzg", zzdp.zzb(), "zzh", zzdj.zzc()});
        } else if (i2 == 3) {
            return new zzdv();
        } else {
            if (i2 == 4) {
                return new zzdu((zzcm) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzi;
        }
    }
}
