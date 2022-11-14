package androidx.work.impl;

import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.work.Configuration;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.foreground.SystemForegroundService;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class Processor implements ExecutionListener, ForegroundProcessor {
    public static final String FOREGROUND_WAKELOCK_TAG = "ProcessorForegroundLck";
    public static final String TAG = Logger.tagWithPrefix("Processor");
    public Context mAppContext;
    public Set<String> mCancelledIds;
    public Configuration mConfiguration;
    public Map<String, WorkerWrapper> mEnqueuedWorkMap = new HashMap();
    @Nullable
    public PowerManager.WakeLock mForegroundLock;
    public Map<String, WorkerWrapper> mForegroundWorkMap = new HashMap();
    public final Object mLock;
    public final List<ExecutionListener> mOuterListeners;
    public List<Scheduler> mSchedulers;
    public WorkDatabase mWorkDatabase;
    public TaskExecutor mWorkTaskExecutor;

    public static class FutureListener implements Runnable {
        @NonNull
        public ExecutionListener mExecutionListener;
        @NonNull
        public ListenableFuture<Boolean> mFuture;
        @NonNull
        public String mWorkSpecId;

        public FutureListener(@NonNull ExecutionListener executionListener, @NonNull String str, @NonNull ListenableFuture<Boolean> listenableFuture) {
            this.mExecutionListener = executionListener;
            this.mWorkSpecId = str;
            this.mFuture = listenableFuture;
        }

        public void run() {
            boolean z;
            try {
                z = this.mFuture.get().booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                z = true;
            }
            this.mExecutionListener.onExecuted(this.mWorkSpecId, z);
        }
    }

    public Processor(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor taskExecutor, @NonNull WorkDatabase workDatabase, @NonNull List<Scheduler> list) {
        this.mAppContext = context;
        this.mConfiguration = configuration;
        this.mWorkTaskExecutor = taskExecutor;
        this.mWorkDatabase = workDatabase;
        this.mSchedulers = list;
        this.mCancelledIds = new HashSet();
        this.mOuterListeners = new ArrayList();
        this.mForegroundLock = null;
        this.mLock = new Object();
    }

    public static boolean interrupt(@NonNull String str, @Nullable WorkerWrapper workerWrapper) {
        if (workerWrapper != null) {
            workerWrapper.interrupt();
            Logger.get().debug(TAG, String.format("WorkerWrapper interrupted for %s", new Object[]{str}), new Throwable[0]);
            return true;
        }
        Logger.get().debug(TAG, String.format("WorkerWrapper could not be found for %s", new Object[]{str}), new Throwable[0]);
        return false;
    }

    private void stopForegroundService() {
        synchronized (this.mLock) {
            if (!(!this.mForegroundWorkMap.isEmpty())) {
                SystemForegroundService instance = SystemForegroundService.getInstance();
                if (instance != null) {
                    Logger.get().debug(TAG, "No more foreground work. Stopping SystemForegroundService", new Throwable[0]);
                    instance.stopForegroundService();
                } else {
                    Logger.get().debug(TAG, "No more foreground work. SystemForegroundService is already stopped", new Throwable[0]);
                }
                if (this.mForegroundLock != null) {
                    this.mForegroundLock.release();
                    this.mForegroundLock = null;
                }
            }
        }
    }

    public void addExecutionListener(@NonNull ExecutionListener executionListener) {
        synchronized (this.mLock) {
            this.mOuterListeners.add(executionListener);
        }
    }

    public boolean hasWork() {
        boolean z;
        synchronized (this.mLock) {
            if (this.mEnqueuedWorkMap.isEmpty()) {
                if (this.mForegroundWorkMap.isEmpty()) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public boolean isCancelled(@NonNull String str) {
        boolean contains;
        synchronized (this.mLock) {
            contains = this.mCancelledIds.contains(str);
        }
        return contains;
    }

    public boolean isEnqueued(@NonNull String str) {
        boolean z;
        synchronized (this.mLock) {
            if (!this.mEnqueuedWorkMap.containsKey(str)) {
                if (!this.mForegroundWorkMap.containsKey(str)) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public boolean isEnqueuedInForeground(@NonNull String str) {
        boolean containsKey;
        synchronized (this.mLock) {
            containsKey = this.mForegroundWorkMap.containsKey(str);
        }
        return containsKey;
    }

    public void onExecuted(@NonNull String str, boolean z) {
        synchronized (this.mLock) {
            this.mEnqueuedWorkMap.remove(str);
            Logger.get().debug(TAG, String.format("%s %s executed; reschedule = %s", new Object[]{getClass().getSimpleName(), str, Boolean.valueOf(z)}), new Throwable[0]);
            for (ExecutionListener onExecuted : this.mOuterListeners) {
                onExecuted.onExecuted(str, z);
            }
        }
    }

    public void removeExecutionListener(@NonNull ExecutionListener executionListener) {
        synchronized (this.mLock) {
            this.mOuterListeners.remove(executionListener);
        }
    }

    public void startForeground(@NonNull String str, @NonNull ForegroundInfo foregroundInfo) {
        synchronized (this.mLock) {
            Logger.get().info(TAG, String.format("Moving WorkSpec (%s) to the foreground", new Object[]{str}), new Throwable[0]);
            WorkerWrapper remove = this.mEnqueuedWorkMap.remove(str);
            if (remove != null) {
                if (this.mForegroundLock == null) {
                    PowerManager.WakeLock newWakeLock = WakeLocks.newWakeLock(this.mAppContext, FOREGROUND_WAKELOCK_TAG);
                    this.mForegroundLock = newWakeLock;
                    newWakeLock.acquire();
                }
                this.mForegroundWorkMap.put(str, remove);
                ContextCompat.startForegroundService(this.mAppContext, SystemForegroundDispatcher.createStartForegroundIntent(this.mAppContext, str, foregroundInfo));
            }
        }
    }

    public boolean startWork(@NonNull String str) {
        return startWork(str, (WorkerParameters.RuntimeExtras) null);
    }

    public boolean stopAndCancelWork(@NonNull String str) {
        boolean interrupt;
        synchronized (this.mLock) {
            boolean z = true;
            Logger.get().debug(TAG, String.format("Processor cancelling %s", new Object[]{str}), new Throwable[0]);
            this.mCancelledIds.add(str);
            WorkerWrapper remove = this.mForegroundWorkMap.remove(str);
            if (remove == null) {
                z = false;
            }
            if (remove == null) {
                remove = this.mEnqueuedWorkMap.remove(str);
            }
            interrupt = interrupt(str, remove);
            if (z) {
                stopForegroundService();
            }
        }
        return interrupt;
    }

    public void stopForeground(@NonNull String str) {
        synchronized (this.mLock) {
            this.mForegroundWorkMap.remove(str);
            stopForegroundService();
        }
    }

    public boolean stopForegroundWork(@NonNull String str) {
        boolean interrupt;
        synchronized (this.mLock) {
            Logger.get().debug(TAG, String.format("Processor stopping foreground work %s", new Object[]{str}), new Throwable[0]);
            interrupt = interrupt(str, this.mForegroundWorkMap.remove(str));
        }
        return interrupt;
    }

    public boolean stopWork(@NonNull String str) {
        boolean interrupt;
        synchronized (this.mLock) {
            Logger.get().debug(TAG, String.format("Processor stopping background work %s", new Object[]{str}), new Throwable[0]);
            interrupt = interrupt(str, this.mEnqueuedWorkMap.remove(str));
        }
        return interrupt;
    }

    public boolean startWork(@NonNull String str, @Nullable WorkerParameters.RuntimeExtras runtimeExtras) {
        synchronized (this.mLock) {
            if (isEnqueued(str)) {
                Logger.get().debug(TAG, String.format("Work %s is already enqueued for processing", new Object[]{str}), new Throwable[0]);
                return false;
            }
            WorkerWrapper build = new WorkerWrapper.Builder(this.mAppContext, this.mConfiguration, this.mWorkTaskExecutor, this, this.mWorkDatabase, str).withSchedulers(this.mSchedulers).withRuntimeExtras(runtimeExtras).build();
            ListenableFuture<Boolean> future = build.getFuture();
            future.addListener(new FutureListener(this, str, future), this.mWorkTaskExecutor.getMainThreadExecutor());
            this.mEnqueuedWorkMap.put(str, build);
            this.mWorkTaskExecutor.getBackgroundExecutor().execute(build);
            Logger.get().debug(TAG, String.format("%s: processing %s", new Object[]{Processor.class.getSimpleName(), str}), new Throwable[0]);
            return true;
        }
    }
}
