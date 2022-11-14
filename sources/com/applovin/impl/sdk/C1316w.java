package com.applovin.impl.sdk;

import androidx.annotation.Nullable;
import com.applovin.impl.mediation.p010a.C0801a;
import com.applovin.impl.mediation.p010a.C0806f;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.w */
public class C1316w {

    /* renamed from: a */
    public final C1188m f2576a;

    /* renamed from: b */
    public final C1314v f2577b;

    /* renamed from: c */
    public final Map<String, C0801a> f2578c = new HashMap(4);

    /* renamed from: d */
    public final Object f2579d = new Object();

    public C1316w(C1188m mVar) {
        this.f2576a = mVar;
        this.f2577b = mVar.mo10922B();
    }

    @Nullable
    /* renamed from: a */
    public String mo11377a(String str) {
        String P;
        synchronized (this.f2579d) {
            C0801a aVar = this.f2578c.get(str);
            P = aVar != null ? aVar.mo9898P() : null;
        }
        return P;
    }

    /* renamed from: a */
    public void mo11378a(C0801a aVar) {
        synchronized (this.f2579d) {
            C1314v vVar = this.f2577b;
            vVar.mo11372b("MediationWaterfallWinnerTracker", "Tracking winning ad: " + aVar);
            this.f2578c.put(aVar.getAdUnitId(), aVar);
        }
    }

    /* renamed from: b */
    public void mo11379b(C0801a aVar) {
        synchronized (this.f2579d) {
            String adUnitId = aVar.getAdUnitId();
            C0806f fVar = this.f2578c.get(adUnitId);
            if (aVar == fVar) {
                C1314v vVar = this.f2577b;
                vVar.mo11372b("MediationWaterfallWinnerTracker", "Clearing previous winning ad: " + fVar);
                this.f2578c.remove(adUnitId);
            } else {
                C1314v vVar2 = this.f2577b;
                vVar2.mo11372b("MediationWaterfallWinnerTracker", "Previous winner not cleared for ad: " + aVar + " , since it could have already been updated with a new ad: " + fVar);
            }
        }
    }
}
