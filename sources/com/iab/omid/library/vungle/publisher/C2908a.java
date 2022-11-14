package com.iab.omid.library.vungle.publisher;

import android.annotation.SuppressLint;
import android.webkit.WebView;
import com.iab.omid.library.vungle.p054e.C2906b;

/* renamed from: com.iab.omid.library.vungle.publisher.a */
public class C2908a extends AdSessionStatePublisher {
    @SuppressLint({"SetJavaScriptEnabled"})
    public C2908a(WebView webView) {
        if (webView != null && !webView.getSettings().getJavaScriptEnabled()) {
            webView.getSettings().setJavaScriptEnabled(true);
        }
        this.f3526a = new C2906b(webView);
    }
}
