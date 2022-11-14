package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbv;
import com.google.android.gms.ads.internal.util.zze;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzesf implements zzeqo<JSONObject> {
    public final String zza;
    public final String zzb;

    public zzesf(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final /* bridge */ /* synthetic */ void zzd(Object obj) {
        try {
            JSONObject zzg = zzbv.zzg((JSONObject) obj, "pii");
            zzg.put("doritos", this.zza);
            zzg.put("doritos_v2", this.zzb);
        } catch (JSONException unused) {
            zze.zza("Failed putting doritos string.");
        }
    }
}
