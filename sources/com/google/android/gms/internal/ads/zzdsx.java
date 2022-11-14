package com.google.android.gms.internal.ads;

import com.facebook.GraphRequest;
import com.google.android.gms.ads.internal.zzs;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdsx {
    public final Map<String, Map<String, JSONObject>> zza = new ConcurrentHashMap();
    public JSONObject zzb;
    public final Executor zzc;
    public boolean zzd;
    public JSONObject zze;

    public zzdsx(Executor executor) {
        this.zzc = executor;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzg */
    public final synchronized void zzf() {
        Map map;
        this.zzd = true;
        zzcfz zzn = zzs.zzg().zzl().zzn();
        if (zzn != null) {
            JSONObject zzg = zzn.zzg();
            if (zzg != null) {
                this.zzb = ((Boolean) zzbex.zzc().zzb(zzbjn.zzcq)).booleanValue() ? zzg.optJSONObject("common_settings") : null;
                this.zze = zzg.optJSONObject("ad_unit_patterns");
                JSONArray optJSONArray = zzg.optJSONArray("ad_unit_id_settings");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("ad_unit_id");
                            String optString2 = optJSONObject.optString(GraphRequest.FORMAT_PARAM);
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject("request_signals");
                            if (!(optString == null || optJSONObject2 == null || optString2 == null)) {
                                if (this.zza.containsKey(optString2)) {
                                    map = this.zza.get(optString2);
                                } else {
                                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                                    this.zza.put(optString2, concurrentHashMap);
                                    map = concurrentHashMap;
                                }
                                map.put(optString, optJSONObject2);
                            }
                        }
                    }
                }
            }
        }
    }

    public final void zza() {
        zzs.zzg().zzl().zzp(new zzdsu(this));
        this.zzc.execute(new zzdsv(this));
    }

    @CheckForNull
    public final JSONObject zzb(String str, String str2) {
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzcp)).booleanValue() || str == null || str2 == null) {
            return null;
        }
        if (!this.zzd) {
            zzf();
        }
        Map map = this.zza.get(str2);
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = (JSONObject) map.get(str);
        if (jSONObject != null) {
            return jSONObject;
        }
        String zza2 = zzdsz.zza(this.zze, str, str2);
        if (zza2 == null) {
            return null;
        }
        return (JSONObject) map.get(zza2);
    }

    @CheckForNull
    public final JSONObject zzc() {
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzcq)).booleanValue()) {
            return null;
        }
        return this.zzb;
    }

    public final /* synthetic */ void zze() {
        this.zzc.execute(new zzdsw(this));
    }
}
