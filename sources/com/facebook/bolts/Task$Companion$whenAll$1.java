package com.facebook.bolts;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Task.kt */
public final class Task$Companion$whenAll$1<TTaskResult, TContinuationResult> implements Continuation {
    public final /* synthetic */ TaskCompletionSource<Void> $allFinished;
    public final /* synthetic */ ArrayList<Exception> $causes;
    public final /* synthetic */ AtomicInteger $count;
    public final /* synthetic */ ReentrantLock $errorLock;
    public final /* synthetic */ AtomicBoolean $isCancelled;

    public Task$Companion$whenAll$1(ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, AtomicInteger atomicInteger, ArrayList<Exception> arrayList, TaskCompletionSource<Void> taskCompletionSource) {
        this.$errorLock = reentrantLock;
        this.$isCancelled = atomicBoolean;
        this.$count = atomicInteger;
        this.$causes = arrayList;
        this.$allFinished = taskCompletionSource;
    }

    public final Void then(Task<Object> task) {
        Intrinsics.checkNotNullParameter(task, "it");
        if (task.isFaulted()) {
            ReentrantLock reentrantLock = this.$errorLock;
            ArrayList<Exception> arrayList = this.$causes;
            reentrantLock.lock();
            try {
                arrayList.add(task.getError());
            } finally {
                reentrantLock.unlock();
            }
        }
        if (task.isCancelled()) {
            this.$isCancelled.set(true);
        }
        if (this.$count.decrementAndGet() == 0) {
            if (this.$causes.size() != 0) {
                if (this.$causes.size() == 1) {
                    this.$allFinished.setError(this.$causes.get(0));
                } else {
                    this.$allFinished.setError(new AggregateException(GeneratedOutlineSupport.outline21(new Object[]{Integer.valueOf(this.$causes.size())}, 1, "There were %d exceptions.", "java.lang.String.format(format, *args)"), this.$causes));
                }
            } else if (this.$isCancelled.get()) {
                this.$allFinished.setCancelled();
            } else {
                this.$allFinished.setResult(null);
            }
        }
        return null;
    }
}
