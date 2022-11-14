package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfnc<F, T> extends AbstractSequentialList<T> implements Serializable {
    public final List<F> zza;
    public final zzfju<? super F, ? extends T> zzb;

    public zzfnc(List<F> list, zzfju<? super F, ? extends T> zzfju) {
        this.zza = list;
        this.zzb = zzfju;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final ListIterator<T> listIterator(int i) {
        return new zzfnb(this, this.zza.listIterator(i));
    }

    public final int size() {
        return this.zza.size();
    }
}
