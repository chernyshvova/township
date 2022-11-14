package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfmz {
    @NullableDecl
    public static <T> T zza(Iterator<T> it) {
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        it.remove();
        return next;
    }

    public static void zzb(Iterator<?> it) {
        if (it != null) {
            while (it.hasNext()) {
                it.next();
                it.remove();
            }
            return;
        }
        throw null;
    }
}
