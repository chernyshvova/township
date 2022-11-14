package com.google.android.gms.internal.ads;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzamp {
    public static final zzamp zza = new zzamp(0, 0, 0, 1.0f);
    public static final zzif<zzamp> zzf = zzamo.zza;
    @IntRange(from = 0)
    public final int zzb;
    @IntRange(from = 0)
    public final int zzc;
    @IntRange(from = 0, mo281to = 359)
    public final int zzd;
    @FloatRange(from = 0.0d, fromInclusive = false)
    public final float zze;

    public zzamp(@IntRange(from = 0) int i, @IntRange(from = 0) int i2, @IntRange(from = 0, mo281to = 359) int i3, @FloatRange(from = 0.0d, fromInclusive = false) float f) {
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = f;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzamp) {
            zzamp zzamp = (zzamp) obj;
            return this.zzb == zzamp.zzb && this.zzc == zzamp.zzc && this.zzd == zzamp.zzd && this.zze == zzamp.zze;
        }
    }

    public final int hashCode() {
        return Float.floatToRawIntBits(this.zze) + ((((((this.zzb + 217) * 31) + this.zzc) * 31) + this.zzd) * 31);
    }
}
