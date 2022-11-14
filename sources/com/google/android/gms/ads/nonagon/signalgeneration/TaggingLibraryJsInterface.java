package com.google.android.gms.ads.nonagon.signalgeneration;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzbjn;
import com.google.android.gms.internal.ads.zzcgs;
import com.google.android.gms.internal.ads.zzfb;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class TaggingLibraryJsInterface {
    public final Context zza;
    public final WebView zzb;
    public final zzfb zzc;

    public TaggingLibraryJsInterface(WebView webView, zzfb zzfb) {
        this.zzb = webView;
        this.zza = webView.getContext();
        this.zzc = zzfb;
    }

    @JavascriptInterface
    @TargetApi(21)
    @KeepForSdk
    public String getClickSignals(String str) {
        zzbjn.zza(this.zza);
        try {
            return this.zzc.zzb().zzg(this.zza, str, this.zzb);
        } catch (RuntimeException e) {
            zzcgs.zzg("Exception getting click signals. ", e);
            zzs.zzg().zzg(e, "TaggingLibraryJsInterface.getClickSignals");
            return "";
        }
    }

    @JavascriptInterface
    @TargetApi(21)
    @KeepForSdk
    public String getQueryInfo() {
        zzs.zzc();
        String uuid = UUID.randomUUID().toString();
        QueryInfo.generate(this.zza, AdFormat.BANNER, new AdRequest.Builder().build(), new zzag(this, uuid));
        return uuid;
    }

    @JavascriptInterface
    @TargetApi(21)
    @KeepForSdk
    public String getViewSignals() {
        zzbjn.zza(this.zza);
        try {
            return this.zzc.zzb().zzi(this.zza, this.zzb, (Activity) null);
        } catch (RuntimeException e) {
            zzcgs.zzg("Exception getting view signals. ", e);
            zzs.zzg().zzg(e, "TaggingLibraryJsInterface.getViewSignals");
            return "";
        }
    }

    @JavascriptInterface
    @TargetApi(21)
    @KeepForSdk
    public void reportTouchEvent(String str) {
        zzbjn.zza(this.zza);
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("x");
            int i2 = jSONObject.getInt("y");
            int i3 = jSONObject.getInt("duration_ms");
            float f = (float) jSONObject.getDouble("force");
            int i4 = jSONObject.getInt("type");
            this.zzc.zzd(MotionEvent.obtain(0, (long) i3, i4 != 0 ? i4 != 1 ? i4 != 2 ? i4 != 3 ? -1 : 3 : 2 : 1 : 0, (float) i, (float) i2, f, 1.0f, 0, 1.0f, 1.0f, 0, 0));
        } catch (RuntimeException | JSONException e) {
            zzcgs.zzg("Failed to parse the touch string. ", e);
            zzs.zzg().zzg(e, "TaggingLibraryJsInterface.reportTouchEvent");
        }
    }
}
