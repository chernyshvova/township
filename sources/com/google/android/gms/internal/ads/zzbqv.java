package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.google.android.gms.ads.p033h5.OnH5AdsEventListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final /* synthetic */ class zzbqv implements OnH5AdsEventListener {
    public final WebView zza;

    public zzbqv(WebView webView) {
        this.zza = webView;
    }

    public final void onH5AdsEvent(String str) {
        WebView webView = this.zza;
        int i = zzbqw.zza;
        webView.evaluateJavascript(str, (ValueCallback) null);
    }
}
