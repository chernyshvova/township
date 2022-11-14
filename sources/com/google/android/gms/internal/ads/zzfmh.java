package com.google.android.gms.internal.ads;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfmh<K, V> extends zzfli<K, V> implements Serializable {
    @NullableDecl
    public final K zza;
    @NullableDecl
    public final V zzb;

    public zzfmh(@NullableDecl K k, @NullableDecl V v) {
        this.zza = k;
        this.zzb = v;
    }

    @NullableDecl
    public final K getKey() {
        return this.zza;
    }

    @NullableDecl
    public final V getValue() {
        return this.zzb;
    }

    public final V setValue(V v) {
        throw new UnsupportedOperationException();
    }
}
