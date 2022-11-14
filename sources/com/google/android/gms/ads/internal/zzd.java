package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzfpl;
import com.google.android.gms.internal.ads.zzfqe;
import com.google.android.gms.internal.ads.zzfqn;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzd implements zzfpl {
    public static final zzfpl zza = new zzd();

    public final zzfqn zza(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject.optBoolean("isSuccessful", false)) {
            zzs.zzg().zzl().zzm(jSONObject.getString("appSettingsJson"));
        }
        return zzfqe.zza(null);
    }
}
