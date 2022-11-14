package com.google.android.gms.internal.drive;

import java.util.Iterator;
import java.util.Map;

public final class zzkw<K> implements Iterator<Map.Entry<K, Object>> {
    public Iterator<Map.Entry<K, Object>> zztg;

    public zzkw(Iterator<Map.Entry<K, Object>> it) {
        this.zztg = it;
    }

    public final boolean hasNext() {
        return this.zztg.hasNext();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.zztg.next();
        return next.getValue() instanceof zzkt ? new zzkv(next) : next;
    }

    public final void remove() {
        this.zztg.remove();
    }
}
