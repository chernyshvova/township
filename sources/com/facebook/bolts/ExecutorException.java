package com.facebook.bolts;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExecutorException.kt */
public final class ExecutorException extends RuntimeException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExecutorException(Exception exc) {
        super("An exception was thrown by an Executor", exc);
        Intrinsics.checkNotNullParameter(exc, "e");
    }
}
