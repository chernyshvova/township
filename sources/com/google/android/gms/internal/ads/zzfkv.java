package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzfkv<T> implements Iterator<T> {
    public final Iterator<Map.Entry> zza;
    @NullableDecl
    public Object zzb = null;
    @NullableDecl
    public Collection zzc = null;
    public Iterator zzd = zzfmy.INSTANCE;
    public final /* synthetic */ zzflh zze;

    public zzfkv(zzflh zzflh) {
        this.zze = zzflh;
        this.zza = zzflh.zza.entrySet().iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext() || this.zzd.hasNext();
    }

    public final T next() {
        if (!this.zzd.hasNext()) {
            Map.Entry next = this.zza.next();
            this.zzb = next.getKey();
            Collection collection = (Collection) next.getValue();
            this.zzc = collection;
            this.zzd = collection.iterator();
        }
        return this.zzd.next();
    }

    public final void remove() {
        this.zzd.remove();
        if (this.zzc.isEmpty()) {
            this.zza.remove();
        }
        zzflh.zzo(this.zze);
    }
}
