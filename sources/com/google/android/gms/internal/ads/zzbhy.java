package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbhy {
    public final String zza;
    public final Bundle zzb;
    public final String zzc;

    public zzbhy(String str, Bundle bundle, String str2) {
        this.zza = str;
        this.zzb = bundle;
        this.zzc = str2;
    }

    public final String zza() {
        return this.zza;
    }

    public final String zzb() {
        if (TextUtils.isEmpty(this.zzc)) {
            return "";
        }
        try {
            return new JSONObject(this.zzc).optString("request_id", "");
        } catch (JSONException unused) {
            return "";
        }
    }

    public final Bundle zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzc;
    }
}
