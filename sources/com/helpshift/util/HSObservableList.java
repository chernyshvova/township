package com.helpshift.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HSObservableList<T> extends ArrayList<T> {
    public HSListObserver<T> observer;

    public HSObservableList() {
    }

    public boolean add(T t) {
        HSListObserver<T> hSListObserver;
        boolean add = super.add(t);
        if (add && (hSListObserver = this.observer) != null) {
            hSListObserver.add(t);
        }
        return add;
    }

    public boolean addAll(Collection<? extends T> collection) {
        HSListObserver<T> hSListObserver;
        boolean addAll = super.addAll(collection);
        if (addAll && (hSListObserver = this.observer) != null) {
            hSListObserver.addAll(collection);
        }
        return addAll;
    }

    public void prependItems(Collection<? extends T> collection) {
        super.addAll(0, collection);
    }

    public T setAndNotifyObserver(int i, T t) {
        HSListObserver<T> hSListObserver;
        T t2 = super.set(i, t);
        if (!(t2 == null || (hSListObserver = this.observer) == null)) {
            hSListObserver.update(t);
        }
        return t2;
    }

    public void setObserver(HSListObserver<T> hSListObserver) {
        this.observer = hSListObserver;
    }

    public HSObservableList(List<T> list) {
        super(list);
    }
}
