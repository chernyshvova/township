package com.helpshift.util;

public interface FetchDataFromThread<T, R> {
    void onDataFetched(T t);

    void onFailure(R r);
}
