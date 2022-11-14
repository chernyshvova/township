package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzs;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcsq implements zzcsg {
    public final Context zza;
    public final zzg zzb = zzs.zzg().zzl();

    public zzcsq(Context context) {
        this.zza = context;
    }

    public final void zza(Map<String, String> map) {
        if (!map.isEmpty()) {
            String str = map.get("gad_idless");
            if (str != null) {
                boolean parseBoolean = Boolean.parseBoolean(str);
                map.remove("gad_idless");
                if (((Boolean) zzbex.zzc().zzb(zzbjn.zzao)).booleanValue()) {
                    this.zzb.zzB(parseBoolean);
                    if (((Boolean) zzbex.zzc().zzb(zzbjn.zzew)).booleanValue() && parseBoolean) {
                        this.zza.deleteDatabase("OfflineUpload.db");
                    }
                }
            }
            Bundle bundle = new Bundle();
            for (Map.Entry next : map.entrySet()) {
                bundle.putString((String) next.getKey(), (String) next.getValue());
            }
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzaj)).booleanValue()) {
                zzs.zzA().zze(bundle);
            }
        }
    }
}
