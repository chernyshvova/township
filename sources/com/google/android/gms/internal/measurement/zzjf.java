package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzjf implements zzjc {
    public final Map<?, ?> zza(Object obj) {
        return (zzjd) obj;
    }

    public final Map<?, ?> zzb(Object obj) {
        return (zzjd) obj;
    }

    public final boolean zzc(Object obj) {
        return !((zzjd) obj).zzd();
    }

    public final Object zzd(Object obj) {
        ((zzjd) obj).zzc();
        return obj;
    }

    public final Object zze(Object obj) {
        return zzjd.zza().zzb();
    }

    public final zzja<?, ?> zzf(Object obj) {
        zzjb zzjb = (zzjb) obj;
        throw new NoSuchMethodError();
    }

    public final Object zza(Object obj, Object obj2) {
        zzjd zzjd = (zzjd) obj;
        zzjd zzjd2 = (zzjd) obj2;
        if (!zzjd2.isEmpty()) {
            if (!zzjd.zzd()) {
                zzjd = zzjd.zzb();
            }
            zzjd.zza(zzjd2);
        }
        return zzjd;
    }

    public final int zza(int i, Object obj, Object obj2) {
        zzjd zzjd = (zzjd) obj;
        zzjb zzjb = (zzjb) obj2;
        if (zzjd.isEmpty()) {
            return 0;
        }
        Iterator it = zzjd.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
