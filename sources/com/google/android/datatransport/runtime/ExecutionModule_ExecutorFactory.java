package com.google.android.datatransport.runtime;

import com.android.billingclient.api.zzam;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class ExecutionModule_ExecutorFactory implements Object<Executor> {
    public static final ExecutionModule_ExecutorFactory INSTANCE = new ExecutionModule_ExecutorFactory();

    public Object get() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        zzam.checkNotNull1(newSingleThreadExecutor, "Cannot return null from a non-@Nullable @Provides method");
        return newSingleThreadExecutor;
    }
}
