package com.applovin.impl.adview;

import android.annotation.TargetApi;
import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.p025ad.C1057e;
import com.applovin.impl.sdk.p028d.C1094b;

@TargetApi(29)
/* renamed from: com.applovin.impl.adview.f */
public class C0748f {

    /* renamed from: a */
    public final C1188m f436a;

    /* renamed from: b */
    public final WebViewRenderProcessClient f437b = new WebViewRenderProcessClient() {
        public void onRenderProcessResponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
        }

        public void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
            if (webView instanceof C0740d) {
                C1057e currentAd = ((C0740d) webView).getCurrentAd();
                C0748f.this.f436a.mo10964ab().mo10717a((AppLovinAdBase) currentAd).mo10725a(C1094b.f1866D).mo10728a();
                C1314v B = C0748f.this.f436a.mo10922B();
                B.mo11376e("AdWebViewRenderProcessClient", "WebView render process unresponsive for ad: " + currentAd);
            }
        }
    };

    public C0748f(C1188m mVar) {
        this.f436a = mVar;
    }

    /* renamed from: a */
    public WebViewRenderProcessClient mo9641a() {
        return this.f437b;
    }
}
