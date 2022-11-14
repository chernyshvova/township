package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaeu {
    public final int zza;
    public final boolean zzb;

    public zzaeu(int i, boolean z) {
        this.zza = i;
        this.zzb = z;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaeu.class == obj.getClass()) {
            zzaeu zzaeu = (zzaeu) obj;
            return this.zza == zzaeu.zza && this.zzb == zzaeu.zzb;
        }
    }

    public final int hashCode() {
        return (this.zza * 31) + (this.zzb ? 1 : 0);
    }
}
