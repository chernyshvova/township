package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbv;
import com.google.android.gms.ads.internal.util.zze;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzero implements zzeqo<JSONObject> {
    public final JSONObject zza;

    public zzero(JSONObject jSONObject) {
        this.zza = jSONObject;
    }

    public final /* bridge */ /* synthetic */ void zzd(Object obj) {
        try {
            JSONObject zzg = zzbv.zzg((JSONObject) obj, "content_info");
            JSONObject jSONObject = this.zza;
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                zzg.put(next, jSONObject.get(next));
            }
        } catch (JSONException unused) {
            zze.zza("Failed putting app indexing json.");
        }
    }
}