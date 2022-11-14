package com.iab.omid.library.applovin.p045b;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.applovin.adsession.ErrorType;
import com.iab.omid.library.applovin.p047d.C2858c;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.applovin.b.e */
public class C2846e {

    /* renamed from: a */
    public static C2846e f3406a = new C2846e();

    /* renamed from: a */
    public static final C2846e m3308a() {
        return f3406a;
    }

    /* renamed from: a */
    public void mo36734a(WebView webView) {
        mo36740a(webView, "finishSession", new Object[0]);
    }

    /* renamed from: a */
    public void mo36735a(WebView webView, float f) {
        mo36740a(webView, "setDeviceVolume", Float.valueOf(f));
    }

    /* renamed from: a */
    public void mo36736a(WebView webView, ErrorType errorType, String str) {
        mo36740a(webView, "error", errorType.toString(), str);
    }

    /* renamed from: a */
    public void mo36737a(WebView webView, String str, String str2) {
        if (str != null && !TextUtils.isEmpty(str2)) {
            mo36744a(webView, "(function() {this.omidVerificationProperties = this.omidVerificationProperties || {};this.omidVerificationProperties.injectionId = '%INJECTION_ID%';var script=document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");document.body.appendChild(script);})();".replace("%SCRIPT_SRC%", str).replace("%INJECTION_ID%", str2));
        }
    }

    /* renamed from: a */
    public void mo36738a(WebView webView, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            mo36740a(webView, "publishMediaEvent", str, jSONObject);
            return;
        }
        mo36740a(webView, "publishMediaEvent", str);
    }

    /* renamed from: a */
    public void mo36739a(WebView webView, String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        mo36740a(webView, "startSession", str, jSONObject, jSONObject2, jSONObject3);
    }

    @VisibleForTesting
    /* renamed from: a */
    public void mo36740a(WebView webView, String str, Object... objArr) {
        if (webView != null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("javascript: if(window.omidBridge!==undefined){omidBridge.");
            sb.append(str);
            sb.append("(");
            mo36743a(sb, objArr);
            sb.append(")}");
            mo36741a(webView, sb);
            return;
        }
        C2858c.m3373a("The WebView is null for " + str);
    }

    @VisibleForTesting
    /* renamed from: a */
    public void mo36741a(final WebView webView, StringBuilder sb) {
        final String sb2 = sb.toString();
        Handler handler = webView.getHandler();
        if (handler == null || Looper.myLooper() == handler.getLooper()) {
            webView.loadUrl(sb2);
        } else {
            handler.post(new Runnable() {
                public void run() {
                    webView.loadUrl(sb2);
                }
            });
        }
    }

    /* renamed from: a */
    public void mo36742a(WebView webView, JSONObject jSONObject) {
        mo36740a(webView, "init", jSONObject);
    }

    @VisibleForTesting
    /* renamed from: a */
    public void mo36743a(StringBuilder sb, Object[] objArr) {
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                if (obj == null) {
                    sb.append('\"');
                } else {
                    if (obj instanceof String) {
                        String obj2 = obj.toString();
                        if (obj2.startsWith("{")) {
                            sb.append(obj2);
                        } else {
                            sb.append('\"');
                            sb.append(obj2);
                        }
                    } else {
                        sb.append(obj);
                    }
                    sb.append(",");
                }
                sb.append('\"');
                sb.append(",");
            }
            sb.setLength(sb.length() - 1);
        }
    }

    /* renamed from: a */
    public boolean mo36744a(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return false;
        }
        webView.loadUrl("javascript: " + str);
        return true;
    }

    /* renamed from: b */
    public void mo36745b(WebView webView) {
        mo36740a(webView, "publishImpressionEvent", new Object[0]);
    }

    /* renamed from: b */
    public void mo36746b(WebView webView, String str) {
        mo36740a(webView, "setNativeViewHierarchy", str);
    }

    /* renamed from: b */
    public void mo36747b(WebView webView, @NonNull JSONObject jSONObject) {
        mo36740a(webView, "publishLoadedEvent", jSONObject);
    }

    /* renamed from: c */
    public void mo36748c(WebView webView) {
        mo36740a(webView, "publishLoadedEvent", new Object[0]);
    }

    /* renamed from: c */
    public void mo36749c(WebView webView, String str) {
        mo36740a(webView, "setState", str);
    }
}
