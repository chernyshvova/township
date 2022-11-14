package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzfq<K> extends zzfg<K> {
    public final transient zzfc<K, ?> zza;
    public final transient zzfb<K> zzb;

    public zzfq(zzfc<K, ?> zzfc, zzfb<K> zzfb) {
        this.zza = zzfc;
        this.zzb = zzfb;
    }

    public final boolean contains(@NullableDecl Object obj) {
        return this.zza.get(obj) != null;
    }

    public final int size() {
        return this.zza.size();
    }

    /* renamed from: zza */
    public final zzfx<K> iterator() {
        return (zzfx) zze().iterator();
    }

    public final zzfb<K> zze() {
        return this.zzb;
    }

    public final boolean zzf() {
        return true;
    }

    public final int zza(Object[] objArr, int i) {
        return zze().zza(objArr, i);
    }
}
