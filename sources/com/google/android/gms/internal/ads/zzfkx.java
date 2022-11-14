package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzfkx extends zzfnh {
    public final /* synthetic */ zzflh zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfkx(zzflh zzflh, Map map) {
        super(map);
        this.zza = zzflh;
    }

    public final void clear() {
        zzfmz.zzb(iterator());
    }

    public final boolean containsAll(Collection<?> collection) {
        return this.zzd.keySet().containsAll(collection);
    }

    public final boolean equals(@NullableDecl Object obj) {
        return this == obj || this.zzd.keySet().equals(obj);
    }

    public final int hashCode() {
        return this.zzd.keySet().hashCode();
    }

    public final Iterator iterator() {
        return new zzfkw(this, this.zzd.entrySet().iterator());
    }

    public final boolean remove(Object obj) {
        Collection collection = (Collection) this.zzd.remove(obj);
        if (collection == null) {
            return false;
        }
        int size = collection.size();
        collection.clear();
        zzflh.zzr(this.zza, size);
        return size > 0;
    }
}
