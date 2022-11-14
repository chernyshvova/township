package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzai<T> {
    @Nullable
    public final T zza;
    @Nullable
    public final zzl zzb;
    @Nullable
    public final zzal zzc;
    public boolean zzd;

    public zzai(zzal zzal) {
        this.zzd = false;
        this.zza = null;
        this.zzb = null;
        this.zzc = zzal;
    }

    public zzai(@Nullable T t, @Nullable zzl zzl) {
        this.zzd = false;
        this.zza = t;
        this.zzb = zzl;
        this.zzc = null;
    }

    public static <T> zzai<T> zza(@Nullable T t, @Nullable zzl zzl) {
        return new zzai<>(t, zzl);
    }

    public static <T> zzai<T> zzb(zzal zzal) {
        return new zzai<>(zzal);
    }

    public final boolean zzc() {
        return this.zzc == null;
    }
}
