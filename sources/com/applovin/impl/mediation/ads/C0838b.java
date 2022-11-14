package com.applovin.impl.mediation.ads;

import com.applovin.impl.mediation.ads.C0836a;
import com.applovin.impl.mediation.p010a.C0804d;
import com.applovin.impl.mediation.p010a.C0805e;
import com.applovin.impl.sdk.C1041aa;
import com.applovin.impl.sdk.C1042ab;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;

/* renamed from: com.applovin.impl.mediation.ads.b */
public class C0838b implements C1042ab.C1045a {

    /* renamed from: a */
    public final C1188m f700a;

    /* renamed from: b */
    public final C0804d f701b;

    /* renamed from: c */
    public final C1042ab f702c;

    /* renamed from: d */
    public final C1041aa f703d;

    /* renamed from: e */
    public final C0836a.C0837a f704e;

    public C0838b(C0804d dVar, C0836a.C0837a aVar, C1188m mVar) {
        this.f700a = mVar;
        this.f701b = dVar;
        this.f704e = aVar;
        this.f703d = new C1041aa(dVar.mo9885w(), mVar);
        C1042ab abVar = new C1042ab(this.f701b.mo9885w(), mVar, this);
        this.f702c = abVar;
        abVar.mo10510a((C0805e) this.f701b);
        C1314v B = mVar.mo10922B();
        B.mo11372b("MaxNativeAdView", "Created new MaxNativeAdView (" + this + ")");
    }

    /* renamed from: a */
    private void m834a(long j) {
        this.f700a.mo10922B().mo11372b("MaxNativeAdView", "Scheduling viewability impression for ad...");
        this.f700a.mo10925E().processViewabilityAdImpressionPostback(this.f701b, j, this.f704e);
    }

    /* renamed from: a */
    public void mo9993a() {
        this.f702c.mo10509a();
        this.f700a.mo10973ak().mo11228b(this.f701b);
        this.f700a.mo10925E().destroyAd(this.f701b);
    }

    /* renamed from: b */
    public void mo9994b() {
        if (this.f701b.mo9888z().compareAndSet(false, true)) {
            this.f700a.mo10922B().mo11372b("MaxNativeAdView", "Scheduling impression for ad manually...");
            this.f700a.mo10925E().processRawAdImpressionPostback(this.f701b, this.f704e);
        }
    }

    public void onLogVisibilityImpression() {
        m834a(this.f703d.mo10508a(this.f701b));
    }
}
