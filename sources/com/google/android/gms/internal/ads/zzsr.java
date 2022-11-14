package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzsr {
    public static final zzsr zza = new zzsr(-3, -9223372036854775807L, -1);
    public final int zzb;
    public final long zzc;
    public final long zzd;

    public zzsr(int i, long j, long j2) {
        this.zzb = i;
        this.zzc = j;
        this.zzd = j2;
    }

    public static zzsr zza(long j, long j2) {
        return new zzsr(-1, j, j2);
    }

    public static zzsr zzb(long j, long j2) {
        return new zzsr(-2, j, j2);
    }

    public static zzsr zzc(long j) {
        return new zzsr(0, -9223372036854775807L, j);
    }
}
