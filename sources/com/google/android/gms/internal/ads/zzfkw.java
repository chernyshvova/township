package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfkw implements Iterator {
    @NullableDecl
    public Map.Entry zza;
    public final /* synthetic */ Iterator zzb;
    public final /* synthetic */ zzfkx zzc;

    public zzfkw(zzfkx zzfkx, Iterator it) {
        this.zzc = zzfkx;
        this.zzb = it;
    }

    public final boolean hasNext() {
        return this.zzb.hasNext();
    }

    public final Object next() {
        Map.Entry entry = (Map.Entry) this.zzb.next();
        this.zza = entry;
        return entry.getKey();
    }

    public final void remove() {
        zzfke.zzb(this.zza != null, "no calls to next() since the last call to remove()");
        Collection collection = (Collection) this.zza.getValue();
        this.zzb.remove();
        zzflh.zzr(this.zzc.zza, collection.size());
        collection.clear();
        this.zza = null;
    }
}
