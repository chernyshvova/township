package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzs;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbju {
    public static boolean zza(@Nullable zzbkc zzbkc, @Nullable zzbjz zzbjz, String... strArr) {
        if (zzbjz == null) {
            return false;
        }
        zzbkc.zzb(zzbjz, zzs.zzj().elapsedRealtime(), strArr);
        return true;
    }
}
