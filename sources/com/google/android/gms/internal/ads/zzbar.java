package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbar extends zzgec<zzbar, zzbaq> implements zzgfl {
    public static final zzbar zzr;
    public int zzb;
    public int zze;
    public String zzf = "";
    public int zzg;
    public int zzh = 1000;
    public zzbcb zzi;
    public zzgek zzj = zzgec.zzaD();
    public zzbah zzk;
    public zzbam zzl;
    public zzbbf zzm;
    public zzazj zzn;
    public zzbbp zzo;
    public zzbcy zzp;
    public zzazu zzq;

    static {
        zzbar zzbar = new zzbar();
        zzr = zzbar;
        zzgec.zzay(zzbar.class, zzbar);
    }

    public static zzbaq zze() {
        return (zzbaq) zzr.zzas();
    }

    public static /* synthetic */ void zzg(zzbar zzbar, String str) {
        str.getClass();
        zzbar.zzb |= 2;
        zzbar.zzf = str;
    }

    public static /* synthetic */ void zzh(zzbar zzbar, Iterable iterable) {
        zzgek zzgek = zzbar.zzj;
        if (!zzgek.zza()) {
            int size = zzgek.size();
            zzbar.zzj = zzgek.zzc(size == 0 ? 10 : size + size);
        }
        zzgcj.zzar(iterable, zzbar.zzj);
    }

    public static /* synthetic */ void zzj(zzbar zzbar, zzbah zzbah) {
        zzbah.getClass();
        zzbar.zzk = zzbah;
        zzbar.zzb |= 32;
    }

    public static /* synthetic */ void zzk(zzbar zzbar, zzazj zzazj) {
        zzazj.getClass();
        zzbar.zzn = zzazj;
        zzbar.zzb |= 256;
    }

    public static /* synthetic */ void zzl(zzbar zzbar, zzbbp zzbbp) {
        zzbbp.getClass();
        zzbar.zzo = zzbbp;
        zzbar.zzb |= 512;
    }

    public static /* synthetic */ void zzm(zzbar zzbar, zzbcy zzbcy) {
        zzbcy.getClass();
        zzbar.zzp = zzbcy;
        zzbar.zzb |= 1024;
    }

    public static /* synthetic */ void zzn(zzbar zzbar, zzazu zzazu) {
        zzazu.getClass();
        zzbar.zzq = zzazu;
        zzbar.zzb |= 2048;
    }

    public final String zza() {
        return this.zzf;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzr, "\u0001\r\u0000\u0001\t\u0015\r\u0000\u0001\u0000\tင\u0000\nဈ\u0001\u000bဋ\u0002\fဌ\u0003\rဉ\u0004\u000e\u0015\u000fဉ\u0005\u0010ဉ\u0006\u0011ဉ\u0007\u0012ဉ\b\u0013ဉ\t\u0014ဉ\n\u0015ဉ\u000b", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", zzbap.zzc(), "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq"});
        } else if (i2 == 3) {
            return new zzbar();
        } else {
            if (i2 == 4) {
                return new zzbaq((zzaze) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzr;
        }
    }

    public final zzbah zzc() {
        zzbah zzbah = this.zzk;
        return zzbah == null ? zzbah.zza() : zzbah;
    }

    public final zzazj zzd() {
        zzazj zzazj = this.zzn;
        return zzazj == null ? zzazj.zzc() : zzazj;
    }
}
