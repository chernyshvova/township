package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaww implements Runnable {
    public final ValueCallback<String> zza = new zzawv(this);
    public final /* synthetic */ zzawo zzb;
    public final /* synthetic */ WebView zzc;
    public final /* synthetic */ boolean zzd;
    public final /* synthetic */ zzawy zze;

    public zzaww(zzawy zzawy, zzawo zzawo, WebView webView, boolean z) {
        this.zze = zzawy;
        this.zzb = zzawo;
        this.zzc = webView;
        this.zzd = z;
    }

    public final void run() {
        if (this.zzc.getSettings().getJavaScriptEnabled()) {
            try {
                this.zzc.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zza);
            } catch (Throwable unused) {
                ((zzawv) this.zza).onReceiveValue("");
            }
        }
    }
}
