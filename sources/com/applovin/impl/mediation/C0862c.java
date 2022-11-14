package com.applovin.impl.mediation;

import com.applovin.impl.mediation.p010a.C0803c;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.utils.C1260e;

/* renamed from: com.applovin.impl.mediation.c */
public class C0862c {

    /* renamed from: a */
    public final C1188m f770a;

    /* renamed from: b */
    public final C1314v f771b;

    /* renamed from: c */
    public final C0864a f772c;

    /* renamed from: d */
    public C1260e f773d;

    /* renamed from: com.applovin.impl.mediation.c$a */
    public interface C0864a {
        /* renamed from: c */
        void mo9997c(C0803c cVar);
    }

    public C0862c(C1188m mVar, C0864a aVar) {
        this.f770a = mVar;
        this.f771b = mVar.mo10922B();
        this.f772c = aVar;
    }

    /* renamed from: a */
    public void mo10028a() {
        this.f771b.mo11372b("AdHiddenCallbackTimeoutManager", "Cancelling timeout");
        C1260e eVar = this.f773d;
        if (eVar != null) {
            eVar.mo11276a();
            this.f773d = null;
        }
    }

    /* renamed from: a */
    public void mo10029a(final C0803c cVar, long j) {
        C1314v vVar = this.f771b;
        vVar.mo11372b("AdHiddenCallbackTimeoutManager", "Scheduling in " + j + "ms...");
        this.f773d = C1260e.m2499a(j, this.f770a, new Runnable() {
            public void run() {
                C0862c.this.f771b.mo11372b("AdHiddenCallbackTimeoutManager", "Timing out...");
                C0862c.this.f772c.mo9997c(cVar);
            }
        });
    }
}
