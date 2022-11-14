package com.google.android.gms.internal.consent_sdk;

import android.annotation.TargetApi;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzbf extends WebViewClient {
    public final /* synthetic */ zzbe zza;

    public zzbf(zzbe zzbe) {
        this.zza = zzbe;
    }

    public final void onLoadResource(WebView webView, String str) {
        if (zzbe.zza(str)) {
            this.zza.zzb.zza(str);
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        if (!this.zza.zzc) {
            zzbj unused = this.zza.zzb;
            Log.d("UserMessagingPlatform", "Wall html loaded.");
            boolean unused2 = this.zza.zzc = true;
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        this.zza.zzb.zza(i, str, str2);
    }

    @TargetApi(24)
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        String uri = webResourceRequest.getUrl().toString();
        if (!zzbe.zza(uri)) {
            return false;
        }
        this.zza.zzb.zza(uri);
        return true;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!zzbe.zza(str)) {
            return false;
        }
        this.zza.zzb.zza(str);
        return true;
    }
}
