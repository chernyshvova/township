package com.applovin.impl.mediation;

import com.applovin.impl.mediation.C0799a;
import com.applovin.impl.mediation.C0862c;
import com.applovin.impl.mediation.p010a.C0803c;
import com.applovin.impl.sdk.C1188m;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.mediation.b */
public class C0839b implements C0799a.C0800a, C0862c.C0864a {

    /* renamed from: a */
    public final C0799a f705a;

    /* renamed from: b */
    public final C0862c f706b;

    /* renamed from: c */
    public final MaxAdListener f707c;

    public C0839b(C1188m mVar, MaxAdListener maxAdListener) {
        this.f707c = maxAdListener;
        this.f705a = new C0799a(mVar);
        this.f706b = new C0862c(mVar, this);
    }

    /* renamed from: a */
    public void mo9823a(final C0803c cVar) {
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
            public void run() {
                C0839b.this.f707c.onAdHidden(cVar);
            }
        }, cVar.mo9882y());
    }

    /* renamed from: a */
    public void mo9995a(MaxAd maxAd) {
        this.f706b.mo10028a();
        this.f705a.mo9821a();
    }

    /* renamed from: b */
    public void mo9996b(C0803c cVar) {
        long w = cVar.mo9880w();
        if (w >= 0) {
            this.f706b.mo10029a(cVar, w);
        }
        if (cVar.mo9881x()) {
            this.f705a.mo9822a(cVar, this);
        }
    }

    /* renamed from: c */
    public void mo9997c(C0803c cVar) {
        this.f707c.onAdHidden(cVar);
    }
}
