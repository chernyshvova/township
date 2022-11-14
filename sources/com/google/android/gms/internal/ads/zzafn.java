package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzafn extends zzmv {
    public static final Object zzc = new Object();
    public static final zzkq zzd;
    public final long zze;
    public final long zzf;
    public final boolean zzg;
    @Nullable
    public final zzkq zzh;
    @Nullable
    public final zzko zzi;

    static {
        zzkj zzkj = new zzkj();
        zzkj.zza("SinglePeriodTimeline");
        zzkj.zzb(Uri.EMPTY);
        zzd = zzkj.zzc();
    }

    public zzafn(long j, long j2, long j3, long j4, long j5, long j6, long j7, boolean z, boolean z2, @Nullable Object obj, zzkq zzkq, @Nullable zzko zzko) {
        this.zze = j4;
        this.zzf = j5;
        this.zzg = z;
        this.zzh = zzkq;
        this.zzi = zzko;
    }

    public final zzmu zze(int i, zzmu zzmu, long j) {
        zzajg.zzc(i, 0, 1);
        zzmu.zza(zzmu.zza, this.zzh, (Object) null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, this.zzg, false, this.zzi, 0, this.zzf, 0, 0, 0);
        return zzmu;
    }

    public final zzms zzg(int i, zzms zzms, boolean z) {
        zzajg.zzc(i, 0, 1);
        zzms.zza((Object) null, z ? zzc : null, 0, this.zze, 0, zzafy.zza, false);
        return zzms;
    }

    public final int zzh(Object obj) {
        return zzc.equals(obj) ? 0 : -1;
    }

    public final Object zzi(int i) {
        zzajg.zzc(i, 0, 1);
        return zzc;
    }

    public final int zzr() {
        return 1;
    }

    public final int zzs() {
        return 1;
    }
}
