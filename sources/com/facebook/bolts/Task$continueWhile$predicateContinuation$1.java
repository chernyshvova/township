package com.facebook.bolts;

import com.playrix.engine.Shortcuts;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Task.kt */
public final class Task$continueWhile$predicateContinuation$1 implements Continuation<Void, Task<Void>> {
    public final /* synthetic */ Continuation<Void, Task<Void>> $continuation;
    public final /* synthetic */ CancellationToken $ct;
    public final /* synthetic */ Executor $executor;
    public final /* synthetic */ Callable<Boolean> $predicate;

    public Task$continueWhile$predicateContinuation$1(CancellationToken cancellationToken, Callable<Boolean> callable, Continuation<Void, Task<Void>> continuation, Executor executor) {
        this.$ct = cancellationToken;
        this.$predicate = callable;
        this.$continuation = continuation;
        this.$executor = executor;
    }

    public Task<Void> then(Task<Void> task) throws Exception {
        Intrinsics.checkNotNullParameter(task, Shortcuts.SHORTCUT_SCHEDULED_TASK_KEY);
        CancellationToken cancellationToken = this.$ct;
        if (cancellationToken != null && cancellationToken.isCancellationRequested()) {
            return Task.Companion.cancelled();
        }
        Boolean call = this.$predicate.call();
        Intrinsics.checkNotNullExpressionValue(call, "predicate.call()");
        if (call.booleanValue()) {
            return Task.Companion.forResult(null).onSuccessTask(this.$continuation, this.$executor).onSuccessTask(this, this.$executor);
        }
        return Task.Companion.forResult(null);
    }
}
