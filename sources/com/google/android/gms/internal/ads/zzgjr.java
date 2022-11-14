package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgjr<T> {
    public final List<zzgju<T>> zza;
    public final List<zzgju<Collection<T>>> zzb;

    public /* synthetic */ zzgjr(int i, int i2, zzgjq zzgjq) {
        this.zza = zzgjd.zza(i);
        this.zzb = zzgjd.zza(i2);
    }

    public final zzgjr<T> zza(zzgju<? extends T> zzgju) {
        this.zza.add(zzgju);
        return this;
    }

    public final zzgjr<T> zzb(zzgju<? extends Collection<? extends T>> zzgju) {
        this.zzb.add(zzgju);
        return this;
    }

    public final zzgjs<T> zzc() {
        return new zzgjs<>(this.zza, this.zzb, (zzgjq) null);
    }
}
