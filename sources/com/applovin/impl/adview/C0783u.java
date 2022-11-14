package com.applovin.impl.adview;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdImpl;
import java.lang.ref.WeakReference;

/* renamed from: com.applovin.impl.adview.u */
public class C0783u extends WebViewClient {

    /* renamed from: a */
    public final C1314v f514a;

    /* renamed from: b */
    public WeakReference<C0784a> f515b;

    /* renamed from: com.applovin.impl.adview.u$a */
    public interface C0784a {
        /* renamed from: a */
        void mo9528a(C0782t tVar);

        /* renamed from: b */
        void mo9529b(C0782t tVar);

        /* renamed from: c */
        void mo9530c(C0782t tVar);
    }

    public C0783u(C1188m mVar) {
        this.f514a = mVar.mo10922B();
    }

    /* renamed from: a */
    private void m590a(WebView webView, String str) {
        C1314v vVar = this.f514a;
        vVar.mo11374c("WebViewButtonClient", "Processing click on ad URL \"" + str + "\"");
        if (str != null && (webView instanceof C0782t)) {
            C0782t tVar = (C0782t) webView;
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String host = parse.getHost();
            String path = parse.getPath();
            C0784a aVar = (C0784a) this.f515b.get();
            if (AppLovinNativeAdImpl.AD_RESPONSE_TYPE_APPLOVIN.equalsIgnoreCase(scheme) && "com.applovin.sdk".equalsIgnoreCase(host) && aVar != null) {
                if ("/track_click".equals(path)) {
                    aVar.mo9528a(tVar);
                } else if ("/close_ad".equals(path)) {
                    aVar.mo9529b(tVar);
                } else if ("/skip_ad".equals(path)) {
                    aVar.mo9530c(tVar);
                } else {
                    C1314v vVar2 = this.f514a;
                    vVar2.mo11375d("WebViewButtonClient", "Unknown URL: " + str);
                    C1314v vVar3 = this.f514a;
                    vVar3.mo11375d("WebViewButtonClient", "Path: " + path);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo9709a(WeakReference<C0784a> weakReference) {
        this.f515b = weakReference;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        m590a(webView, str);
        return true;
    }
}
