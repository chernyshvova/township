package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgff {
    public static final int zza(int i, Object obj, Object obj2) {
        zzgfe zzgfe = (zzgfe) obj;
        zzgfd zzgfd = (zzgfd) obj2;
        if (zzgfe.isEmpty()) {
            return 0;
        }
        Iterator it = zzgfe.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }

    public static final boolean zzb(Object obj) {
        return !((zzgfe) obj).zze();
    }

    public static final Object zzc(Object obj, Object obj2) {
        zzgfe zzgfe = (zzgfe) obj;
        zzgfe zzgfe2 = (zzgfe) obj2;
        if (!zzgfe2.isEmpty()) {
            if (!zzgfe.zze()) {
                zzgfe = zzgfe.zzc();
            }
            zzgfe.zzb(zzgfe2);
        }
        return zzgfe;
    }
}
