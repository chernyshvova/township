package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaei implements zzafj {
    public final zzafj zza;
    public final long zzb;

    public zzaei(zzafj zzafj, long j) {
        this.zza = zzafj;
        this.zzb = j;
    }

    public final zzafj zza() {
        return this.zza;
    }

    public final boolean zzb() {
        return this.zza.zzb();
    }

    public final void zzc() throws IOException {
        this.zza.zzc();
    }

    public final int zzd(zzkd zzkd, zzrr zzrr, int i) {
        int zzd = this.zza.zzd(zzkd, zzrr, i);
        if (zzd != -4) {
            return zzd;
        }
        zzrr.zzd = Math.max(0, zzrr.zzd + this.zzb);
        return -4;
    }

    public final int zze(long j) {
        return this.zza.zze(j - this.zzb);
    }
}
