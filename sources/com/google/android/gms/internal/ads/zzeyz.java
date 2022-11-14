package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeyz {
    public final JSONObject zza;

    public zzeyz(JSONObject jSONObject) {
        this.zza = jSONObject;
    }

    @Nullable
    public final String zza() {
        if (zzb() - 1 != 1) {
            return "javascript";
        }
        return null;
    }

    public final int zzb() {
        int optInt = this.zza.optInt("media_type", -1);
        if (optInt != 0) {
            return optInt != 1 ? 3 : 1;
        }
        return 2;
    }
}
