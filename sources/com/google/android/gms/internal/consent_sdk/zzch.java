package com.google.android.gms.internal.consent_sdk;

import android.annotation.TargetApi;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.annotation.GuardedBy;
import com.helpshift.support.fragments.SingleQuestionFragment;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public class zzch {
    @GuardedBy("WebViewUtil.class")
    public static Boolean zza;

    /* JADX WARNING: Can't wrap try/catch for region: R(5:5|6|7|8|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0012 */
    @android.annotation.TargetApi(19)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zza(android.webkit.WebView r3) {
        /*
            java.lang.Class<com.google.android.gms.internal.consent_sdk.zzch> r0 = com.google.android.gms.internal.consent_sdk.zzch.class
            monitor-enter(r0)
            java.lang.Boolean r1 = zza     // Catch:{ all -> 0x001e }
            if (r1 != 0) goto L_0x0016
            java.lang.String r1 = "(function(){})()"
            r2 = 0
            r3.evaluateJavascript(r1, r2)     // Catch:{ IllegalStateException -> 0x0012 }
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ IllegalStateException -> 0x0012 }
            zza = r3     // Catch:{ IllegalStateException -> 0x0012 }
            goto L_0x0016
        L_0x0012:
            java.lang.Boolean r3 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x001e }
            zza = r3     // Catch:{ all -> 0x001e }
        L_0x0016:
            java.lang.Boolean r3 = zza     // Catch:{ all -> 0x001e }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x001e }
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            return r3
        L_0x001e:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.consent_sdk.zzch.zza(android.webkit.WebView):boolean");
    }

    @TargetApi(19)
    public static void zza(WebView webView, String str) {
        if (zza(webView)) {
            webView.evaluateJavascript(str, (ValueCallback) null);
            return;
        }
        String valueOf = String.valueOf(str);
        webView.loadUrl(valueOf.length() != 0 ? SingleQuestionFragment.JS_inlineScriptTag.concat(valueOf) : new String(SingleQuestionFragment.JS_inlineScriptTag));
    }
}
