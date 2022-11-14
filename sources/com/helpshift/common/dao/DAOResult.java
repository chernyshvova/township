package com.helpshift.common.dao;

public class DAOResult<T> {
    public final T data;
    public final boolean isSuccess;

    public DAOResult(boolean z, T t) {
        this.isSuccess = z;
        this.data = t;
    }

    public T getData() {
        return this.data;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }
}
