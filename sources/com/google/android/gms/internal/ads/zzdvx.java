package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdvx {
    @Nullable
    public Long zza;
    public final String zzb;
    @Nullable
    public String zzc;
    @Nullable
    public Integer zzd;
    @Nullable
    public String zze;
    @Nullable
    public Integer zzf;

    public /* synthetic */ zzdvx(String str, zzdvw zzdvw) {
        this.zzb = str;
    }

    public static /* synthetic */ String zza(zzdvx zzdvx) {
        String str = (String) zzbex.zzc().zzb(zzbjn.zzgx);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("objectId", zzdvx.zza);
            jSONObject.put("eventCategory", zzdvx.zzb);
            jSONObject.putOpt("event", zzdvx.zzc);
            jSONObject.putOpt("errorCode", zzdvx.zzd);
            jSONObject.putOpt("rewardType", zzdvx.zze);
            jSONObject.putOpt("rewardAmount", zzdvx.zzf);
        } catch (JSONException unused) {
            zzcgs.zzi("Could not convert parameters to JSON.");
        }
        String jSONObject2 = jSONObject.toString();
        return GeneratedOutlineSupport.outline20(new StringBuilder(String.valueOf(str).length() + 16 + String.valueOf(jSONObject2).length()), str, "(\"h5adsEvent\",", jSONObject2, ");");
    }
}
