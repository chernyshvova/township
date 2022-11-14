package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.GraphRequest;
import com.google.android.gms.ads.internal.zzs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcfz {
    public final List<String> zza = new ArrayList();
    public final List<String> zzb = new ArrayList();
    public final Map<String, zzbvc> zzc = new HashMap();
    public String zzd;
    public String zze;
    public long zzf;
    public JSONObject zzg;
    public boolean zzh = false;
    public final List<String> zzi = new ArrayList();
    public boolean zzj = false;

    public zzcfz(String str, long j) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        JSONObject optJSONObject2;
        this.zze = str;
        this.zzf = j;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.zzg = jSONObject;
                if (jSONObject.optInt("status", -1) != 1) {
                    this.zzh = false;
                    zzcgs.zzi("App settings could not be fetched successfully.");
                    return;
                }
                this.zzh = true;
                this.zzd = this.zzg.optString("app_id");
                JSONArray optJSONArray2 = this.zzg.optJSONArray("ad_unit_id_settings");
                if (optJSONArray2 != null) {
                    for (int i = 0; i < optJSONArray2.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray2.getJSONObject(i);
                        String optString = jSONObject2.optString(GraphRequest.FORMAT_PARAM);
                        String optString2 = jSONObject2.optString("ad_unit_id");
                        if (!TextUtils.isEmpty(optString)) {
                            if (!TextUtils.isEmpty(optString2)) {
                                if ("interstitial".equalsIgnoreCase(optString)) {
                                    this.zzb.add(optString2);
                                } else if (("rewarded".equalsIgnoreCase(optString) || "rewarded_interstitial".equals(optString)) && (optJSONObject2 = jSONObject2.optJSONObject("mediation_config")) != null) {
                                    this.zzc.put(optString2, new zzbvc(optJSONObject2));
                                }
                            }
                        }
                    }
                }
                JSONArray optJSONArray3 = this.zzg.optJSONArray("persistable_banner_ad_unit_ids");
                if (optJSONArray3 != null) {
                    for (int i2 = 0; i2 < optJSONArray3.length(); i2++) {
                        this.zza.add(optJSONArray3.optString(i2));
                    }
                }
                if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfc)).booleanValue()) {
                    JSONObject optJSONObject3 = this.zzg.optJSONObject("common_settings");
                    if (!(optJSONObject3 == null || (optJSONArray = optJSONObject3.optJSONArray("loeid")) == null)) {
                        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                            this.zzi.add(optJSONArray.get(i3).toString());
                        }
                    }
                }
                if (((Boolean) zzbex.zzc().zzb(zzbjn.zzeB)).booleanValue() && (optJSONObject = this.zzg.optJSONObject("common_settings")) != null) {
                    this.zzj = optJSONObject.optBoolean("is_prefetching_enabled", false);
                }
            } catch (JSONException e) {
                zzcgs.zzj("Exception occurred while processing app setting json", e);
                zzs.zzg().zzg(e, "AppSettings.parseAppSettingsJson");
            }
        }
    }

    public final void zza(long j) {
        this.zzf = j;
    }

    public final long zzb() {
        return this.zzf;
    }

    public final boolean zzc() {
        return this.zzh;
    }

    public final String zzd() {
        return this.zze;
    }

    public final String zze() {
        return this.zzd;
    }

    public final Map<String, zzbvc> zzf() {
        return this.zzc;
    }

    public final JSONObject zzg() {
        return this.zzg;
    }

    public final List<String> zzh() {
        return this.zzi;
    }

    public final boolean zzi() {
        return this.zzj;
    }
}
