package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzawz {
    public final float zza;
    public final float zzb;
    public final float zzc;
    public final float zzd;
    public final int zze;

    @VisibleForTesting
    public zzawz(float f, float f2, float f3, float f4, int i) {
        this.zza = f;
        this.zzb = f2;
        this.zzc = f + f3;
        this.zzd = f2 + f4;
        this.zze = i;
    }

    public final float zza() {
        return this.zza;
    }

    public final float zzb() {
        return this.zzb;
    }

    public final float zzc() {
        return this.zzc;
    }

    public final float zzd() {
        return this.zzd;
    }

    public final int zze() {
        return this.zze;
    }
}
