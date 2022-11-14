package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzfmt<K, V> extends zzfll<K, V> implements Serializable {
    public final transient zzfmp<K, ? extends zzfmg<V>> zzb;
    public final transient int zzc;

    public zzfmt(zzfmp<K, ? extends zzfmg<V>> zzfmp, int i) {
        this.zzb = zzfmp;
        this.zzc = i;
    }

    public final int zzd() {
        throw null;
    }

    @Deprecated
    public final boolean zze(K k, V v) {
        throw null;
    }

    @Deprecated
    public final void zzf() {
        throw null;
    }

    public final Set<K> zzh() {
        throw new AssertionError("unreachable");
    }

    public final /* bridge */ /* synthetic */ Collection zzj() {
        return new zzfms(this);
    }

    public final Map<K, Collection<V>> zzl() {
        throw new AssertionError("should never be called");
    }

    public final boolean zzt(@NullableDecl Object obj) {
        return obj != null && super.zzt(obj);
    }

    public final /* bridge */ /* synthetic */ Collection zzv() {
        throw null;
    }

    public final /* bridge */ /* synthetic */ Map zzw() {
        return this.zzb;
    }
}
