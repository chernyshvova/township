package com.applovin.impl.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserModel;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.mediation.p010a.C0801a;
import com.applovin.impl.p007a.C0631a;
import com.applovin.impl.sdk.p025ad.C1057e;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.utils.C1260e;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdk;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.applovin.impl.sdk.p */
public class C1243p {

    /* renamed from: a */
    public static final AtomicBoolean f2388a = new AtomicBoolean();

    /* renamed from: b */
    public static final Lock f2389b = new ReentrantLock();

    /* renamed from: c */
    public static Runnable f2390c;

    /* renamed from: d */
    public static Thread f2391d;

    /* renamed from: e */
    public final Map<Integer, Thread> f2392e = new HashMap();

    /* renamed from: f */
    public final Object f2393f = new Object();

    /* renamed from: g */
    public final C1188m f2394g;

    /* renamed from: h */
    public final Runnable f2395h;

    /* renamed from: i */
    public C1260e f2396i = null;

    /* renamed from: j */
    public final Map<Integer, String> f2397j = new HashMap();

    /* renamed from: k */
    public final Map<Integer, String> f2398k = new HashMap();

    public C1243p(C1188m mVar) {
        this.f2394g = mVar;
        this.f2395h = new Runnable() {
            public void run() {
                C1260e unused = C1243p.this.f2396i = null;
                C1243p.this.mo11227b();
            }
        };
    }

    /* renamed from: a */
    public static Thread m2426a(String str) {
        Thread thread = new Thread(f2390c, str);
        thread.setDaemon(true);
        return thread;
    }

    /* renamed from: a */
    public static void m2427a() {
        if (f2388a.compareAndSet(false, true)) {
            f2389b.lock();
            f2390c = new Runnable() {
                public void run() {
                    try {
                        C1243p.f2389b.lockInterruptibly();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            };
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("ALDEBUG-");
            outline24.append(AppLovinSdk.VERSION);
            Thread a = m2426a(outline24.toString());
            f2391d = a;
            a.start();
        }
    }

    @Nullable
    /* renamed from: c */
    private String m2428c(Object obj) {
        if (!(obj instanceof C0801a)) {
            return null;
        }
        C0801a aVar = (C0801a) obj;
        if ("APPLOVIN".equals(aVar.mo9899Q())) {
            return null;
        }
        StringBuilder sb = new StringBuilder(aVar.mo9899Q());
        sb.append("/");
        sb.append(aVar.getFormat().getLabel());
        String creativeId = aVar.getCreativeId();
        if (StringUtils.isValidString(creativeId)) {
            sb.append("/");
            sb.append(creativeId);
        }
        return sb.toString();
    }

    @Nullable
    /* renamed from: d */
    private String m2430d(Object obj) {
        if (!(obj instanceof C1057e)) {
            return null;
        }
        C1057e eVar = (C1057e) obj;
        StringBuilder sb = new StringBuilder("AL/");
        sb.append(eVar.getSize().getLabel());
        sb.append("/");
        sb.append(eVar.getAdIdNumber());
        if (eVar instanceof C0631a) {
            sb.append("/VAST/");
            sb.append(((C0631a) eVar).mo9328l().mo9385a());
        }
        if (StringUtils.isValidString(eVar.getDspName())) {
            sb.append("/DSP/");
            sb.append(eVar.getDspName());
        }
        return sb.toString();
    }

    /* renamed from: d */
    private void m2431d() {
        Context L = this.f2394g.mo10932L();
        StringBuilder sb = new StringBuilder("ALDEBUG-");
        sb.append(AppLovinSdk.VERSION);
        try {
            PackageInfo packageInfo = L.getPackageManager().getPackageInfo("com.google.android.webview", 0);
            sb.append("-");
            sb.append(packageInfo.versionName);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        ActivityManager activityManager = (ActivityManager) L.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (activityManager != null) {
            activityManager.getMemoryInfo(memoryInfo);
            sb.append("-");
            sb.append(memoryInfo.availMem / 1000000);
            sb.append("MB");
            sb.append("/");
            sb.append(memoryInfo.totalMem / 1000000);
            sb.append("MB");
            sb.append("(");
            sb.append(memoryInfo.lowMemory);
            sb.append(")");
        }
        Map<String, Object> b = this.f2394g.mo10941V().mo11207b();
        if (b.containsKey("gms_mb")) {
            sb.append("-GMS-");
            sb.append(b.get("gms_mb"));
            sb.append("MB");
        }
        for (Integer intValue : this.f2397j.keySet()) {
            int intValue2 = intValue.intValue();
            sb.append("-");
            sb.append(this.f2397j.get(Integer.valueOf(intValue2)));
        }
        for (Integer intValue3 : this.f2398k.keySet()) {
            int intValue4 = intValue3.intValue();
            sb.append("-");
            sb.append(this.f2398k.get(Integer.valueOf(intValue4)));
        }
        String sb2 = sb.toString();
        Thread thread = f2391d;
        if (thread == null) {
            Thread a = m2426a(sb2);
            f2391d = a;
            a.start();
            return;
        }
        thread.setName(sb2);
    }

    @Nullable
    /* renamed from: e */
    private String m2432e(Object obj) {
        if (obj instanceof C0801a) {
            C0801a aVar = (C0801a) obj;
            StringBuilder sb = new StringBuilder("MAX-");
            sb.append(AppLovinSdk.VERSION);
            sb.append("-");
            sb.append(aVar.getFormat().getLabel());
            sb.append("-");
            sb.append(aVar.mo9899Q());
            if (StringUtils.isValidString(aVar.getCreativeId())) {
                sb.append("-");
                sb.append(aVar.getCreativeId());
            }
            return sb.toString();
        } else if (!(obj instanceof C1057e)) {
            return null;
        } else {
            C1057e eVar = (C1057e) obj;
            String label = eVar.getAdZone().mo10549b() != null ? eVar.getAdZone().mo10549b().getLabel() : "NULL";
            StringBuilder sb2 = new StringBuilder("AL-");
            GeneratedOutlineSupport.outline34(sb2, AppLovinSdk.VERSION, "-", label, "-");
            sb2.append(eVar.getAdIdNumber());
            if (eVar instanceof C0631a) {
                sb2.append("-VAST-");
                sb2.append(((C0631a) eVar).mo9328l().mo9385a());
            }
            if (StringUtils.isValidString(eVar.getDspName())) {
                sb2.append("-DSP-");
                sb2.append(eVar.getDspName());
            }
            return sb2.toString();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0075, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo11226a(java.lang.Object r7) {
        /*
            r6 = this;
            com.applovin.impl.sdk.m r0 = r6.f2394g
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r1 = com.applovin.impl.sdk.p027c.C1085b.f1721dV
            java.lang.Object r0 = r0.mo10946a(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0079
            if (r7 != 0) goto L_0x0013
            goto L_0x0079
        L_0x0013:
            int r0 = java.lang.System.identityHashCode(r7)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Object r1 = r6.f2393f
            monitor-enter(r1)
            java.util.Map<java.lang.Integer, java.lang.Thread> r2 = r6.f2392e     // Catch:{ all -> 0x0076 }
            boolean r2 = r2.containsKey(r0)     // Catch:{ all -> 0x0076 }
            if (r2 != 0) goto L_0x0074
            java.lang.String r2 = r6.m2432e(r7)     // Catch:{ all -> 0x0076 }
            if (r2 != 0) goto L_0x002e
            monitor-exit(r1)     // Catch:{ all -> 0x0076 }
            return
        L_0x002e:
            java.lang.String r3 = r6.m2428c(r7)     // Catch:{ all -> 0x0076 }
            boolean r4 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r3)     // Catch:{ all -> 0x0076 }
            if (r4 == 0) goto L_0x003d
            java.util.Map<java.lang.Integer, java.lang.String> r4 = r6.f2397j     // Catch:{ all -> 0x0076 }
            r4.put(r0, r3)     // Catch:{ all -> 0x0076 }
        L_0x003d:
            java.lang.String r7 = r6.m2430d(r7)     // Catch:{ all -> 0x0076 }
            boolean r3 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r7)     // Catch:{ all -> 0x0076 }
            if (r3 == 0) goto L_0x004c
            java.util.Map<java.lang.Integer, java.lang.String> r3 = r6.f2398k     // Catch:{ all -> 0x0076 }
            r3.put(r0, r7)     // Catch:{ all -> 0x0076 }
        L_0x004c:
            com.applovin.impl.sdk.m r7 = r6.f2394g     // Catch:{ all -> 0x0076 }
            com.applovin.impl.sdk.v r7 = r7.mo10922B()     // Catch:{ all -> 0x0076 }
            java.lang.String r3 = "AppLovinSdk"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0076 }
            r4.<init>()     // Catch:{ all -> 0x0076 }
            java.lang.String r5 = "Creating ad debug thread with name: "
            r4.append(r5)     // Catch:{ all -> 0x0076 }
            r4.append(r2)     // Catch:{ all -> 0x0076 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0076 }
            r7.mo11372b(r3, r4)     // Catch:{ all -> 0x0076 }
            java.lang.Thread r7 = m2426a((java.lang.String) r2)     // Catch:{ all -> 0x0076 }
            r7.start()     // Catch:{ all -> 0x0076 }
            java.util.Map<java.lang.Integer, java.lang.Thread> r2 = r6.f2392e     // Catch:{ all -> 0x0076 }
            r2.put(r0, r7)     // Catch:{ all -> 0x0076 }
        L_0x0074:
            monitor-exit(r1)     // Catch:{ all -> 0x0076 }
            return
        L_0x0076:
            r7 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0076 }
            throw r7
        L_0x0079:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1243p.mo11226a(java.lang.Object):void");
    }

    /* renamed from: b */
    public void mo11227b() {
        if (((Boolean) this.f2394g.mo10946a(C1085b.f1721dV)).booleanValue() && !this.f2394g.mo10988e()) {
            long longValue = ((Long) this.f2394g.mo10946a(C1085b.f1723dX)).longValue();
            if (longValue > 0 && this.f2396i == null) {
                m2431d();
                this.f2396i = C1260e.m2499a(longValue, this.f2394g, this.f2395h);
            }
        }
    }

    /* renamed from: b */
    public void mo11228b(Object obj) {
        if (((Boolean) this.f2394g.mo10946a(C1085b.f1721dV)).booleanValue() && obj != null) {
            Integer valueOf = Integer.valueOf(System.identityHashCode(obj));
            synchronized (this.f2393f) {
                Thread thread = this.f2392e.get(valueOf);
                if (thread != null) {
                    C1314v B = this.f2394g.mo10922B();
                    B.mo11372b(AppLovinSdk.TAG, "Destroying ad debug thread with name: " + thread.getName());
                    thread.interrupt();
                    this.f2392e.remove(valueOf);
                    this.f2397j.remove(valueOf);
                    this.f2398k.remove(valueOf);
                }
            }
        }
    }
}
