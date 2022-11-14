package com.swrve.sdk.localstorage;

import java.util.Map;

public class SimpleEntry<K, V> implements Map.Entry<K, V> {
    public K key;
    public V value;

    public SimpleEntry(K k, V v) {
        this.key = k;
        this.value = v;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public V setValue(V v) {
        this.value = v;
        return v;
    }
}
