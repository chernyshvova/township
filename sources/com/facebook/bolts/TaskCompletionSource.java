package com.facebook.bolts;

/* compiled from: TaskCompletionSource.kt */
public class TaskCompletionSource<TResult> {
    public final Task<TResult> task = new Task<>();

    public final Task<TResult> getTask() {
        return this.task;
    }

    public final void setCancelled() {
        if (!trySetCancelled()) {
            throw new IllegalStateException("Cannot cancel a completed task.".toString());
        }
    }

    public final void setError(Exception exc) {
        if (!trySetError(exc)) {
            throw new IllegalStateException("Cannot set the error on a completed task.".toString());
        }
    }

    public final void setResult(TResult tresult) {
        if (!trySetResult(tresult)) {
            throw new IllegalStateException("Cannot set the result of a completed task.".toString());
        }
    }

    public final boolean trySetCancelled() {
        return this.task.trySetCancelled();
    }

    public final boolean trySetError(Exception exc) {
        return this.task.trySetError(exc);
    }

    public final boolean trySetResult(TResult tresult) {
        return this.task.trySetResult(tresult);
    }
}
