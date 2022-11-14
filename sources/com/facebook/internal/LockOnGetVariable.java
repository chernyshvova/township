package com.facebook.internal;

import com.facebook.FacebookSdk;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LockOnGetVariable.kt */
public final class LockOnGetVariable<T> {
    public CountDownLatch initLatch;
    public T storedValue;

    public LockOnGetVariable(T t) {
        this.storedValue = t;
    }

    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final Void m3625_init_$lambda0(LockOnGetVariable lockOnGetVariable, Callable callable) {
        Intrinsics.checkNotNullParameter(lockOnGetVariable, "this$0");
        Intrinsics.checkNotNullParameter(callable, "$callable");
        try {
            lockOnGetVariable.storedValue = callable.call();
        } finally {
            CountDownLatch countDownLatch = lockOnGetVariable.initLatch;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }

    private final void waitOnInit() {
        CountDownLatch countDownLatch = this.initLatch;
        if (countDownLatch != null) {
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
            }
        }
    }

    public final T getValue() {
        waitOnInit();
        return this.storedValue;
    }

    public LockOnGetVariable(Callable<T> callable) {
        Intrinsics.checkNotNullParameter(callable, "callable");
        this.initLatch = new CountDownLatch(1);
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        FacebookSdk.getExecutor().execute(new FutureTask(new Callable(callable) {
            public final /* synthetic */ Callable f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return LockOnGetVariable.m3625_init_$lambda0(LockOnGetVariable.this, this.f$1);
            }
        }));
    }
}
