package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzehq implements zzedp<zzezn, zzefk> {
    @GuardedBy("this")
    public final Map<String, zzedq<zzezn, zzefk>> zza = new HashMap();
    public final zzdss zzb;

    public zzehq(zzdss zzdss) {
        this.zzb = zzdss;
    }

    public final zzedq<zzezn, zzefk> zza(String str, JSONObject jSONObject) throws zzezb {
        zzedq<zzezn, zzefk> zzedq;
        synchronized (this) {
            zzedq = this.zza.get(str);
            if (zzedq == null) {
                zzedq = new zzedq<>(this.zzb.zzb(str, jSONObject), new zzefk(), str);
                this.zza.put(str, zzedq);
            }
        }
        return zzedq;
    }
}
