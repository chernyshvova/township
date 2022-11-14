package com.vungle.warren.p037ui.view;

import android.annotation.SuppressLint;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* renamed from: com.vungle.warren.ui.view.WebSettingsUtils */
public class WebSettingsUtils {
    @SuppressLint({"NewApi"})
    public static void applyDefault(WebView webView) {
        WebSettings settings = webView.getSettings();
        settings.setBuiltInZoomControls(false);
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSaveFormData(true);
        settings.setUseWideViewPort(false);
        settings.setAllowFileAccess(true);
        webView.setVisibility(4);
    }
}
