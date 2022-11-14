package com.iab.omid.library.applovin.publisher;

import android.annotation.SuppressLint;
import android.webkit.WebView;

/* renamed from: com.iab.omid.library.applovin.publisher.a */
public class C2865a extends AdSessionStatePublisher {
    @SuppressLint({"SetJavaScriptEnabled"})
    public C2865a(WebView webView) {
        if (webView != null && !webView.getSettings().getJavaScriptEnabled()) {
            webView.getSettings().setJavaScriptEnabled(true);
        }
        mo36763a(webView);
    }
}
