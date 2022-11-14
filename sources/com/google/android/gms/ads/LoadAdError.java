package com.google.android.gms.ads;

import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbjn;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class LoadAdError extends AdError {
    @Nullable
    public final ResponseInfo zza;

    public LoadAdError(int i, @RecentlyNonNull String str, @RecentlyNonNull String str2, @Nullable AdError adError, @Nullable ResponseInfo responseInfo) {
        super(i, str, str2, adError);
        this.zza = responseInfo;
    }

    @RecentlyNullable
    public ResponseInfo getResponseInfo() {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfJ)).booleanValue()) {
            return this.zza;
        }
        return null;
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
        JSONObject zzb = super.zzb();
        ResponseInfo responseInfo = getResponseInfo();
        if (responseInfo == null) {
            zzb.put("Response Info", "null");
        } else {
            zzb.put("Response Info", responseInfo.zza());
        }
        return zzb;
    }
}
