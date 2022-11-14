package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfob<K> extends zzfmv<K> {
    public final transient zzfmp<K, ?> zza;
    public final transient zzfml<K> zzb;

    public zzfob(zzfmp<K, ?> zzfmp, zzfml<K> zzfml) {
        this.zza = zzfmp;
        this.zzb = zzfml;
    }

    public final boolean contains(@NullableDecl Object obj) {
        return this.zza.get(obj) != null;
    }

    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    public final int size() {
        return this.zza.size();
    }

    public final zzfom<K> zza() {
        return this.zzb.listIterator(0);
    }

    public final zzfml<K> zze() {
        return this.zzb;
    }

    public final boolean zzf() {
        throw null;
    }

    public final int zzg(Object[] objArr, int i) {
        return this.zzb.zzg(objArr, i);
    }
}
