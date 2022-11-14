package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
public final class zzt implements Executor {
    public final void execute(@NonNull Runnable runnable) {
        runnable.run();
    }
}
