package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.util.Map;

@TargetApi(11)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcnu extends zzcnv {
    public zzcnu(zzcmr zzcmr, zzayx zzayx, boolean z) {
        super(zzcmr, zzayx, z);
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zzL(webView, str, (Map<String, String>) null);
    }
}
