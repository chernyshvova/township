package com.google.android.gms.internal.drive;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzna extends AbstractList<String> implements zzkz, RandomAccess {
    public final zzkz zzvt;

    public zzna(zzkz zzkz) {
        this.zzvt = zzkz;
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.zzvt.get(i);
    }

    public final Iterator<String> iterator() {
        return new zznc(this);
    }

    public final ListIterator<String> listIterator(int i) {
        return new zznb(this, i);
    }

    public final int size() {
        return this.zzvt.size();
    }

    public final Object zzao(int i) {
        return this.zzvt.zzao(i);
    }

    public final List<?> zzdr() {
        return this.zzvt.zzdr();
    }

    public final zzkz zzds() {
        return this;
    }
}
