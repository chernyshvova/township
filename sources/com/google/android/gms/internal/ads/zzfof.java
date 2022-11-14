package com.google.android.gms.internal.ads;

import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfof extends zzfnx<Comparable> implements Serializable {
    public static final zzfof zza = new zzfof();

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        if (comparable == null) {
            throw null;
        } else if (comparable == comparable2) {
            return 0;
        } else {
            return comparable2.compareTo(comparable);
        }
    }

    public final String toString() {
        return "Ordering.natural().reverse()";
    }

    public final <S extends Comparable> zzfnx<S> zza() {
        return zzfnv.zza;
    }
}
