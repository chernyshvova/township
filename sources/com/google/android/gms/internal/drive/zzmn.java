package com.google.android.gms.internal.drive;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class zzmn implements Iterator<Object> {
    public final boolean hasNext() {
        return false;
    }

    public final Object next() {
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
