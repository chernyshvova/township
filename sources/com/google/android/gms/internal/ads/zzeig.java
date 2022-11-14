package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeig implements zzedp<zzbxo, zzefj> {
    public final zzejk zza;

    public zzeig(zzejk zzejk) {
        this.zza = zzejk;
    }

    public final zzedq<zzbxo, zzefj> zza(String str, JSONObject jSONObject) throws zzezb {
        zzbxo zzb = this.zza.zzb(str);
        if (zzb == null) {
            return null;
        }
        return new zzedq<>(zzb, new zzefj(), str);
    }
}
