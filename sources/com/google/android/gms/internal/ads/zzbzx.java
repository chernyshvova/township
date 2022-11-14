package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbzx {
    public final boolean zza;
    public final String zzb;

    public zzbzx(boolean z, String str) {
        this.zza = z;
        this.zzb = str;
    }

    @Nullable
    public static zzbzx zza(JSONObject jSONObject) {
        return new zzbzx(jSONObject.optBoolean("enable_prewarming", false), jSONObject.optString("prefetch_url", ""));
    }
}
