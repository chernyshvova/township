package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcha extends ScheduledThreadPoolExecutor {
    public zzcha(int i, ThreadFactory threadFactory) {
        super(3, threadFactory);
    }
}
