package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcey implements ThreadFactory {
    public final AtomicInteger zza = new AtomicInteger(1);

    public zzcey(zzcfb zzcfb) {
    }

    public final Thread newThread(@NonNull Runnable runnable) {
        return new Thread(runnable, GeneratedOutlineSupport.outline9(42, "AdWorker(SCION_TASK_EXECUTOR) #", this.zza.getAndIncrement()));
    }
}
