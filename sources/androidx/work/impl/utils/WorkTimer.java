package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Logger;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkTimer {
    public static final String TAG = Logger.tagWithPrefix("WorkTimer");
    public final ThreadFactory mBackgroundThreadFactory = new ThreadFactory() {
        public int mThreadsCreated = 0;

        public Thread newThread(@NonNull Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("WorkManager-WorkTimer-thread-");
            outline24.append(this.mThreadsCreated);
            newThread.setName(outline24.toString());
            this.mThreadsCreated++;
            return newThread;
        }
    };
    public final ScheduledExecutorService mExecutorService = Executors.newSingleThreadScheduledExecutor(this.mBackgroundThreadFactory);
    public final Map<String, TimeLimitExceededListener> mListeners = new HashMap();
    public final Object mLock = new Object();
    public final Map<String, WorkTimerRunnable> mTimerMap = new HashMap();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface TimeLimitExceededListener {
        void onTimeLimitExceeded(@NonNull String str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class WorkTimerRunnable implements Runnable {
        public static final String TAG = "WrkTimerRunnable";
        public final String mWorkSpecId;
        public final WorkTimer mWorkTimer;

        public WorkTimerRunnable(@NonNull WorkTimer workTimer, @NonNull String str) {
            this.mWorkTimer = workTimer;
            this.mWorkSpecId = str;
        }

        public void run() {
            synchronized (this.mWorkTimer.mLock) {
                if (this.mWorkTimer.mTimerMap.remove(this.mWorkSpecId) != null) {
                    TimeLimitExceededListener remove = this.mWorkTimer.mListeners.remove(this.mWorkSpecId);
                    if (remove != null) {
                        remove.onTimeLimitExceeded(this.mWorkSpecId);
                    }
                } else {
                    Logger.get().debug(TAG, String.format("Timer with %s is already marked as complete.", new Object[]{this.mWorkSpecId}), new Throwable[0]);
                }
            }
        }
    }

    @VisibleForTesting
    @NonNull
    public ScheduledExecutorService getExecutorService() {
        return this.mExecutorService;
    }

    @VisibleForTesting
    @NonNull
    public synchronized Map<String, TimeLimitExceededListener> getListeners() {
        return this.mListeners;
    }

    @VisibleForTesting
    @NonNull
    public synchronized Map<String, WorkTimerRunnable> getTimerMap() {
        return this.mTimerMap;
    }

    public void onDestroy() {
        if (!this.mExecutorService.isShutdown()) {
            this.mExecutorService.shutdownNow();
        }
    }

    public void startTimer(@NonNull String str, long j, @NonNull TimeLimitExceededListener timeLimitExceededListener) {
        synchronized (this.mLock) {
            Logger.get().debug(TAG, String.format("Starting timer for %s", new Object[]{str}), new Throwable[0]);
            stopTimer(str);
            WorkTimerRunnable workTimerRunnable = new WorkTimerRunnable(this, str);
            this.mTimerMap.put(str, workTimerRunnable);
            this.mListeners.put(str, timeLimitExceededListener);
            this.mExecutorService.schedule(workTimerRunnable, j, TimeUnit.MILLISECONDS);
        }
    }

    public void stopTimer(@NonNull String str) {
        synchronized (this.mLock) {
            if (this.mTimerMap.remove(str) != null) {
                Logger.get().debug(TAG, String.format("Stopping timer for %s", new Object[]{str}), new Throwable[0]);
                this.mListeners.remove(str);
            }
        }
    }
}
