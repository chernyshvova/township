package com.google.android.gms.ads;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.internal.ads.zzbdt;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbhd;
import com.google.android.gms.internal.ads.zzbjn;
import com.google.android.gms.internal.ads.zzcgs;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class ResponseInfo {
    @Nullable
    public final zzbhd zza;
    public final List<AdapterResponseInfo> zzb = new ArrayList();

    public ResponseInfo(@Nullable zzbhd zzbhd) {
        zzbhd zzbhd2;
        this.zza = zzbhd;
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfJ)).booleanValue() && (zzbhd2 = this.zza) != null) {
            try {
                List<zzbdt> zzg = zzbhd2.zzg();
                if (zzg != null) {
                    for (zzbdt zza2 : zzg) {
                        AdapterResponseInfo zza3 = AdapterResponseInfo.zza(zza2);
                        if (zza3 != null) {
                            this.zzb.add(zza3);
                        }
                    }
                }
            } catch (RemoteException e) {
                zzcgs.zzg("Could not forward getAdapterResponseInfo to ResponseInfo.", e);
            }
        }
    }

    @Nullable
    public static ResponseInfo zzb(@Nullable zzbhd zzbhd) {
        if (zzbhd != null) {
            return new ResponseInfo(zzbhd);
        }
        return null;
    }

    @NonNull
    public static ResponseInfo zzc(@Nullable zzbhd zzbhd) {
        return new ResponseInfo(zzbhd);
    }

    @NonNull
    public List<AdapterResponseInfo> getAdapterResponses() {
        return this.zzb;
    }

    @RecentlyNullable
    public String getMediationAdapterClassName() {
        try {
            zzbhd zzbhd = this.zza;
            if (zzbhd != null) {
                return zzbhd.zze();
            }
            return null;
        } catch (RemoteException e) {
            zzcgs.zzg("Could not forward getMediationAdapterClassName to ResponseInfo.", e);
            return null;
        }
    }

    @RecentlyNullable
    public String getResponseId() {
        try {
            zzbhd zzbhd = this.zza;
            if (zzbhd != null) {
                return zzbhd.zzf();
            }
            return null;
        } catch (RemoteException e) {
            zzcgs.zzg("Could not forward getResponseId to ResponseInfo.", e);
            return null;
        }
    }

    @RecentlyNonNull
    public String toString() {
        try {
            return zza().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    @RecentlyNonNull
    public final JSONObject zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String responseId = getResponseId();
        if (responseId == null) {
            jSONObject.put("Response ID", "null");
        } else {
            jSONObject.put("Response ID", responseId);
        }
        String mediationAdapterClassName = getMediationAdapterClassName();
        if (mediationAdapterClassName == null) {
            jSONObject.put("Mediation Adapter Class Name", "null");
        } else {
            jSONObject.put("Mediation Adapter Class Name", mediationAdapterClassName);
        }
        JSONArray jSONArray = new JSONArray();
        for (AdapterResponseInfo zzb2 : this.zzb) {
            jSONArray.put(zzb2.zzb());
        }
        jSONObject.put("Adapter Responses", jSONArray);
        return jSONObject;
    }
}
