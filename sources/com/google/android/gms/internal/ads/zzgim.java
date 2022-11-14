package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgim extends zzgec<zzgim, zzghk> implements zzgfl {
    public static final zzgim zzx;
    public int zzb;
    public int zze;
    public int zzf;
    public String zzg = "";
    public String zzh = "";
    public String zzi = "";
    public zzghm zzj;
    public zzgel<zzgij> zzk = zzgec.zzaE();
    public String zzl = "";
    public zzgib zzm;
    public boolean zzn;
    public zzgel<String> zzo = zzgec.zzaE();
    public String zzp = "";
    public boolean zzq;
    public boolean zzr;
    public zzgcz zzs = zzgcz.zzb;
    public zzgil zzt;
    public zzgel<String> zzu = zzgec.zzaE();
    public zzgel<String> zzv = zzgec.zzaE();
    public byte zzw = 2;

    static {
        zzgim zzgim = new zzgim();
        zzx = zzgim;
        zzgec.zzay(zzgim.class, zzgim);
    }

    public static zzghk zze() {
        return (zzghk) zzx.zzas();
    }

    public static /* synthetic */ void zzg(zzgim zzgim, zzgie zzgie) {
        zzgim.zze = zzgie.zza();
        zzgim.zzb |= 1;
    }

    public static /* synthetic */ void zzh(zzgim zzgim, String str) {
        str.getClass();
        zzgim.zzb |= 4;
        zzgim.zzg = str;
    }

    public static /* synthetic */ void zzi(zzgim zzgim, String str) {
        str.getClass();
        zzgim.zzb |= 8;
        zzgim.zzh = str;
    }

    public static /* synthetic */ void zzj(zzgim zzgim, zzghm zzghm) {
        zzghm.getClass();
        zzgim.zzj = zzghm;
        zzgim.zzb |= 32;
    }

    public static /* synthetic */ void zzk(zzgim zzgim, zzgij zzgij) {
        zzgij.getClass();
        zzgel<zzgij> zzgel = zzgim.zzk;
        if (!zzgel.zza()) {
            zzgim.zzk = zzgec.zzaF(zzgel);
        }
        zzgim.zzk.add(zzgij);
    }

    public static /* synthetic */ void zzl(zzgim zzgim, String str) {
        zzgim.zzb |= 64;
        zzgim.zzl = str;
    }

    public static /* synthetic */ void zzm(zzgim zzgim) {
        zzgim.zzb &= -65;
        zzgim.zzl = zzx.zzl;
    }

    public static /* synthetic */ void zzn(zzgim zzgim, zzgib zzgib) {
        zzgib.getClass();
        zzgim.zzm = zzgib;
        zzgim.zzb |= 128;
    }

    public static /* synthetic */ void zzo(zzgim zzgim, zzgil zzgil) {
        zzgil.getClass();
        zzgim.zzt = zzgil;
        zzgim.zzb |= 8192;
    }

    public static /* synthetic */ void zzp(zzgim zzgim, Iterable iterable) {
        zzgel<String> zzgel = zzgim.zzu;
        if (!zzgel.zza()) {
            zzgim.zzu = zzgec.zzaF(zzgel);
        }
        zzgcj.zzar(iterable, zzgim.zzu);
    }

    public static /* synthetic */ void zzq(zzgim zzgim, Iterable iterable) {
        zzgel<String> zzgel = zzgim.zzv;
        if (!zzgel.zza()) {
            zzgim.zzv = zzgec.zzaF(zzgel);
        }
        zzgcj.zzar(iterable, zzgim.zzv);
    }

    public final String zza() {
        return this.zzg;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzw);
        }
        byte b = 1;
        if (i2 == 2) {
            return zzgec.zzaz(zzx, "\u0001\u0012\u0000\u0001\u0001\u0015\u0012\u0000\u0004\u0001\u0001ဈ\u0002\u0002ဈ\u0003\u0003ဈ\u0004\u0004Л\u0005ဇ\b\u0006\u001a\u0007ဈ\t\bဇ\n\tဇ\u000b\nဌ\u0000\u000bဌ\u0001\fဉ\u0005\rဈ\u0006\u000eဉ\u0007\u000fည\f\u0011ဉ\r\u0014\u001a\u0015\u001a", new Object[]{"zzb", "zzg", "zzh", "zzi", "zzk", zzgij.class, "zzn", "zzo", "zzp", "zzq", "zzr", "zze", zzgie.zzc(), "zzf", zzghj.zzb(), "zzj", "zzl", "zzm", "zzs", "zzt", "zzu", "zzv"});
        } else if (i2 == 3) {
            return new zzgim();
        } else {
            if (i2 == 4) {
                return new zzghk((zzghg) null);
            }
            if (i2 == 5) {
                return zzx;
            }
            if (obj == null) {
                b = 0;
            }
            this.zzw = b;
            return null;
        }
    }

    public final List<zzgij> zzc() {
        return this.zzk;
    }

    public final String zzd() {
        return this.zzl;
    }
}
