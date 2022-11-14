package com.microsoft.appcenter.persistence;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.json.DefaultLogSerializer;
import java.io.Closeable;
import java.util.Collection;
import java.util.List;

public abstract class Persistence implements Closeable {
    public DefaultLogSerializer mLogSerializer;

    public static class PersistenceException extends Exception {
        public PersistenceException(String str, Throwable th) {
            super(str, th);
        }

        public PersistenceException(String str) {
            super(str);
        }
    }

    public abstract void deleteLogs(String str);

    @Nullable
    public abstract String getLogs(@NonNull String str, @NonNull Collection<String> collection, @IntRange(from = 0) int i, @NonNull List<Log> list);

    public abstract long putLog(@NonNull Log log, @NonNull String str, @IntRange(from = 1, mo281to = 2) int i) throws PersistenceException;
}
