package com.vungle.warren.utility;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SDKExecutors implements Executors {
    public static final ThreadPoolExecutor API_EXECUTOR;
    public static final ExecutorService BACKGROUND_EXECUTOR;
    public static final ExecutorService IO_EXECUTOR;
    public static final int IO_KEEP_ALIVE_TIME_SECONDS = 5;
    public static final int JOBS_KEEP_ALIVE_TIME_SECONDS = 1;
    public static final ExecutorService JOB_EXECUTOR;
    public static final ExecutorService LOGGER_EXECUTOR;
    public static int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
    public static final int SINGLE_CORE_POOL_SIZE = 1;
    public static final ExecutorService TASK_EXECUTOR;
    public static final ExecutorService UI_EXECUTOR;
    public static final int VUNGLE_KEEP_ALIVE_TIME_SECONDS = 10;

    public static class NamedThreadFactory implements ThreadFactory {
        public AtomicInteger atomicInteger = new AtomicInteger(0);
        public final String name;
        public ThreadFactory threadFactory = Executors.defaultThreadFactory();

        public NamedThreadFactory(String str) {
            this.name = str;
        }

        public Thread newThread(@NonNull Runnable runnable) {
            Thread newThread = this.threadFactory.newThread(runnable);
            newThread.setName(this.name + "-th-" + this.atomicInteger.incrementAndGet());
            return newThread;
        }
    }

    static {
        C20531 r0 = new AbstractExecutorService() {
            public final Handler UIHandler = new Handler(Looper.getMainLooper());

            public boolean awaitTermination(long j, @NonNull TimeUnit timeUnit) {
                return false;
            }

            public void execute(@NonNull Runnable runnable) {
                this.UIHandler.post(runnable);
            }

            public boolean isShutdown() {
                return false;
            }

            public boolean isTerminated() {
                return false;
            }

            public void shutdown() {
            }

            public List<Runnable> shutdownNow() {
                return null;
            }
        };
        int i = NUMBER_OF_CORES;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 1, TimeUnit.SECONDS, new PriorityBlockingQueue(), new NamedThreadFactory("vng_jr"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1, 1, 5, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("vng_io"));
        threadPoolExecutor2.allowCoreThreadTimeOut(true);
        ThreadPoolExecutor threadPoolExecutor3 = new ThreadPoolExecutor(1, 1, 5, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("vng_logger"));
        threadPoolExecutor3.allowCoreThreadTimeOut(true);
        ThreadPoolExecutor threadPoolExecutor4 = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("vng_background"));
        threadPoolExecutor4.allowCoreThreadTimeOut(true);
        ThreadPoolExecutor threadPoolExecutor5 = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("vng_api"));
        threadPoolExecutor5.allowCoreThreadTimeOut(true);
        ThreadPoolExecutor threadPoolExecutor6 = new ThreadPoolExecutor(1, 20, 10, TimeUnit.SECONDS, new SynchronousQueue(), new NamedThreadFactory("vng_task"));
        UI_EXECUTOR = r0;
        JOB_EXECUTOR = threadPoolExecutor;
        IO_EXECUTOR = threadPoolExecutor2;
        BACKGROUND_EXECUTOR = threadPoolExecutor4;
        API_EXECUTOR = threadPoolExecutor5;
        LOGGER_EXECUTOR = threadPoolExecutor3;
        TASK_EXECUTOR = threadPoolExecutor6;
    }

    public ExecutorService getApiExecutor() {
        return API_EXECUTOR;
    }

    public ExecutorService getBackgroundExecutor() {
        return BACKGROUND_EXECUTOR;
    }

    public ExecutorService getIOExecutor() {
        return IO_EXECUTOR;
    }

    public ExecutorService getJobExecutor() {
        return JOB_EXECUTOR;
    }

    public ExecutorService getLoggerExecutor() {
        return LOGGER_EXECUTOR;
    }

    public ExecutorService getTaskExecutor() {
        return TASK_EXECUTOR;
    }

    public ExecutorService getUIExecutor() {
        return UI_EXECUTOR;
    }
}
