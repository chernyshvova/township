package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.p007a.C0631a;
import com.applovin.impl.p007a.C0638d;
import com.applovin.impl.p007a.C0642h;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.network.C1229h;
import com.applovin.impl.sdk.p025ad.C1052a;
import com.applovin.impl.sdk.p025ad.C1057e;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.p028d.C1101d;
import com.applovin.impl.sdk.utils.C1263g;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.helpshift.support.fragments.SingleQuestionFragment;

/* renamed from: com.applovin.impl.adview.d */
public class C0740d extends C0751h {
    @Nullable

    /* renamed from: c */
    public static WebView f418c;

    /* renamed from: a */
    public final C1314v f419a;

    /* renamed from: b */
    public final C1188m f420b;

    /* renamed from: d */
    public C1101d f421d;

    /* renamed from: e */
    public C1057e f422e;

    /* renamed from: f */
    public boolean f423f;

    /* renamed from: g */
    public boolean f424g;

    public C0740d(C0746e eVar, C1188m mVar, Context context) {
        this(eVar, mVar, context, false);
    }

    public C0740d(C0746e eVar, C1188m mVar, Context context, boolean z) {
        super(context);
        if (mVar != null) {
            this.f420b = mVar;
            this.f419a = mVar.mo10922B();
            setBackgroundColor(0);
            WebSettings settings = getSettings();
            settings.setSupportMultipleWindows(false);
            settings.setJavaScriptEnabled(true);
            setWebViewClient(eVar);
            setWebChromeClient(new C0739c(mVar));
            setVerticalScrollBarEnabled(false);
            setHorizontalScrollBarEnabled(false);
            setScrollBarStyle(33554432);
            if (C1263g.m2512h() && ((Boolean) mVar.mo10946a(C1085b.f1767eP)).booleanValue()) {
                setWebViewRenderProcessClient(new C0748f(mVar).mo9641a());
            }
            setOnTouchListener(new View.OnTouchListener() {
                @SuppressLint({"ClickableViewAccessibility"})
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (view.hasFocus()) {
                        return false;
                    }
                    view.requestFocus();
                    return false;
                }
            });
            setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    C0740d.this.f419a.mo11372b("AdWebView", "Received a LongClick event.");
                    return true;
                }
            });
            return;
        }
        throw new IllegalArgumentException("No sdk specified.");
    }

    /* renamed from: a */
    private String m486a(String str, String str2) {
        if (StringUtils.isValidString(str)) {
            return Utils.replaceCommonMacros(this.f424g, str).replace("{SOURCE}", str2);
        }
        return null;
    }

    /* renamed from: a */
    public static void m488a(final C1229h hVar, final C1188m mVar, final AppLovinPostbackListener appLovinPostbackListener) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                String a = hVar.mo11103a();
                C0740d.m492c();
                if (C0740d.f418c == null) {
                    appLovinPostbackListener.onPostbackFailure(a, -1);
                    return;
                }
                if (hVar.mo11108c() != null) {
                    a = StringUtils.appendQueryParameters(a, hVar.mo11108c(), ((Boolean) mVar.mo10946a(C1085b.f1734di)).booleanValue());
                }
                String outline17 = GeneratedOutlineSupport.outline17("al_firePostback('", a, "');");
                if (C1263g.m2507c()) {
                    C0740d.f418c.evaluateJavascript(outline17, (ValueCallback) null);
                } else {
                    WebView b = C0740d.f418c;
                    b.loadUrl(SingleQuestionFragment.JS_inlineScriptTag + outline17);
                }
                appLovinPostbackListener.onPostbackSuccess(a);
            }
        });
    }

    /* renamed from: a */
    private void m489a(String str, String str2, String str3, C1188m mVar) {
        String a = m486a(str3, str);
        if (StringUtils.isValidString(a)) {
            C1314v vVar = this.f419a;
            vVar.mo11372b("AdWebView", "Rendering webview for VAST ad with resourceContents : " + a);
            loadDataWithBaseURL(str2, a, "text/html", (String) null, "");
            return;
        }
        String a2 = m486a((String) mVar.mo10946a(C1085b.f1787ej), str);
        if (StringUtils.isValidString(a2)) {
            C1314v vVar2 = this.f419a;
            vVar2.mo11372b("AdWebView", "Rendering webview for VAST ad with resourceContents : " + a2);
            loadDataWithBaseURL(str2, a2, "text/html", (String) null, "");
            return;
        }
        C1314v vVar3 = this.f419a;
        vVar3.mo11372b("AdWebView", "Rendering webview for VAST ad with resourceURL : " + str);
        loadUrl(str);
    }

    /* renamed from: b */
    private void m491b(C1057e eVar) {
        Boolean n;
        Integer a;
        loadUrl("about:blank");
        int av = this.f422e.mo10615av();
        if (av >= 0) {
            setLayerType(av, (Paint) null);
        }
        if (C1263g.m2506b()) {
            getSettings().setMediaPlaybackRequiresUserGesture(eVar.mo10611ar());
        }
        if (C1263g.m2507c() && eVar.mo10613at()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        C0785v au = eVar.mo10614au();
        if (au != null) {
            WebSettings settings = getSettings();
            WebSettings.PluginState b = au.mo9712b();
            if (b != null) {
                settings.setPluginState(b);
            }
            Boolean c = au.mo9713c();
            if (c != null) {
                settings.setAllowFileAccess(c.booleanValue());
            }
            Boolean d = au.mo9714d();
            if (d != null) {
                settings.setLoadWithOverviewMode(d.booleanValue());
            }
            Boolean e = au.mo9715e();
            if (e != null) {
                settings.setUseWideViewPort(e.booleanValue());
            }
            Boolean f = au.mo9716f();
            if (f != null) {
                settings.setAllowContentAccess(f.booleanValue());
            }
            Boolean g = au.mo9717g();
            if (g != null) {
                settings.setBuiltInZoomControls(g.booleanValue());
            }
            Boolean h = au.mo9718h();
            if (h != null) {
                settings.setDisplayZoomControls(h.booleanValue());
            }
            Boolean i = au.mo9719i();
            if (i != null) {
                settings.setSaveFormData(i.booleanValue());
            }
            Boolean j = au.mo9720j();
            if (j != null) {
                settings.setGeolocationEnabled(j.booleanValue());
            }
            Boolean k = au.mo9721k();
            if (k != null) {
                settings.setNeedInitialFocus(k.booleanValue());
            }
            Boolean l = au.mo9722l();
            if (l != null) {
                settings.setAllowFileAccessFromFileURLs(l.booleanValue());
            }
            Boolean m = au.mo9723m();
            if (m != null) {
                settings.setAllowUniversalAccessFromFileURLs(m.booleanValue());
            }
            if (C1263g.m2508d() && (a = au.mo9711a()) != null) {
                settings.setMixedContentMode(a.intValue());
            }
            if (C1263g.m2509e() && (n = au.mo9724n()) != null) {
                settings.setOffscreenPreRaster(n.booleanValue());
            }
        }
    }

    /* renamed from: c */
    public static void m492c() {
        if (f418c == null) {
            try {
                WebView webView = new WebView(C1188m.m2053M());
                f418c = webView;
                webView.getSettings().setJavaScriptEnabled(true);
                f418c.loadData("<html><head>\n<script type=\"text/javascript\">\n    window.al_firePostback = function(postback) {\n    setTimeout(function() {\n        var img = new Image();\n        img.src = postback;\n    }, 100);\n};\n</script></head>\n<body></body></html>", "text/html", "UTF-8");
                f418c.setWebViewClient(new WebViewClient() {
                    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                        if (webView != C0740d.f418c) {
                            return true;
                        }
                        C0740d.f418c.destroy();
                        WebView unused = C0740d.f418c = null;
                        AppLovinSdkUtils.runOnUiThread(new Runnable() {
                            public void run() {
                                C0740d.m492c();
                            }
                        });
                        return true;
                    }
                });
            } catch (Throwable th) {
                C1314v.m2659c("AdWebView", "Failed to initialize WebView for postbacks.", th);
            }
        }
    }

    /* renamed from: a */
    public void mo9614a(C1057e eVar) {
        C1314v vVar;
        String str;
        C1314v vVar2;
        String str2;
        String str3;
        String as;
        String str4;
        String str5;
        String str6;
        String as2;
        C1188m mVar;
        if (!this.f423f) {
            this.f422e = eVar;
            try {
                m491b(eVar);
                if (Utils.isBML(eVar.getSize())) {
                    setVisibility(0);
                }
                if (eVar instanceof C1052a) {
                    C1052a aVar = (C1052a) eVar;
                    String replaceCommonMacros = Utils.replaceCommonMacros(this.f424g, aVar.mo9311b());
                    if (aVar.isOpenMeasurementEnabled()) {
                        replaceCommonMacros = this.f420b.mo10975am().mo10472a(replaceCommonMacros);
                    }
                    loadDataWithBaseURL(eVar.mo10612as(), replaceCommonMacros, "text/html", (String) null, "");
                    if (aVar.isOpenMeasurementEnabled()) {
                        aVar.getAdEventTracker().mo10456b(this);
                        aVar.getAdEventTracker().mo10450a((View) this);
                        aVar.getAdEventTracker().mo10457c();
                        aVar.getAdEventTracker().mo10458d();
                    }
                    vVar = this.f419a;
                    str = "AppLovinAd rendered";
                } else if (eVar instanceof C0631a) {
                    C0631a aVar2 = (C0631a) eVar;
                    C0638d aK = aVar2.mo9303aK();
                    if (aK != null) {
                        C0642h b = aK.mo9357b();
                        Uri b2 = b.mo9380b();
                        String uri = b2 != null ? b2.toString() : "";
                        String c = b.mo9381c();
                        String aM = aVar2.mo9305aM();
                        if (!StringUtils.isValidString(uri)) {
                            if (!StringUtils.isValidString(c)) {
                                vVar2 = this.f419a;
                                str2 = "Unable to load companion ad. No resources provided.";
                                vVar2.mo11376e("AdWebView", str2);
                                return;
                            }
                        }
                        if (b.mo9377a() == C0642h.C0643a.STATIC) {
                            this.f419a.mo11372b("AdWebView", "Rendering WebView for static VAST ad");
                            loadDataWithBaseURL(eVar.mo10612as(), m486a((String) this.f420b.mo10946a(C1085b.f1786ei), uri), "text/html", (String) null, "");
                            return;
                        }
                        if (b.mo9377a() == C0642h.C0643a.HTML) {
                            if (StringUtils.isValidString(c)) {
                                String a = m486a(aM, c);
                                str3 = StringUtils.isValidString(a) ? a : c;
                                C1314v vVar3 = this.f419a;
                                vVar3.mo11372b("AdWebView", "Rendering WebView for HTML VAST ad with resourceContents: " + str3);
                                as = eVar.mo10612as();
                                str4 = "text/html";
                                str5 = null;
                                str6 = "";
                            } else if (StringUtils.isValidString(uri)) {
                                this.f419a.mo11372b("AdWebView", "Preparing to load HTML VAST ad resourceUri");
                                as2 = eVar.mo10612as();
                                mVar = this.f420b;
                                m489a(uri, as2, aM, mVar);
                                return;
                            } else {
                                return;
                            }
                        } else if (b.mo9377a() != C0642h.C0643a.IFRAME) {
                            vVar2 = this.f419a;
                            str2 = "Failed to render VAST companion ad of invalid type";
                            vVar2.mo11376e("AdWebView", str2);
                            return;
                        } else if (StringUtils.isValidString(uri)) {
                            this.f419a.mo11372b("AdWebView", "Preparing to load iFrame VAST ad resourceUri");
                            as2 = eVar.mo10612as();
                            mVar = this.f420b;
                            m489a(uri, as2, aM, mVar);
                            return;
                        } else if (StringUtils.isValidString(c)) {
                            String a2 = m486a(aM, c);
                            str3 = StringUtils.isValidString(a2) ? a2 : c;
                            C1314v vVar4 = this.f419a;
                            vVar4.mo11372b("AdWebView", "Rendering WebView for iFrame VAST ad with resourceContents: " + str3);
                            as = eVar.mo10612as();
                            str4 = "text/html";
                            str5 = null;
                            str6 = "";
                        } else {
                            return;
                        }
                        loadDataWithBaseURL(as, str3, str4, str5, str6);
                        return;
                    }
                    vVar = this.f419a;
                    str = "No companion ad provided.";
                } else {
                    return;
                }
                vVar.mo11372b("AdWebView", str);
            } catch (Throwable th) {
                String valueOf = eVar != null ? String.valueOf(eVar.getAdIdNumber()) : "null";
                throw new RuntimeException("Unable to render AppLovin ad (" + valueOf + ") - " + th);
            }
        } else {
            C1314v.m2663i("AdWebView", "Ad can not be loaded in a destroyed webview");
        }
    }

    /* renamed from: a */
    public void mo9615a(String str) {
        mo9616a(str, (Runnable) null);
    }

    /* renamed from: a */
    public void mo9616a(String str, Runnable runnable) {
        try {
            C1314v vVar = this.f419a;
            vVar.mo11372b("AdWebView", "Forwarding \"" + str + "\" to ad template");
            loadUrl(str);
        } catch (Throwable th) {
            this.f419a.mo11373b("AdWebView", "Unable to forward to template", th);
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public void computeScroll() {
    }

    public void destroy() {
        this.f423f = true;
        super.destroy();
    }

    public C1057e getCurrentAd() {
        return this.f422e;
    }

    public C1101d getStatsManagerHelper() {
        return this.f421d;
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
    }

    public void scrollTo(int i, int i2) {
    }

    public void setIsShownOutOfContext(boolean z) {
        this.f424g = z;
    }

    public void setStatsManagerHelper(C1101d dVar) {
        this.f421d = dVar;
    }
}
