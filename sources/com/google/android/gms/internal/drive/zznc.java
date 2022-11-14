package com.google.android.gms.internal.drive;

import java.util.Iterator;

public final class zznc implements Iterator<String> {
    public final /* synthetic */ zzna zzvw;
    public Iterator<String> zzvx = this.zzvw.zzvt.iterator();

    public zznc(zzna zzna) {
        this.zzvw = zzna;
    }

    public final boolean hasNext() {
        return this.zzvx.hasNext();
    }

    public final /* synthetic */ Object next() {
        return this.zzvx.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
