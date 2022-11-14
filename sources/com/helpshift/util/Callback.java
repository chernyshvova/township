package com.helpshift.util;

public interface Callback<T, V> {
    void onFailure(V v);

    void onSuccess(T t);
}
