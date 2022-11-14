package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzmc {
    public static final zzmc zza = new zzmc(false);
    public final boolean zzb;

    public zzmc(boolean z) {
        this.zzb = z;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && zzmc.class == obj.getClass() && this.zzb == ((zzmc) obj).zzb;
    }

    public final int hashCode() {
        return this.zzb ? 0 : 1;
    }
}
