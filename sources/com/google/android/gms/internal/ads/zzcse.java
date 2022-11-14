package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcse {
    public final Map<String, zzcsh> zza;
    public final Map<String, zzcsg> zzb;

    public zzcse(Map<String, zzcsh> map, Map<String, zzcsg> map2) {
        this.zza = map;
        this.zzb = map2;
    }

    public final void zza(zzeyq zzeyq) throws Exception {
        for (zzeyo next : zzeyq.zzb.zzc) {
            if (this.zza.containsKey(next.zza)) {
                this.zza.get(next.zza).zza(next.zzb);
            } else if (this.zzb.containsKey(next.zza)) {
                zzcsg zzcsg = this.zzb.get(next.zza);
                JSONObject jSONObject = next.zzb;
                HashMap hashMap = new HashMap();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next2 = keys.next();
                    String optString = jSONObject.optString(next2);
                    if (optString != null) {
                        hashMap.put(next2, optString);
                    }
                }
                zzcsg.zza(hashMap);
            }
        }
    }
}
