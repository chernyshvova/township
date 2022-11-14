package com.facebook.bolts;

import android.os.Handler;
import android.os.Looper;
import com.vungle.warren.p037ui.contract.AdContract;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidExecutors.kt */
public final class AndroidExecutors {
    public static final int CORE_POOL_SIZE;
    public static final int CPU_COUNT;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final AndroidExecutors INSTANCE = new AndroidExecutors();
    public static final long KEEP_ALIVE_TIME = 1;
    public static final int MAX_POOL_SIZE;
    public final Executor uiThread = new UIThreadExecutor();

    /* compiled from: AndroidExecutors.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ExecutorService newCachedThreadPool() {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(AndroidExecutors.CORE_POOL_SIZE, AndroidExecutors.MAX_POOL_SIZE, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            return threadPoolExecutor;
        }

        public final Executor uiThread() {
            return AndroidExecutors.INSTANCE.uiThread;
        }
    }

    /* compiled from: AndroidExecutors.kt */
    public static final class UIThreadExecutor implements Executor {
        public void execute(Runnable runnable) {
            Intrinsics.checkNotNullParameter(runnable, AdContract.AdvertisementBus.COMMAND);
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        CORE_POOL_SIZE = availableProcessors + 1;
        MAX_POOL_SIZE = (availableProcessors * 2) + 1;
    }

    public static final ExecutorService newCachedThreadPool() {
        return Companion.newCachedThreadPool();
    }

    public static final Executor uiThread() {
        return Companion.uiThread();
    }
}
