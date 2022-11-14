package com.google.android.gms.internal.measurement;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzes extends AbstractSet<K> {
    public final /* synthetic */ zzem zza;

    public zzes(zzem zzem) {
        this.zza = zzem;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(Object obj) {
        return this.zza.containsKey(obj);
    }

    public final Iterator<K> iterator() {
        return this.zza.zze();
    }

    public final boolean remove(@NullableDecl Object obj) {
        Map zzb = this.zza.zzb();
        if (zzb != null) {
            return zzb.keySet().remove(obj);
        }
        return this.zza.zzb(obj) != zzem.zzd;
    }

    public final int size() {
        return this.zza.size();
    }
}
