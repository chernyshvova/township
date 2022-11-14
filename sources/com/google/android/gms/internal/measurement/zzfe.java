package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public class zzfe<K, V> extends zzek<K, V> implements Serializable {
    public final transient zzfc<K, ? extends zzey<V>> zza;
    public final transient int zzb;

    public zzfe(zzfc<K, ? extends zzey<V>> zzfc, int i) {
        this.zza = zzfc;
        this.zzb = i;
    }

    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public final boolean zza(@NullableDecl Object obj) {
        return obj != null && super.zza(obj);
    }

    public final Map<K, Collection<V>> zzb() {
        throw new AssertionError("should never be called");
    }

    public final /* synthetic */ Map zza() {
        return this.zza;
    }
}
