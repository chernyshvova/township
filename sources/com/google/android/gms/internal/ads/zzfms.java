package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfms<K, V> extends zzfmg<V> {
    public final transient zzfmt<K, V> zza;

    public zzfms(zzfmt<K, V> zzfmt) {
        this.zza = zzfmt;
    }

    public final boolean contains(@NullableDecl Object obj) {
        return this.zza.zzt(obj);
    }

    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return new zzfmq(this.zza);
    }

    public final int size() {
        return this.zza.zzc;
    }

    public final zzfom<V> zza() {
        return new zzfmq(this.zza);
    }

    public final boolean zzf() {
        throw null;
    }

    public final int zzg(Object[] objArr, int i) {
        zzfon zzt = ((zzfml) this.zza.zzb.values()).listIterator(0);
        while (zzt.hasNext()) {
            i = ((zzfmg) zzt.next()).zzg(objArr, i);
        }
        return i;
    }
}
