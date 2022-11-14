package com.google.android.play.core.tasks;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.tasks.l */
public final class C2352l implements Executor {

    /* renamed from: a */
    public final Handler f3303a = new Handler(Looper.getMainLooper());

    public final void execute(Runnable runnable) {
        this.f3303a.post(runnable);
    }
}
