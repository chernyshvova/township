package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzfjh implements zzfjf {
    public zzfjh() {
    }

    public /* synthetic */ zzfjh(zzfjg zzfjg) {
    }

    public final ExecutorService zza(int i, ThreadFactory threadFactory, int i2) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService(threadPoolExecutor);
    }

    public final ExecutorService zzb(int i) {
        return zza(1, Executors.defaultThreadFactory(), 2);
    }

    public final ExecutorService zzc(ThreadFactory threadFactory, int i) {
        return zza(1, threadFactory, 1);
    }
}
