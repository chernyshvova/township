package com.vungle.warren.p037ui.view;

import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.JsonObject;
import com.vungle.warren.omsdk.WebViewObserver;

/* renamed from: com.vungle.warren.ui.view.WebViewAPI */
public interface WebViewAPI {

    /* renamed from: com.vungle.warren.ui.view.WebViewAPI$MRAIDDelegate */
    public interface MRAIDDelegate {
        boolean processCommand(String str, JsonObject jsonObject);
    }

    /* renamed from: com.vungle.warren.ui.view.WebViewAPI$WebClientErrorHandler */
    public interface WebClientErrorHandler {
        void onReceivedError(String str, boolean z);

        void onRenderProcessUnresponsive(@NonNull WebView webView, @Nullable WebViewRenderProcess webViewRenderProcess);

        boolean onWebRenderingProcessGone(WebView webView, boolean z);
    }

    void notifyPropertiesChange(boolean z);

    void setAdVisibility(boolean z);

    void setConsentStatus(boolean z, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4);

    void setErrorHandler(WebClientErrorHandler webClientErrorHandler);

    void setMRAIDDelegate(MRAIDDelegate mRAIDDelegate);

    void setWebViewObserver(WebViewObserver webViewObserver);
}
