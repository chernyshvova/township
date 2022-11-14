package com.vungle.warren.downloader;

import androidx.annotation.NonNull;
import java.io.File;
import java.io.IOException;
import java.util.List;

public interface DownloaderCache {
    void clear();

    boolean deleteAndRemove(@NonNull File file);

    boolean deleteContents(@NonNull File file);

    long getCacheUpdateTimestamp(@NonNull File file);

    @NonNull
    File getFile(@NonNull String str) throws IOException;

    @NonNull
    File getMetaFile(@NonNull File file);

    void init();

    void onCacheHit(@NonNull File file, long j);

    @NonNull
    List<File> purge();

    void setCacheLastUpdateTimestamp(@NonNull File file, long j);

    void startTracking(@NonNull File file);

    void stopTracking(@NonNull File file);
}
