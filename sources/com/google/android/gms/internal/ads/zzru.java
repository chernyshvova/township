package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzru {
    public static final zzru zza = new zzru(0, 0, 0);
    public static final zzif<zzru> zze = zzrt.zza;
    public final int zzb = 0;
    public final int zzc;
    public final int zzd;

    public zzru(int i, int i2, int i3) {
        this.zzc = i2;
        this.zzd = i3;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzru)) {
            return false;
        }
        zzru zzru = (zzru) obj;
        int i = zzru.zzb;
        return this.zzc == zzru.zzc && this.zzd == zzru.zzd;
    }

    public final int hashCode() {
        return ((this.zzc + 16337) * 31) + this.zzd;
    }
}
