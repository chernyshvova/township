package com.google.android.gms.internal.measurement;

import java.util.AbstractCollection;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzeu extends AbstractCollection<V> {
    public final /* synthetic */ zzem zza;

    public zzeu(zzem zzem) {
        this.zza = zzem;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final Iterator<V> iterator() {
        return this.zza.zzg();
    }

    public final int size() {
        return this.zza.size();
    }
}
