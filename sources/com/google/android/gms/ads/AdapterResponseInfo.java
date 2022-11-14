package com.google.android.gms.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.internal.ads.zzbdd;
import com.google.android.gms.internal.ads.zzbdt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class AdapterResponseInfo {
    public final zzbdt zza;
    @Nullable
    public final AdError zzb;

    public AdapterResponseInfo(zzbdt zzbdt) {
        this.zza = zzbdt;
        zzbdd zzbdd = zzbdt.zzc;
        this.zzb = zzbdd == null ? null : zzbdd.zza();
    }

    @Nullable
    public static AdapterResponseInfo zza(@Nullable zzbdt zzbdt) {
        if (zzbdt != null) {
            return new AdapterResponseInfo(zzbdt);
        }
        return null;
    }

    @RecentlyNullable
    public AdError getAdError() {
        return this.zzb;
    }

    @RecentlyNonNull
    public String getAdapterClassName() {
        return this.zza.zza;
    }

    @RecentlyNonNull
    public Bundle getCredentials() {
        return this.zza.zzd;
    }

    public long getLatencyMillis() {
        return this.zza.zzb;
    }

    @RecentlyNonNull
    public String toString() {
        try {
            return zzb().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    @RecentlyNonNull
    public final JSONObject zzb() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Adapter", this.zza.zza);
        jSONObject.put("Latency", this.zza.zzb);
        JSONObject jSONObject2 = new JSONObject();
        for (String str : this.zza.zzd.keySet()) {
            jSONObject2.put(str, this.zza.zzd.get(str));
        }
        jSONObject.put("Credentials", jSONObject2);
        AdError adError = this.zzb;
        if (adError == null) {
            jSONObject.put("Ad Error", "null");
        } else {
            jSONObject.put("Ad Error", adError.zzb());
        }
        return jSONObject;
    }
}
