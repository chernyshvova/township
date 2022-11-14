package com.helpshift.util;

import java.util.Collection;

public interface HSListObserver<T> {
    void add(T t);

    void addAll(Collection<? extends T> collection);

    void update(T t);
}
