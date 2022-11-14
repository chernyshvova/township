package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzflu extends AbstractCollection {
    public final /* synthetic */ zzflv zza;

    public zzflu(zzflv zzflv) {
        this.zza = zzflv;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final Iterator iterator() {
        zzflv zzflv = this.zza;
        Map zzc = zzflv.zzc();
        if (zzc != null) {
            return zzc.values().iterator();
        }
        return new zzflp(zzflv);
    }

    public final int size() {
        return this.zza.size();
    }
}
