package com.vungle.warren.utility;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.NonNull;

public class HandlerScheduler implements Scheduler {
    public Handler handler = new Handler(Looper.getMainLooper());

    private long calculateTime(long j) {
        return SystemClock.uptimeMillis() + j;
    }

    public void cancel(@NonNull String str) {
        this.handler.removeCallbacksAndMessages(str);
    }

    public void cancelAll() {
        this.handler.removeCallbacksAndMessages((Object) null);
    }

    public void schedule(@NonNull Runnable runnable, @NonNull String str, long j) {
        this.handler.postAtTime(runnable, str, calculateTime(j));
    }

    public void schedule(@NonNull Runnable runnable, long j) {
        this.handler.postAtTime(runnable, calculateTime(j));
    }
}
