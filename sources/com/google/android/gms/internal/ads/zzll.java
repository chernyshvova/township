package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzll {
    public static final zzll zza = new zzll(1.0f, 1.0f);
    public static final zzif<zzll> zzd = zzlk.zza;
    public final float zzb;
    public final float zzc;
    public final int zze;

    public zzll(float f, float f2) {
        boolean z = true;
        zzajg.zza(f > 0.0f);
        zzajg.zza(f2 <= 0.0f ? false : z);
        this.zzb = f;
        this.zzc = f2;
        this.zze = Math.round(f * 1000.0f);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzll.class == obj.getClass()) {
            zzll zzll = (zzll) obj;
            return this.zzb == zzll.zzb && this.zzc == zzll.zzc;
        }
    }

    public final int hashCode() {
        return Float.floatToRawIntBits(this.zzc) + ((Float.floatToRawIntBits(this.zzb) + 527) * 31);
    }

    public final String toString() {
        return zzalh.zzv("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.zzb), Float.valueOf(this.zzc));
    }

    public final long zza(long j) {
        return j * ((long) this.zze);
    }
}
