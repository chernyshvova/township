package com.google.firebase.iid;

import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
public final /* synthetic */ class FirebaseInstanceId$$Lambda$1 implements Executor {
    public static final Executor $instance = new FirebaseInstanceId$$Lambda$1();

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
