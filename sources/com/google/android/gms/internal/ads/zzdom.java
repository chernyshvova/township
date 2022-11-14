package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdom {
    public final zzfqo zza;
    public final zzdoz zzb;
    public final zzdpe zzc;

    public zzdom(zzfqo zzfqo, zzdoz zzdoz, zzdpe zzdpe) {
        this.zza = zzfqo;
        this.zzb = zzdoz;
        this.zzc = zzdpe;
    }

    public final zzfqn<zzdma> zza(zzeyq zzeyq, zzeye zzeye, JSONObject jSONObject) {
        zzfqn zzi;
        zzeyq zzeyq2 = zzeyq;
        zzeye zzeye2 = zzeye;
        JSONObject jSONObject2 = jSONObject;
        zzfqn zzb2 = this.zza.zzb(new zzdok(this, zzeyq2, zzeye2, jSONObject2));
        zzfqn<List<zzbls>> zzb3 = this.zzb.zzb(jSONObject2, "images");
        zzfqn<zzcmr> zzc2 = this.zzb.zzc(jSONObject2, "images", zzeye2, zzeyq2.zzb.zzb);
        zzfqn<zzbls> zza2 = this.zzb.zza(jSONObject2, "secondary_image");
        zzfqn<zzbls> zza3 = this.zzb.zza(jSONObject2, "app_icon");
        zzfqn<zzblp> zzd = this.zzb.zzd(jSONObject2, "attribution");
        zzfqn<zzcmr> zze = this.zzb.zze(jSONObject2, zzeye2, zzeyq2.zzb.zzb);
        zzdoz zzdoz = this.zzb;
        if (!jSONObject2.optBoolean("enable_omid")) {
            zzi = zzfqe.zza(null);
        } else {
            JSONObject optJSONObject = jSONObject2.optJSONObject("omid_settings");
            if (optJSONObject == null) {
                zzi = zzfqe.zza(null);
            } else {
                String optString = optJSONObject.optString("omid_html");
                if (TextUtils.isEmpty(optString)) {
                    zzi = zzfqe.zza(null);
                } else {
                    zzi = zzfqe.zzi(zzfqe.zza(null), new zzdou(zzdoz, optString), zzche.zze);
                }
            }
        }
        zzfqn zzfqn = zzi;
        zzfqn<List<zzdpd>> zza4 = this.zzc.zza(jSONObject2, "custom_assets");
        return zzfqe.zzl(zzb2, zzb3, zzc2, zza2, zza3, zzd, zze, zzfqn, zza4).zza(new zzdol(this, zzb2, zzb3, zza3, zza2, zzd, jSONObject, zze, zzc2, zzfqn, zza4), this.zza);
    }
}
