package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfbk implements ThreadFactory {
    public final AtomicInteger zza = new AtomicInteger(1);

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, GeneratedOutlineSupport.outline9(25, "AdWorker(NG) #", this.zza.getAndIncrement()));
    }
}
