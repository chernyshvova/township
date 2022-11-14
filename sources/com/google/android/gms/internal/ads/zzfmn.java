package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzfmn<K, V> extends zzfmt<K, V> implements zzfna<K, V> {
    public zzfmn(zzfmp<K, zzfml<V>> zzfmp, int i) {
        super(zzfmp, i);
    }

    public final zzfml<V> zza(@NullableDecl K k) {
        zzfml<V> zzfml = (zzfml) this.zzb.get(k);
        return zzfml == null ? zzfml.zzi() : zzfml;
    }
}
