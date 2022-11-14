package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaxh {
    public final long zza;
    public final String zzb;
    public final int zzc;

    public zzaxh(long j, String str, int i) {
        this.zza = j;
        this.zzb = str;
        this.zzc = i;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj != null && (obj instanceof zzaxh)) {
            zzaxh zzaxh = (zzaxh) obj;
            if (zzaxh.zza == this.zza && zzaxh.zzc == this.zzc) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return (int) this.zza;
    }
}
