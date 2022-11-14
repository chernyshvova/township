package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdb extends zzgec<zzdb, zzda> implements zzgfl {
    public static final zzdb zzk;
    public int zzb;
    public long zze = -1;
    public long zzf = -1;
    public long zzg = -1;
    public long zzh = -1;
    public long zzi = -1;
    public long zzj = -1;

    static {
        zzdb zzdb = new zzdb();
        zzk = zzdb;
        zzgec.zzay(zzdb.class, zzdb);
    }

    public static zzda zza() {
        return (zzda) zzk.zzas();
    }

    public static /* synthetic */ void zzd(zzdb zzdb, long j) {
        zzdb.zzb |= 4;
        zzdb.zzg = j;
    }

    public static /* synthetic */ void zze(zzdb zzdb, long j) {
        zzdb.zzb |= 8;
        zzdb.zzh = j;
    }

    public static /* synthetic */ void zzf(zzdb zzdb, long j) {
        zzdb.zzb |= 16;
        zzdb.zzi = j;
    }

    public static /* synthetic */ void zzg(zzdb zzdb, long j) {
        zzdb.zzb |= 32;
        zzdb.zzj = j;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgec.zzaz(zzk, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        } else if (i2 == 3) {
            return new zzdb();
        } else {
            if (i2 == 4) {
                return new zzda((zzcm) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzk;
        }
    }
}
