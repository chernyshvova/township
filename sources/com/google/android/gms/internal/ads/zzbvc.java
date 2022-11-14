package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbvc {
    public final List<zzbvb> zza;
    public final List<String> zzb;
    public final List<String> zzc;
    public final List<String> zzd;
    public final List<String> zze;
    public final List<String> zzf;
    public final String zzg;
    public final String zzh;

    public zzbvc(JSONObject jSONObject) throws JSONException {
        String str;
        if (zzcgs.zzm(2)) {
            String valueOf = String.valueOf(jSONObject.toString(2));
            if (valueOf.length() != 0) {
                str = "Mediation Response JSON: ".concat(valueOf);
            } else {
                str = new String("Mediation Response JSON: ");
            }
            zze.zza(str);
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                zzbvb zzbvb = new zzbvb(jSONArray.getJSONObject(i2));
                "banner".equalsIgnoreCase(zzbvb.zzv);
                arrayList.add(zzbvb);
                if (i < 0) {
                    Iterator<String> it = zzbvb.zzc.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                                i = i2;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }
        jSONArray.length();
        this.zza = Collections.unmodifiableList(arrayList);
        this.zzg = jSONObject.optString("qdata");
        jSONObject.optInt("fs_model_type", -1);
        jSONObject.optLong("timeout_ms", -1);
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            optJSONObject.optLong("ad_network_timeout_millis", -1);
            zzs.zzu();
            this.zzb = zzbvd.zza(optJSONObject, "click_urls");
            zzs.zzu();
            this.zzc = zzbvd.zza(optJSONObject, "imp_urls");
            zzs.zzu();
            this.zzd = zzbvd.zza(optJSONObject, "downloaded_imp_urls");
            zzs.zzu();
            this.zze = zzbvd.zza(optJSONObject, "nofill_urls");
            zzs.zzu();
            this.zzf = zzbvd.zza(optJSONObject, "remote_ping_urls");
            optJSONObject.optBoolean("render_in_browser", false);
            optJSONObject.optLong("refresh", -1);
            zzccm zza2 = zzccm.zza(optJSONObject.optJSONArray("rewards"));
            if (zza2 == null) {
                this.zzh = null;
            } else {
                this.zzh = zza2.zza;
            }
            optJSONObject.optBoolean("use_displayed_impression", false);
            optJSONObject.optBoolean("allow_pub_rendered_attribution", false);
            optJSONObject.optBoolean("allow_pub_owned_ad_view", false);
            optJSONObject.optBoolean("allow_custom_click_gesture", false);
            return;
        }
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = null;
        this.zzf = null;
        this.zzh = null;
    }
}
