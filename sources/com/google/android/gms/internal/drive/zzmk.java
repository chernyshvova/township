package com.google.android.gms.internal.drive;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzmk implements Iterator<Map.Entry<K, V>> {
    public int pos;
    public Iterator<Map.Entry<K, V>> zzvj;
    public final /* synthetic */ zzmi zzvk;

    public zzmk(zzmi zzmi) {
        this.zzvk = zzmi;
        this.pos = this.zzvk.zzve.size();
    }

    private final Iterator<Map.Entry<K, V>> zzew() {
        if (this.zzvj == null) {
            this.zzvj = this.zzvk.zzvh.entrySet().iterator();
        }
        return this.zzvj;
    }

    public final boolean hasNext() {
        int i = this.pos;
        return (i > 0 && i <= this.zzvk.zzve.size()) || zzew().hasNext();
    }

    public final /* synthetic */ Object next() {
        if (zzew().hasNext()) {
            return (Map.Entry) zzew().next();
        }
        List zzb = this.zzvk.zzve;
        int i = this.pos - 1;
        this.pos = i;
        return (Map.Entry) zzb.get(i);
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ zzmk(zzmi zzmi, zzmj zzmj) {
        this(zzmi);
    }
}
