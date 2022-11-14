package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbv;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdme extends zzdmf {
    public final JSONObject zzb;
    public final boolean zzc;
    public final boolean zzd;
    public final boolean zze;
    public final boolean zzf;
    public final String zzg;

    public zzdme(zzeye zzeye, JSONObject jSONObject) {
        super(zzeye);
        this.zzb = zzbv.zzh(jSONObject, "tracking_urls_and_actions", "active_view");
        boolean z = false;
        this.zzc = zzbv.zzi(false, jSONObject, "allow_pub_owned_ad_view");
        this.zzd = zzbv.zzi(false, jSONObject, "attribution", "allow_pub_rendering");
        this.zze = zzbv.zzi(false, jSONObject, "enable_omid");
        this.zzg = zzbv.zzj("", jSONObject, "watermark_overlay_png_base64");
        this.zzf = jSONObject.optJSONObject("overlay") != null ? true : z;
    }

    public final JSONObject zza() {
        JSONObject jSONObject = this.zzb;
        if (jSONObject != null) {
            return jSONObject;
        }
        try {
            return new JSONObject(this.zza.zzz);
        } catch (JSONException unused) {
            return null;
        }
    }

    public final boolean zzb() {
        return this.zzf;
    }

    public final boolean zzc() {
        return this.zzc;
    }

    public final boolean zzd() {
        return this.zze;
    }

    public final boolean zze() {
        return this.zzd;
    }

    public final String zzf() {
        return this.zzg;
    }
}
