package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgej<F, T> extends AbstractList<T> {
    public final List<F> zza;
    public final zzgei<F, T> zzb;

    public zzgej(List<F> list, zzgei<F, T> zzgei) {
        this.zza = list;
        this.zzb = zzgei;
    }

    public final T get(int i) {
        T zzb2 = zzazx.zzb(((Integer) this.zza.get(i)).intValue());
        return zzb2 == null ? zzazx.AD_FORMAT_TYPE_UNSPECIFIED : zzb2;
    }

    public final int size() {
        return this.zza.size();
    }
}
