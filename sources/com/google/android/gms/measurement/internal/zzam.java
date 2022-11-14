package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzam {
    public final String zza;
    public final String zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;
    public final long zzf;
    public final long zzg;
    public final Long zzh;
    public final Long zzi;
    public final Long zzj;
    public final Boolean zzk;

    public zzam(String str, String str2, long j, long j2, long j3, long j4, long j5, Long l, Long l2, Long l3, Boolean bool) {
        long j6 = j;
        long j7 = j2;
        long j8 = j3;
        long j9 = j5;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        boolean z = true;
        Preconditions.checkArgument(j6 >= 0);
        Preconditions.checkArgument(j7 >= 0);
        Preconditions.checkArgument(j8 >= 0);
        Preconditions.checkArgument(j9 < 0 ? false : z);
        this.zza = str;
        this.zzb = str2;
        this.zzc = j6;
        this.zzd = j7;
        this.zze = j8;
        this.zzf = j4;
        this.zzg = j9;
        this.zzh = l;
        this.zzi = l2;
        this.zzj = l3;
        this.zzk = bool;
    }

    public final zzam zza(long j) {
        return new zzam(this.zza, this.zzb, this.zzc, this.zzd, this.zze, j, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk);
    }

    public final zzam zza(long j, long j2) {
        return new zzam(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, j, Long.valueOf(j2), this.zzi, this.zzj, this.zzk);
    }

    public final zzam zza(Long l, Long l2, Boolean bool) {
        return new zzam(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, l, l2, (bool == null || bool.booleanValue()) ? bool : null);
    }

    public zzam(String str, String str2, long j, long j2, long j3, long j4, Long l, Long l2, Long l3, Boolean bool) {
        this(str, str2, 0, 0, 0, j3, 0, (Long) null, (Long) null, (Long) null, (Boolean) null);
    }
}
