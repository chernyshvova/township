package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfnd {
    public static <E> ArrayList<E> zza(int i) {
        zzflm.zzb(i, "initialArraySize");
        return new ArrayList<>(i);
    }

    public static <F, T> List<T> zzb(List<F> list, zzfju<? super F, ? extends T> zzfju) {
        return new zzfnc(list, zzfju);
    }
}
