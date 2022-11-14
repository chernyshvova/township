package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzlr {
    public final zzajr zza;

    public zzlr(zzajr zzajr) {
        this.zza = zzajr;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzlr)) {
            return false;
        }
        return this.zza.equals(((zzlr) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }
}
