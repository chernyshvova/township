package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.facebook.GraphRequest;
import com.google.android.gms.ads.internal.util.zzbv;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbor implements zzbps<Object> {
    public final zzbos zza;

    public zzbor(zzbos zzbos) {
        this.zza = zzbos;
    }

    public final void zza(Object obj, Map<String, String> map) {
        if (this.zza != null) {
            String str = map.get("name");
            if (str == null) {
                zzcgs.zzh("Ad metadata with no name parameter.");
                str = "";
            }
            Bundle bundle = null;
            if (map.containsKey(GraphRequest.DEBUG_SEVERITY_INFO)) {
                try {
                    bundle = zzbv.zzk(new JSONObject(map.get(GraphRequest.DEBUG_SEVERITY_INFO)));
                } catch (JSONException e) {
                    zzcgs.zzg("Failed to convert ad metadata to JSON.", e);
                }
            }
            if (bundle == null) {
                zzcgs.zzf("Failed to convert ad metadata to Bundle.");
            } else {
                this.zza.zza(str, bundle);
            }
        }
    }
}
