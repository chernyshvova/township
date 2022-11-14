package com.applovin.impl.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.Nullable;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.p027c.C1084a;
import com.applovin.impl.sdk.utils.C1304n;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.sdk.d */
public class C1090d implements AppLovinBroadcastManager.Receiver {

    /* renamed from: a */
    public C1304n f1850a;

    /* renamed from: b */
    public final Object f1851b = new Object();

    /* renamed from: c */
    public final AtomicBoolean f1852c = new AtomicBoolean();

    /* renamed from: d */
    public boolean f1853d;

    /* renamed from: e */
    public final C1188m f1854e;

    /* renamed from: f */
    public final WeakReference<C1092a> f1855f;

    /* renamed from: g */
    public long f1856g;

    /* renamed from: h */
    public boolean f1857h;

    /* renamed from: com.applovin.impl.sdk.d$a */
    public interface C1092a {
        void onAdRefresh();
    }

    public C1090d(C1188m mVar, C1092a aVar) {
        this.f1855f = new WeakReference<>(aVar);
        this.f1854e = mVar;
    }

    /* renamed from: i */
    private void m1684i() {
        synchronized (this.f1851b) {
            if (this.f1850a != null) {
                this.f1850a.mo11334b();
            } else {
                this.f1854e.mo10922B().mo11372b("AdRefreshManager", "An ad load is in progress. Will pause refresh once the ad finishes loading.");
                this.f1852c.set(true);
            }
        }
    }

    /* renamed from: j */
    private void m1685j() {
        synchronized (this.f1851b) {
            if (this.f1850a != null) {
                this.f1850a.mo11335c();
            } else {
                this.f1852c.set(false);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m1686k() {
        synchronized (this.f1851b) {
            this.f1850a = null;
            if (!((Boolean) this.f1854e.mo10946a(C1084a.f1536s)).booleanValue()) {
                this.f1854e.mo10972aj().unregisterReceiver(this);
            }
        }
    }

    /* renamed from: l */
    private void m1687l() {
        if (((Boolean) this.f1854e.mo10946a(C1084a.f1535r)).booleanValue()) {
            m1684i();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* renamed from: m */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1688m() {
        /*
            r4 = this;
            com.applovin.impl.sdk.m r0 = r4.f1854e
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r1 = com.applovin.impl.sdk.p027c.C1084a.f1535r
            java.lang.Object r0 = r0.mo10946a(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x005f
            java.lang.Object r0 = r4.f1851b
            monitor-enter(r0)
            com.applovin.impl.sdk.m r1 = r4.f1854e     // Catch:{ all -> 0x005c }
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r2 = com.applovin.impl.sdk.p027c.C1084a.f1538u     // Catch:{ all -> 0x005c }
            java.lang.Object r1 = r1.mo10946a(r2)     // Catch:{ all -> 0x005c }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x005c }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x005c }
            if (r1 == 0) goto L_0x0036
            boolean r1 = r4.f1853d     // Catch:{ all -> 0x005c }
            if (r1 == 0) goto L_0x0036
            com.applovin.impl.sdk.m r1 = r4.f1854e     // Catch:{ all -> 0x005c }
            com.applovin.impl.sdk.v r1 = r1.mo10922B()     // Catch:{ all -> 0x005c }
            java.lang.String r2 = "AdRefreshManager"
            java.lang.String r3 = "Fullscreen ad dismissed but banner ad refresh paused by publisher. Waiting for publisher to resume banner ad refresh."
            r1.mo11372b(r2, r3)     // Catch:{ all -> 0x005c }
            monitor-exit(r0)     // Catch:{ all -> 0x005c }
            return
        L_0x0036:
            com.applovin.impl.sdk.m r1 = r4.f1854e     // Catch:{ all -> 0x005c }
            com.applovin.impl.sdk.z r1 = r1.mo10965ac()     // Catch:{ all -> 0x005c }
            boolean r1 = r1.mo11386a()     // Catch:{ all -> 0x005c }
            if (r1 == 0) goto L_0x0051
            com.applovin.impl.sdk.m r1 = r4.f1854e     // Catch:{ all -> 0x005c }
            com.applovin.impl.sdk.v r1 = r1.mo10922B()     // Catch:{ all -> 0x005c }
            java.lang.String r2 = "AdRefreshManager"
            java.lang.String r3 = "Waiting for the application to enter foreground to resume the timer."
            r1.mo11372b(r2, r3)     // Catch:{ all -> 0x005c }
            monitor-exit(r0)     // Catch:{ all -> 0x005c }
            return
        L_0x0051:
            com.applovin.impl.sdk.utils.n r1 = r4.f1850a     // Catch:{ all -> 0x005c }
            if (r1 == 0) goto L_0x005a
            com.applovin.impl.sdk.utils.n r1 = r4.f1850a     // Catch:{ all -> 0x005c }
            r1.mo11335c()     // Catch:{ all -> 0x005c }
        L_0x005a:
            monitor-exit(r0)     // Catch:{ all -> 0x005c }
            goto L_0x005f
        L_0x005c:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005c }
            throw r1
        L_0x005f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1090d.m1688m():void");
    }

    /* renamed from: a */
    public void mo10699a(long j) {
        synchronized (this.f1851b) {
            mo10703c();
            this.f1856g = j;
            this.f1850a = C1304n.m2612a(j, this.f1854e, new Runnable() {
                public void run() {
                    C1090d.this.m1686k();
                    C1092a aVar = (C1092a) C1090d.this.f1855f.get();
                    if (aVar != null) {
                        aVar.onAdRefresh();
                    }
                }
            });
            if (!((Boolean) this.f1854e.mo10946a(C1084a.f1536s)).booleanValue()) {
                this.f1854e.mo10972aj().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
                this.f1854e.mo10972aj().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
                this.f1854e.mo10972aj().registerReceiver(this, new IntentFilter("com.applovin.fullscreen_ad_displayed"));
                this.f1854e.mo10972aj().registerReceiver(this, new IntentFilter("com.applovin.fullscreen_ad_hidden"));
            }
            if (((Boolean) this.f1854e.mo10946a(C1084a.f1535r)).booleanValue() && (this.f1854e.mo10966ad().mo11252b() || this.f1854e.mo10965ac().mo11386a())) {
                this.f1850a.mo11334b();
            }
            if (this.f1852c.compareAndSet(true, false) && ((Boolean) this.f1854e.mo10946a(C1084a.f1539v)).booleanValue()) {
                this.f1854e.mo10922B().mo11372b("AdRefreshManager", "Pausing refresh for a previous request.");
                this.f1850a.mo11334b();
            }
        }
    }

    /* renamed from: a */
    public void mo10700a(boolean z) {
        this.f1857h = z;
    }

    /* renamed from: a */
    public boolean mo10701a() {
        boolean z;
        synchronized (this.f1851b) {
            z = this.f1850a != null;
        }
        return z;
    }

    /* renamed from: b */
    public long mo10702b() {
        long a;
        synchronized (this.f1851b) {
            a = this.f1850a != null ? this.f1850a.mo11333a() : -1;
        }
        return a;
    }

    /* renamed from: c */
    public void mo10703c() {
        synchronized (this.f1851b) {
            if (this.f1850a != null) {
                this.f1850a.mo11336d();
                m1686k();
            }
        }
    }

    /* renamed from: d */
    public void mo10704d() {
        synchronized (this.f1851b) {
            m1684i();
            this.f1853d = true;
        }
    }

    /* renamed from: e */
    public void mo10705e() {
        synchronized (this.f1851b) {
            m1685j();
            this.f1853d = false;
        }
    }

    /* renamed from: f */
    public boolean mo10706f() {
        return this.f1853d;
    }

    /* renamed from: g */
    public void mo10707g() {
        if (((Boolean) this.f1854e.mo10946a(C1084a.f1534q)).booleanValue()) {
            m1684i();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0085, code lost:
        if (r2 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0087, code lost:
        r0 = (com.applovin.impl.sdk.C1090d.C1092a) r9.f1855f.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008f, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0091, code lost:
        r0.onAdRefresh();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return;
     */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo10708h() {
        /*
            r9 = this;
            com.applovin.impl.sdk.m r0 = r9.f1854e
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r1 = com.applovin.impl.sdk.p027c.C1084a.f1534q
            java.lang.Object r0 = r0.mo10946a(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0098
            java.lang.Object r0 = r9.f1851b
            monitor-enter(r0)
            boolean r1 = r9.f1857h     // Catch:{ all -> 0x0095 }
            if (r1 != 0) goto L_0x0027
            com.applovin.impl.sdk.m r1 = r9.f1854e     // Catch:{ all -> 0x0095 }
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r2 = com.applovin.impl.sdk.p027c.C1084a.f1537t     // Catch:{ all -> 0x0095 }
            java.lang.Object r1 = r1.mo10946a(r2)     // Catch:{ all -> 0x0095 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x0095 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x0095 }
            if (r1 == 0) goto L_0x003a
        L_0x0027:
            boolean r1 = r9.f1853d     // Catch:{ all -> 0x0095 }
            if (r1 == 0) goto L_0x003a
            com.applovin.impl.sdk.m r1 = r9.f1854e     // Catch:{ all -> 0x0095 }
            com.applovin.impl.sdk.v r1 = r1.mo10922B()     // Catch:{ all -> 0x0095 }
            java.lang.String r2 = "AdRefreshManager"
            java.lang.String r3 = "Application resumed but banner ad refresh paused by publisher. Waiting for publisher to resume banner ad refresh."
            r1.mo11372b(r2, r3)     // Catch:{ all -> 0x0095 }
            monitor-exit(r0)     // Catch:{ all -> 0x0095 }
            return
        L_0x003a:
            com.applovin.impl.sdk.m r1 = r9.f1854e     // Catch:{ all -> 0x0095 }
            com.applovin.impl.sdk.s r1 = r1.mo10966ad()     // Catch:{ all -> 0x0095 }
            boolean r1 = r1.mo11252b()     // Catch:{ all -> 0x0095 }
            if (r1 == 0) goto L_0x0055
            com.applovin.impl.sdk.m r1 = r9.f1854e     // Catch:{ all -> 0x0095 }
            com.applovin.impl.sdk.v r1 = r1.mo10922B()     // Catch:{ all -> 0x0095 }
            java.lang.String r2 = "AdRefreshManager"
            java.lang.String r3 = "Waiting for the full screen ad to be dismissed to resume the timer."
            r1.mo11372b(r2, r3)     // Catch:{ all -> 0x0095 }
            monitor-exit(r0)     // Catch:{ all -> 0x0095 }
            return
        L_0x0055:
            com.applovin.impl.sdk.utils.n r1 = r9.f1850a     // Catch:{ all -> 0x0095 }
            r2 = 0
            if (r1 == 0) goto L_0x0084
            long r3 = r9.f1856g     // Catch:{ all -> 0x0095 }
            long r5 = r9.mo10702b()     // Catch:{ all -> 0x0095 }
            long r3 = r3 - r5
            com.applovin.impl.sdk.m r1 = r9.f1854e     // Catch:{ all -> 0x0095 }
            com.applovin.impl.sdk.c.b<java.lang.Long> r5 = com.applovin.impl.sdk.p027c.C1084a.f1533p     // Catch:{ all -> 0x0095 }
            java.lang.Object r1 = r1.mo10946a(r5)     // Catch:{ all -> 0x0095 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ all -> 0x0095 }
            long r5 = r1.longValue()     // Catch:{ all -> 0x0095 }
            r7 = 0
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 < 0) goto L_0x007f
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x007f
            r9.mo10703c()     // Catch:{ all -> 0x0095 }
            r1 = 1
            r2 = 1
            goto L_0x0084
        L_0x007f:
            com.applovin.impl.sdk.utils.n r1 = r9.f1850a     // Catch:{ all -> 0x0095 }
            r1.mo11335c()     // Catch:{ all -> 0x0095 }
        L_0x0084:
            monitor-exit(r0)     // Catch:{ all -> 0x0095 }
            if (r2 == 0) goto L_0x0098
            java.lang.ref.WeakReference<com.applovin.impl.sdk.d$a> r0 = r9.f1855f
            java.lang.Object r0 = r0.get()
            com.applovin.impl.sdk.d$a r0 = (com.applovin.impl.sdk.C1090d.C1092a) r0
            if (r0 == 0) goto L_0x0098
            r0.onAdRefresh()
            goto L_0x0098
        L_0x0095:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0095 }
            throw r1
        L_0x0098:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1090d.mo10708h():void");
    }

    public void onReceive(Context context, Intent intent, @Nullable Map<String, Object> map) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            mo10707g();
        } else if ("com.applovin.application_resumed".equals(action)) {
            mo10708h();
        } else if ("com.applovin.fullscreen_ad_displayed".equals(action)) {
            m1687l();
        } else if ("com.applovin.fullscreen_ad_hidden".equals(action)) {
            m1688m();
        }
    }
}
