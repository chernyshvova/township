package com.applovin.impl.sdk.p029e;

import android.net.Uri;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.p025ad.C1052a;
import com.applovin.impl.sdk.p025ad.C1057e;
import com.applovin.impl.sdk.p028d.C1101d;
import com.applovin.sdk.AppLovinAdLoadListener;

/* renamed from: com.applovin.impl.sdk.e.d */
public class C1118d extends C1115c {

    /* renamed from: c */
    public final C1052a f1979c;

    /* renamed from: d */
    public boolean f1980d;

    /* renamed from: e */
    public boolean f1981e;

    public C1118d(C1052a aVar, C1188m mVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super("TaskCacheAppLovinAd", aVar, mVar, appLovinAdLoadListener);
        this.f1979c = aVar;
    }

    /* renamed from: j */
    private void m1850j() {
        mo10768a("Caching HTML resources...");
        this.f1979c.mo10533a(mo10786a(this.f1979c.mo9311b(), this.f1979c.mo10560F(), (C1057e) this.f1979c));
        this.f1979c.mo10585a(true);
        mo10768a("Finish caching non-video resources for ad #" + this.f1979c.getAdIdNumber());
        C1314v B = this.f1961b.mo10922B();
        String e = mo10774e();
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Ad updated with cachedHTML = ");
        outline24.append(this.f1979c.mo9311b());
        B.mo11370a(e, outline24.toString());
    }

    /* renamed from: k */
    private void m1851k() {
        Uri e;
        if (!mo10790b() && (e = mo10792e(this.f1979c.mo10535h())) != null) {
            if (this.f1979c.mo10593aH()) {
                this.f1979c.mo10533a(this.f1979c.mo9311b().replaceFirst(this.f1979c.mo9313d(), e.toString()));
                mo10768a("Replaced video URL with cached video URI in HTML for web video ad");
            }
            this.f1979c.mo10534f();
            this.f1979c.mo10532a(e);
        }
    }

    /* renamed from: a */
    public void mo10800a(boolean z) {
        this.f1980d = z;
    }

    /* renamed from: b */
    public void mo10801b(boolean z) {
        this.f1981e = z;
    }

    public void run() {
        super.run();
        boolean e = this.f1979c.mo9314e();
        boolean z = this.f1981e;
        if (e || z) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Begin caching for streaming ad #");
            outline24.append(this.f1979c.getAdIdNumber());
            outline24.append("...");
            mo10768a(outline24.toString());
            mo10791c();
            if (e) {
                if (this.f1980d) {
                    mo10795i();
                }
                m1850j();
                if (!this.f1980d) {
                    mo10795i();
                }
                m1851k();
            } else {
                mo10795i();
                m1850j();
            }
        } else {
            StringBuilder outline242 = GeneratedOutlineSupport.outline24("Begin processing for non-streaming ad #");
            outline242.append(this.f1979c.getAdIdNumber());
            outline242.append("...");
            mo10768a(outline242.toString());
            mo10791c();
            m1850j();
            m1851k();
            mo10795i();
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f1979c.getCreatedAtMillis();
        C1101d.m1737a(this.f1979c, this.f1961b);
        C1101d.m1736a(currentTimeMillis, (AppLovinAdBase) this.f1979c, this.f1961b);
        mo10788a((AppLovinAdBase) this.f1979c);
        mo10787a();
    }
}
