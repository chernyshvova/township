package com.facebook.bolts;

/* compiled from: Continuation.kt */
public interface Continuation<TTaskResult, TContinuationResult> {
    TContinuationResult then(Task<TTaskResult> task) throws Exception;
}
