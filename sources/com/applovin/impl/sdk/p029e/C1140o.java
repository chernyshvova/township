package com.applovin.impl.sdk.p029e;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.utils.C1260e;
import com.applovin.impl.sdk.utils.C1263g;
import com.applovin.impl.sdk.utils.Utils;
import com.facebook.internal.security.CertificateUtil;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.e.o */
public class C1140o {

    /* renamed from: A */
    public boolean f2007A;

    /* renamed from: a */
    public final String f2008a = "TaskManager";

    /* renamed from: b */
    public final C1188m f2009b;

    /* renamed from: c */
    public final C1314v f2010c;

    /* renamed from: d */
    public final ScheduledThreadPoolExecutor f2011d;

    /* renamed from: e */
    public final ScheduledThreadPoolExecutor f2012e;

    /* renamed from: f */
    public final ScheduledThreadPoolExecutor f2013f;

    /* renamed from: g */
    public final ScheduledThreadPoolExecutor f2014g;

    /* renamed from: h */
    public final ScheduledThreadPoolExecutor f2015h;

    /* renamed from: i */
    public final ScheduledThreadPoolExecutor f2016i;

    /* renamed from: j */
    public final ScheduledThreadPoolExecutor f2017j;

    /* renamed from: k */
    public final ScheduledThreadPoolExecutor f2018k;

    /* renamed from: l */
    public final ScheduledThreadPoolExecutor f2019l;

    /* renamed from: m */
    public final ScheduledThreadPoolExecutor f2020m;

    /* renamed from: n */
    public final ScheduledThreadPoolExecutor f2021n;

    /* renamed from: o */
    public final ScheduledThreadPoolExecutor f2022o;

    /* renamed from: p */
    public final ScheduledThreadPoolExecutor f2023p;

    /* renamed from: q */
    public final ScheduledThreadPoolExecutor f2024q;

    /* renamed from: r */
    public final ScheduledThreadPoolExecutor f2025r;

    /* renamed from: s */
    public final ScheduledThreadPoolExecutor f2026s;

    /* renamed from: t */
    public final ScheduledThreadPoolExecutor f2027t;

    /* renamed from: u */
    public final ScheduledThreadPoolExecutor f2028u;

    /* renamed from: v */
    public final ScheduledThreadPoolExecutor f2029v;

    /* renamed from: w */
    public final ScheduledThreadPoolExecutor f2030w;

    /* renamed from: x */
    public final ScheduledThreadPoolExecutor f2031x;

    /* renamed from: y */
    public final List<C1145c> f2032y = new ArrayList(5);

    /* renamed from: z */
    public final Object f2033z = new Object();

    /* renamed from: com.applovin.impl.sdk.e.o$a */
    public enum C1142a {
        MAIN,
        TIMEOUT,
        BACKGROUND,
        ADVERTISING_INFO_COLLECTION,
        POSTBACKS,
        CACHING_INTERSTITIAL,
        CACHING_INCENTIVIZED,
        CACHING_OTHER,
        REWARD,
        MEDIATION_MAIN,
        MEDIATION_TIMEOUT,
        MEDIATION_BACKGROUND,
        MEDIATION_POSTBACKS,
        MEDIATION_BANNER,
        MEDIATION_INTERSTITIAL,
        MEDIATION_INCENTIVIZED,
        MEDIATION_REWARDED_INTERSTITIAL,
        MEDIATION_REWARD
    }

    /* renamed from: com.applovin.impl.sdk.e.o$b */
    public class C1143b implements ThreadFactory {

        /* renamed from: b */
        public final String f2057b;

        public C1143b(String str) {
            this.f2057b = str;
        }

        public Thread newThread(Runnable runnable) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("AppLovinSdk:");
            outline24.append(this.f2057b);
            outline24.append(CertificateUtil.DELIMITER);
            outline24.append(Utils.shortenKey(C1140o.this.f2009b.mo11010z()));
            Thread thread = new Thread(runnable, outline24.toString());
            thread.setDaemon(true);
            thread.setPriority(10);
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                public void uncaughtException(Thread thread, Throwable th) {
                    C1140o.this.f2010c.mo11373b("TaskManager", "Caught unhandled exception", th);
                }
            });
            return thread;
        }
    }

    /* renamed from: com.applovin.impl.sdk.e.o$c */
    public class C1145c implements Runnable {

        /* renamed from: b */
        public final String f2060b;

        /* renamed from: c */
        public final C1109a f2061c;

        /* renamed from: d */
        public final C1142a f2062d;

        public C1145c(C1109a aVar, C1142a aVar2) {
            this.f2060b = aVar.mo10774e();
            this.f2061c = aVar;
            this.f2062d = aVar2;
        }

        public void run() {
            long j;
            StringBuilder sb;
            C1314v vVar;
            try {
                C1263g.m2504a();
                if (C1140o.this.f2009b.mo10986c()) {
                    if (!this.f2061c.mo10776g()) {
                        C1140o.this.f2010c.mo11374c(this.f2060b, "Task re-scheduled...");
                        C1140o.this.mo10830a(this.f2061c, this.f2062d, 2000);
                        j = C1140o.this.m1911a(this.f2062d) - 1;
                        vVar = C1140o.this.f2010c;
                        sb = new StringBuilder();
                        sb.append(this.f2062d);
                        sb.append(" queue finished task ");
                        sb.append(this.f2061c.mo10774e());
                        sb.append(" with queue size ");
                        sb.append(j);
                        vVar.mo11374c("TaskManager", sb.toString());
                    }
                }
                this.f2061c.run();
                j = C1140o.this.m1911a(this.f2062d) - 1;
                vVar = C1140o.this.f2010c;
                sb = new StringBuilder();
            } catch (Throwable th) {
                C1314v b = C1140o.this.f2010c;
                b.mo11374c("TaskManager", this.f2062d + " queue finished task " + this.f2061c.mo10774e() + " with queue size " + (C1140o.this.m1911a(this.f2062d) - 1));
                throw th;
            }
            sb.append(this.f2062d);
            sb.append(" queue finished task ");
            sb.append(this.f2061c.mo10774e());
            sb.append(" with queue size ");
            sb.append(j);
            vVar.mo11374c("TaskManager", sb.toString());
        }
    }

    public C1140o(C1188m mVar) {
        this.f2009b = mVar;
        this.f2010c = mVar.mo10922B();
        this.f2011d = m1914a("main");
        this.f2012e = m1914a("timeout");
        this.f2013f = m1914a("back");
        this.f2014g = m1914a("advertising_info_collection");
        this.f2015h = m1914a("postbacks");
        this.f2016i = m1914a("caching_interstitial");
        this.f2017j = m1914a("caching_incentivized");
        this.f2018k = m1914a("caching_other");
        this.f2019l = m1914a("reward");
        this.f2020m = m1914a("mediation_main");
        this.f2021n = m1914a("mediation_timeout");
        this.f2022o = m1914a("mediation_background");
        this.f2023p = m1914a("mediation_postbacks");
        this.f2024q = m1914a("mediation_banner");
        this.f2025r = m1914a("mediation_interstitial");
        this.f2026s = m1914a("mediation_incentivized");
        this.f2027t = m1914a("mediation_rewarded_interstitial");
        this.f2028u = m1914a("mediation_reward");
        this.f2029v = m1915a("auxiliary_operations", ((Integer) mVar.mo10946a(C1085b.f1682ci)).intValue());
        this.f2030w = m1915a("caching_operations", ((Integer) mVar.mo10946a(C1085b.f1683cj)).intValue());
        this.f2031x = m1915a("shared_thread_pool", ((Integer) mVar.mo10946a(C1085b.f1587as)).intValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public long m1911a(C1142a aVar) {
        long taskCount;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (aVar == C1142a.MAIN) {
            taskCount = this.f2011d.getTaskCount();
            scheduledThreadPoolExecutor = this.f2011d;
        } else if (aVar == C1142a.TIMEOUT) {
            taskCount = this.f2012e.getTaskCount();
            scheduledThreadPoolExecutor = this.f2012e;
        } else if (aVar == C1142a.BACKGROUND) {
            taskCount = this.f2013f.getTaskCount();
            scheduledThreadPoolExecutor = this.f2013f;
        } else if (aVar == C1142a.ADVERTISING_INFO_COLLECTION) {
            taskCount = this.f2014g.getTaskCount();
            scheduledThreadPoolExecutor = this.f2014g;
        } else if (aVar == C1142a.POSTBACKS) {
            taskCount = this.f2015h.getTaskCount();
            scheduledThreadPoolExecutor = this.f2015h;
        } else if (aVar == C1142a.CACHING_INTERSTITIAL) {
            taskCount = this.f2016i.getTaskCount();
            scheduledThreadPoolExecutor = this.f2016i;
        } else if (aVar == C1142a.CACHING_INCENTIVIZED) {
            taskCount = this.f2017j.getTaskCount();
            scheduledThreadPoolExecutor = this.f2017j;
        } else if (aVar == C1142a.CACHING_OTHER) {
            taskCount = this.f2018k.getTaskCount();
            scheduledThreadPoolExecutor = this.f2018k;
        } else if (aVar == C1142a.REWARD) {
            taskCount = this.f2019l.getTaskCount();
            scheduledThreadPoolExecutor = this.f2019l;
        } else if (aVar == C1142a.MEDIATION_MAIN) {
            taskCount = this.f2020m.getTaskCount();
            scheduledThreadPoolExecutor = this.f2020m;
        } else if (aVar == C1142a.MEDIATION_TIMEOUT) {
            taskCount = this.f2021n.getTaskCount();
            scheduledThreadPoolExecutor = this.f2021n;
        } else if (aVar == C1142a.MEDIATION_BACKGROUND) {
            taskCount = this.f2022o.getTaskCount();
            scheduledThreadPoolExecutor = this.f2022o;
        } else if (aVar == C1142a.MEDIATION_POSTBACKS) {
            taskCount = this.f2023p.getTaskCount();
            scheduledThreadPoolExecutor = this.f2023p;
        } else if (aVar == C1142a.MEDIATION_BANNER) {
            taskCount = this.f2024q.getTaskCount();
            scheduledThreadPoolExecutor = this.f2024q;
        } else if (aVar == C1142a.MEDIATION_INTERSTITIAL) {
            taskCount = this.f2025r.getTaskCount();
            scheduledThreadPoolExecutor = this.f2025r;
        } else if (aVar == C1142a.MEDIATION_INCENTIVIZED) {
            taskCount = this.f2026s.getTaskCount();
            scheduledThreadPoolExecutor = this.f2026s;
        } else if (aVar == C1142a.MEDIATION_REWARDED_INTERSTITIAL) {
            taskCount = this.f2027t.getTaskCount();
            scheduledThreadPoolExecutor = this.f2027t;
        } else if (aVar != C1142a.MEDIATION_REWARD) {
            return 0;
        } else {
            taskCount = this.f2028u.getTaskCount();
            scheduledThreadPoolExecutor = this.f2028u;
        }
        return taskCount - scheduledThreadPoolExecutor.getCompletedTaskCount();
    }

    /* renamed from: a */
    private ScheduledThreadPoolExecutor m1914a(String str) {
        return m1915a(str, 1);
    }

    /* renamed from: a */
    private ScheduledThreadPoolExecutor m1915a(String str, int i) {
        return new ScheduledThreadPoolExecutor(i, new C1143b(str));
    }

    /* renamed from: a */
    private void m1916a(final Runnable runnable, long j, final ScheduledExecutorService scheduledExecutorService, boolean z) {
        if (j <= 0) {
            scheduledExecutorService.submit(runnable);
        } else if (z) {
            C1260e.m2499a(j, this.f2009b, new Runnable() {
                public void run() {
                    scheduledExecutorService.execute(runnable);
                }
            });
        } else {
            scheduledExecutorService.schedule(runnable, j, TimeUnit.MILLISECONDS);
        }
    }

    /* renamed from: a */
    private boolean m1917a(C1145c cVar) {
        if (cVar.f2061c.mo10776g()) {
            return false;
        }
        synchronized (this.f2033z) {
            if (this.f2007A) {
                return false;
            }
            this.f2032y.add(cVar);
            return true;
        }
    }

    /* renamed from: a */
    public void mo10828a(C1109a aVar) {
        if (aVar != null) {
            try {
                aVar.run();
            } catch (Throwable th) {
                this.f2010c.mo11373b(aVar.mo10774e(), "Task failed execution", th);
            }
        } else {
            this.f2010c.mo11376e("TaskManager", "Attempted to execute null task immediately");
        }
    }

    /* renamed from: a */
    public void mo10829a(C1109a aVar, C1142a aVar2) {
        mo10830a(aVar, aVar2, 0);
    }

    /* renamed from: a */
    public void mo10830a(C1109a aVar, C1142a aVar2, long j) {
        mo10831a(aVar, aVar2, j, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.applovin.impl.sdk.e.o$c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: com.applovin.impl.sdk.e.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.applovin.impl.sdk.e.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: com.applovin.impl.sdk.e.a} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo10831a(com.applovin.impl.sdk.p029e.C1109a r8, com.applovin.impl.sdk.p029e.C1140o.C1142a r9, long r10, boolean r12) {
        /*
            r7 = this;
            if (r8 == 0) goto L_0x010c
            r0 = 0
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 < 0) goto L_0x00f5
            com.applovin.impl.sdk.e.o$c r0 = new com.applovin.impl.sdk.e.o$c
            r0.<init>(r8, r9)
            boolean r1 = r7.m1917a((com.applovin.impl.sdk.p029e.C1140o.C1145c) r0)
            if (r1 != 0) goto L_0x00e9
            com.applovin.impl.sdk.m r1 = r7.f2009b
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r2 = com.applovin.impl.sdk.p027c.C1085b.f1588at
            java.lang.Object r1 = r1.mo10946a(r2)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0029
            java.util.concurrent.ScheduledThreadPoolExecutor r9 = r7.f2031x
            r2 = r8
            r5 = r9
            goto L_0x00e2
        L_0x0029:
            long r1 = r7.m1911a((com.applovin.impl.sdk.p029e.C1140o.C1142a) r9)
            r3 = 1
            long r1 = r1 + r3
            com.applovin.impl.sdk.v r3 = r7.f2010c
            java.lang.String r4 = "Scheduling "
            java.lang.StringBuilder r4 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r4)
            java.lang.String r8 = r8.mo10774e()
            r4.append(r8)
            java.lang.String r8 = " on "
            r4.append(r8)
            r4.append(r9)
            java.lang.String r8 = " queue in "
            r4.append(r8)
            r4.append(r10)
            java.lang.String r8 = "ms with new queue size "
            r4.append(r8)
            r4.append(r1)
            java.lang.String r8 = r4.toString()
            java.lang.String r1 = "TaskManager"
            r3.mo11372b(r1, r8)
            com.applovin.impl.sdk.e.o$a r8 = com.applovin.impl.sdk.p029e.C1140o.C1142a.MAIN
            if (r9 != r8) goto L_0x0069
            java.util.concurrent.ScheduledThreadPoolExecutor r8 = r7.f2011d
        L_0x0066:
            r9 = r8
            goto L_0x00e0
        L_0x0069:
            com.applovin.impl.sdk.e.o$a r8 = com.applovin.impl.sdk.p029e.C1140o.C1142a.TIMEOUT
            if (r9 != r8) goto L_0x0070
            java.util.concurrent.ScheduledThreadPoolExecutor r8 = r7.f2012e
            goto L_0x0066
        L_0x0070:
            com.applovin.impl.sdk.e.o$a r8 = com.applovin.impl.sdk.p029e.C1140o.C1142a.BACKGROUND
            if (r9 != r8) goto L_0x0077
            java.util.concurrent.ScheduledThreadPoolExecutor r8 = r7.f2013f
            goto L_0x0066
        L_0x0077:
            com.applovin.impl.sdk.e.o$a r8 = com.applovin.impl.sdk.p029e.C1140o.C1142a.ADVERTISING_INFO_COLLECTION
            if (r9 != r8) goto L_0x007e
            java.util.concurrent.ScheduledThreadPoolExecutor r8 = r7.f2014g
            goto L_0x0066
        L_0x007e:
            com.applovin.impl.sdk.e.o$a r8 = com.applovin.impl.sdk.p029e.C1140o.C1142a.POSTBACKS
            if (r9 != r8) goto L_0x0085
            java.util.concurrent.ScheduledThreadPoolExecutor r8 = r7.f2015h
            goto L_0x0066
        L_0x0085:
            com.applovin.impl.sdk.e.o$a r8 = com.applovin.impl.sdk.p029e.C1140o.C1142a.CACHING_INTERSTITIAL
            if (r9 != r8) goto L_0x008c
            java.util.concurrent.ScheduledThreadPoolExecutor r8 = r7.f2016i
            goto L_0x0066
        L_0x008c:
            com.applovin.impl.sdk.e.o$a r8 = com.applovin.impl.sdk.p029e.C1140o.C1142a.CACHING_INCENTIVIZED
            if (r9 != r8) goto L_0x0093
            java.util.concurrent.ScheduledThreadPoolExecutor r8 = r7.f2017j
            goto L_0x0066
        L_0x0093:
            com.applovin.impl.sdk.e.o$a r8 = com.applovin.impl.sdk.p029e.C1140o.C1142a.CACHING_OTHER
            if (r9 != r8) goto L_0x009a
            java.util.concurrent.ScheduledThreadPoolExecutor r8 = r7.f2018k
            goto L_0x0066
        L_0x009a:
            com.applovin.impl.sdk.e.o$a r8 = com.applovin.impl.sdk.p029e.C1140o.C1142a.REWARD
            if (r9 != r8) goto L_0x00a1
            java.util.concurrent.ScheduledThreadPoolExecutor r8 = r7.f2019l
            goto L_0x0066
        L_0x00a1:
            com.applovin.impl.sdk.e.o$a r8 = com.applovin.impl.sdk.p029e.C1140o.C1142a.MEDIATION_MAIN
            if (r9 != r8) goto L_0x00a8
            java.util.concurrent.ScheduledThreadPoolExecutor r8 = r7.f2020m
            goto L_0x0066
        L_0x00a8:
            com.applovin.impl.sdk.e.o$a r8 = com.applovin.impl.sdk.p029e.C1140o.C1142a.MEDIATION_TIMEOUT
            if (r9 != r8) goto L_0x00af
            java.util.concurrent.ScheduledThreadPoolExecutor r8 = r7.f2021n
            goto L_0x0066
        L_0x00af:
            com.applovin.impl.sdk.e.o$a r8 = com.applovin.impl.sdk.p029e.C1140o.C1142a.MEDIATION_BACKGROUND
            if (r9 != r8) goto L_0x00b6
            java.util.concurrent.ScheduledThreadPoolExecutor r8 = r7.f2022o
            goto L_0x0066
        L_0x00b6:
            com.applovin.impl.sdk.e.o$a r8 = com.applovin.impl.sdk.p029e.C1140o.C1142a.MEDIATION_POSTBACKS
            if (r9 != r8) goto L_0x00bd
            java.util.concurrent.ScheduledThreadPoolExecutor r8 = r7.f2023p
            goto L_0x0066
        L_0x00bd:
            com.applovin.impl.sdk.e.o$a r8 = com.applovin.impl.sdk.p029e.C1140o.C1142a.MEDIATION_BANNER
            if (r9 != r8) goto L_0x00c4
            java.util.concurrent.ScheduledThreadPoolExecutor r8 = r7.f2024q
            goto L_0x0066
        L_0x00c4:
            com.applovin.impl.sdk.e.o$a r8 = com.applovin.impl.sdk.p029e.C1140o.C1142a.MEDIATION_INTERSTITIAL
            if (r9 != r8) goto L_0x00cb
            java.util.concurrent.ScheduledThreadPoolExecutor r8 = r7.f2025r
            goto L_0x0066
        L_0x00cb:
            com.applovin.impl.sdk.e.o$a r8 = com.applovin.impl.sdk.p029e.C1140o.C1142a.MEDIATION_INCENTIVIZED
            if (r9 != r8) goto L_0x00d2
            java.util.concurrent.ScheduledThreadPoolExecutor r8 = r7.f2026s
            goto L_0x0066
        L_0x00d2:
            com.applovin.impl.sdk.e.o$a r8 = com.applovin.impl.sdk.p029e.C1140o.C1142a.MEDIATION_REWARDED_INTERSTITIAL
            if (r9 != r8) goto L_0x00d9
            java.util.concurrent.ScheduledThreadPoolExecutor r8 = r7.f2027t
            goto L_0x0066
        L_0x00d9:
            com.applovin.impl.sdk.e.o$a r8 = com.applovin.impl.sdk.p029e.C1140o.C1142a.MEDIATION_REWARD
            if (r9 != r8) goto L_0x00f4
            java.util.concurrent.ScheduledThreadPoolExecutor r8 = r7.f2028u
            goto L_0x0066
        L_0x00e0:
            r5 = r9
            r2 = r0
        L_0x00e2:
            r1 = r7
            r3 = r10
            r6 = r12
            r1.m1916a((java.lang.Runnable) r2, (long) r3, (java.util.concurrent.ScheduledExecutorService) r5, (boolean) r6)
            goto L_0x00f4
        L_0x00e9:
            com.applovin.impl.sdk.v r9 = r7.f2010c
            java.lang.String r8 = r8.mo10774e()
            java.lang.String r10 = "Task execution delayed until after init"
            r9.mo11374c(r8, r10)
        L_0x00f4:
            return
        L_0x00f5:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r12 = "Invalid delay specified: "
            r9.append(r12)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L_0x010c:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "No task specified"
            r8.<init>(r9)
            goto L_0x0115
        L_0x0114:
            throw r8
        L_0x0115:
            goto L_0x0114
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.p029e.C1140o.mo10831a(com.applovin.impl.sdk.e.a, com.applovin.impl.sdk.e.o$a, long, boolean):void");
    }

    /* renamed from: a */
    public boolean mo10832a() {
        return this.f2007A;
    }

    /* renamed from: b */
    public ScheduledExecutorService mo10833b() {
        return this.f2029v;
    }

    /* renamed from: c */
    public ScheduledExecutorService mo10834c() {
        return this.f2030w;
    }

    /* renamed from: d */
    public void mo10835d() {
        synchronized (this.f2033z) {
            this.f2007A = false;
        }
    }

    /* renamed from: e */
    public void mo10836e() {
        synchronized (this.f2033z) {
            this.f2007A = true;
            for (C1145c next : this.f2032y) {
                mo10829a(next.f2061c, next.f2062d);
            }
            this.f2032y.clear();
        }
    }
}
