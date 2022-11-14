package com.helpshift.common.domain;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class HSThreadFactory implements ThreadFactory {
    public final String poolName;
    public final AtomicInteger threadNumber = new AtomicInteger(1);

    public HSThreadFactory(String str) {
        this.poolName = str;
    }

    public Thread newThread(Runnable runnable) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("HS-");
        outline24.append(this.poolName);
        outline24.append("-t-");
        outline24.append(this.threadNumber.getAndIncrement());
        return new Thread(runnable, outline24.toString());
    }
}
