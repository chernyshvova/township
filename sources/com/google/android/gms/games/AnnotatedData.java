package com.google.android.gms.games;

import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNullable;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public class AnnotatedData<T> {
    @Nullable
    public final T zza;
    public final boolean zzb;

    public AnnotatedData(@Nullable T t, boolean z) {
        this.zza = t;
        this.zzb = z;
    }

    @RecentlyNullable
    public T get() {
        return this.zza;
    }

    public boolean isStale() {
        return this.zzb;
    }
}
