package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzega implements zzedp<zzezn, zzefj> {
    public final zzdss zza;

    public zzega(zzdss zzdss) {
        this.zza = zzdss;
    }

    public final zzedq<zzezn, zzefj> zza(String str, JSONObject jSONObject) throws zzezb {
        return new zzedq<>(this.zza.zzb(str, jSONObject), new zzefj(), str);
    }
}
