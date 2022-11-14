package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzko {
    public static final zzko zza = new zzko(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, -3.4028235E38f, -3.4028235E38f);
    public static final zzif<zzko> zzg = zzkn.zza;
    public final long zzb = -9223372036854775807L;
    public final long zzc = -9223372036854775807L;
    public final long zzd = -9223372036854775807L;
    public final float zze = -3.4028235E38f;
    public final float zzf = -3.4028235E38f;

    public zzko(long j, long j2, long j3, float f, float f2) {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzko)) {
            return false;
        }
        long j = ((zzko) obj).zzb;
        return true;
    }

    public final int hashCode() {
        int i = (int) -9223372034707292159L;
        int floatToIntBits = Float.floatToIntBits(-3.4028235E38f);
        return Float.floatToIntBits(-3.4028235E38f) + ((floatToIntBits + (((((i * 31) + i) * 31) + i) * 31)) * 31);
    }
}
