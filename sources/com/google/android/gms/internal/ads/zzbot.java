package com.google.android.gms.internal.ads;

import com.facebook.GraphRequest;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbot implements zzbps<Object> {
    public final zzbou zza;

    public zzbot(zzbou zzbou) {
        this.zza = zzbou;
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("name");
        if (str == null) {
            zzcgs.zzi("App event with no name parameter.");
        } else {
            this.zza.zzbS(str, map.get(GraphRequest.DEBUG_SEVERITY_INFO));
        }
    }
}
