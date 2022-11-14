package com.helpshift.util;

public interface Predicate<T> {
    boolean matches(T t);
}
