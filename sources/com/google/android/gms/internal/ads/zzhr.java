package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzhr extends zzgec<zzhr, zzhq> implements zzgfl {
    public static final zzhr zzj;
    public int zzb;
    public String zze = "";
    public String zzf = "";
    public long zzg;
    public long zzh;
    public long zzi;

    static {
        zzhr zzhr = new zzhr();
        zzj = zzhr;
        zzgec.zzay(zzhr.class, zzhr);
    }

    public static zzhr zzg(zzgcz zzgcz) throws zzgeo {
        return (zzhr) zzgec.zzaH(zzj, zzgcz);
    }

    public static zzhr zzh(zzgcz zzgcz, zzgdo zzgdo) throws zzgeo {
        return (zzhr) zzgec.zzaI(zzj, zzgcz, zzgdo);
    }

    public static zzhq zzi() {
        return (zzhq) zzj.zzas();
    }

    public static zzhr zzj() {
        return zzj;
    }

    public static /* synthetic */ void zzl(zzhr zzhr, String str) {
        str.getClass();
        zzhr.zzb |= 1;
        zzhr.zze = str;
    }

    public static /* synthetic */ void zzm(zzhr zzhr, String str) {
        str.getClass();
        zzhr.zzb |= 2;
        zzhr.zzf = str;
    }

    public static /* synthetic */ void zzn(zzhr zzhr, long j) {
        zzhr.zzb |= 4;
        zzhr.zzg = j;
    }

    public static /* synthetic */ void zzo(zzhr zzhr, long j) {
        zzhr.zzb |= 8;
        zzhr.zzh = j;
    }

    public static /* synthetic */ void zzp(zzhr zzhr, long j) {
        zzhr.zzb |= 16;
        zzhr.zzi = j;
    }

    public final String zza() {
        return this.zze;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi"});
        } else if (i2 == 3) {
            return new zzhr();
        } else {
            if (i2 == 4) {
                return new zzhq((zzhp) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzj;
        }
    }

    public final String zzc() {
        return this.zzf;
    }

    public final long zzd() {
        return this.zzg;
    }

    public final long zze() {
        return this.zzh;
    }

    public final long zzf() {
        return this.zzi;
    }
}
