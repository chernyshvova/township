package com.applovin.impl.mediation;

import android.app.Activity;
import android.os.Bundle;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.mediation.p010a.C0803c;
import com.applovin.impl.sdk.C1008a;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.utils.C1256a;

/* renamed from: com.applovin.impl.mediation.a */
public class C0799a extends C1256a {

    /* renamed from: a */
    public final C1008a f590a;

    /* renamed from: b */
    public final C1314v f591b;

    /* renamed from: c */
    public C0800a f592c;

    /* renamed from: d */
    public C0803c f593d;

    /* renamed from: e */
    public int f594e;

    /* renamed from: f */
    public boolean f595f;

    /* renamed from: com.applovin.impl.mediation.a$a */
    public interface C0800a {
        /* renamed from: a */
        void mo9823a(C0803c cVar);
    }

    public C0799a(C1188m mVar) {
        this.f591b = mVar.mo10922B();
        this.f590a = mVar.mo10967ae();
    }

    /* renamed from: a */
    public void mo9821a() {
        this.f591b.mo11372b("AdActivityObserver", "Cancelling...");
        this.f590a.mo10437b(this);
        this.f592c = null;
        this.f593d = null;
        this.f594e = 0;
        this.f595f = false;
    }

    /* renamed from: a */
    public void mo9822a(C0803c cVar, C0800a aVar) {
        C1314v vVar = this.f591b;
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Starting for ad ");
        outline24.append(cVar.getAdUnitId());
        outline24.append("...");
        vVar.mo11372b("AdActivityObserver", outline24.toString());
        mo9821a();
        this.f592c = aVar;
        this.f593d = cVar;
        this.f590a.mo10435a(this);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (!this.f595f) {
            this.f595f = true;
        }
        this.f594e++;
        this.f591b.mo11372b("AdActivityObserver", "Created Activity: " + activity + ", counter is " + this.f594e);
    }

    public void onActivityDestroyed(Activity activity) {
        if (this.f595f) {
            this.f594e--;
            this.f591b.mo11372b("AdActivityObserver", "Destroyed Activity: " + activity + ", counter is " + this.f594e);
            if (this.f594e <= 0) {
                this.f591b.mo11372b("AdActivityObserver", "Last ad Activity destroyed");
                if (this.f592c != null) {
                    this.f591b.mo11372b("AdActivityObserver", "Invoking callback...");
                    this.f592c.mo9823a(this.f593d);
                }
                mo9821a();
            }
        }
    }
}
