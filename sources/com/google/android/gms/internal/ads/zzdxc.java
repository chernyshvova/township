package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.text.TextUtils;
import com.facebook.GraphRequest;
import com.vungle.warren.model.ReportDBAdapter;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdxc implements zzdbg, zzddy, zzdcv {
    public final zzdxo zza;
    public final String zzb;
    public int zzc = 0;
    public zzdxb zzd = zzdxb.AD_REQUESTED;
    public zzdaw zze;
    public zzbdd zzf;

    public zzdxc(zzdxo zzdxo, zzeyw zzeyw) {
        this.zza = zzdxo;
        this.zzb = zzeyw.zzf;
    }

    public static JSONObject zzd(zzdaw zzdaw) throws JSONException {
        JSONObject jSONObject;
        String str;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("winningAdapterClassName", zzdaw.zze());
        jSONObject2.put("responseSecsSinceEpoch", zzdaw.zzc());
        jSONObject2.put("responseId", zzdaw.zzf());
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzgs)).booleanValue()) {
            String zzd2 = zzdaw.zzd();
            if (!TextUtils.isEmpty(zzd2)) {
                String valueOf = String.valueOf(zzd2);
                if (valueOf.length() != 0) {
                    str = "Bidding data: ".concat(valueOf);
                } else {
                    str = new String("Bidding data: ");
                }
                zzcgs.zzd(str);
                jSONObject2.put("biddingData", new JSONObject(zzd2));
            }
        }
        JSONArray jSONArray = new JSONArray();
        List<zzbdt> zzg = zzdaw.zzg();
        if (zzg != null) {
            for (zzbdt next : zzg) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("adapterClassName", next.zza);
                jSONObject3.put("latencyMillis", next.zzb);
                zzbdd zzbdd = next.zzc;
                if (zzbdd == null) {
                    jSONObject = null;
                } else {
                    jSONObject = zze(zzbdd);
                }
                jSONObject3.put("error", jSONObject);
                jSONArray.put(jSONObject3);
            }
        }
        jSONObject2.put("adNetworks", jSONArray);
        return jSONObject2;
    }

    public static JSONObject zze(zzbdd zzbdd) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("errorDomain", zzbdd.zzc);
        jSONObject.put("errorCode", zzbdd.zza);
        jSONObject.put("errorDescription", zzbdd.zzb);
        zzbdd zzbdd2 = zzbdd.zzd;
        jSONObject.put("underlyingError", zzbdd2 == null ? null : zze(zzbdd2));
        return jSONObject;
    }

    public final void zza(zzcxi zzcxi) {
        this.zze = zzcxi.zzm();
        this.zzd = zzdxb.AD_LOADED;
    }

    public final boolean zzb() {
        return this.zzd != zzdxb.AD_REQUESTED;
    }

    public final void zzbT(zzbdd zzbdd) {
        this.zzd = zzdxb.AD_LOAD_FAILED;
        this.zzf = zzbdd;
    }

    public final JSONObject zzc() throws JSONException {
        IBinder iBinder;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("state", this.zzd);
        jSONObject.put(GraphRequest.FORMAT_PARAM, zzeye.zza(this.zzc));
        zzdaw zzdaw = this.zze;
        JSONObject jSONObject2 = null;
        if (zzdaw != null) {
            jSONObject2 = zzd(zzdaw);
        } else {
            zzbdd zzbdd = this.zzf;
            if (!(zzbdd == null || (iBinder = zzbdd.zze) == null)) {
                zzdaw zzdaw2 = (zzdaw) iBinder;
                jSONObject2 = zzd(zzdaw2);
                List<zzbdt> zzg = zzdaw2.zzg();
                if (zzg != null && zzg.isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(zze(this.zzf));
                    jSONObject2.put(ReportDBAdapter.ReportColumns.COLUMN_ERRORS, jSONArray);
                }
            }
        }
        jSONObject.put("responseInfo", jSONObject2);
        return jSONObject;
    }

    public final void zzj(zzcbk zzcbk) {
        this.zza.zzj(this.zzb, this);
    }

    public final void zzq(zzeyq zzeyq) {
        if (!zzeyq.zzb.zza.isEmpty()) {
            this.zzc = zzeyq.zzb.zza.get(0).zzb;
        }
    }
}
