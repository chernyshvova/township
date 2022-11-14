package com.google.android.gms.internal.ads;

import com.helpshift.analytics.AnalyticsEventKey;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzdzd implements zzfpl {
    public final zzdzg zza;
    public final String zzb;
    public final String zzc;

    public zzdzd(zzdzg zzdzg, String str, String str2) {
        this.zza = zzdzg;
        this.zzb = str;
        this.zzc = str2;
    }

    public final zzfqn zza(Object obj) {
        String str = this.zzb;
        String str2 = this.zzc;
        String str3 = (String) obj;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("headers", new JSONObject());
            jSONObject3.put("body", str);
            jSONObject2.put("base_url", "");
            jSONObject2.put("signals", new JSONObject(str2));
            jSONObject.put("request", jSONObject2);
            jSONObject.put(AnalyticsEventKey.RESPONSE, jSONObject3);
            jSONObject.put("flags", new JSONObject());
            return zzfqe.zza(jSONObject);
        } catch (JSONException e) {
            String valueOf = String.valueOf(e.getMessage());
            throw new JSONException(valueOf.length() != 0 ? "Preloaded loader: ".concat(valueOf) : new String("Preloaded loader: "));
        }
    }
}
