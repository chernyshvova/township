package com.applovin.sdk;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdImpl;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.Set;

public class AppLovinWebViewActivity extends Activity {
    public static final String EVENT_DISMISSED_VIA_BACK_BUTTON = "dismissed_via_back_button";
    public static final String INTENT_EXTRA_KEY_IMMERSIVE_MODE_ON = "immersive_mode_on";
    public static final String INTENT_EXTRA_KEY_SDK_KEY = "sdk_key";

    /* renamed from: a */
    public String f2727a;

    /* renamed from: b */
    public WebView f2728b;

    /* renamed from: c */
    public EventListener f2729c;

    public interface EventListener {
        void onReceivedEvent(String str);
    }

    public void loadUrl(String str, EventListener eventListener) {
        this.f2729c = eventListener;
        WebView webView = this.f2728b;
        if (webView == null) {
            this.f2727a = str;
        } else {
            webView.loadUrl(str);
        }
    }

    public void onBackPressed() {
        EventListener eventListener = this.f2729c;
        if (eventListener != null) {
            eventListener.onReceivedEvent(EVENT_DISMISSED_VIA_BACK_BUTTON);
        }
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra(INTENT_EXTRA_KEY_SDK_KEY);
        if (TextUtils.isEmpty(stringExtra)) {
            C1314v.m2663i("AppLovinWebViewActivity", "No SDK key specified");
        } else {
            final C1188m mVar = AppLovinSdk.getInstance(stringExtra, new AppLovinSdkSettings(getApplicationContext()), getApplicationContext()).coreSdk;
            try {
                WebView webView = new WebView(this);
                this.f2728b = webView;
                setContentView(webView);
                WebSettings settings = this.f2728b.getSettings();
                settings.setSupportMultipleWindows(false);
                settings.setJavaScriptEnabled(true);
                this.f2728b.setVerticalScrollBarEnabled(true);
                this.f2728b.setHorizontalScrollBarEnabled(true);
                this.f2728b.setScrollBarStyle(33554432);
                this.f2728b.setWebViewClient(new WebViewClient() {
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        Uri parse = Uri.parse(str);
                        String scheme = parse.getScheme();
                        String host = parse.getHost();
                        String path = parse.getPath();
                        C1314v B = mVar.mo10922B();
                        B.mo11372b("AppLovinWebViewActivity", "Handling url load: " + str);
                        if (!AppLovinNativeAdImpl.AD_RESPONSE_TYPE_APPLOVIN.equalsIgnoreCase(scheme) || !"com.applovin.sdk".equalsIgnoreCase(host) || AppLovinWebViewActivity.this.f2729c == null) {
                            return super.shouldOverrideUrlLoading(webView, str);
                        }
                        if (!path.endsWith("webview_event")) {
                            return true;
                        }
                        Set<String> queryParameterNames = parse.getQueryParameterNames();
                        String str2 = queryParameterNames.isEmpty() ? "" : (String) queryParameterNames.toArray()[0];
                        if (StringUtils.isValidString(str2)) {
                            String queryParameter = parse.getQueryParameter(str2);
                            C1314v B2 = mVar.mo10922B();
                            B2.mo11372b("AppLovinWebViewActivity", "Parsed WebView event parameter name: " + str2 + " and value: " + queryParameter);
                            AppLovinWebViewActivity.this.f2729c.onReceivedEvent(queryParameter);
                            return true;
                        }
                        mVar.mo10922B().mo11376e("AppLovinWebViewActivity", "Failed to parse WebView event parameter");
                        return true;
                    }
                });
                if (getIntent().getBooleanExtra(INTENT_EXTRA_KEY_IMMERSIVE_MODE_ON, false)) {
                    getWindow().getDecorView().setSystemUiVisibility(5894);
                }
                if (StringUtils.isValidString(this.f2727a)) {
                    this.f2728b.loadUrl(this.f2727a);
                    return;
                }
                return;
            } catch (Throwable th) {
                mVar.mo10922B().mo11373b("AppLovinWebViewActivity", "Failed to initialize WebView.", th);
            }
        }
        finish();
    }
}
