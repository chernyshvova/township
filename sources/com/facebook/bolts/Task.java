package com.facebook.bolts;

import com.facebook.bolts.Task;
import com.playrix.engine.Shortcuts;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Task.kt */
public final class Task<TResult> {
    public static final ExecutorService BACKGROUND_EXECUTOR = BoltsExecutors.Companion.background();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final Executor IMMEDIATE_EXECUTOR = BoltsExecutors.Companion.immediate$facebook_bolts_release();
    public static final Task<?> TASK_CANCELLED = new Task<>(true);
    public static final Task<Boolean> TASK_FALSE = new Task<>(Boolean.FALSE);
    public static final Task<?> TASK_NULL = new Task<>((Object) null);
    public static final Task<Boolean> TASK_TRUE = new Task<>(Boolean.TRUE);
    public static final Executor UI_THREAD_EXECUTOR = AndroidExecutors.Companion.uiThread();
    public static volatile UnobservedExceptionHandler unobservedExceptionHandler;
    public boolean cancelledField;
    public boolean completeField;
    public final Condition condition;
    public List<Continuation<TResult, Void>> continuations = new ArrayList();
    public Exception errorField;
    public boolean errorHasBeenObserved;
    public final ReentrantLock lock;
    public TResult resultField;
    public UnobservedErrorNotifier unobservedErrorNotifier;

    /* compiled from: Task.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: call$lambda-2  reason: not valid java name */
        public static final void m3603call$lambda2(CancellationToken cancellationToken, TaskCompletionSource taskCompletionSource, Callable callable) {
            Intrinsics.checkNotNullParameter(taskCompletionSource, "$tcs");
            Intrinsics.checkNotNullParameter(callable, "$callable");
            if (cancellationToken == null || !cancellationToken.isCancellationRequested()) {
                try {
                    taskCompletionSource.setResult(callable.call());
                } catch (CancellationException unused) {
                    taskCompletionSource.setCancelled();
                } catch (Exception e) {
                    taskCompletionSource.setError(e);
                }
            } else {
                taskCompletionSource.setCancelled();
            }
        }

        /* access modifiers changed from: private */
        public final <TContinuationResult, TResult> void completeAfterTask(TaskCompletionSource<TContinuationResult> taskCompletionSource, Continuation<TResult, Task<TContinuationResult>> continuation, Task<TResult> task, Executor executor, CancellationToken cancellationToken) {
            try {
                executor.execute(new Runnable(taskCompletionSource, continuation, task) {
                    public final /* synthetic */ TaskCompletionSource f$1;
                    public final /* synthetic */ Continuation f$2;
                    public final /* synthetic */ Task f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void run() {
                        Task.Companion.m3604completeAfterTask$lambda7(CancellationToken.this, this.f$1, this.f$2, this.f$3);
                    }
                });
            } catch (Exception e) {
                taskCompletionSource.setError(new ExecutorException(e));
            }
        }

        /* renamed from: completeAfterTask$lambda-7  reason: not valid java name */
        public static final void m3604completeAfterTask$lambda7(CancellationToken cancellationToken, TaskCompletionSource taskCompletionSource, Continuation continuation, Task task) {
            Intrinsics.checkNotNullParameter(taskCompletionSource, "$tcs");
            Intrinsics.checkNotNullParameter(continuation, "$continuation");
            Intrinsics.checkNotNullParameter(task, "$task");
            if (cancellationToken == null || !cancellationToken.isCancellationRequested()) {
                try {
                    Task task2 = (Task) continuation.then(task);
                    if (task2 == null) {
                        taskCompletionSource.setResult(null);
                    } else {
                        task2.continueWith(new Continuation(taskCompletionSource) {
                            public final /* synthetic */ TaskCompletionSource f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final Object then(Task task) {
                                return Task.Companion.m3605completeAfterTask$lambda7$lambda6(CancellationToken.this, this.f$1, task);
                            }
                        });
                    }
                } catch (CancellationException unused) {
                    taskCompletionSource.setCancelled();
                } catch (Exception e) {
                    taskCompletionSource.setError(e);
                }
            } else {
                taskCompletionSource.setCancelled();
            }
        }

        /* renamed from: completeAfterTask$lambda-7$lambda-6  reason: not valid java name */
        public static final Void m3605completeAfterTask$lambda7$lambda6(CancellationToken cancellationToken, TaskCompletionSource taskCompletionSource, Task task) {
            Intrinsics.checkNotNullParameter(taskCompletionSource, "$tcs");
            Intrinsics.checkNotNullParameter(task, Shortcuts.SHORTCUT_SCHEDULED_TASK_KEY);
            if (cancellationToken == null || !cancellationToken.isCancellationRequested()) {
                if (task.isCancelled()) {
                    taskCompletionSource.setCancelled();
                } else if (task.isFaulted()) {
                    taskCompletionSource.setError(task.getError());
                } else {
                    taskCompletionSource.setResult(task.getResult());
                }
                return null;
            }
            taskCompletionSource.setCancelled();
            return null;
        }

        /* access modifiers changed from: private */
        public final <TContinuationResult, TResult> void completeImmediately(TaskCompletionSource<TContinuationResult> taskCompletionSource, Continuation<TResult, TContinuationResult> continuation, Task<TResult> task, Executor executor, CancellationToken cancellationToken) {
            try {
                executor.execute(new Runnable(taskCompletionSource, continuation, task) {
                    public final /* synthetic */ TaskCompletionSource f$1;
                    public final /* synthetic */ Continuation f$2;
                    public final /* synthetic */ Task f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void run() {
                        Task.Companion.m3606completeImmediately$lambda5(CancellationToken.this, this.f$1, this.f$2, this.f$3);
                    }
                });
            } catch (Exception e) {
                taskCompletionSource.setError(new ExecutorException(e));
            }
        }

        /* renamed from: completeImmediately$lambda-5  reason: not valid java name */
        public static final void m3606completeImmediately$lambda5(CancellationToken cancellationToken, TaskCompletionSource taskCompletionSource, Continuation continuation, Task task) {
            Intrinsics.checkNotNullParameter(taskCompletionSource, "$tcs");
            Intrinsics.checkNotNullParameter(continuation, "$continuation");
            Intrinsics.checkNotNullParameter(task, "$task");
            if (cancellationToken == null || !cancellationToken.isCancellationRequested()) {
                try {
                    taskCompletionSource.setResult(continuation.then(task));
                } catch (CancellationException unused) {
                    taskCompletionSource.setCancelled();
                } catch (Exception e) {
                    taskCompletionSource.setError(e);
                }
            } else {
                taskCompletionSource.setCancelled();
            }
        }

        /* renamed from: delay$lambda-0  reason: not valid java name */
        public static final void m3607delay$lambda0(TaskCompletionSource taskCompletionSource) {
            Intrinsics.checkNotNullParameter(taskCompletionSource, "$tcs");
            taskCompletionSource.trySetResult(null);
        }

        /* renamed from: delay$lambda-1  reason: not valid java name */
        public static final void m3608delay$lambda1(ScheduledFuture scheduledFuture, TaskCompletionSource taskCompletionSource) {
            Intrinsics.checkNotNullParameter(taskCompletionSource, "$tcs");
            scheduledFuture.cancel(true);
            taskCompletionSource.trySetCancelled();
        }

        /* renamed from: whenAny$lambda-4  reason: not valid java name */
        public static final Void m3609whenAny$lambda4(AtomicBoolean atomicBoolean, TaskCompletionSource taskCompletionSource, Task task) {
            Intrinsics.checkNotNullParameter(atomicBoolean, "$isAnyTaskComplete");
            Intrinsics.checkNotNullParameter(taskCompletionSource, "$firstCompleted");
            Intrinsics.checkNotNullParameter(task, "it");
            if (atomicBoolean.compareAndSet(false, true)) {
                taskCompletionSource.setResult(task);
                return null;
            }
            task.getError();
            return null;
        }

        /* renamed from: whenAnyResult$lambda-3  reason: not valid java name */
        public static final Void m3610whenAnyResult$lambda3(AtomicBoolean atomicBoolean, TaskCompletionSource taskCompletionSource, Task task) {
            Intrinsics.checkNotNullParameter(atomicBoolean, "$isAnyTaskComplete");
            Intrinsics.checkNotNullParameter(taskCompletionSource, "$firstCompleted");
            Intrinsics.checkNotNullParameter(task, "it");
            if (atomicBoolean.compareAndSet(false, true)) {
                taskCompletionSource.setResult(task);
                return null;
            }
            task.getError();
            return null;
        }

        public final <TResult> Task<TResult> call(Callable<TResult> callable, Executor executor) {
            Intrinsics.checkNotNullParameter(callable, "callable");
            Intrinsics.checkNotNullParameter(executor, "executor");
            return call(callable, executor, (CancellationToken) null);
        }

        public final <TResult> Task<TResult> callInBackground(Callable<TResult> callable) {
            Intrinsics.checkNotNullParameter(callable, "callable");
            return call(callable, Task.BACKGROUND_EXECUTOR, (CancellationToken) null);
        }

        public final <TResult> Task<TResult> cancelled() {
            return Task.TASK_CANCELLED;
        }

        public final Task<Void> delay(long j) {
            return delay$facebook_bolts_release(j, BoltsExecutors.Companion.scheduled$facebook_bolts_release(), (CancellationToken) null);
        }

        public final Task<Void> delay$facebook_bolts_release(long j, ScheduledExecutorService scheduledExecutorService, CancellationToken cancellationToken) {
            Intrinsics.checkNotNullParameter(scheduledExecutorService, "executor");
            if (cancellationToken != null && cancellationToken.isCancellationRequested()) {
                return cancelled();
            }
            if (j <= 0) {
                return forResult((Object) null);
            }
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            ScheduledFuture<?> schedule = scheduledExecutorService.schedule(new Runnable() {
                public final void run() {
                    Task.Companion.m3607delay$lambda0(TaskCompletionSource.this);
                }
            }, j, TimeUnit.MILLISECONDS);
            if (cancellationToken != null) {
                cancellationToken.register(new Runnable(schedule, taskCompletionSource) {
                    public final /* synthetic */ ScheduledFuture f$0;
                    public final /* synthetic */ TaskCompletionSource f$1;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                    }

                    public final void run() {
                        Task.Companion.m3608delay$lambda1(this.f$0, this.f$1);
                    }
                });
            }
            return taskCompletionSource.getTask();
        }

        public final <TResult> Task<TResult> forError(Exception exc) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setError(exc);
            return taskCompletionSource.getTask();
        }

        public final <TResult> Task<TResult> forResult(TResult tresult) {
            if (tresult == null) {
                return Task.TASK_NULL;
            }
            if (tresult instanceof Boolean) {
                return ((Boolean) tresult).booleanValue() ? Task.TASK_TRUE : Task.TASK_FALSE;
            }
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setResult(tresult);
            return taskCompletionSource.getTask();
        }

        public final UnobservedExceptionHandler getUnobservedExceptionHandler() {
            return Task.unobservedExceptionHandler;
        }

        public final void setUnobservedExceptionHandler(UnobservedExceptionHandler unobservedExceptionHandler) {
            Task.unobservedExceptionHandler = unobservedExceptionHandler;
        }

        public final Task<Void> whenAll(Collection<? extends Task<?>> collection) {
            Intrinsics.checkNotNullParameter(collection, "tasks");
            if (collection.isEmpty()) {
                return forResult((Object) null);
            }
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            ArrayList arrayList = new ArrayList();
            ReentrantLock reentrantLock = new ReentrantLock();
            AtomicInteger atomicInteger = new AtomicInteger(collection.size());
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            for (Task continueWith : collection) {
                continueWith.continueWith(new Task$Companion$whenAll$1(reentrantLock, atomicBoolean, atomicInteger, arrayList, taskCompletionSource));
            }
            return taskCompletionSource.getTask();
        }

        public final <TResult> Task<List<TResult>> whenAllResult(Collection<Task<TResult>> collection) {
            Intrinsics.checkNotNullParameter(collection, "tasks");
            return whenAll(collection).onSuccess(new Task$Companion$whenAllResult$1(collection));
        }

        public final Task<Task<?>> whenAny(Collection<? extends Task<?>> collection) {
            Intrinsics.checkNotNullParameter(collection, "tasks");
            if (collection.isEmpty()) {
                return forResult((Object) null);
            }
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            for (Task continueWith : collection) {
                continueWith.continueWith(new Continuation(atomicBoolean, taskCompletionSource) {
                    public final /* synthetic */ AtomicBoolean f$0;
                    public final /* synthetic */ TaskCompletionSource f$1;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                    }

                    public final Object then(Task task) {
                        return Task.Companion.m3609whenAny$lambda4(this.f$0, this.f$1, task);
                    }
                });
            }
            return taskCompletionSource.getTask();
        }

        public final <TResult> Task<Task<TResult>> whenAnyResult(Collection<Task<TResult>> collection) {
            Intrinsics.checkNotNullParameter(collection, "tasks");
            if (collection.isEmpty()) {
                return forResult((Object) null);
            }
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            for (Task<TResult> continueWith : collection) {
                continueWith.continueWith(new Continuation(atomicBoolean, taskCompletionSource) {
                    public final /* synthetic */ AtomicBoolean f$0;
                    public final /* synthetic */ TaskCompletionSource f$1;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                    }

                    public final Object then(Task task) {
                        return Task.Companion.m3610whenAnyResult$lambda3(this.f$0, this.f$1, task);
                    }
                });
            }
            return taskCompletionSource.getTask();
        }

        public final <TResult> Task<TResult> call(Callable<TResult> callable, Executor executor, CancellationToken cancellationToken) {
            Intrinsics.checkNotNullParameter(callable, "callable");
            Intrinsics.checkNotNullParameter(executor, "executor");
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            try {
                executor.execute(new Runnable(taskCompletionSource, callable) {
                    public final /* synthetic */ TaskCompletionSource f$1;
                    public final /* synthetic */ Callable f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        Task.Companion.m3603call$lambda2(CancellationToken.this, this.f$1, this.f$2);
                    }
                });
            } catch (Exception e) {
                taskCompletionSource.setError(new ExecutorException(e));
            }
            return taskCompletionSource.getTask();
        }

        public final <TResult> Task<TResult> callInBackground(Callable<TResult> callable, CancellationToken cancellationToken) {
            Intrinsics.checkNotNullParameter(callable, "callable");
            return call(callable, Task.BACKGROUND_EXECUTOR, cancellationToken);
        }

        public final Task<Void> delay(long j, CancellationToken cancellationToken) {
            return delay$facebook_bolts_release(j, BoltsExecutors.Companion.scheduled$facebook_bolts_release(), cancellationToken);
        }

        public final <TResult> Task<TResult> call(Callable<TResult> callable) {
            Intrinsics.checkNotNullParameter(callable, "callable");
            return call(callable, Task.IMMEDIATE_EXECUTOR, (CancellationToken) null);
        }

        public final <TResult> Task<TResult> call(Callable<TResult> callable, CancellationToken cancellationToken) {
            Intrinsics.checkNotNullParameter(callable, "callable");
            return call(callable, Task.IMMEDIATE_EXECUTOR, cancellationToken);
        }
    }

    /* compiled from: Task.kt */
    public final class TaskCompletionSource extends TaskCompletionSource<TResult> {
        public final /* synthetic */ Task<TResult> this$0;

        public TaskCompletionSource(Task task) {
            Intrinsics.checkNotNullParameter(task, "this$0");
            this.this$0 = task;
        }
    }

    /* compiled from: Task.kt */
    public interface UnobservedExceptionHandler {
        void unobservedException(Task<?> task, UnobservedTaskException unobservedTaskException);
    }

    public Task() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
    }

    public static final <TResult> Task<TResult> call(Callable<TResult> callable) {
        return Companion.call(callable);
    }

    public static final <TResult> Task<TResult> call(Callable<TResult> callable, CancellationToken cancellationToken) {
        return Companion.call(callable, cancellationToken);
    }

    public static final <TResult> Task<TResult> call(Callable<TResult> callable, Executor executor) {
        return Companion.call(callable, executor);
    }

    public static final <TResult> Task<TResult> call(Callable<TResult> callable, Executor executor, CancellationToken cancellationToken) {
        return Companion.call(callable, executor, cancellationToken);
    }

    public static final <TResult> Task<TResult> callInBackground(Callable<TResult> callable) {
        return Companion.callInBackground(callable);
    }

    public static final <TResult> Task<TResult> callInBackground(Callable<TResult> callable, CancellationToken cancellationToken) {
        return Companion.callInBackground(callable, cancellationToken);
    }

    public static final <TResult> Task<TResult> cancelled() {
        return Companion.cancelled();
    }

    public static /* synthetic */ Task continueWhile$default(Task task, Callable callable, Continuation continuation, Executor executor, CancellationToken cancellationToken, int i, Object obj) {
        if ((i & 4) != 0) {
            executor = IMMEDIATE_EXECUTOR;
        }
        if ((i & 8) != 0) {
            cancellationToken = null;
        }
        return task.continueWhile(callable, continuation, executor, cancellationToken);
    }

    /* renamed from: continueWith$lambda-10$lambda-9  reason: not valid java name */
    public static final Void m3598continueWith$lambda10$lambda9(TaskCompletionSource taskCompletionSource, Continuation continuation, Executor executor, CancellationToken cancellationToken, Task task) {
        Intrinsics.checkNotNullParameter(taskCompletionSource, "$tcs");
        Intrinsics.checkNotNullParameter(continuation, "$continuation");
        Intrinsics.checkNotNullParameter(executor, "$executor");
        Intrinsics.checkNotNullParameter(task, Shortcuts.SHORTCUT_SCHEDULED_TASK_KEY);
        Companion.completeImmediately(taskCompletionSource, continuation, task, executor, cancellationToken);
        return null;
    }

    /* renamed from: continueWithTask$lambda-12$lambda-11  reason: not valid java name */
    public static final Void m3599continueWithTask$lambda12$lambda11(TaskCompletionSource taskCompletionSource, Continuation continuation, Executor executor, CancellationToken cancellationToken, Task task) {
        Intrinsics.checkNotNullParameter(taskCompletionSource, "$tcs");
        Intrinsics.checkNotNullParameter(continuation, "$continuation");
        Intrinsics.checkNotNullParameter(executor, "$executor");
        Intrinsics.checkNotNullParameter(task, Shortcuts.SHORTCUT_SCHEDULED_TASK_KEY);
        Companion.completeAfterTask(taskCompletionSource, continuation, task, executor, cancellationToken);
        return null;
    }

    public static final Task<Void> delay(long j) {
        return Companion.delay(j);
    }

    public static final Task<Void> delay(long j, CancellationToken cancellationToken) {
        return Companion.delay(j, cancellationToken);
    }

    public static final Task<Void> delay$facebook_bolts_release(long j, ScheduledExecutorService scheduledExecutorService, CancellationToken cancellationToken) {
        return Companion.delay$facebook_bolts_release(j, scheduledExecutorService, cancellationToken);
    }

    public static final <TResult> Task<TResult> forError(Exception exc) {
        return Companion.forError(exc);
    }

    public static final <TResult> Task<TResult> forResult(TResult tresult) {
        return Companion.forResult(tresult);
    }

    public static final UnobservedExceptionHandler getUnobservedExceptionHandler() {
        return Companion.getUnobservedExceptionHandler();
    }

    /* renamed from: makeVoid$lambda-8  reason: not valid java name */
    public static final Task m3600makeVoid$lambda8(Task task) {
        Intrinsics.checkNotNullParameter(task, Shortcuts.SHORTCUT_SCHEDULED_TASK_KEY);
        if (task.isCancelled()) {
            return Companion.cancelled();
        }
        if (task.isFaulted()) {
            return Companion.forError(task.getError());
        }
        return Companion.forResult(null);
    }

    /* renamed from: onSuccess$lambda-13  reason: not valid java name */
    public static final Task m3601onSuccess$lambda13(CancellationToken cancellationToken, Continuation continuation, Task task) {
        Intrinsics.checkNotNullParameter(continuation, "$continuation");
        Intrinsics.checkNotNullParameter(task, Shortcuts.SHORTCUT_SCHEDULED_TASK_KEY);
        if (cancellationToken != null && cancellationToken.isCancellationRequested()) {
            return Companion.cancelled();
        }
        if (task.isFaulted()) {
            return Companion.forError(task.getError());
        }
        if (task.isCancelled()) {
            return Companion.cancelled();
        }
        return task.continueWith(continuation);
    }

    /* renamed from: onSuccessTask$lambda-14  reason: not valid java name */
    public static final Task m3602onSuccessTask$lambda14(CancellationToken cancellationToken, Continuation continuation, Task task) {
        Intrinsics.checkNotNullParameter(continuation, "$continuation");
        Intrinsics.checkNotNullParameter(task, Shortcuts.SHORTCUT_SCHEDULED_TASK_KEY);
        if (cancellationToken != null && cancellationToken.isCancellationRequested()) {
            return Companion.cancelled();
        }
        if (task.isFaulted()) {
            return Companion.forError(task.getError());
        }
        if (task.isCancelled()) {
            return Companion.cancelled();
        }
        return task.continueWithTask(continuation);
    }

    private final void runContinuations() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            List<Continuation<TResult, Void>> list = this.continuations;
            if (list != null) {
                for (Continuation then : list) {
                    then.then(this);
                }
            }
            this.continuations = null;
            reentrantLock.unlock();
        } catch (RuntimeException e) {
            throw e;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public static final void setUnobservedExceptionHandler(UnobservedExceptionHandler unobservedExceptionHandler2) {
        Companion.setUnobservedExceptionHandler(unobservedExceptionHandler2);
    }

    public static final Task<Void> whenAll(Collection<? extends Task<?>> collection) {
        return Companion.whenAll(collection);
    }

    public static final <TResult> Task<List<TResult>> whenAllResult(Collection<Task<TResult>> collection) {
        return Companion.whenAllResult(collection);
    }

    public static final Task<Task<?>> whenAny(Collection<? extends Task<?>> collection) {
        return Companion.whenAny(collection);
    }

    public static final <TResult> Task<Task<TResult>> whenAnyResult(Collection<Task<TResult>> collection) {
        return Companion.whenAnyResult(collection);
    }

    public final <TOut> Task<TOut> cast() {
        return this;
    }

    public final Task<Void> continueWhile(Callable<Boolean> callable, Continuation<Void, Task<Void>> continuation) {
        Intrinsics.checkNotNullParameter(callable, "predicate");
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        return continueWhile(callable, continuation, IMMEDIATE_EXECUTOR, (CancellationToken) null);
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> continuation, Executor executor) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        Intrinsics.checkNotNullParameter(executor, "executor");
        return continueWith(continuation, executor, (CancellationToken) null);
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> continuation, Executor executor) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        Intrinsics.checkNotNullParameter(executor, "executor");
        return continueWithTask(continuation, executor, (CancellationToken) null);
    }

    public final Exception getError() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.errorField != null) {
                this.errorHasBeenObserved = true;
                UnobservedErrorNotifier unobservedErrorNotifier2 = this.unobservedErrorNotifier;
                if (unobservedErrorNotifier2 != null) {
                    unobservedErrorNotifier2.setObserved();
                    this.unobservedErrorNotifier = null;
                }
            }
            return this.errorField;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final TResult getResult() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.resultField;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean isCancelled() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.cancelledField;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean isCompleted() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.completeField;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean isFaulted() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.errorField != null;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final Task<Void> makeVoid() {
        return continueWithTask($$Lambda$ndlVPrub0oL9djdunBW8rP1h3c.INSTANCE);
    }

    public final <TContinuationResult> Task<TContinuationResult> onSuccess(Continuation<TResult, TContinuationResult> continuation, Executor executor) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        Intrinsics.checkNotNullParameter(executor, "executor");
        return onSuccess(continuation, executor, (CancellationToken) null);
    }

    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(Continuation<TResult, Task<TContinuationResult>> continuation, Executor executor) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        Intrinsics.checkNotNullParameter(executor, "executor");
        return onSuccessTask(continuation, executor, (CancellationToken) null);
    }

    public final boolean trySetCancelled() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.completeField) {
                return false;
            }
            this.completeField = true;
            this.cancelledField = true;
            this.condition.signalAll();
            runContinuations();
            reentrantLock.unlock();
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean trySetError(Exception exc) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.completeField) {
                return false;
            }
            this.completeField = true;
            this.errorField = exc;
            this.errorHasBeenObserved = false;
            this.condition.signalAll();
            runContinuations();
            if (!this.errorHasBeenObserved && unobservedExceptionHandler != null) {
                this.unobservedErrorNotifier = new UnobservedErrorNotifier(this);
            }
            reentrantLock.unlock();
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean trySetResult(TResult tresult) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.completeField) {
                return false;
            }
            this.completeField = true;
            this.resultField = tresult;
            this.condition.signalAll();
            runContinuations();
            reentrantLock.unlock();
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void waitForCompletion() throws InterruptedException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!isCompleted()) {
                this.condition.await();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final Task<Void> continueWhile(Callable<Boolean> callable, Continuation<Void, Task<Void>> continuation, CancellationToken cancellationToken) {
        Intrinsics.checkNotNullParameter(callable, "predicate");
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        return continueWhile(callable, continuation, IMMEDIATE_EXECUTOR, cancellationToken);
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> continuation, Executor executor, CancellationToken cancellationToken) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        Intrinsics.checkNotNullParameter(executor, "executor");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            boolean isCompleted = isCompleted();
            if (!isCompleted) {
                List<Continuation<TResult, Void>> list = this.continuations;
                if (list != null) {
                    list.add(new Continuation(continuation, executor, cancellationToken) {
                        public final /* synthetic */ Continuation f$1;
                        public final /* synthetic */ Executor f$2;
                        public final /* synthetic */ CancellationToken f$3;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                        }

                        public final Object then(Task task) {
                            return Task.m3598continueWith$lambda10$lambda9(TaskCompletionSource.this, this.f$1, this.f$2, this.f$3, task);
                        }
                    });
                }
            }
            if (isCompleted) {
                Companion.completeImmediately(taskCompletionSource, continuation, this, executor, cancellationToken);
            }
            return taskCompletionSource.getTask();
        } finally {
            reentrantLock.unlock();
        }
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> continuation, Executor executor, CancellationToken cancellationToken) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        Intrinsics.checkNotNullParameter(executor, "executor");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            boolean isCompleted = isCompleted();
            if (!isCompleted) {
                List<Continuation<TResult, Void>> list = this.continuations;
                if (list != null) {
                    list.add(new Continuation(continuation, executor, cancellationToken) {
                        public final /* synthetic */ Continuation f$1;
                        public final /* synthetic */ Executor f$2;
                        public final /* synthetic */ CancellationToken f$3;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                        }

                        public final Object then(Task task) {
                            return Task.m3599continueWithTask$lambda12$lambda11(TaskCompletionSource.this, this.f$1, this.f$2, this.f$3, task);
                        }
                    });
                }
            }
            if (isCompleted) {
                Companion.completeAfterTask(taskCompletionSource, continuation, this, executor, cancellationToken);
            }
            return taskCompletionSource.getTask();
        } finally {
            reentrantLock.unlock();
        }
    }

    public final <TContinuationResult> Task<TContinuationResult> onSuccess(Continuation<TResult, TContinuationResult> continuation, Executor executor, CancellationToken cancellationToken) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        Intrinsics.checkNotNullParameter(executor, "executor");
        return continueWithTask(new Continuation(continuation) {
            public final /* synthetic */ Continuation f$1;

            {
                this.f$1 = r2;
            }

            public final Object then(Task task) {
                return Task.m3601onSuccess$lambda13(CancellationToken.this, this.f$1, task);
            }
        }, executor);
    }

    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(Continuation<TResult, Task<TContinuationResult>> continuation, Executor executor, CancellationToken cancellationToken) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        Intrinsics.checkNotNullParameter(executor, "executor");
        return continueWithTask(new Continuation(continuation) {
            public final /* synthetic */ Continuation f$1;

            {
                this.f$1 = r2;
            }

            public final Object then(Task task) {
                return Task.m3602onSuccessTask$lambda14(CancellationToken.this, this.f$1, task);
            }
        }, executor);
    }

    public final Task<Void> continueWhile(Callable<Boolean> callable, Continuation<Void, Task<Void>> continuation, Executor executor, CancellationToken cancellationToken) {
        Intrinsics.checkNotNullParameter(callable, "predicate");
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        Intrinsics.checkNotNullParameter(executor, "executor");
        return makeVoid().continueWithTask(new Task$continueWhile$predicateContinuation$1(cancellationToken, callable, continuation, executor), executor);
    }

    public final <TContinuationResult> Task<TContinuationResult> onSuccess(Continuation<TResult, TContinuationResult> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        return onSuccess(continuation, IMMEDIATE_EXECUTOR, (CancellationToken) null);
    }

    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(Continuation<TResult, Task<TContinuationResult>> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        return onSuccessTask(continuation, IMMEDIATE_EXECUTOR);
    }

    public Task(TResult tresult) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
        trySetResult(tresult);
    }

    public final <TContinuationResult> Task<TContinuationResult> onSuccess(Continuation<TResult, TContinuationResult> continuation, CancellationToken cancellationToken) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        return onSuccess(continuation, IMMEDIATE_EXECUTOR, cancellationToken);
    }

    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(Continuation<TResult, Task<TContinuationResult>> continuation, CancellationToken cancellationToken) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        return onSuccessTask(continuation, IMMEDIATE_EXECUTOR, cancellationToken);
    }

    public final boolean waitForCompletion(long j, TimeUnit timeUnit) throws InterruptedException {
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!isCompleted()) {
                this.condition.await(j, timeUnit);
            }
            return isCompleted();
        } finally {
            reentrantLock.unlock();
        }
    }

    public Task(boolean z) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
        if (z) {
            trySetCancelled();
        } else {
            trySetResult((Object) null);
        }
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        return continueWith(continuation, IMMEDIATE_EXECUTOR, (CancellationToken) null);
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        return continueWithTask(continuation, IMMEDIATE_EXECUTOR, (CancellationToken) null);
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> continuation, CancellationToken cancellationToken) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        return continueWith(continuation, IMMEDIATE_EXECUTOR, cancellationToken);
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> continuation, CancellationToken cancellationToken) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        return continueWithTask(continuation, IMMEDIATE_EXECUTOR, cancellationToken);
    }
}
