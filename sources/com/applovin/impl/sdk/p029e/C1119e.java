package com.applovin.impl.sdk.p029e;

import android.net.Uri;
import android.webkit.URLUtil;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.p007a.C0631a;
import com.applovin.impl.p007a.C0638d;
import com.applovin.impl.p007a.C0642h;
import com.applovin.impl.p007a.C0651n;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p025ad.C1057e;
import com.applovin.impl.sdk.p028d.C1101d;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.Collections;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.e.e */
public class C1119e extends C1115c {

    /* renamed from: c */
    public final C0631a f1982c;

    public C1119e(C0631a aVar, C1188m mVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super("TaskCacheVastAd", aVar, mVar, appLovinAdLoadListener);
        this.f1982c = aVar;
    }

    /* renamed from: j */
    private void m1854j() {
        String str;
        String str2;
        String str3;
        if (!mo10790b()) {
            if (this.f1982c.mo9307aO()) {
                C0638d aK = this.f1982c.mo9303aK();
                if (aK != null) {
                    C0642h b = aK.mo9357b();
                    if (b != null) {
                        Uri b2 = b.mo9380b();
                        String uri = b2 != null ? b2.toString() : "";
                        String c = b.mo9381c();
                        if (URLUtil.isValidUrl(uri) || StringUtils.isValidString(c)) {
                            if (b.mo9377a() == C0642h.C0643a.STATIC) {
                                mo10768a("Caching static companion ad at " + uri + "...");
                                Uri b3 = mo10789b(uri, Collections.emptyList(), false);
                                if (b3 != null) {
                                    b.mo9378a(b3);
                                } else {
                                    str2 = "Failed to cache static companion ad";
                                }
                            } else if (b.mo9377a() == C0642h.C0643a.HTML) {
                                if (StringUtils.isValidString(uri)) {
                                    mo10768a("Begin caching HTML companion ad. Fetching from " + uri + "...");
                                    c = mo10793f(uri);
                                    if (StringUtils.isValidString(c)) {
                                        str3 = "HTML fetched. Caching HTML now...";
                                    } else {
                                        str2 = "Unable to load companion ad resources from " + uri;
                                    }
                                } else {
                                    str3 = "Caching provided HTML for companion ad. No fetch required. HTML: " + c;
                                }
                                mo10768a(str3);
                                b.mo9379a(mo10786a(c, (List<String>) Collections.emptyList(), (C1057e) this.f1982c));
                            } else if (b.mo9377a() == C0642h.C0643a.IFRAME) {
                                str = "Skip caching of iFrame resource...";
                            } else {
                                return;
                            }
                            this.f1982c.mo10585a(true);
                            return;
                        }
                        mo10771c("Companion ad does not have any resources attached. Skipping...");
                        return;
                    }
                    str2 = "Failed to retrieve non-video resources from companion ad. Skipping...";
                    mo10773d(str2);
                    return;
                }
                str = "No companion ad provided. Skipping...";
            } else {
                str = "Companion ad caching disabled. Skipping...";
            }
            mo10768a(str);
        }
    }

    /* renamed from: k */
    private void m1855k() {
        C0651n aJ;
        Uri b;
        if (!mo10790b()) {
            if (!this.f1982c.mo9308aP()) {
                mo10768a("Video caching disabled. Skipping...");
            } else if (this.f1982c.mo9329m() != null && (aJ = this.f1982c.mo9302aJ()) != null && (b = aJ.mo9408b()) != null) {
                Uri a = mo10784a(b.toString(), (List<String>) Collections.emptyList(), false);
                if (a != null) {
                    mo10768a("Video file successfully cached into: " + a);
                    aJ.mo9407a(a);
                    return;
                }
                mo10773d("Failed to cache video file: " + aJ);
            }
        }
    }

    /* renamed from: l */
    private void m1856l() {
        String str;
        String str2;
        if (!mo10790b()) {
            if (this.f1982c.mo9306aN() != null) {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Begin caching HTML template. Fetching from ");
                outline24.append(this.f1982c.mo9306aN());
                outline24.append("...");
                mo10768a(outline24.toString());
                str = mo10785a(this.f1982c.mo9306aN().toString(), this.f1982c.mo10560F());
            } else {
                str = this.f1982c.mo9305aM();
            }
            if (StringUtils.isValidString(str)) {
                C0631a aVar = this.f1982c;
                aVar.mo9301a(mo10786a(str, aVar.mo10560F(), (C1057e) this.f1982c));
                str2 = "Finish caching HTML template " + this.f1982c.mo9305aM() + " for ad #" + this.f1982c.getAdIdNumber();
            } else {
                str2 = "Unable to load HTML template";
            }
            mo10768a(str2);
        }
    }

    /* renamed from: h */
    public void mo10794h() {
        this.f1982c.getAdEventTracker().mo10459e();
        super.mo10794h();
    }

    /* renamed from: i */
    public void mo10795i() {
        this.f1982c.getAdEventTracker().mo10457c();
        super.mo10795i();
    }

    public void run() {
        super.run();
        if (this.f1982c.mo9314e()) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Begin caching for VAST streaming ad #");
            outline24.append(this.f1969a.getAdIdNumber());
            outline24.append("...");
            mo10768a(outline24.toString());
            mo10791c();
            if (this.f1982c.mo9327k()) {
                mo10795i();
            }
            if (this.f1982c.mo9321h() == C0631a.C0634b.COMPANION_AD) {
                m1854j();
                m1856l();
            } else {
                m1855k();
            }
            if (!this.f1982c.mo9327k()) {
                mo10795i();
            }
            if (this.f1982c.mo9321h() == C0631a.C0634b.COMPANION_AD) {
                m1855k();
            } else {
                m1854j();
                m1856l();
            }
        } else {
            StringBuilder outline242 = GeneratedOutlineSupport.outline24("Begin caching for VAST ad #");
            outline242.append(this.f1969a.getAdIdNumber());
            outline242.append("...");
            mo10768a(outline242.toString());
            mo10791c();
            m1854j();
            m1855k();
            m1856l();
            mo10795i();
        }
        StringBuilder outline243 = GeneratedOutlineSupport.outline24("Finished caching VAST ad #");
        outline243.append(this.f1982c.getAdIdNumber());
        mo10768a(outline243.toString());
        long currentTimeMillis = System.currentTimeMillis() - this.f1982c.getCreatedAtMillis();
        C1101d.m1737a(this.f1982c, this.f1961b);
        C1101d.m1736a(currentTimeMillis, (AppLovinAdBase) this.f1982c, this.f1961b);
        mo10788a((AppLovinAdBase) this.f1982c);
        this.f1982c.mo9311b();
        mo10787a();
    }
}
