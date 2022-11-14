package com.appsflyer.internal;

import android.net.TrafficStats;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.appsflyer.internal.n */
public final class C1486n {
    public static C1486n valueOf;
    public ScheduledExecutorService AFInAppEventParameterName;
    public Executor AFInAppEventType;
    public ScheduledExecutorService AFKeystoreWrapper;
    public final ThreadFactory values = new ThreadFactory() {
        public final Thread newThread(@NonNull final Runnable runnable) {
            return new Thread(new Runnable() {
                public final void run() {
                    TrafficStats.setThreadStatsTag("AppsFlyer".hashCode());
                    runnable.run();
                }
            });
        }
    };

    public final Executor AFInAppEventParameterName() {
        Executor executor = this.AFInAppEventType;
        if (executor == null || ((executor instanceof ThreadPoolExecutor) && (((ThreadPoolExecutor) executor).isShutdown() || ((ThreadPoolExecutor) this.AFInAppEventType).isTerminated() || ((ThreadPoolExecutor) this.AFInAppEventType).isTerminating()))) {
            this.AFInAppEventType = Executors.newFixedThreadPool(2, this.values);
        }
        return this.AFInAppEventType;
    }

    public final ScheduledThreadPoolExecutor values() {
        ScheduledExecutorService scheduledExecutorService = this.AFInAppEventParameterName;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown() || this.AFInAppEventParameterName.isTerminated()) {
            this.AFInAppEventParameterName = Executors.newScheduledThreadPool(2, this.values);
        }
        return (ScheduledThreadPoolExecutor) this.AFInAppEventParameterName;
    }

    public static void AFInAppEventParameterName(ExecutorService executorService) {
        try {
            AFLogger.AFKeystoreWrapper("shut downing executor ...");
            executorService.shutdown();
            executorService.awaitTermination(10, TimeUnit.SECONDS);
            if (!executorService.isTerminated()) {
                AFLogger.AFKeystoreWrapper("killing non-finished tasks");
            }
            executorService.shutdownNow();
        } catch (InterruptedException unused) {
            AFLogger.AFKeystoreWrapper("InterruptedException!!!");
            if (!executorService.isTerminated()) {
                AFLogger.AFKeystoreWrapper("killing non-finished tasks");
            }
            executorService.shutdownNow();
        } catch (Throwable th) {
            if (!executorService.isTerminated()) {
                AFLogger.AFKeystoreWrapper("killing non-finished tasks");
            }
            executorService.shutdownNow();
            throw th;
        }
    }
}
