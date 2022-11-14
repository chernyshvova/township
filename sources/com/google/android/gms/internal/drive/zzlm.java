package com.google.android.gms.internal.drive;

import java.util.Iterator;
import java.util.Map;

public final class zzlm implements zzll {
    public final Object zzb(Object obj, Object obj2) {
        zzlk zzlk = (zzlk) obj;
        zzlk zzlk2 = (zzlk) obj2;
        if (!zzlk2.isEmpty()) {
            if (!zzlk.isMutable()) {
                zzlk = zzlk.zzdx();
            }
            zzlk.zza(zzlk2);
        }
        return zzlk;
    }

    public final Map<?, ?> zzh(Object obj) {
        return (zzlk) obj;
    }

    public final Map<?, ?> zzi(Object obj) {
        return (zzlk) obj;
    }

    public final boolean zzj(Object obj) {
        return !((zzlk) obj).isMutable();
    }

    public final Object zzk(Object obj) {
        ((zzlk) obj).zzbp();
        return obj;
    }

    public final Object zzl(Object obj) {
        return zzlk.zzdw().zzdx();
    }

    public final zzlj<?, ?> zzm(Object obj) {
        throw new NoSuchMethodError();
    }

    public final int zzb(int i, Object obj, Object obj2) {
        zzlk zzlk = (zzlk) obj;
        if (zzlk.isEmpty()) {
            return 0;
        }
        Iterator it = zzlk.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
