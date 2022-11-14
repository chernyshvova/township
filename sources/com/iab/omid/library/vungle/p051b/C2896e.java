package com.iab.omid.library.vungle.p051b;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import androidx.annotation.VisibleForTesting;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.iab.omid.library.vungle.C2883a;

/* renamed from: com.iab.omid.library.vungle.b.e */
public class C2896e {

    /* renamed from: a */
    public static C2896e f3510a = new C2896e();

    @VisibleForTesting
    /* renamed from: a */
    public void mo36849a(final WebView webView, String str, Object... objArr) {
        if (webView != null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("javascript: if(window.omidBridge!==undefined){omidBridge.");
            sb.append(str);
            sb.append("(");
            if (objArr.length > 0) {
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
            sb.append(")}");
            final String sb2 = sb.toString();
            Handler handler = webView.getHandler();
            if (handler == null || Looper.myLooper() == handler.getLooper()) {
                webView.loadUrl(sb2);
            } else {
                handler.post(new Runnable(this) {
                    public void run() {
                        webView.loadUrl(sb2);
                    }
                });
            }
        } else {
            String outline16 = GeneratedOutlineSupport.outline16("The WebView is null for ", str);
            if (C2883a.f3487a.booleanValue() && !TextUtils.isEmpty(outline16)) {
                Log.i("OMIDLIB", outline16);
            }
        }
    }
}
