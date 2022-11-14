package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zze;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzesb implements zzeqp<zzeqo<JSONObject>> {
    public final JSONObject zza;

    public zzesb(Context context) {
        this.zza = zzcbu.zzb(context);
    }

    public final zzfqn<zzeqo<JSONObject>> zza() {
        return zzfqe.zza(new zzesa(this));
    }

    public final /* synthetic */ void zzb(JSONObject jSONObject) {
        try {
            jSONObject.put("gms_sdk_env", this.zza);
        } catch (JSONException unused) {
            zze.zza("Failed putting version constants.");
        }
    }
}
