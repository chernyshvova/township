package com.google.android.gms.internal.games_v2;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public enum zzfq implements Executor {
    INSTANCE;

    public final void execute(Runnable runnable) {
        runnable.run();
    }

    public final String toString() {
        return "MoreExecutors.directExecutor()";
    }
}
