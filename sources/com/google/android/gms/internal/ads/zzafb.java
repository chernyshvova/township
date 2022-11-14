package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzafb {
    public final long zza;
    public final long zzb;
    public boolean zzc;
    @Nullable
    public zzahe zzd;
    @Nullable
    public zzafb zze;

    public zzafb(long j, int i) {
        this.zza = j;
        this.zzb = j + 65536;
    }

    public final int zza(long j) {
        long j2 = this.zza;
        int i = this.zzd.zzb;
        return (int) (j - j2);
    }

    public final zzafb zzb() {
        this.zzd = null;
        zzafb zzafb = this.zze;
        this.zze = null;
        return zzafb;
    }
}
