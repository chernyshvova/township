package com.google.android.gms.internal.ads;

import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzajr {
    public final SparseBooleanArray zza;

    public /* synthetic */ zzajr(SparseBooleanArray sparseBooleanArray, zzajp zzajp) {
        this.zza = sparseBooleanArray;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzajr)) {
            return false;
        }
        return this.zza.equals(((zzajr) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zza() {
        return this.zza.size();
    }

    public final int zzb(int i) {
        zzajg.zzc(i, 0, this.zza.size());
        return this.zza.keyAt(i);
    }
}
