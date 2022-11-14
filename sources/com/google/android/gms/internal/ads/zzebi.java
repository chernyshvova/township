package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import com.swrve.sdk.rest.RESTClient;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzebi implements zzfcb<zzebh, zzebd> {
    public final String zza;

    public zzebi(String str) {
        this.zza = str;
    }

    public final /* bridge */ /* synthetic */ Object zza(Object obj) throws Exception {
        zzebh zzebh = (zzebh) obj;
        int optInt = zzebh.zza.optInt("http_timeout_millis", 60000);
        zzcbn zzb = zzebh.zzb;
        if (zzb.zza() == -2) {
            HashMap hashMap = new HashMap();
            if (zzebh.zzb.zzg() && !TextUtils.isEmpty(this.zza)) {
                hashMap.put("Cookie", this.zza);
            }
            String str = "";
            if (zzebh.zzb.zzf()) {
                JSONObject optJSONObject = zzebh.zza.optJSONObject("pii");
                if (optJSONObject != null) {
                    if (!TextUtils.isEmpty(optJSONObject.optString("doritos", str))) {
                        hashMap.put("x-afma-drt-cookie", optJSONObject.optString("doritos", str));
                    }
                    if (!TextUtils.isEmpty(optJSONObject.optString("doritos_v2", str))) {
                        hashMap.put("x-afma-drt-v2-cookie", optJSONObject.optString("doritos_v2", str));
                    }
                } else {
                    zze.zza("DSID signal does not exist.");
                }
            }
            if (zzebh.zzb != null && !TextUtils.isEmpty(zzebh.zzb.zzd())) {
                str = zzebh.zzb.zzd();
            }
            return new zzebd(zzebh.zzb.zze(), optInt, hashMap, str);
        } else if (zzb.zza() == 1) {
            if (zzb.zzb() != null) {
                zzcgs.zzf(TextUtils.join(RESTClient.COMMA_SEPARATOR, zzb.zzb()));
            }
            throw new zzdxy(2, "Error building request URL.");
        } else {
            throw new zzdxy(1);
        }
    }
}
