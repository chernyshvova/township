package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcb extends zzgec<zzcb, zzbv> implements zzgfl {
    public static final zzcb zzr;
    public int zzb;
    public String zze = "";
    public long zzf;
    public String zzg = "";
    public String zzh = "";
    public String zzi = "";
    public long zzj;
    public long zzk;
    public String zzl = "";
    public long zzm;
    public String zzn = "";
    public String zzo = "";
    public zzgel<zzbx> zzp = zzgec.zzaE();
    public int zzq;

    static {
        zzcb zzcb = new zzcb();
        zzr = zzcb;
        zzgec.zzay(zzcb.class, zzcb);
    }

    public static zzbv zza() {
        return (zzbv) zzr.zzas();
    }

    public static /* synthetic */ void zzd(zzcb zzcb, String str) {
        str.getClass();
        zzcb.zzb |= 1;
        zzcb.zze = str;
    }

    public static /* synthetic */ void zze(zzcb zzcb, long j) {
        zzcb.zzb |= 2;
        zzcb.zzf = j;
    }

    public static /* synthetic */ void zzf(zzcb zzcb, String str) {
        str.getClass();
        zzcb.zzb |= 4;
        zzcb.zzg = str;
    }

    public static /* synthetic */ void zzg(zzcb zzcb, String str) {
        str.getClass();
        zzcb.zzb |= 8;
        zzcb.zzh = str;
    }

    public static /* synthetic */ void zzh(zzcb zzcb, String str) {
        zzcb.zzb |= 16;
        zzcb.zzi = str;
    }

    public static /* synthetic */ void zzi(zzcb zzcb, String str) {
        zzcb.zzb |= 1024;
        zzcb.zzo = str;
    }

    public static /* synthetic */ void zzj(zzcb zzcb, zzca zzca) {
        zzcb.zzq = zzca.zza();
        zzcb.zzb |= 2048;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzr, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဈ\u0007\tဂ\b\nဈ\t\u000bဈ\n\f\u001b\rဌ\u000b", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", zzbx.class, "zzq", zzca.zzc()});
        } else if (i2 == 3) {
            return new zzcb();
        } else {
            if (i2 == 4) {
                return new zzbv((zzbu) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzr;
        }
    }
}
