package com.applovin.impl.adview;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PointF;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.p007a.C0631a;
import com.applovin.impl.p007a.C0638d;
import com.applovin.impl.p007a.C0647l;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.network.C1226g;
import com.applovin.impl.sdk.p025ad.C1057e;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.p028d.C1094b;
import com.applovin.impl.sdk.p028d.C1101d;
import com.applovin.impl.sdk.utils.C1256a;
import com.applovin.impl.sdk.utils.C1267j;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.google.android.gms.drive.DriveFile;

/* renamed from: com.applovin.impl.adview.e */
public class C0746e extends WebViewClient {

    /* renamed from: a */
    public final C1188m f431a;

    /* renamed from: b */
    public final C1314v f432b;

    /* renamed from: c */
    public final C0725b f433c;

    public C0746e(@Nullable C0725b bVar, C1188m mVar) {
        this.f431a = mVar;
        this.f432b = mVar.mo10922B();
        this.f433c = bVar;
    }

    /* renamed from: a */
    private void m497a() {
        this.f433c.mo9589l();
    }

    /* renamed from: a */
    private void m498a(PointF pointF) {
        this.f433c.mo9565a(pointF);
    }

    /* renamed from: a */
    private void m499a(Uri uri, C0740d dVar) {
        String str;
        C1314v vVar;
        final String queryParameter = uri.getQueryParameter("n");
        if (StringUtils.isValidString(queryParameter)) {
            String queryParameter2 = uri.getQueryParameter("load_type");
            if ("external".equalsIgnoreCase(queryParameter2)) {
                C1314v vVar2 = this.f432b;
                vVar2.mo11372b("AdWebView", "Loading new page externally: " + queryParameter);
                Utils.openUri(dVar.getContext(), Uri.parse(queryParameter), this.f431a);
                C1267j.m2574c(this.f433c.mo9584g(), (AppLovinAd) this.f433c.mo9593p(), this.f433c.mo9595r());
                return;
            } else if ("internal".equalsIgnoreCase(queryParameter2)) {
                C1314v vVar3 = this.f432b;
                vVar3.mo11372b("AdWebView", "Loading new page in WebView: " + queryParameter);
                dVar.loadUrl(queryParameter);
                String queryParameter3 = uri.getQueryParameter("bg_color");
                if (StringUtils.isValidString(queryParameter3)) {
                    dVar.setBackgroundColor(Color.parseColor(queryParameter3));
                    return;
                }
                return;
            } else if ("in_app".equalsIgnoreCase(queryParameter2)) {
                C1314v vVar4 = this.f432b;
                vVar4.mo11372b("AdWebView", "Loading new page in slide-up webview: " + queryParameter);
                this.f431a.mo10967ae().mo10435a(new C1256a() {
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                        if (activity instanceof AppLovinWebViewActivity) {
                            ((AppLovinWebViewActivity) activity).loadUrl(queryParameter, (AppLovinWebViewActivity.EventListener) null);
                            C1267j.m2542a(C0746e.this.f433c.mo9584g(), (AppLovinAd) C0746e.this.f433c.mo9593p(), C0746e.this.f433c.mo9595r());
                        }
                    }

                    public void onActivityDestroyed(Activity activity) {
                        if (activity instanceof AppLovinWebViewActivity) {
                            C1267j.m2569b(C0746e.this.f433c.mo9584g(), (AppLovinAd) C0746e.this.f433c.mo9593p(), C0746e.this.f433c.mo9595r());
                            C0746e.this.f431a.mo10967ae().mo10437b(this);
                        }
                    }
                });
                Intent intent = new Intent(this.f431a.mo10932L(), AppLovinWebViewActivity.class);
                intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f431a.mo11010z());
                intent.setFlags(DriveFile.MODE_READ_ONLY);
                this.f431a.mo10932L().startActivity(intent);
                return;
            } else {
                vVar = this.f432b;
                str = "Could not find load type in original uri";
            }
        } else {
            vVar = this.f432b;
            str = "Could not find url to load from query in original uri";
        }
        vVar.mo11376e("AdWebView", str);
    }

    /* renamed from: a */
    private void m500a(Uri uri, C1057e eVar) {
        String queryParameter = uri.getQueryParameter("n");
        if (URLUtil.isValidUrl(queryParameter)) {
            String appendQueryParameter = StringUtils.appendQueryParameter(queryParameter, "clcode", eVar.getClCode());
            this.f431a.mo10940U().mo11145a(C1226g.m2290o().mo11174c(appendQueryParameter).mo11169a(false).mo11176c(Boolean.parseBoolean(uri.getQueryParameter("fire_from_webview"))).mo11170a());
            return;
        }
        C1314v vVar = this.f432b;
        vVar.mo11376e("AdWebView", "Could not find postback url to fire from query in original uri: " + uri);
    }

    /* renamed from: a */
    private void m501a(C0631a aVar, C0740d dVar) {
        C0638d aK = aVar.mo9303aK();
        if (aK != null) {
            C0647l.m155a(aK.mo9358c(), this.f433c.mo9594q());
            m502a(dVar, aK.mo9356a());
        }
    }

    /* renamed from: a */
    private void m502a(C0740d dVar, Uri uri) {
        C1057e currentAd = dVar.getCurrentAd();
        AppLovinAdView r = this.f433c.mo9595r();
        if (r == null || currentAd == null) {
            C1314v vVar = this.f432b;
            vVar.mo11376e("AdWebView", "Attempting to track click that is null or not an ApplovinAdView instance for clickedUri = " + uri);
            return;
        }
        C1101d statsManagerHelper = dVar.getStatsManagerHelper();
        if (statsManagerHelper != null) {
            statsManagerHelper.mo10732b();
        }
        this.f433c.mo9570a(currentAd, r, uri, dVar.getAndClearLastClickLocation());
    }

    /* renamed from: b */
    private void m504b() {
        this.f433c.mo9588k();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ca, code lost:
        if (r6.mo9304aL() != false) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01bd, code lost:
        if (r6.mo9304aL() != false) goto L_0x00aa;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo9630a(android.webkit.WebView r9, java.lang.String r10, boolean r11) {
        /*
            r8 = this;
            com.applovin.impl.adview.b r0 = r8.f433c
            r1 = 1
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            com.applovin.impl.sdk.v r0 = r8.f432b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Processing click on ad URL \""
            r2.append(r3)
            r2.append(r10)
            java.lang.String r3 = "\""
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "AdWebView"
            r0.mo11374c(r3, r2)
            if (r10 == 0) goto L_0x01c3
            boolean r0 = r9 instanceof com.applovin.impl.adview.C0740d
            if (r0 == 0) goto L_0x01c3
            android.net.Uri r0 = android.net.Uri.parse(r10)
            com.applovin.impl.adview.d r9 = (com.applovin.impl.adview.C0740d) r9
            java.lang.String r2 = r0.getScheme()
            java.lang.String r4 = r0.getHost()
            java.lang.String r5 = r0.getPath()
            com.applovin.impl.adview.b r6 = r8.f433c
            com.applovin.impl.sdk.ad.e r6 = r6.mo9593p()
            if (r6 != 0) goto L_0x004b
            com.applovin.impl.sdk.v r9 = r8.f432b
            java.lang.String r10 = "Unable to process click, ad not found!"
            r9.mo11376e(r3, r10)
            return r1
        L_0x004b:
            java.lang.String r7 = "applovin"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x0188
            java.lang.String r7 = "com.applovin.sdk"
            boolean r7 = r7.equals(r4)
            if (r7 == 0) goto L_0x0188
            java.lang.String r11 = "/adservice/close_ad"
            boolean r11 = r11.equals(r5)
            if (r11 == 0) goto L_0x0068
            r8.m497a()
            goto L_0x01c3
        L_0x0068:
            java.lang.String r11 = "/adservice/expand_ad"
            boolean r11 = r11.equals(r5)
            if (r11 == 0) goto L_0x0079
            android.graphics.PointF r9 = r9.getAndClearLastClickLocation()
            r8.m498a((android.graphics.PointF) r9)
            goto L_0x01c3
        L_0x0079:
            java.lang.String r11 = "/adservice/contract_ad"
            boolean r11 = r11.equals(r5)
            if (r11 == 0) goto L_0x0086
            r8.m504b()
            goto L_0x01c3
        L_0x0086:
            java.lang.String r11 = "/adservice/no_op"
            boolean r11 = r11.equals(r5)
            if (r11 == 0) goto L_0x008f
            return r1
        L_0x008f:
            java.lang.String r11 = "/adservice/load_url"
            boolean r11 = r11.equals(r5)
            if (r11 == 0) goto L_0x009c
            r8.m499a((android.net.Uri) r0, (com.applovin.impl.adview.C0740d) r9)
            goto L_0x01c3
        L_0x009c:
            java.lang.String r11 = "/adservice/track_click_now"
            boolean r2 = r11.equals(r5)
            if (r2 == 0) goto L_0x00b8
            boolean r10 = r6 instanceof com.applovin.impl.p007a.C0631a
            if (r10 == 0) goto L_0x00af
            com.applovin.impl.a.a r6 = (com.applovin.impl.p007a.C0631a) r6
        L_0x00aa:
            r8.m501a((com.applovin.impl.p007a.C0631a) r6, (com.applovin.impl.adview.C0740d) r9)
            goto L_0x01c3
        L_0x00af:
            android.net.Uri r10 = android.net.Uri.parse(r11)
            r8.m502a((com.applovin.impl.adview.C0740d) r9, (android.net.Uri) r10)
            goto L_0x01c3
        L_0x00b8:
            java.lang.String r11 = "/adservice/deeplink"
            boolean r11 = r11.equals(r5)
            if (r11 == 0) goto L_0x00d2
            boolean r10 = r6 instanceof com.applovin.impl.p007a.C0631a
            if (r10 == 0) goto L_0x00cd
            com.applovin.impl.a.a r6 = (com.applovin.impl.p007a.C0631a) r6
            boolean r10 = r6.mo9304aL()
            if (r10 == 0) goto L_0x00cd
        L_0x00cc:
            goto L_0x00aa
        L_0x00cd:
            r8.m502a((com.applovin.impl.adview.C0740d) r9, (android.net.Uri) r0)
            goto L_0x01c3
        L_0x00d2:
            java.lang.String r9 = "/adservice/postback"
            boolean r9 = r9.equals(r5)
            if (r9 == 0) goto L_0x00df
            r8.m500a((android.net.Uri) r0, (com.applovin.impl.sdk.p025ad.C1057e) r6)
            goto L_0x01c3
        L_0x00df:
            com.applovin.impl.adview.b r9 = r8.f433c
            com.applovin.impl.adview.g r9 = r9.mo9585h()
            if (r9 == 0) goto L_0x015b
            java.lang.String r9 = "/video_began"
            boolean r9 = r9.equals(r5)
            r10 = 0
            if (r9 == 0) goto L_0x0106
            java.lang.String r9 = "duration"
            java.lang.String r9 = r0.getQueryParameter(r9)
            double r9 = com.applovin.impl.sdk.utils.Utils.tryParseDouble(r9, r10)
            com.applovin.impl.adview.b r11 = r8.f433c
            com.applovin.impl.adview.g r11 = r11.mo9585h()
            r11.mo9551a(r9)
            goto L_0x01c3
        L_0x0106:
            java.lang.String r9 = "/video_completed"
            boolean r9 = r9.equals(r5)
            if (r9 == 0) goto L_0x0119
            com.applovin.impl.adview.b r9 = r8.f433c
            com.applovin.impl.adview.g r9 = r9.mo9585h()
            r9.mo9552a_()
            goto L_0x01c3
        L_0x0119:
            java.lang.String r9 = "/video_progress"
            boolean r9 = r9.equals(r5)
            if (r9 == 0) goto L_0x0136
            java.lang.String r9 = "percent_viewed"
            java.lang.String r9 = r0.getQueryParameter(r9)
            double r9 = com.applovin.impl.sdk.utils.Utils.tryParseDouble(r9, r10)
            com.applovin.impl.adview.b r11 = r8.f433c
            com.applovin.impl.adview.g r11 = r11.mo9585h()
            r11.mo9553b(r9)
            goto L_0x01c3
        L_0x0136:
            java.lang.String r9 = "/video_waiting"
            boolean r9 = r9.equals(r5)
            if (r9 == 0) goto L_0x0149
            com.applovin.impl.adview.b r9 = r8.f433c
            com.applovin.impl.adview.g r9 = r9.mo9585h()
            r9.mo9554b_()
            goto L_0x01c3
        L_0x0149:
            java.lang.String r9 = "/video_resumed"
            boolean r9 = r9.equals(r5)
            if (r9 == 0) goto L_0x01c3
            com.applovin.impl.adview.b r9 = r8.f433c
            com.applovin.impl.adview.g r9 = r9.mo9585h()
            r9.mo9555c()
            goto L_0x01c3
        L_0x015b:
            com.applovin.impl.sdk.v r9 = r8.f432b
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "Unknown URL: "
            r11.append(r0)
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            r9.mo11375d(r3, r10)
            com.applovin.impl.sdk.v r9 = r8.f432b
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Path: "
            r10.append(r11)
            r10.append(r5)
            java.lang.String r10 = r10.toString()
            r9.mo11375d(r3, r10)
            goto L_0x01c3
        L_0x0188:
            if (r11 == 0) goto L_0x01c1
            java.util.List r10 = r6.mo10616aw()
            java.util.List r11 = r6.mo10617ax()
            boolean r5 = r10.isEmpty()
            if (r5 != 0) goto L_0x019e
            boolean r10 = r10.contains(r2)
            if (r10 == 0) goto L_0x01ab
        L_0x019e:
            boolean r10 = r11.isEmpty()
            if (r10 != 0) goto L_0x01b3
            boolean r10 = r11.contains(r4)
            if (r10 == 0) goto L_0x01ab
            goto L_0x01b3
        L_0x01ab:
            com.applovin.impl.sdk.v r9 = r8.f432b
            java.lang.String r10 = "URL is not whitelisted - bypassing click"
            r9.mo11376e(r3, r10)
            goto L_0x01c3
        L_0x01b3:
            boolean r10 = r6 instanceof com.applovin.impl.p007a.C0631a
            if (r10 == 0) goto L_0x00cd
            com.applovin.impl.a.a r6 = (com.applovin.impl.p007a.C0631a) r6
            boolean r10 = r6.mo9304aL()
            if (r10 == 0) goto L_0x00cd
            goto L_0x00cc
        L_0x01c1:
            r9 = 0
            return r9
        L_0x01c3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.C0746e.mo9630a(android.webkit.WebView, java.lang.String, boolean):boolean");
    }

    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
        C1314v vVar = this.f432b;
        vVar.mo11374c("AdWebView", "Loaded resource: " + str);
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        C0725b bVar = this.f433c;
        if (bVar != null) {
            bVar.mo9566a(webView);
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        C0725b bVar = this.f433c;
        if (bVar != null) {
            C1057e p = bVar.mo9593p();
            String str3 = "Received error with error code: " + i + " with description \\'" + str + "\\' for URL: " + str2;
            if (p != null) {
                this.f431a.mo10964ab().mo10717a((AppLovinAdBase) p).mo10727a(C1094b.f1893z, str3).mo10728a();
            }
            this.f432b.mo11376e("AdWebView", str3 + " for ad: " + p);
        }
    }

    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        onReceivedError(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
    }

    @TargetApi(21)
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        C0725b bVar = this.f433c;
        if (bVar != null) {
            C1057e p = bVar.mo9593p();
            this.f431a.mo10964ab().mo10717a((AppLovinAdBase) p).mo10725a(C1094b.f1863A).mo10728a();
            C1314v vVar = this.f432b;
            vVar.mo11376e("AdWebView", "Received HTTP error: " + webResourceResponse + "for url: " + webResourceRequest.getUrl() + " and ad: " + p);
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        C0725b bVar = this.f433c;
        if (bVar != null) {
            C1057e p = bVar.mo9593p();
            String str = "Received SSL error: " + sslError;
            this.f431a.mo10964ab().mo10717a((AppLovinAdBase) p).mo10727a(C1094b.f1865C, str).mo10728a();
            this.f432b.mo11376e("AdWebView", str + " for ad: " + p);
        }
    }

    @TargetApi(26)
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (this.f433c == null) {
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Render process gone for ad: ");
        outline24.append(this.f433c.mo9593p());
        outline24.append(". Process did crash: ");
        outline24.append(renderProcessGoneDetail.didCrash());
        C1314v.m2663i("AdWebView", outline24.toString());
        C1057e p = this.f433c.mo9593p();
        if (p != null) {
            this.f431a.mo10964ab().mo10717a((AppLovinAdBase) p).mo10725a(C1094b.f1864B).mo10728a();
        }
        if (!((Boolean) this.f431a.mo10946a(C1085b.f1761eJ)).booleanValue()) {
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }
        if (renderProcessGoneDetail.didCrash() && ((Boolean) this.f431a.mo10946a(C1085b.f1764eM)).booleanValue()) {
            throw new RuntimeException(GeneratedOutlineSupport.outline16("Render process crashed. This is likely caused by a crash in an AppLovin ad with ID: ", p != null ? String.valueOf(p.getAdIdNumber()) : "null"));
        } else if (webView == null || !webView.equals(this.f433c.mo9596s())) {
            return true;
        } else {
            this.f433c.mo9583f();
            AppLovinAdSize b = this.f433c.mo9578b();
            if (!Utils.isBML(b)) {
                return true;
            }
            this.f433c.mo9577a(b);
            this.f433c.mo9582e();
            return true;
        }
    }

    @TargetApi(24)
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        boolean hasGesture = ((Boolean) this.f431a.mo10946a(C1085b.f1605bJ)).booleanValue() ? webResourceRequest.hasGesture() : true;
        Uri url = webResourceRequest.getUrl();
        if (url != null) {
            return mo9630a(webView, url.toString(), hasGesture);
        }
        this.f432b.mo11376e("AdWebView", "No url found for request");
        return false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return mo9630a(webView, str, true);
    }
}
