package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.text.TextUtils;
import android.webkit.WebView;
import com.playrix.engine.VideoPlayer;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzffm extends zzffj {
    public WebView zza;
    public Long zzb = null;
    public final Map<String, zzfer> zzc;

    public zzffm(Map<String, zzfer> map, String str) {
        this.zzc = map;
    }

    public final void zza() {
        String str;
        WebView webView = new WebView(zzffa.zza().zzb());
        this.zza = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        zzc(this.zza);
        WebView webView2 = this.zza;
        if (webView2 != null && !TextUtils.isEmpty((CharSequence) null)) {
            if ("null".length() != 0) {
                str = "javascript: ".concat("null");
            } else {
                str = new String("javascript: ");
            }
            webView2.loadUrl(str);
        }
        Iterator<String> it = this.zzc.keySet().iterator();
        if (!it.hasNext()) {
            this.zzb = Long.valueOf(System.nanoTime());
            return;
        }
        zzfer zzfer = this.zzc.get(it.next());
        throw null;
    }

    public final void zzb() {
        long j;
        super.zzb();
        if (this.zzb == null) {
            j = 4000;
        } else {
            j = TimeUnit.MILLISECONDS.convert(System.nanoTime() - this.zzb.longValue(), TimeUnit.NANOSECONDS);
        }
        new Handler().postDelayed(new zzffl(this), Math.max(VideoPlayer.FRAME_TIMEOUT - j, 2000));
        this.zza = null;
    }

    public final void zzh(zzfel zzfel, zzfej zzfej) {
        JSONObject jSONObject = new JSONObject();
        Map<String, zzfer> zzf = zzfej.zzf();
        for (String next : zzf.keySet()) {
            zzffn.zzc(jSONObject, next, zzf.get(next));
        }
        zzi(zzfel, zzfej, jSONObject);
    }
}
