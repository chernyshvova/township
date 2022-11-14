package com.helpshift.util.concurrent;

import com.helpshift.common.domain.HSThreadFactory;
import com.helpshift.util.HSLogger;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

public class DispatchQueue {
    public static final String TAG = "HS_DispatchQueue";
    public LinkedBlockingQueue<Thread> afterThreads = new LinkedBlockingQueue<>();
    public LinkedBlockingQueue<Future> tasks = new LinkedBlockingQueue<>();
    public ExecutorService threadPoolExecutor;

    public DispatchQueue(boolean z) {
        if (z) {
            this.threadPoolExecutor = Executors.newCachedThreadPool(new HSThreadFactory("cmdpq-a"));
        } else {
            this.threadPoolExecutor = Executors.newSingleThreadExecutor(new HSThreadFactory("cmdpq-b"));
        }
    }

    private void trackTask(Future future) {
        this.tasks.add(future);
    }

    public void dispatchAfter(Runnable runnable, long j) {
        final long j2 = j;
        final Runnable runnable2 = runnable;
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(j2);
                    this.dispatchAsync(runnable2);
                } catch (InterruptedException e) {
                    HSLogger.m3248w(DispatchQueue.TAG, "Runnable interrupted : ", e);
                    Thread.currentThread().interrupt();
                }
            }
        }, "HS-cmdpq-trig");
        thread.start();
        this.afterThreads.add(thread);
    }

    public void dispatchAsync(Runnable runnable) {
        trackTask(this.threadPoolExecutor.submit(runnable));
    }

    public void dispatchSync(Runnable runnable) {
        try {
            this.threadPoolExecutor.submit(runnable).get();
        } catch (InterruptedException e) {
            HSLogger.m3248w(TAG, "Runnable interrupted : ", e);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e2) {
            HSLogger.m3248w(TAG, "Execution exception : ", e2);
        }
    }

    public void join() {
        try {
            Iterator<Thread> it = this.afterThreads.iterator();
            while (it.hasNext()) {
                it.next().join();
            }
            Iterator<Future> it2 = this.tasks.iterator();
            while (it2.hasNext()) {
                it2.next().get();
            }
            this.tasks.clear();
        } catch (InterruptedException e) {
            HSLogger.m3248w(TAG, "Runnable interrupted : ", e);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e2) {
            HSLogger.m3248w(TAG, "Execution exception : ", e2);
        }
    }
}
