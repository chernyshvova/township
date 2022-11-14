package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.internal.ads.zzcnt;
import com.google.android.gms.internal.ads.zzcoa;
import com.google.android.gms.internal.ads.zzcoc;

@TargetApi(17)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcns<WebViewT extends zzcnt & zzcoa & zzcoc> {
    public final zzcnr zza;
    public final WebViewT zzb;

    public zzcns(WebViewT webviewt, zzcnr zzcnr) {
        this.zza = zzcnr;
        this.zzb = webviewt;
    }

    @JavascriptInterface
    public String getClickSignals(String str) {
        if (TextUtils.isEmpty(str)) {
            zze.zza("Click string is empty, not proceeding.");
            return "";
        }
        zzfb zzU = this.zzb.zzU();
        if (zzU == null) {
            zze.zza("Signal utils is empty, ignoring.");
            return "";
        }
        zzex zzb2 = zzU.zzb();
        if (zzb2 == null) {
            zze.zza("Signals object is empty, ignoring.");
            return "";
        } else if (this.zzb.getContext() == null) {
            zze.zza("Context is null, ignoring.");
            return "";
        } else {
            Context context = this.zzb.getContext();
            WebViewT webviewt = this.zzb;
            return zzb2.zzf(context, str, (View) webviewt, webviewt.zzj());
        }
    }

    @JavascriptInterface
    public void notify(String str) {
        if (TextUtils.isEmpty(str)) {
            zzcgs.zzi("URL is empty, ignoring message");
        } else {
            zzr.zza.post(new zzcnq(this, str));
        }
    }

    public final /* synthetic */ void zza(String str) {
        this.zza.zza(Uri.parse(str));
    }
}
