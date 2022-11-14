package com.applovin.impl.adview;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;

/* renamed from: com.applovin.impl.adview.c */
public class C0739c extends WebChromeClient {

    /* renamed from: a */
    public final C1314v f417a;

    public C0739c(C1188m mVar) {
        this.f417a = mVar.mo10922B();
    }

    public void onConsoleMessage(String str, int i, String str2) {
        C1314v vVar = this.f417a;
        vVar.mo11375d("AdWebView", "console.log[" + i + "] :" + str);
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        this.f417a.mo11372b("AdWebView", consoleMessage.sourceId() + ": " + consoleMessage.lineNumber() + ": " + consoleMessage.message());
        return true;
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        C1314v vVar = this.f417a;
        vVar.mo11375d("AdWebView", "Alert attempted: " + str2);
        return true;
    }

    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        C1314v vVar = this.f417a;
        vVar.mo11375d("AdWebView", "JS onBeforeUnload attempted: " + str2);
        return true;
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        C1314v vVar = this.f417a;
        vVar.mo11375d("AdWebView", "JS confirm attempted: " + str2);
        return true;
    }
}
