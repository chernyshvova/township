package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzazj extends zzgec<zzazj, zzazi> implements zzgfl {
    public static final zzazj zzp;
    public int zzb;
    public int zze;
    public int zzf = 1000;
    public zzbab zzg;
    public zzbad zzh;
    public zzgel<zzazz> zzi = zzgec.zzaE();
    public zzbaf zzj;
    public zzbbr zzk;
    public zzbbh zzl;
    public zzbav zzm;
    public zzbax zzn;
    public zzgel<zzbcd> zzo = zzgec.zzaE();

    static {
        zzazj zzazj = new zzazj();
        zzp = zzazj;
        zzgec.zzay(zzazj.class, zzazj);
    }

    public static zzazj zzc() {
        return zzp;
    }

    public static /* synthetic */ void zze(zzazj zzazj, zzazh zzazh) {
        zzazj.zze = zzazh.zza();
        zzazj.zzb |= 1;
    }

    public static /* synthetic */ void zzf(zzazj zzazj, zzbad zzbad) {
        zzbad.getClass();
        zzazj.zzh = zzbad;
        zzazj.zzb |= 8;
    }

    public final zzbad zza() {
        zzbad zzbad = this.zzh;
        return zzbad == null ? zzbad.zza() : zzbad;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzp, "\u0001\u000b\u0000\u0001\u0007\u0011\u000b\u0000\u0002\u0000\u0007ဌ\u0000\bဌ\u0001\tဉ\u0002\nဉ\u0003\u000b\u001b\fဉ\u0004\rဉ\u0005\u000eဉ\u0006\u000fဉ\u0007\u0010ဉ\b\u0011\u001b", new Object[]{"zzb", "zze", zzazh.zzc(), "zzf", zzbap.zzc(), "zzg", "zzh", "zzi", zzazz.class, "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", zzbcd.class});
        } else if (i2 == 3) {
            return new zzazj();
        } else {
            if (i2 == 4) {
                return new zzazi((zzaze) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzp;
        }
    }
}
