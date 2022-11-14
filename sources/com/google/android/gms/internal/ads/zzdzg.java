package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzs;
import java.io.StringReader;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdzg {
    public final zzcop zza;
    public final Context zzb;
    public final zzcgy zzc;
    public final zzeyw zzd;
    public final Executor zze;
    public final String zzf;

    public zzdzg(zzcop zzcop, Context context, zzcgy zzcgy, zzeyw zzeyw, Executor executor, String str) {
        this.zza = zzcop;
        this.zzb = context;
        this.zzc = zzcgy;
        this.zzd = zzeyw;
        this.zze = executor;
        this.zzf = str;
    }

    private final zzfqn<zzeyq> zzc(String str, String str2) {
        zzbuh zzb2 = zzs.zzp().zzb(this.zzb, this.zzc);
        zzbub<JSONObject> zzbub = zzbue.zza;
        return zzfqe.zzi(zzfqe.zzi(zzfqe.zzi(zzfqe.zza(""), new zzdzd(this, str, str2), this.zze), new zzdze(zzb2.zza("google.afma.response.normalize", zzbub, zzbub)), this.zze), new zzdzf(this), this.zze);
    }

    private final String zzd(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("ad_types");
            if (jSONArray != null && "unknown".equals(jSONArray.getString(0))) {
                jSONObject.put("ad_types", new JSONArray().put(this.zzf));
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(valueOf.length() + 45);
            sb.append("Failed to update the ad types for rendering. ");
            sb.append(valueOf);
            zzcgs.zzi(sb.toString());
            return str;
        }
    }

    public static final String zze(String str) {
        try {
            return new JSONObject(str).optString("request_id", "");
        } catch (JSONException unused) {
            return "";
        }
    }

    public final zzfqn<zzeyq> zza() {
        String str = this.zzd.zzd.zzx;
        if (!TextUtils.isEmpty(str)) {
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzff)).booleanValue()) {
                String zze2 = zze(str);
                if (TextUtils.isEmpty(zze2)) {
                    return zzfqe.zzc(new zzehd(15, "Invalid ad string."));
                }
                String zzb2 = this.zza.zzw().zzb(zze2);
                if (!TextUtils.isEmpty(zzb2)) {
                    return zzc(str, zzd(zzb2));
                }
            }
        }
        zzbdb zzbdb = this.zzd.zzd.zzs;
        if (zzbdb != null) {
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfd)).booleanValue()) {
                String zze3 = zze(zzbdb.zza);
                String zze4 = zze(zzbdb.zzb);
                if (!TextUtils.isEmpty(zze4) && zze3.equals(zze4)) {
                    this.zza.zzw().zzc(zze3);
                }
            }
            return zzc(zzbdb.zza, zzd(zzbdb.zzb));
        }
        return zzfqe.zzc(new zzehd(14, "Mismatch request IDs."));
    }

    public final /* synthetic */ zzfqn zzb(JSONObject jSONObject) throws Exception {
        return zzfqe.zza(new zzeyq(new zzeyn(this.zzd), zzeyp.zza(new StringReader(jSONObject.toString()))));
    }
}
