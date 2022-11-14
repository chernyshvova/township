package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;
import com.helpshift.analytics.AnalyticsEventKey;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeaz implements zzbua<zzeba> {
    public final /* bridge */ /* synthetic */ JSONObject zzb(Object obj) throws JSONException {
        zzeba zzeba = (zzeba) obj;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject2.put("base_url", zzeba.zzc.zzc());
        jSONObject2.put("signals", zzeba.zzb);
        jSONObject3.put("body", zzeba.zza.zzc);
        jSONObject3.put("headers", zzs.zzc().zzf(zzeba.zza.zzb));
        jSONObject3.put("response_code", zzeba.zza.zza);
        jSONObject3.put("latency", zzeba.zza.zzd);
        jSONObject.put("request", jSONObject2);
        jSONObject.put(AnalyticsEventKey.RESPONSE, jSONObject3);
        jSONObject.put("flags", zzeba.zzc.zzh());
        return jSONObject;
    }
}
