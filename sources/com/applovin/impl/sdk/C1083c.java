package com.applovin.impl.sdk;

import androidx.annotation.Nullable;
import com.applovin.impl.sdk.p025ad.AppLovinAdImpl;
import com.applovin.impl.sdk.p025ad.C1056d;
import com.applovin.impl.sdk.p025ad.C1063f;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.c */
public class C1083c {

    /* renamed from: a */
    public final C1188m f1485a;

    /* renamed from: b */
    public final C1314v f1486b;

    /* renamed from: c */
    public final Object f1487c = new Object();

    /* renamed from: d */
    public final Map<C1056d, C1317x> f1488d = new HashMap();

    /* renamed from: e */
    public final Map<C1056d, C1317x> f1489e = new HashMap();

    public C1083c(C1188m mVar) {
        this.f1485a = mVar;
        this.f1486b = mVar.mo10922B();
        for (C1056d next : C1056d.m1476f()) {
            this.f1488d.put(next, new C1317x());
            this.f1489e.put(next, new C1317x());
        }
    }

    /* renamed from: d */
    private C1317x m1641d(C1056d dVar) {
        C1317x xVar;
        synchronized (this.f1487c) {
            xVar = this.f1488d.get(dVar);
            if (xVar == null) {
                xVar = new C1317x();
                this.f1488d.put(dVar, xVar);
            }
        }
        return xVar;
    }

    /* renamed from: e */
    private C1317x m1642e(C1056d dVar) {
        C1317x xVar;
        synchronized (this.f1487c) {
            xVar = this.f1489e.get(dVar);
            if (xVar == null) {
                xVar = new C1317x();
                this.f1489e.put(dVar, xVar);
            }
        }
        return xVar;
    }

    /* renamed from: f */
    private C1317x m1643f(C1056d dVar) {
        synchronized (this.f1487c) {
            C1317x e = m1642e(dVar);
            if (e.mo11380a() > 0) {
                return e;
            }
            C1317x d = m1641d(dVar);
            return d;
        }
    }

    @Nullable
    /* renamed from: a */
    public AppLovinAdImpl mo10669a(C1056d dVar) {
        C1063f fVar;
        StringBuilder sb;
        String str;
        synchronized (this.f1487c) {
            C1317x d = m1641d(dVar);
            if (d.mo11380a() > 0) {
                m1642e(dVar).mo11381a(d.mo11383c());
                fVar = new C1063f(dVar, this.f1485a);
            } else {
                fVar = null;
            }
        }
        C1314v vVar = this.f1486b;
        if (fVar != null) {
            str = "Retrieved ad of zone ";
        } else {
            sb = new StringBuilder();
            str = "Unable to retrieve ad of zone ";
        }
        sb.append(str);
        sb.append(dVar);
        sb.append("...");
        vVar.mo11372b("AdPreloadManager", sb.toString());
        return fVar;
    }

    /* renamed from: a */
    public void mo10670a(AppLovinAdImpl appLovinAdImpl) {
        synchronized (this.f1487c) {
            m1641d(appLovinAdImpl.getAdZone()).mo11381a(appLovinAdImpl);
            C1314v vVar = this.f1486b;
            vVar.mo11372b("AdPreloadManager", "Ad enqueued: " + appLovinAdImpl);
        }
    }

    @Nullable
    /* renamed from: b */
    public AppLovinAdImpl mo10671b(C1056d dVar) {
        AppLovinAdImpl c;
        synchronized (this.f1487c) {
            c = m1643f(dVar).mo11383c();
        }
        return c;
    }

    /* renamed from: c */
    public AppLovinAdBase mo10672c(C1056d dVar) {
        AppLovinAdImpl d;
        synchronized (this.f1487c) {
            d = m1643f(dVar).mo11384d();
        }
        return d;
    }
}
