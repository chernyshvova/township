package com.applovin.impl.sdk;

import android.content.Intent;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.p029e.C1109a;
import com.applovin.impl.sdk.p029e.C1140o;
import com.applovin.impl.sdk.p029e.C1166z;
import com.applovin.impl.sdk.utils.C1263g;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.ac */
public class C1046ac {
    @Nullable

    /* renamed from: a */
    public static WebView f1378a;

    /* renamed from: b */
    public static volatile String f1379b;

    /* renamed from: c */
    public static volatile Map<String, String> f1380c;

    /* renamed from: com.applovin.impl.sdk.ac$a */
    public static class C1051a extends WebViewClient {

        /* renamed from: a */
        public final C1188m f1385a;

        public C1051a(C1188m mVar) {
            this.f1385a = mVar;
        }

        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            this.f1385a.mo10972aj().sendBroadcast(new Intent("com.applovin.render_process_gone"), (Map<String, Object>) null);
            return true;
        }
    }

    /* renamed from: a */
    public static String m1440a() {
        return f1379b;
    }

    /* renamed from: a */
    public static void m1443a(C1188m mVar) {
        if (f1378a == null) {
            try {
                WebView webView = new WebView(mVar.mo10932L());
                f1378a = webView;
                webView.setWebViewClient(new C1051a(mVar));
            } catch (Throwable th) {
                mVar.mo10922B().mo11373b("WebViewDataCollector", "Failed to initialize WebView for data collection.", th);
            }
        }
    }

    /* renamed from: b */
    public static Map<String, String> m1444b() {
        return f1380c != null ? f1380c : Collections.emptyMap();
    }

    /* renamed from: b */
    public static void m1445b(final C1188m mVar) {
        if (f1379b == null) {
            f1379b = "";
            if (C1263g.m2506b()) {
                mVar.mo10938S().mo10829a((C1109a) new C1166z(mVar, true, new Runnable() {
                    public void run() {
                        try {
                            String unused = C1046ac.f1379b = WebSettings.getDefaultUserAgent(mVar.mo10932L());
                        } catch (Throwable th) {
                            mVar.mo10922B().mo11373b("WebViewDataCollector", "Failed to collect user agent", th);
                        }
                    }
                }), C1140o.C1142a.BACKGROUND);
            } else {
                AppLovinSdkUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        try {
                            C1046ac.m1443a(mVar);
                            String unused = C1046ac.f1379b = C1046ac.f1378a.getSettings().getUserAgentString();
                        } catch (Throwable th) {
                            mVar.mo10922B().mo11373b("WebViewDataCollector", "Failed to collect user agent", th);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: c */
    public static void m1447c(final C1188m mVar) {
        if (f1380c == null) {
            f1380c = Collections.emptyMap();
            if (C1263g.m2508d()) {
                AppLovinSdkUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        try {
                            C1046ac.m1443a(mVar);
                            C1046ac.f1378a.setWebViewClient(new C1051a(mVar) {
                                public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                                    HashMap hashMap = new HashMap();
                                    for (Map.Entry next : webResourceRequest.getRequestHeaders().entrySet()) {
                                        StringBuilder outline24 = GeneratedOutlineSupport.outline24("AppLovin-WebView-");
                                        outline24.append((String) next.getKey());
                                        hashMap.put(outline24.toString(), next.getValue());
                                    }
                                    Map unused = C1046ac.f1380c = hashMap;
                                    return super.shouldInterceptRequest(webView, webResourceRequest);
                                }
                            });
                            C1046ac.f1378a.loadUrl("https://blank");
                        } catch (Throwable th) {
                            mVar.mo10922B().mo11373b("WebViewDataCollector", "Failed to collect WebView HTTP headers", th);
                        }
                    }
                });
            }
        }
    }
}
