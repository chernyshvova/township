package com.google.android.gms.internal.ads;

import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfnk {
    public static <V> V zza(Map<?, V> map, @NullableDecl Object obj) {
        if (map != null) {
            try {
                return map.get(obj);
            } catch (ClassCastException | NullPointerException unused) {
                return null;
            }
        } else {
            throw null;
        }
    }
}
