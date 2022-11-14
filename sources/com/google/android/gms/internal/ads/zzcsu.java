package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcsu implements zzcsh {
    public final zzcee zza;

    public zzcsu(zzcee zzcee) {
        this.zza = zzcee;
    }

    public final void zza(JSONObject jSONObject) {
        int i;
        long optLong = jSONObject.optLong("timestamp");
        if (jSONObject.optBoolean("npa_reset")) {
            i = -1;
        } else {
            i = jSONObject.optBoolean("npa");
        }
        this.zza.zzd(i, optLong);
    }
}
