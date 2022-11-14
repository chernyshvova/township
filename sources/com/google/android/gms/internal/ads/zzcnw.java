package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.Nullable;

@TargetApi(21)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcnw extends zzcnv {
    public zzcnw(zzcmr zzcmr, zzayx zzayx, boolean z) {
        super(zzcmr, zzayx, z);
    }

    @Nullable
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
            return null;
        }
        return zzL(webView, webResourceRequest.getUrl().toString(), webResourceRequest.getRequestHeaders());
    }
}
