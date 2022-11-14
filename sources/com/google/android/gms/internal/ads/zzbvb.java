package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.facebook.appevents.codeless.internal.PathComponent;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.internal.zzs;
import com.vungle.warren.downloader.CleverCache;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbvb {
    public final String zza;
    public final String zzb;
    public final List<String> zzc;
    public final String zzd;
    public final String zze;
    public final List<String> zzf;
    public final List<String> zzg;
    public final List<String> zzh;
    public final List<String> zzi;
    public final List<String> zzj;
    public final String zzk;
    public final List<String> zzl;
    public final List<String> zzm;
    public final List<String> zzn;
    public final String zzo;
    public final String zzp;
    @Nullable
    public final String zzq;
    @Nullable
    public final String zzr;
    public final String zzs;
    @Nullable
    public final List<String> zzt;
    public final String zzu;
    @Nullable
    public final String zzv;

    public zzbvb(JSONObject jSONObject) throws JSONException {
        List<String> list;
        this.zzb = jSONObject.optString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.zzc = Collections.unmodifiableList(arrayList);
        this.zzd = jSONObject.optString("allocation_id", (String) null);
        zzs.zzu();
        this.zzf = zzbvd.zza(jSONObject, "clickurl");
        zzs.zzu();
        this.zzg = zzbvd.zza(jSONObject, "imp_urls");
        zzs.zzu();
        this.zzh = zzbvd.zza(jSONObject, "downloaded_imp_urls");
        zzs.zzu();
        this.zzj = zzbvd.zza(jSONObject, "fill_urls");
        zzs.zzu();
        this.zzl = zzbvd.zza(jSONObject, "video_start_urls");
        zzs.zzu();
        this.zzn = zzbvd.zza(jSONObject, "video_complete_urls");
        zzs.zzu();
        this.zzm = zzbvd.zza(jSONObject, "video_reward_urls");
        this.zzo = jSONObject.optString("transaction_id");
        this.zzp = jSONObject.optString("valid_from_timestamp");
        JSONObject optJSONObject = jSONObject.optJSONObject("ad");
        if (optJSONObject != null) {
            zzs.zzu();
            list = zzbvd.zza(optJSONObject, "manual_impression_urls");
        } else {
            list = null;
        }
        this.zzi = list;
        this.zza = optJSONObject != null ? optJSONObject.toString() : null;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        this.zzk = optJSONObject2 != null ? optJSONObject2.toString() : null;
        this.zze = optJSONObject2 != null ? optJSONObject2.optString(PathComponent.PATH_CLASS_NAME_KEY) : null;
        this.zzq = jSONObject.optString("html_template", (String) null);
        this.zzr = jSONObject.optString("ad_base_url", (String) null);
        JSONObject optJSONObject3 = jSONObject.optJSONObject(CleverCache.ASSETS_DIR);
        this.zzs = optJSONObject3 != null ? optJSONObject3.toString() : null;
        zzs.zzu();
        this.zzt = zzbvd.zza(jSONObject, "template_ids");
        JSONObject optJSONObject4 = jSONObject.optJSONObject("ad_loader_options");
        this.zzu = optJSONObject4 != null ? optJSONObject4.toString() : null;
        this.zzv = jSONObject.optString(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, (String) null);
        jSONObject.optLong("ad_network_timeout_millis", -1);
    }
}
