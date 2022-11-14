package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@Deprecated
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbjz {
    public final long zza;
    @Nullable
    public final String zzb;
    @Nullable
    public final zzbjz zzc;

    public zzbjz(long j, @Nullable String str, @Nullable zzbjz zzbjz) {
        this.zza = j;
        this.zzb = str;
        this.zzc = zzbjz;
    }

    public final long zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }

    @Nullable
    public final zzbjz zzc() {
        return this.zzc;
    }
}
