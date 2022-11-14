package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.util.zzbv;
import com.google.android.gms.ads.internal.util.zze;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzerf implements zzeqo<JSONObject> {
    public final AdvertisingIdClient.Info zza;
    public final String zzb;

    public zzerf(AdvertisingIdClient.Info info, String str) {
        this.zza = info;
        this.zzb = str;
    }

    public final /* bridge */ /* synthetic */ void zzd(Object obj) {
        try {
            JSONObject zzg = zzbv.zzg((JSONObject) obj, "pii");
            AdvertisingIdClient.Info info = this.zza;
            if (info == null || TextUtils.isEmpty(info.getId())) {
                zzg.put("pdid", this.zzb);
                zzg.put("pdidtype", "ssaid");
                return;
            }
            zzg.put("rdid", this.zza.getId());
            zzg.put("is_lat", this.zza.isLimitAdTrackingEnabled());
            zzg.put("idtype", "adid");
        } catch (JSONException e) {
            zze.zzb("Failed putting Ad ID.", e);
        }
    }
}
