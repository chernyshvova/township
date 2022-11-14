package com.applovin.impl.sdk.network;

import android.content.SharedPreferences;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.p027c.C1087d;
import com.applovin.impl.sdk.p029e.C1109a;
import com.applovin.impl.sdk.p029e.C1140o;
import com.applovin.impl.sdk.p029e.C1166z;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinPostbackListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.network.f */
public class C1222f {

    /* renamed from: a */
    public final C1188m f2321a;

    /* renamed from: b */
    public final C1314v f2322b;

    /* renamed from: c */
    public final SharedPreferences f2323c;

    /* renamed from: d */
    public final Object f2324d = new Object();

    /* renamed from: e */
    public final ArrayList<C1226g> f2325e;

    /* renamed from: f */
    public final ArrayList<C1226g> f2326f = new ArrayList<>();

    /* renamed from: g */
    public final Set<C1226g> f2327g = new HashSet();

    public C1222f(C1188m mVar) {
        if (mVar != null) {
            this.f2321a = mVar;
            this.f2322b = mVar.mo10922B();
            this.f2323c = mVar.mo10932L().getSharedPreferences("com.applovin.sdk.impl.postbackQueue.domain", 0);
            this.f2325e = m2274b();
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005a, code lost:
        r0 = ((java.lang.Integer) r4.f2321a.mo10946a(com.applovin.impl.sdk.p027c.C1085b.f1661cN)).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006c, code lost:
        if (r5.mo11162k() <= r0) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006e, code lost:
        r6 = r4.f2322b;
        r6.mo11375d("PersistentPostbackManager", "Exceeded maximum persisted attempt count of " + r0 + ". Dequeuing postback: " + r5);
        m2284d(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0093, code lost:
        r1 = r4.f2324d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0095, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r4.f2327g.add(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x009b, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a0, code lost:
        if (r5.mo11156f() == null) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a2, code lost:
        r0 = new org.json.JSONObject(r5.mo11156f());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00ac, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ad, code lost:
        r4.f2321a.mo10943X().dispatchPostbackRequest(com.applovin.impl.sdk.network.C1229h.m2326b(r4.f2321a).mo11186d(r5.mo11151b()).mo11189e(r5.mo11152c()).mo11184c(r5.mo11153d()).mo11191f(r5.mo11150a()).mo11187d(r5.mo11154e()).mo11182b(r0).mo11194g(r5.mo11158h()).mo11192f(r5.mo11157g()).mo11195h(r5.mo11160i()).mo11193g(r5.mo11161j()).mo11183b(), new com.applovin.impl.sdk.network.C1222f.C12242(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m2272a(final com.applovin.impl.sdk.network.C1226g r5, final com.applovin.sdk.AppLovinPostbackListener r6) {
        /*
            r4 = this;
            com.applovin.impl.sdk.v r0 = r4.f2322b
            java.lang.String r1 = "PersistentPostbackManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Preparing to submit postback..."
            r2.append(r3)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            r0.mo11372b(r1, r2)
            com.applovin.impl.sdk.m r0 = r4.f2321a
            boolean r0 = r0.mo10986c()
            if (r0 == 0) goto L_0x002a
            com.applovin.impl.sdk.v r5 = r4.f2322b
            java.lang.String r6 = "PersistentPostbackManager"
            java.lang.String r0 = "Skipping postback dispatch because SDK is still initializing - postback will be dispatched afterwards"
            r5.mo11372b(r6, r0)
            return
        L_0x002a:
            java.lang.Object r0 = r4.f2324d
            monitor-enter(r0)
            java.util.Set<com.applovin.impl.sdk.network.g> r1 = r4.f2327g     // Catch:{ all -> 0x0115 }
            boolean r1 = r1.contains(r5)     // Catch:{ all -> 0x0115 }
            if (r1 == 0) goto L_0x0053
            com.applovin.impl.sdk.v r6 = r4.f2322b     // Catch:{ all -> 0x0115 }
            java.lang.String r1 = "PersistentPostbackManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0115 }
            r2.<init>()     // Catch:{ all -> 0x0115 }
            java.lang.String r3 = "Skip pending postback: "
            r2.append(r3)     // Catch:{ all -> 0x0115 }
            java.lang.String r5 = r5.mo11151b()     // Catch:{ all -> 0x0115 }
            r2.append(r5)     // Catch:{ all -> 0x0115 }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x0115 }
            r6.mo11372b(r1, r5)     // Catch:{ all -> 0x0115 }
            monitor-exit(r0)     // Catch:{ all -> 0x0115 }
            return
        L_0x0053:
            r5.mo11163l()     // Catch:{ all -> 0x0115 }
            r4.m2277c()     // Catch:{ all -> 0x0115 }
            monitor-exit(r0)     // Catch:{ all -> 0x0115 }
            com.applovin.impl.sdk.m r0 = r4.f2321a
            com.applovin.impl.sdk.c.b<java.lang.Integer> r1 = com.applovin.impl.sdk.p027c.C1085b.f1661cN
            java.lang.Object r0 = r0.mo10946a(r1)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            int r1 = r5.mo11162k()
            if (r1 <= r0) goto L_0x0093
            com.applovin.impl.sdk.v r6 = r4.f2322b
            java.lang.String r1 = "PersistentPostbackManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Exceeded maximum persisted attempt count of "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = ". Dequeuing postback: "
            r2.append(r0)
            r2.append(r5)
            java.lang.String r0 = r2.toString()
            r6.mo11375d(r1, r0)
            r4.m2284d((com.applovin.impl.sdk.network.C1226g) r5)
            goto L_0x0111
        L_0x0093:
            java.lang.Object r1 = r4.f2324d
            monitor-enter(r1)
            java.util.Set<com.applovin.impl.sdk.network.g> r0 = r4.f2327g     // Catch:{ all -> 0x0112 }
            r0.add(r5)     // Catch:{ all -> 0x0112 }
            monitor-exit(r1)     // Catch:{ all -> 0x0112 }
            java.util.Map r0 = r5.mo11156f()
            if (r0 == 0) goto L_0x00ac
            org.json.JSONObject r0 = new org.json.JSONObject
            java.util.Map r1 = r5.mo11156f()
            r0.<init>(r1)
            goto L_0x00ad
        L_0x00ac:
            r0 = 0
        L_0x00ad:
            com.applovin.impl.sdk.m r1 = r4.f2321a
            com.applovin.impl.sdk.network.h$a r1 = com.applovin.impl.sdk.network.C1229h.m2326b(r1)
            java.lang.String r2 = r5.mo11151b()
            com.applovin.impl.sdk.network.h$a r1 = r1.mo11127a((java.lang.String) r2)
            java.lang.String r2 = r5.mo11152c()
            com.applovin.impl.sdk.network.h$a r1 = r1.mo11137c((java.lang.String) r2)
            java.util.Map r2 = r5.mo11153d()
            com.applovin.impl.sdk.network.h$a r1 = r1.mo11128a((java.util.Map<java.lang.String, java.lang.String>) r2)
            java.lang.String r2 = r5.mo11150a()
            com.applovin.impl.sdk.network.h$a r1 = r1.mo11133b((java.lang.String) r2)
            java.util.Map r2 = r5.mo11154e()
            com.applovin.impl.sdk.network.h$a r1 = r1.mo11134b((java.util.Map<java.lang.String, java.lang.String>) r2)
            com.applovin.impl.sdk.network.h$a r0 = r1.mo11129a((org.json.JSONObject) r0)
            boolean r1 = r5.mo11158h()
            com.applovin.impl.sdk.network.h$a r0 = r0.mo11139d((boolean) r1)
            boolean r1 = r5.mo11157g()
            com.applovin.impl.sdk.network.h$a r0 = r0.mo11138c((boolean) r1)
            boolean r1 = r5.mo11160i()
            com.applovin.impl.sdk.network.h$a r0 = r0.mo11195h(r1)
            java.lang.String r1 = r5.mo11161j()
            com.applovin.impl.sdk.network.h$a r0 = r0.mo11193g((java.lang.String) r1)
            com.applovin.impl.sdk.network.h r0 = r0.mo11131a()
            com.applovin.impl.sdk.m r1 = r4.f2321a
            com.applovin.impl.sdk.network.PostbackServiceImpl r1 = r1.mo10943X()
            com.applovin.impl.sdk.network.f$2 r2 = new com.applovin.impl.sdk.network.f$2
            r2.<init>(r5, r6)
            r1.dispatchPostbackRequest(r0, r2)
        L_0x0111:
            return
        L_0x0112:
            r5 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0112 }
            throw r5
        L_0x0115:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0115 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.network.C1222f.m2272a(com.applovin.impl.sdk.network.g, com.applovin.sdk.AppLovinPostbackListener):void");
    }

    /* renamed from: b */
    private ArrayList<C1226g> m2274b() {
        Set<String> set = (Set) this.f2321a.mo10979b(C1087d.f1833p, new LinkedHashSet(0), this.f2323c);
        ArrayList<C1226g> arrayList = new ArrayList<>(Math.max(1, set.size()));
        int intValue = ((Integer) this.f2321a.mo10946a(C1085b.f1661cN)).intValue();
        C1314v vVar = this.f2322b;
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Deserializing ");
        outline24.append(set.size());
        outline24.append(" postback(s).");
        vVar.mo11372b("PersistentPostbackManager", outline24.toString());
        for (String str : set) {
            try {
                C1226g gVar = new C1226g(new JSONObject(str), this.f2321a);
                if (gVar.mo11162k() < intValue) {
                    arrayList.add(gVar);
                } else {
                    C1314v vVar2 = this.f2322b;
                    vVar2.mo11372b("PersistentPostbackManager", "Skipping deserialization because maximum attempt count exceeded for postback: " + gVar);
                }
            } catch (Throwable th) {
                C1314v vVar3 = this.f2322b;
                vVar3.mo11373b("PersistentPostbackManager", "Unable to deserialize postback request from json: " + str, th);
            }
        }
        C1314v vVar4 = this.f2322b;
        StringBuilder outline242 = GeneratedOutlineSupport.outline24("Successfully loaded postback queue with ");
        outline242.append(arrayList.size());
        outline242.append(" postback(s).");
        vVar4.mo11372b("PersistentPostbackManager", outline242.toString());
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2276b(C1226g gVar) {
        synchronized (this.f2324d) {
            this.f2325e.add(gVar);
            m2277c();
            C1314v vVar = this.f2322b;
            vVar.mo11372b("PersistentPostbackManager", "Enqueued postback: " + gVar);
        }
    }

    /* renamed from: c */
    private void m2277c() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(this.f2325e.size());
        Iterator<C1226g> it = this.f2325e.iterator();
        while (it.hasNext()) {
            try {
                linkedHashSet.add(it.next().mo11165n().toString());
            } catch (Throwable th) {
                this.f2322b.mo11373b("PersistentPostbackManager", "Unable to serialize postback request to JSON.", th);
            }
        }
        this.f2321a.mo10954a(C1087d.f1833p, linkedHashSet, this.f2323c);
        this.f2322b.mo11372b("PersistentPostbackManager", "Wrote updated postback queue to disk.");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m2280c(C1226g gVar) {
        m2272a(gVar, (AppLovinPostbackListener) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m2282d() {
        synchronized (this.f2324d) {
            Iterator<C1226g> it = this.f2326f.iterator();
            while (it.hasNext()) {
                m2280c(it.next());
            }
            this.f2326f.clear();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m2284d(C1226g gVar) {
        synchronized (this.f2324d) {
            this.f2327g.remove(gVar);
            this.f2325e.remove(gVar);
            m2277c();
        }
        C1314v vVar = this.f2322b;
        vVar.mo11372b("PersistentPostbackManager", "Dequeued successfully transmitted postback: " + gVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m2285e(C1226g gVar) {
        synchronized (this.f2324d) {
            this.f2327g.remove(gVar);
            this.f2326f.add(gVar);
        }
    }

    /* renamed from: a */
    public void mo11144a() {
        C12253 r0 = new Runnable() {
            public void run() {
                synchronized (C1222f.this.f2324d) {
                    if (C1222f.this.f2325e != null) {
                        Iterator it = new ArrayList(C1222f.this.f2325e).iterator();
                        while (it.hasNext()) {
                            C1222f.this.m2280c((C1226g) it.next());
                        }
                    }
                }
            }
        };
        if (((Boolean) this.f2321a.mo10946a(C1085b.f1662cO)).booleanValue()) {
            this.f2321a.mo10938S().mo10829a((C1109a) new C1166z(this.f2321a, r0), C1140o.C1142a.POSTBACKS);
            return;
        }
        r0.run();
    }

    /* renamed from: a */
    public void mo11145a(C1226g gVar) {
        mo11146a(gVar, true);
    }

    /* renamed from: a */
    public void mo11146a(C1226g gVar, boolean z) {
        mo11147a(gVar, z, (AppLovinPostbackListener) null);
    }

    /* renamed from: a */
    public void mo11147a(final C1226g gVar, boolean z, final AppLovinPostbackListener appLovinPostbackListener) {
        if (StringUtils.isValidString(gVar.mo11151b())) {
            if (z) {
                gVar.mo11164m();
            }
            C12231 r3 = new Runnable() {
                public void run() {
                    synchronized (C1222f.this.f2324d) {
                        C1222f.this.m2276b(gVar);
                        C1222f.this.m2272a(gVar, appLovinPostbackListener);
                    }
                }
            };
            if (Utils.isMainThread()) {
                this.f2321a.mo10938S().mo10829a((C1109a) new C1166z(this.f2321a, r3), C1140o.C1142a.POSTBACKS);
                return;
            }
            r3.run();
        }
    }
}
