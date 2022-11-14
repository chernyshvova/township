package com.applovin.impl.sdk.utils;

import com.applovin.impl.sdk.C1188m;
import com.facebook.appevents.codeless.CodelessMatcher;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.applovin.impl.sdk.utils.n */
public class C1304n {

    /* renamed from: a */
    public final C1188m f2545a;

    /* renamed from: b */
    public Timer f2546b;

    /* renamed from: c */
    public long f2547c;

    /* renamed from: d */
    public long f2548d;

    /* renamed from: e */
    public final Runnable f2549e;

    /* renamed from: f */
    public long f2550f;

    /* renamed from: g */
    public final Object f2551g = new Object();

    public C1304n(C1188m mVar, Runnable runnable) {
        this.f2545a = mVar;
        this.f2549e = runnable;
    }

    /* renamed from: a */
    public static C1304n m2612a(long j, C1188m mVar, Runnable runnable) {
        if (j < 0) {
            throw new IllegalArgumentException("Cannot create a scheduled timer. Invalid fire time passed in: " + j + CodelessMatcher.CURRENT_CLASS_NAME);
        } else if (runnable != null) {
            C1304n nVar = new C1304n(mVar, runnable);
            nVar.f2547c = System.currentTimeMillis();
            nVar.f2548d = j;
            try {
                Timer timer = new Timer();
                nVar.f2546b = timer;
                timer.schedule(nVar.m2617e(), j);
            } catch (OutOfMemoryError e) {
                mVar.mo10922B().mo11373b("Timer", "Failed to create timer due to OOM error", e);
            }
            return nVar;
        } else {
            throw new IllegalArgumentException("Cannot create a scheduled timer. Runnable is null.");
        }
    }

    /* renamed from: e */
    private TimerTask m2617e() {
        return new TimerTask() {
            /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r5 = this;
                    r0 = 0
                    com.applovin.impl.sdk.utils.n r1 = com.applovin.impl.sdk.utils.C1304n.this     // Catch:{ all -> 0x001b }
                    java.lang.Runnable r1 = r1.f2549e     // Catch:{ all -> 0x001b }
                    r1.run()     // Catch:{ all -> 0x001b }
                    com.applovin.impl.sdk.utils.n r1 = com.applovin.impl.sdk.utils.C1304n.this
                    java.lang.Object r1 = r1.f2551g
                    monitor-enter(r1)
                    com.applovin.impl.sdk.utils.n r2 = com.applovin.impl.sdk.utils.C1304n.this     // Catch:{ all -> 0x0018 }
                    java.util.Timer unused = r2.f2546b = r0     // Catch:{ all -> 0x0018 }
                    monitor-exit(r1)     // Catch:{ all -> 0x0018 }
                    goto L_0x0042
                L_0x0018:
                    r0 = move-exception
                    monitor-exit(r1)     // Catch:{ all -> 0x0018 }
                    throw r0
                L_0x001b:
                    r1 = move-exception
                    com.applovin.impl.sdk.utils.n r2 = com.applovin.impl.sdk.utils.C1304n.this     // Catch:{ all -> 0x0046 }
                    com.applovin.impl.sdk.m r2 = r2.f2545a     // Catch:{ all -> 0x0046 }
                    if (r2 == 0) goto L_0x0035
                    com.applovin.impl.sdk.utils.n r2 = com.applovin.impl.sdk.utils.C1304n.this     // Catch:{ all -> 0x0046 }
                    com.applovin.impl.sdk.m r2 = r2.f2545a     // Catch:{ all -> 0x0046 }
                    com.applovin.impl.sdk.v r2 = r2.mo10922B()     // Catch:{ all -> 0x0046 }
                    java.lang.String r3 = "Timer"
                    java.lang.String r4 = "Encountered error while executing timed task"
                    r2.mo11373b(r3, r4, r1)     // Catch:{ all -> 0x0046 }
                L_0x0035:
                    com.applovin.impl.sdk.utils.n r1 = com.applovin.impl.sdk.utils.C1304n.this
                    java.lang.Object r1 = r1.f2551g
                    monitor-enter(r1)
                    com.applovin.impl.sdk.utils.n r2 = com.applovin.impl.sdk.utils.C1304n.this     // Catch:{ all -> 0x0043 }
                    java.util.Timer unused = r2.f2546b = r0     // Catch:{ all -> 0x0043 }
                    monitor-exit(r1)     // Catch:{ all -> 0x0043 }
                L_0x0042:
                    return
                L_0x0043:
                    r0 = move-exception
                    monitor-exit(r1)     // Catch:{ all -> 0x0043 }
                    throw r0
                L_0x0046:
                    r1 = move-exception
                    com.applovin.impl.sdk.utils.n r2 = com.applovin.impl.sdk.utils.C1304n.this
                    java.lang.Object r2 = r2.f2551g
                    monitor-enter(r2)
                    com.applovin.impl.sdk.utils.n r3 = com.applovin.impl.sdk.utils.C1304n.this     // Catch:{ all -> 0x0055 }
                    java.util.Timer unused = r3.f2546b = r0     // Catch:{ all -> 0x0055 }
                    monitor-exit(r2)     // Catch:{ all -> 0x0055 }
                    throw r1
                L_0x0055:
                    r0 = move-exception
                    monitor-exit(r2)     // Catch:{ all -> 0x0055 }
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.utils.C1304n.C13051.run():void");
            }
        };
    }

    /* renamed from: a */
    public long mo11333a() {
        if (this.f2546b == null) {
            return this.f2548d - this.f2550f;
        }
        return this.f2548d - (System.currentTimeMillis() - this.f2547c);
    }

    /* renamed from: b */
    public void mo11334b() {
        synchronized (this.f2551g) {
            if (this.f2546b != null) {
                try {
                    this.f2546b.cancel();
                    this.f2550f = Math.max(1, System.currentTimeMillis() - this.f2547c);
                } catch (Throwable th) {
                    this.f2546b = null;
                    throw th;
                }
                this.f2546b = null;
            }
        }
    }

    /* renamed from: c */
    public void mo11335c() {
        synchronized (this.f2551g) {
            if (this.f2550f > 0) {
                try {
                    long j = this.f2548d - this.f2550f;
                    this.f2548d = j;
                    if (j < 0) {
                        this.f2548d = 0;
                    }
                    Timer timer = new Timer();
                    this.f2546b = timer;
                    timer.schedule(m2617e(), this.f2548d);
                    this.f2547c = System.currentTimeMillis();
                } catch (Throwable th) {
                    this.f2550f = 0;
                    throw th;
                }
                this.f2550f = 0;
            }
        }
    }

    /* renamed from: d */
    public void mo11336d() {
        synchronized (this.f2551g) {
            if (this.f2546b != null) {
                try {
                    this.f2546b.cancel();
                    this.f2546b = null;
                } catch (Throwable th) {
                    this.f2546b = null;
                    this.f2550f = 0;
                    throw th;
                }
                this.f2550f = 0;
            }
        }
    }
}
