package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzflj extends AbstractCollection {
    public final /* synthetic */ zzflk zza;

    public zzflj(zzflk zzflk) {
        this.zza = zzflk;
    }

    public final void clear() {
        this.zza.zzf();
    }

    public final boolean contains(@NullableDecl Object obj) {
        return this.zza.zzt(obj);
    }

    public final Iterator iterator() {
        return this.zza.zzk();
    }

    public final int size() {
        return this.zza.zzd();
    }
}
