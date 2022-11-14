package com.vungle.warren.downloader;

import androidx.annotation.NonNull;
import java.util.List;

public interface CachePolicy<T> {
    void clean();

    List<T> getOrderedCacheItems();

    void load();

    void put(@NonNull T t, long j);

    void remove(@NonNull T t);

    void save();
}
