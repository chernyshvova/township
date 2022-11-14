package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcz extends zzgec<zzcz, zzcy> implements zzgfl {
    public static final zzcz zzz;
    public int zzb;
    public long zze = -1;
    public long zzf = -1;
    public long zzg = -1;
    public long zzh = -1;
    public long zzi = -1;
    public long zzj = -1;
    public int zzk = 1000;
    public long zzl = -1;
    public long zzm = -1;
    public long zzn = -1;
    public int zzo = 1000;
    public long zzp = -1;
    public long zzq = -1;
    public long zzr = -1;
    public long zzs = -1;
    public long zzt;
    public long zzu;
    public long zzv = -1;
    public long zzw = -1;
    public long zzx = -1;
    public long zzy = -1;

    static {
        zzcz zzcz = new zzcz();
        zzz = zzcz;
        zzgec.zzay(zzcz.class, zzcz);
    }

    public static zzcy zza() {
        return (zzcy) zzz.zzas();
    }

    public static /* synthetic */ void zzd(zzcz zzcz, long j) {
        zzcz.zzb |= 1;
        zzcz.zze = j;
    }

    public static /* synthetic */ void zze(zzcz zzcz, long j) {
        zzcz.zzb |= 2;
        zzcz.zzf = j;
    }

    public static /* synthetic */ void zzf(zzcz zzcz, long j) {
        zzcz.zzb |= 4;
        zzcz.zzg = j;
    }

    public static /* synthetic */ void zzg(zzcz zzcz, long j) {
        zzcz.zzb |= 8;
        zzcz.zzh = j;
    }

    public static /* synthetic */ void zzh(zzcz zzcz) {
        zzcz.zzb &= -9;
        zzcz.zzh = -1;
    }

    public static /* synthetic */ void zzi(zzcz zzcz, long j) {
        zzcz.zzb |= 16;
        zzcz.zzi = j;
    }

    public static /* synthetic */ void zzj(zzcz zzcz, long j) {
        zzcz.zzb |= 32;
        zzcz.zzj = j;
    }

    public static /* synthetic */ void zzk(zzcz zzcz, zzdm zzdm) {
        zzcz.zzk = zzdm.zza();
        zzcz.zzb |= 64;
    }

    public static /* synthetic */ void zzl(zzcz zzcz, long j) {
        zzcz.zzb |= 128;
        zzcz.zzl = j;
    }

    public static /* synthetic */ void zzm(zzcz zzcz, long j) {
        zzcz.zzb |= 256;
        zzcz.zzm = j;
    }

    public static /* synthetic */ void zzn(zzcz zzcz, long j) {
        zzcz.zzb |= 512;
        zzcz.zzn = j;
    }

    public static /* synthetic */ void zzo(zzcz zzcz, zzdm zzdm) {
        zzcz.zzo = zzdm.zza();
        zzcz.zzb |= 1024;
    }

    public static /* synthetic */ void zzp(zzcz zzcz, long j) {
        zzcz.zzb |= 2048;
        zzcz.zzp = j;
    }

    public static /* synthetic */ void zzq(zzcz zzcz, long j) {
        zzcz.zzb |= 4096;
        zzcz.zzq = j;
    }

    public static /* synthetic */ void zzr(zzcz zzcz, long j) {
        zzcz.zzb |= 8192;
        zzcz.zzr = j;
    }

    public static /* synthetic */ void zzs(zzcz zzcz, long j) {
        zzcz.zzb |= 16384;
        zzcz.zzs = j;
    }

    public static /* synthetic */ void zzt(zzcz zzcz, long j) {
        zzcz.zzb |= 32768;
        zzcz.zzt = j;
    }

    public static /* synthetic */ void zzu(zzcz zzcz, long j) {
        zzcz.zzb |= 65536;
        zzcz.zzu = j;
    }

    public static /* synthetic */ void zzv(zzcz zzcz, long j) {
        zzcz.zzb |= 131072;
        zzcz.zzv = j;
    }

    public static /* synthetic */ void zzw(zzcz zzcz, long j) {
        zzcz.zzb |= 262144;
        zzcz.zzw = j;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzz, "\u0001\u0015\u0000\u0001\u0001\u0015\u0015\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဌ\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000bဌ\n\fဂ\u000b\rဂ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂ\u0014", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzdm.zzc(), "zzl", "zzm", "zzn", "zzo", zzdm.zzc(), "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy"});
        } else if (i2 == 3) {
            return new zzcz();
        } else {
            if (i2 == 4) {
                return new zzcy((zzcm) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzz;
        }
    }
}
