package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfls extends AbstractSet {
    public final /* synthetic */ zzflv zza;

    public zzfls(zzflv zzflv) {
        this.zza = zzflv;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(Object obj) {
        return this.zza.containsKey(obj);
    }

    public final Iterator iterator() {
        zzflv zzflv = this.zza;
        Map zzc = zzflv.zzc();
        if (zzc != null) {
            return zzc.keySet().iterator();
        }
        return new zzfln(zzflv);
    }

    public final boolean remove(@NullableDecl Object obj) {
        Map zzc = this.zza.zzc();
        if (zzc != null) {
            return zzc.keySet().remove(obj);
        }
        return this.zza.zzs(obj) != zzflv.zzd;
    }

    public final int size() {
        return this.zza.size();
    }
}
