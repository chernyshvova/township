package com.google.android.gms.internal.ads;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzlj {
    public static final zzadv zzt = new zzadv(new Object());
    public final zzmv zza;
    public final zzadv zzb;
    public final long zzc;
    public final long zzd;
    public final int zze;
    @Nullable
    public final zzio zzf;
    public final boolean zzg;
    public final zzaft zzh;
    public final zzahd zzi;
    public final List<zzabe> zzj;
    public final zzadv zzk;
    public final boolean zzl;
    public final int zzm;
    public final zzll zzn;
    public final boolean zzo;
    public final boolean zzp;
    public volatile long zzq;
    public volatile long zzr;
    public volatile long zzs;

    public zzlj(zzmv zzmv, zzadv zzadv, long j, long j2, int i, @Nullable zzio zzio, boolean z, zzaft zzaft, zzahd zzahd, List<zzabe> list, zzadv zzadv2, boolean z2, int i2, zzll zzll, long j3, long j4, long j5, boolean z3, boolean z4) {
        this.zza = zzmv;
        this.zzb = zzadv;
        this.zzc = j;
        this.zzd = j2;
        this.zze = i;
        this.zzf = zzio;
        this.zzg = z;
        this.zzh = zzaft;
        this.zzi = zzahd;
        this.zzj = list;
        this.zzk = zzadv2;
        this.zzl = z2;
        this.zzm = i2;
        this.zzn = zzll;
        this.zzq = j3;
        this.zzr = j4;
        this.zzs = j5;
        this.zzo = z3;
        this.zzp = z4;
    }

    public static zzlj zza(zzahd zzahd) {
        return new zzlj(zzmv.zza, zzt, -9223372036854775807L, 0, 1, (zzio) null, false, zzaft.zza, zzahd, zzfml.zzi(), zzt, false, 0, zzll.zza, 0, 0, 0, false, false);
    }

    public static zzadv zzb() {
        return zzt;
    }

    @CheckResult
    public final zzlj zzc(zzadv zzadv, long j, long j2, long j3, long j4, zzaft zzaft, zzahd zzahd, List<zzabe> list) {
        long j5 = j;
        zzaft zzaft2 = zzaft;
        zzahd zzahd2 = zzahd;
        List<zzabe> list2 = list;
        zzmv zzmv = this.zza;
        return new zzlj(zzmv, zzadv, j2, j3, this.zze, this.zzf, this.zzg, zzaft2, zzahd2, list2, this.zzk, this.zzl, this.zzm, this.zzn, this.zzq, j4, j5, this.zzo, this.zzp);
    }

    @CheckResult
    public final zzlj zzd(zzmv zzmv) {
        return new zzlj(zzmv, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzq, this.zzr, this.zzs, this.zzo, this.zzp);
    }

    @CheckResult
    public final zzlj zze(int i) {
        zzmv zzmv = this.zza;
        return new zzlj(zzmv, this.zzb, this.zzc, this.zzd, i, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzq, this.zzr, this.zzs, this.zzo, this.zzp);
    }

    @CheckResult
    public final zzlj zzf(@Nullable zzio zzio) {
        zzmv zzmv = this.zza;
        return new zzlj(zzmv, this.zzb, this.zzc, this.zzd, this.zze, zzio, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzq, this.zzr, this.zzs, this.zzo, this.zzp);
    }

    @CheckResult
    public final zzlj zzg(zzadv zzadv) {
        zzmv zzmv = this.zza;
        return new zzlj(zzmv, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, zzadv, this.zzl, this.zzm, this.zzn, this.zzq, this.zzr, this.zzs, this.zzo, this.zzp);
    }

    @CheckResult
    public final zzlj zzh(boolean z, int i) {
        zzmv zzmv = this.zza;
        return new zzlj(zzmv, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, z, i, this.zzn, this.zzq, this.zzr, this.zzs, this.zzo, this.zzp);
    }

    @CheckResult
    public final zzlj zzi(boolean z) {
        zzmv zzmv = this.zza;
        return new zzlj(zzmv, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzq, this.zzr, this.zzs, z, this.zzp);
    }
}
