package com.google.android.gms.internal.ads;

import android.os.Build;
import android.webkit.WebView;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.constants.CommonSharedPrefrences;
import com.swrve.sdk.rest.RESTClient;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzffj {
    public zzfgh zza = new zzfgh((WebView) null);
    public long zzb;
    public int zzc;

    public zzffj() {
        zzk();
    }

    public void zza() {
    }

    public void zzb() {
        this.zza.clear();
    }

    public final void zzc(WebView webView) {
        this.zza = new zzfgh(webView);
    }

    public final WebView zzd() {
        return (WebView) this.zza.get();
    }

    public final boolean zze() {
        return this.zza.get() != null;
    }

    public final void zzf(String str, long j) {
        if (j >= this.zzb) {
            this.zzc = 2;
            zzffc.zza().zze(zzd(), str);
        }
    }

    public final void zzg(String str, long j) {
        if (j >= this.zzb && this.zzc != 3) {
            this.zzc = 3;
            zzffc.zza().zze(zzd(), str);
        }
    }

    public void zzh(zzfel zzfel, zzfej zzfej) {
        zzi(zzfel, zzfej, (JSONObject) null);
    }

    public final void zzi(zzfel zzfel, zzfej zzfej, JSONObject jSONObject) {
        String zzi = zzfel.zzi();
        JSONObject jSONObject2 = new JSONObject();
        zzffn.zzc(jSONObject2, "environment", "app");
        zzffn.zzc(jSONObject2, "adSessionType", zzfej.zzj());
        JSONObject jSONObject3 = new JSONObject();
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        zzffn.zzc(jSONObject3, "deviceType", GeneratedOutlineSupport.outline19(new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(str2).length()), str, RESTClient.SEMICOLON_SEPARATOR, str2));
        zzffn.zzc(jSONObject3, "osVersion", Integer.toString(Build.VERSION.SDK_INT));
        zzffn.zzc(jSONObject3, "os", "Android");
        zzffn.zzc(jSONObject2, "deviceInfo", jSONObject3);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        zzffn.zzc(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject4 = new JSONObject();
        zzffn.zzc(jSONObject4, "partnerName", zzfej.zzd().zzb());
        zzffn.zzc(jSONObject4, "partnerVersion", zzfej.zzd().zzc());
        zzffn.zzc(jSONObject2, "omidNativeInfo", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        zzffn.zzc(jSONObject5, CommonSharedPrefrences.LIBRARY_VERSION, "1.3.3-google_20200416");
        zzffn.zzc(jSONObject5, "appId", zzffa.zza().zzb().getApplicationContext().getPackageName());
        zzffn.zzc(jSONObject2, "app", jSONObject5);
        if (zzfej.zzh() != null) {
            zzffn.zzc(jSONObject2, "contentUrl", zzfej.zzh());
        }
        zzffn.zzc(jSONObject2, "customReferenceData", zzfej.zzi());
        JSONObject jSONObject6 = new JSONObject();
        Iterator<zzfer> it = zzfej.zze().iterator();
        if (!it.hasNext()) {
            zzffc.zza().zzc(zzd(), zzi, jSONObject2, jSONObject6, jSONObject);
        } else {
            zzfer next = it.next();
            throw null;
        }
    }

    public final void zzj(float f) {
        zzffc.zza().zzf(zzd(), f);
    }

    public final void zzk() {
        this.zzb = System.nanoTime();
        this.zzc = 1;
    }
}
