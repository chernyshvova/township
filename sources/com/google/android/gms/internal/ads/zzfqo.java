package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public interface zzfqo extends ExecutorService {
    zzfqn<?> zza(Runnable runnable);

    <T> zzfqn<T> zzb(Callable<T> callable);
}
