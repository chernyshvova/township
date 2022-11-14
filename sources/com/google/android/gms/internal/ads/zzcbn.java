package com.google.android.gms.internal.ads;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.vungle.warren.model.ReportDBAdapter;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcbn {
    public final List<String> zza;
    public final String zzb;
    public final String zzc;
    public final String zzd;
    public final boolean zze;
    public final boolean zzf;
    public final String zzg;
    public final String zzh;
    public final String zzi;
    public final int zzj;
    public final JSONObject zzk;
    public final String zzl;
    public final String zzm;

    public zzcbn(JSONObject jSONObject) {
        List<String> list;
        this.zzi = jSONObject.optString("url");
        this.zzb = jSONObject.optString("base_uri");
        this.zzc = jSONObject.optString("post_parameters");
        this.zze = zzj(jSONObject.optString("drt_include"));
        this.zzf = zzj(jSONObject.optString("cookies_include", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
        this.zzg = jSONObject.optString("request_id");
        this.zzd = jSONObject.optString("type");
        String optString = jSONObject.optString(ReportDBAdapter.ReportColumns.COLUMN_ERRORS);
        if (optString == null) {
            list = null;
        } else {
            list = Arrays.asList(optString.split(","));
        }
        this.zza = list;
        this.zzj = jSONObject.optInt("valid", 0) == 1 ? -2 : 1;
        this.zzh = jSONObject.optString("fetched_ad");
        jSONObject.optBoolean("render_test_ad_label");
        JSONObject optJSONObject = jSONObject.optJSONObject("preprocessor_flags");
        this.zzk = optJSONObject == null ? new JSONObject() : optJSONObject;
        this.zzl = jSONObject.optString("analytics_query_ad_event_id");
        jSONObject.optBoolean("is_analytics_logging_enabled");
        this.zzm = jSONObject.optString("pool_key");
    }

    public static boolean zzj(String str) {
        return str != null && (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES) || str.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
    }

    public final int zza() {
        return this.zzj;
    }

    public final List<String> zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzc;
    }

    public final String zze() {
        return this.zzi;
    }

    public final boolean zzf() {
        return this.zze;
    }

    public final boolean zzg() {
        return this.zzf;
    }

    public final JSONObject zzh() {
        return this.zzk;
    }

    public final String zzi() {
        return this.zzm;
    }
}
