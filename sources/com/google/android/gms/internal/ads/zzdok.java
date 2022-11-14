package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.vungle.warren.model.ReportDBAdapter;
import com.vungle.warren.model.VisionDataDBAdapter;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzdok implements Callable {
    public final zzdom zza;
    public final zzeyq zzb;
    public final zzeye zzc;
    public final JSONObject zzd;

    public zzdok(zzdom zzdom, zzeyq zzeyq, zzeye zzeye, JSONObject jSONObject) {
        this.zza = zzdom;
        this.zzb = zzeyq;
        this.zzc = zzeye;
        this.zzd = jSONObject;
    }

    public final Object call() {
        zzeyq zzeyq = this.zzb;
        zzeye zzeye = this.zzc;
        JSONObject jSONObject = this.zzd;
        zzdma zzdma = new zzdma();
        zzdma.zza(jSONObject.optInt(ReportDBAdapter.ReportColumns.COLUMN_TEMPATE_ID, -1));
        zzdma.zzl(jSONObject.optString("custom_template_id"));
        JSONObject optJSONObject = jSONObject.optJSONObject("omid_settings");
        zzdma.zzt(optJSONObject != null ? optJSONObject.optString("omid_partner_name") : null);
        zzeyw zzeyw = zzeyq.zza.zza;
        if (zzeyw.zzg.contains(Integer.toString(zzdma.zzv()))) {
            if (zzdma.zzv() == 3) {
                if (zzdma.zzQ() == null) {
                    throw new zzehd(1, "No custom template id for custom template ad response.");
                } else if (!zzeyw.zzh.contains(zzdma.zzQ())) {
                    throw new zzehd(1, "Unexpected custom template id in the response.");
                }
            }
            zzdma.zzi(jSONObject.optDouble("rating", -1.0d));
            String optString = jSONObject.optString("headline", (String) null);
            if (zzeye.zzI) {
                zzs.zzc();
                String zzC = zzr.zzC();
                optString = GeneratedOutlineSupport.outline19(new StringBuilder(String.valueOf(zzC).length() + 3 + String.valueOf(optString).length()), zzC, " : ", optString);
            }
            zzdma.zzq("headline", optString);
            zzdma.zzq("body", jSONObject.optString("body", (String) null));
            zzdma.zzq("call_to_action", jSONObject.optString("call_to_action", (String) null));
            zzdma.zzq("store", jSONObject.optString("store", (String) null));
            zzdma.zzq("price", jSONObject.optString("price", (String) null));
            zzdma.zzq(VisionDataDBAdapter.VisionDataColumns.COLUMN_ADVERTISER, jSONObject.optString(VisionDataDBAdapter.VisionDataColumns.COLUMN_ADVERTISER, (String) null));
            return zzdma;
        }
        throw new zzehd(1, GeneratedOutlineSupport.outline9(32, "Invalid template ID: ", zzdma.zzv()));
    }
}
