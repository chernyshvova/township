package com.applovin.impl.sdk.p029e;

import com.applovin.impl.sdk.C1188m;

/* renamed from: com.applovin.impl.sdk.e.z */
public class C1166z extends C1109a {

    /* renamed from: a */
    public final Runnable f2098a;

    public C1166z(C1188m mVar, Runnable runnable) {
        this(mVar, false, runnable);
    }

    public C1166z(C1188m mVar, boolean z, Runnable runnable) {
        super("TaskRunnable", mVar, z);
        this.f2098a = runnable;
    }

    public void run() {
        this.f2098a.run();
    }
}
