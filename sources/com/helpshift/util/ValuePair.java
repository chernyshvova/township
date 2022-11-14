package com.helpshift.util;

public class ValuePair<F, S> {
    public final F first;
    public final S second;

    public ValuePair(F f, S s) {
        this.first = f;
        this.second = s;
    }
}
