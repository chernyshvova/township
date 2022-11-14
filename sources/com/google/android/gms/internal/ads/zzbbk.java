package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbbk extends zzgec<zzbbk, zzbbj> implements zzgfl {
    public static final zzgei<Integer, zzazx> zzj = new zzbbi();
    public static final zzbbk zzr;
    public int zzb;
    public long zze;
    public int zzf;
    public long zzg;
    public long zzh;
    public zzgeh zzi = zzgec.zzaB();
    public zzbbf zzk;
    public int zzl;
    public int zzm;
    public int zzn;
    public int zzo;
    public int zzp;
    public int zzq;

    static {
        zzbbk zzbbk = new zzbbk();
        zzr = zzbbk;
        zzgec.zzay(zzbbk.class, zzbbk);
    }

    public static /* synthetic */ void zzA(zzbbk zzbbk, zzbap zzbap) {
        zzbbk.zzp = zzbap.zza();
        zzbbk.zzb |= 512;
    }

    public static /* synthetic */ void zzB(zzbbk zzbbk, zzbbo zzbbo) {
        zzbbk.zzq = zzbbo.zza();
        zzbbk.zzb |= 1024;
    }

    public static zzbbk zzn(byte[] bArr) throws zzgeo {
        return (zzbbk) zzgec.zzaJ(zzr, bArr);
    }

    public static zzbbj zzo() {
        return (zzbbj) zzr.zzas();
    }

    public static /* synthetic */ void zzq(zzbbk zzbbk, long j) {
        zzbbk.zzb |= 1;
        zzbbk.zze = j;
    }

    public static /* synthetic */ void zzr(zzbbk zzbbk, zzbap zzbap) {
        zzbbk.zzf = zzbap.zza();
        zzbbk.zzb |= 2;
    }

    public static /* synthetic */ void zzs(zzbbk zzbbk, long j) {
        zzbbk.zzb |= 4;
        zzbbk.zzg = j;
    }

    public static /* synthetic */ void zzt(zzbbk zzbbk, long j) {
        zzbbk.zzb |= 8;
        zzbbk.zzh = j;
    }

    public static /* synthetic */ void zzu(zzbbk zzbbk, Iterable iterable) {
        zzgeh zzgeh = zzbbk.zzi;
        if (!zzgeh.zza()) {
            zzbbk.zzi = zzgec.zzaC(zzgeh);
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            zzbbk.zzi.zzh(((zzazx) it.next()).zza());
        }
    }

    public static /* synthetic */ void zzv(zzbbk zzbbk, zzbbf zzbbf) {
        zzbbf.getClass();
        zzbbk.zzk = zzbbf;
        zzbbk.zzb |= 16;
    }

    public static /* synthetic */ void zzw(zzbbk zzbbk, zzbap zzbap) {
        zzbbk.zzl = zzbap.zza();
        zzbbk.zzb |= 32;
    }

    public static /* synthetic */ void zzx(zzbbk zzbbk, zzbap zzbap) {
        zzbbk.zzm = zzbap.zza();
        zzbbk.zzb |= 64;
    }

    public static /* synthetic */ void zzy(zzbbk zzbbk, zzbap zzbap) {
        zzbbk.zzn = zzbap.zza();
        zzbbk.zzb |= 128;
    }

    public static /* synthetic */ void zzz(zzbbk zzbbk, int i) {
        zzbbk.zzb |= 256;
        zzbbk.zzo = i;
    }

    public final long zza() {
        return this.zze;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzr, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0001\u0000\u0001ဂ\u0000\u0002ဌ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005\u001e\u0006ဉ\u0004\u0007ဌ\u0005\bဌ\u0006\tဌ\u0007\nင\b\u000bဌ\t\fဌ\n", new Object[]{"zzb", "zze", "zzf", zzbap.zzc(), "zzg", "zzh", "zzi", zzazx.zzc(), "zzk", "zzl", zzbap.zzc(), "zzm", zzbap.zzc(), "zzn", zzbap.zzc(), "zzo", "zzp", zzbap.zzc(), "zzq", zzbbo.zzc()});
        } else if (i2 == 3) {
            return new zzbbk();
        } else {
            if (i2 == 4) {
                return new zzbbj((zzaze) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzr;
        }
    }

    public final zzbap zzc() {
        zzbap zzb2 = zzbap.zzb(this.zzf);
        return zzb2 == null ? zzbap.ENUM_FALSE : zzb2;
    }

    public final long zzd() {
        return this.zzg;
    }

    public final long zze() {
        return this.zzh;
    }

    public final List<zzazx> zzf() {
        return new zzgej(this.zzi, zzj);
    }

    public final zzbbf zzg() {
        zzbbf zzbbf = this.zzk;
        return zzbbf == null ? zzbbf.zzg() : zzbbf;
    }

    public final zzbap zzh() {
        zzbap zzb2 = zzbap.zzb(this.zzl);
        return zzb2 == null ? zzbap.ENUM_FALSE : zzb2;
    }

    public final zzbap zzi() {
        zzbap zzb2 = zzbap.zzb(this.zzm);
        return zzb2 == null ? zzbap.ENUM_FALSE : zzb2;
    }

    public final zzbap zzj() {
        zzbap zzb2 = zzbap.zzb(this.zzn);
        return zzb2 == null ? zzbap.ENUM_FALSE : zzb2;
    }

    public final int zzk() {
        return this.zzo;
    }

    public final zzbap zzl() {
        zzbap zzb2 = zzbap.zzb(this.zzp);
        return zzb2 == null ? zzbap.ENUM_FALSE : zzb2;
    }

    public final zzbbo zzm() {
        zzbbo zzb2 = zzbbo.zzb(this.zzq);
        return zzb2 == null ? zzbbo.UNSPECIFIED : zzb2;
    }
}
