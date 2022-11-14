package com.vungle.warren.utility;

import androidx.annotation.NonNull;

public interface Scheduler {
    void cancel(@NonNull String str);

    void cancelAll();

    void schedule(@NonNull Runnable runnable, long j);

    void schedule(@NonNull Runnable runnable, @NonNull String str, long j);
}
