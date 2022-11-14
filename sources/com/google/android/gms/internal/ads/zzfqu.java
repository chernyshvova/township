package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfqu {
    public static Executor zza() {
        return zzfps.INSTANCE;
    }

    public static zzfqo zzb(ExecutorService executorService) {
        zzfqo zzfqo;
        if (executorService instanceof zzfqo) {
            return (zzfqo) executorService;
        }
        if (executorService instanceof ScheduledExecutorService) {
            zzfqo = new zzfqt((ScheduledExecutorService) executorService);
        } else {
            zzfqo = new zzfqq(executorService);
        }
        return zzfqo;
    }

    public static Executor zzc(Executor executor, zzfox<?> zzfox) {
        if (executor == null) {
            throw null;
        } else if (executor == zzfps.INSTANCE) {
            return executor;
        } else {
            return new zzfqp(executor, zzfox);
        }
    }
}
