package com.google.android.gms.internal.ads;

import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzdot implements zzfju {
    public final zzdoz zza;
    public final JSONObject zzb;

    public zzdot(zzdoz zzdoz, JSONObject jSONObject) {
        this.zza = zzdoz;
        this.zzb = jSONObject;
    }

    public final Object apply(Object obj) {
        return this.zza.zzg(this.zzb, (List) obj);
    }
}
