package com.google.android.gms.internal.ads;

import com.facebook.LegacyTokenHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdpe {
    public final Executor zza;
    public final zzdoz zzb;

    public zzdpe(Executor executor, zzdoz zzdoz) {
        this.zza = executor;
        this.zzb = zzdoz;
    }

    public final zzfqn<List<zzdpd>> zza(JSONObject jSONObject, String str) {
        zzfqn<O> zzfqn;
        JSONArray optJSONArray = jSONObject.optJSONArray("custom_assets");
        if (optJSONArray == null) {
            return zzfqe.zza(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject == null) {
                zzfqn = zzfqe.zza(null);
            } else {
                String optString = optJSONObject.optString("name");
                if (optString == null) {
                    zzfqn = zzfqe.zza(null);
                } else {
                    String optString2 = optJSONObject.optString("type");
                    if (LegacyTokenHelper.TYPE_STRING.equals(optString2)) {
                        zzfqn = zzfqe.zza(new zzdpd(optString, optJSONObject.optString("string_value")));
                    } else if ("image".equals(optString2)) {
                        zzfqn = zzfqe.zzj(this.zzb.zza(optJSONObject, "image_value"), new zzdpc(optString), this.zza);
                    } else {
                        zzfqn = zzfqe.zza(null);
                    }
                }
            }
            arrayList.add(zzfqn);
        }
        return zzfqe.zzj(zzfqe.zzk(arrayList), zzdpb.zza, this.zza);
    }
}
