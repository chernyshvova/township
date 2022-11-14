package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Collection;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzfoh<E> extends AbstractSet<E> {
    public boolean removeAll(Collection<?> collection) {
        return zzfoi.zzc(this, collection);
    }

    public boolean retainAll(Collection<?> collection) {
        if (collection != null) {
            return super.retainAll(collection);
        }
        throw null;
    }
}
