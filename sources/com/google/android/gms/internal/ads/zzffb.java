package com.google.android.gms.internal.ads;

import android.webkit.WebView;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzffb implements Runnable {
    public final /* synthetic */ WebView zza;
    public final /* synthetic */ String zzb;

    public zzffb(zzffc zzffc, WebView webView, String str) {
        this.zza = webView;
        this.zzb = str;
    }

    public final void run() {
        this.zza.loadUrl(this.zzb);
    }
}
