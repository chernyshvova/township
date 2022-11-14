package com.applovin.impl.sdk.p029e;

import android.net.Uri;
import android.webkit.WebView;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.adview.C0725b;
import com.applovin.impl.adview.C0740d;
import com.applovin.impl.adview.C0746e;
import com.applovin.impl.mediation.C0996h;
import com.applovin.impl.mediation.p010a.C0801a;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p025ad.C1052a;
import com.applovin.impl.sdk.p025ad.C1053b;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinSdkUtils;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.q */
public class C1147q extends C1109a implements C0996h.C0997a {

    /* renamed from: a */
    public final C1052a f2067a;

    /* renamed from: c */
    public AppLovinAdLoadListener f2068c;

    /* renamed from: d */
    public C0740d f2069d;

    /* renamed from: com.applovin.impl.sdk.e.q$a */
    public class C1149a extends C0746e {
        public C1149a(C1188m mVar) {
            super((C0725b) null, mVar);
        }

        /* renamed from: a */
        private boolean m1937a(String str, C1085b<String> bVar) {
            for (String equalsIgnoreCase : C1147q.this.f1961b.mo10980b(bVar)) {
                if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: a */
        public boolean mo9630a(WebView webView, String str, boolean z) {
            C1147q qVar = C1147q.this;
            qVar.mo10770b("Processing click on ad URL \"" + str + "\"");
            if (str == null || !(webView instanceof C0740d)) {
                return true;
            }
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String host = parse.getHost();
            if (!m1937a(scheme, C1085b.f1679cf)) {
                return true;
            }
            if (m1937a(host, C1085b.f1680cg)) {
                C1147q.this.mo10768a("Ad load succeeded");
                if (C1147q.this.f2068c == null) {
                    return true;
                }
                C1147q.this.f2068c.adReceived(C1147q.this.f2067a);
            } else if (m1937a(host, C1085b.f1681ch)) {
                C1147q.this.mo10768a("Ad load failed");
                if (C1147q.this.f2068c == null) {
                    return true;
                }
                C1147q.this.f2068c.failedToReceiveAd(204);
            } else {
                C1147q.this.mo10773d("Unrecognized webview event");
                return true;
            }
            AppLovinAdLoadListener unused = C1147q.this.f2068c = null;
            return true;
        }
    }

    public C1147q(JSONObject jSONObject, JSONObject jSONObject2, C1053b bVar, AppLovinAdLoadListener appLovinAdLoadListener, C1188m mVar) {
        super("TaskProcessJavaScriptTagAd", mVar);
        this.f2067a = new C1052a(jSONObject, jSONObject2, bVar, mVar);
        this.f2068c = appLovinAdLoadListener;
        mVar.mo10928H().mo10347a((C0996h.C0997a) this);
    }

    /* renamed from: a */
    public void mo10349a(C0801a aVar) {
        if (aVar.mo9833f().equalsIgnoreCase(this.f2067a.mo10563I())) {
            this.f1961b.mo10928H().mo10348b(this);
            AppLovinAdLoadListener appLovinAdLoadListener = this.f2068c;
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.adReceived(this.f2067a);
                this.f2068c = null;
            }
        }
    }

    public void run() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Rendering AppLovin ad #");
        outline24.append(this.f2067a.getAdIdNumber());
        mo10768a(outline24.toString());
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                try {
                    C0740d unused = C1147q.this.f2069d = new C0740d(new C1149a(C1147q.this.f1961b), C1147q.this.f1961b, C1147q.this.mo10775f());
                    C1147q.this.f2069d.loadDataWithBaseURL(C1147q.this.f2067a.mo10612as(), C1147q.this.f2067a.mo9311b(), "text/html", (String) null, "");
                } catch (Throwable th) {
                    C1147q.this.f1961b.mo10928H().mo10348b(C1147q.this);
                    C1147q.this.mo10769a("Failed to initialize WebView", th);
                    if (C1147q.this.f2068c != null) {
                        C1147q.this.f2068c.failedToReceiveAd(-1);
                        AppLovinAdLoadListener unused2 = C1147q.this.f2068c = null;
                    }
                }
            }
        });
    }
}
