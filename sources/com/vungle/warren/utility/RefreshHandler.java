package com.vungle.warren.utility;

import android.os.Handler;
import androidx.annotation.NonNull;

public class RefreshHandler extends Handler {
    public static final int DISABLE_REFRESH_VALUE = 0;

    /* renamed from: ID */
    public static final int f2852ID = 0;
    public long handlerStartTime;
    public long handlerTimeElapsed;
    public final long refreshDuration;
    public Runnable runnable;

    public RefreshHandler(@NonNull Runnable runnable2, long j) {
        this.refreshDuration = j;
        this.runnable = runnable2;
    }

    public synchronized void clean() {
        removeMessages(0);
        removeCallbacks(this.runnable);
        this.handlerTimeElapsed = 0;
        this.handlerStartTime = 0;
    }

    public synchronized void pause() {
        if (hasMessages(0)) {
            this.handlerTimeElapsed = (System.currentTimeMillis() - this.handlerStartTime) + this.handlerTimeElapsed;
            removeMessages(0);
            removeCallbacks(this.runnable);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void start() {
        /*
            r5 = this;
            monitor-enter(r5)
            long r0 = r5.refreshDuration     // Catch:{ all -> 0x0024 }
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x000b
            monitor-exit(r5)
            return
        L_0x000b:
            r0 = 0
            boolean r0 = r5.hasMessages(r0)     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x0022
            long r0 = r5.refreshDuration     // Catch:{ all -> 0x0024 }
            long r2 = r5.handlerTimeElapsed     // Catch:{ all -> 0x0024 }
            long r0 = r0 - r2
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0024 }
            r5.handlerStartTime = r2     // Catch:{ all -> 0x0024 }
            java.lang.Runnable r2 = r5.runnable     // Catch:{ all -> 0x0024 }
            r5.postDelayed(r2, r0)     // Catch:{ all -> 0x0024 }
        L_0x0022:
            monitor-exit(r5)
            return
        L_0x0024:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.utility.RefreshHandler.start():void");
    }
}
