package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaet implements zzafj {
    public final /* synthetic */ zzaew zza;
    public final int zzb;

    public zzaet(zzaew zzaew, int i) {
        this.zza = zzaew;
        this.zzb = i;
    }

    public final boolean zzb() {
        return this.zza.zzp(this.zzb);
    }

    public final void zzc() throws IOException {
        this.zza.zzr(this.zzb);
    }

    public final int zzd(zzkd zzkd, zzrr zzrr, int i) {
        return this.zza.zzt(this.zzb, zzkd, zzrr, i);
    }

    public final int zze(long j) {
        return this.zza.zzu(this.zzb, j);
    }
}
