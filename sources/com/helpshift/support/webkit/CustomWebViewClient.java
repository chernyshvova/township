package com.helpshift.support.webkit;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.helpshift.analytics.AnalyticsEventKey;
import com.helpshift.analytics.AnalyticsEventType;
import com.helpshift.util.AndroidFileUtil;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HelpshiftContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class CustomWebViewClient extends WebViewClient {
    public static final String TAG = CustomWebViewClient.class.getSimpleName();
    public Context context;
    public final CustomWebViewClientListeners customWebViewClientListeners;

    public interface CustomWebViewClientListeners {
        void onPageFinished();

        void onPageStarted();
    }

    public CustomWebViewClient(Context context2, CustomWebViewClientListeners customWebViewClientListeners2) {
        this.customWebViewClientListeners = customWebViewClientListeners2;
        this.context = context2;
    }

    private boolean handleUrlClick(WebView webView, String str) {
        Context context2 = webView.getContext();
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String trim = str.trim();
        Intent intent = new Intent("android.intent.action.VIEW");
        Uri parse = Uri.parse(trim);
        intent.setData(parse);
        try {
            pushFAQDeeplinkClickEvent(trim, parse.getScheme());
            context2.startActivity(intent);
            return true;
        } catch (Exception e) {
            HSLogger.m3238d(TAG, "Unable to resolve activity", (Throwable) e);
            return false;
        }
    }

    private WebResourceResponse interceptRequest(String str) {
        URL url;
        File externalCacheDir = this.context.getExternalCacheDir();
        try {
            url = new URL(str);
        } catch (MalformedURLException e) {
            HSLogger.m3238d(TAG, "MalformedURLException", (Throwable) e);
            url = null;
        }
        if (url != null) {
            File file = new File(externalCacheDir, str.replace("/", "_"));
            if (file.exists()) {
                try {
                    return new WebResourceResponse("", "", new FileInputStream(file));
                } catch (FileNotFoundException e2) {
                    HSLogger.m3248w(TAG, "FileNotFoundException", e2);
                }
            } else if (AndroidFileUtil.isSupportedMimeType(AndroidFileUtil.getMimeType(url))) {
                AndroidFileUtil.saveFile(url, file);
            }
        }
        return null;
    }

    private void pushFAQDeeplinkClickEvent(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsEventKey.PROTOCOL, str2);
        hashMap.put(AnalyticsEventKey.URL, str);
        HelpshiftContext.getCoreApi().getAnalyticsEventDM().pushEvent(AnalyticsEventType.LINK_VIA_FAQ, (Map<String, Object>) hashMap);
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.customWebViewClientListeners.onPageFinished();
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.customWebViewClientListeners.onPageStarted();
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        WebResourceResponse interceptRequest;
        if (Build.VERSION.SDK_INT < 21 || (interceptRequest = interceptRequest(webResourceRequest.getUrl().toString())) == null) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
        return interceptRequest;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        if (Build.VERSION.SDK_INT < 24 || !handleUrlClick(webView, webResourceRequest.getUrl().toString())) {
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
        return true;
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        WebResourceResponse interceptRequest;
        if (Build.VERSION.SDK_INT >= 21 || (interceptRequest = interceptRequest(str)) == null) {
            return super.shouldInterceptRequest(webView, str);
        }
        return interceptRequest;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (Build.VERSION.SDK_INT >= 24 || !handleUrlClick(webView, str)) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        return true;
    }
}
