package com.helpshift.util.concurrent;

public interface ApiExecutor {
    void awaitForSyncExecution();

    void runAsync(Runnable runnable);

    void runOnUiThread(Runnable runnable);

    void runSync(Runnable runnable);
}
