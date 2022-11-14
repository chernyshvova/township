package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.gms.ads.p033h5.H5AdsRequestHandler;

@RequiresApi(api = 21)
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbqw extends zzbqj {
    public static final /* synthetic */ int zza = 0;
    @Nullable
    public WebViewClient zzb;
    public final H5AdsRequestHandler zzc;
    public final WebView zzd;

    public zzbqw(Context context, WebView webView) {
        if (context == null) {
            throw null;
        } else if (webView != null) {
            zzfke.zza(webView.getSettings().getJavaScriptEnabled(), "JavaScript must be enabled on the WebView.");
            this.zzd = webView;
            this.zzc = new H5AdsRequestHandler(context, new zzbqv(webView));
        } else {
            throw null;
        }
    }

    private final boolean zzc(WebView webView) {
        if (this.zzd.equals(webView)) {
            return true;
        }
        zzcgs.zzf("H5AdsWebViewClient must be attached to the same WebVew which was passed in the constructor.");
        return false;
    }

    @Nullable
    public final WebViewClient getDelegate() {
        return this.zzb;
    }

    public final void onLoadResource(WebView webView, String str) {
        if (zzc(webView) && !this.zzc.handleH5AdsRequest(str)) {
            super.onLoadResource(webView, str);
        }
    }

    @RequiresApi(api = 24)
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        if (!zzc(this.zzd)) {
            return false;
        }
        if (this.zzc.handleH5AdsRequest(webResourceRequest.getUrl().toString())) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    public final void zza() {
        this.zzc.clearAdObjects();
    }

    public final void zzb(@Nullable WebViewClient webViewClient) {
        zzfke.zza(webViewClient != this, "Delegate cannot be itself.");
        this.zzb = webViewClient;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!zzc(webView)) {
            return false;
        }
        if (this.zzc.handleH5AdsRequest(str)) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
