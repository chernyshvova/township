package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfks extends zzfng {
    public final /* synthetic */ zzfku zza;

    public zzfks(zzfku zzfku) {
        this.zza = zzfku;
    }

    public final boolean contains(Object obj) {
        Set entrySet = this.zza.zza.entrySet();
        if (entrySet != null) {
            try {
                return entrySet.contains(obj);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        } else {
            throw null;
        }
    }

    public final Iterator<Map.Entry> iterator() {
        return new zzfkt(this.zza);
    }

    public final boolean remove(Object obj) {
        if (!contains(obj)) {
            return false;
        }
        zzflh.zzs(this.zza.zzb, ((Map.Entry) obj).getKey());
        return true;
    }

    public final Map zza() {
        return this.zza;
    }
}
