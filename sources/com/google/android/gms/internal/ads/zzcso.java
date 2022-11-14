package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcso implements zzcsg {
    public final zzdxo zza;

    public zzcso(zzdxo zzdxo) {
        this.zza = zzdxo;
    }

    public final void zza(Map<String, String> map) {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzgr)).booleanValue()) {
            String str = map.get("policy_violations");
            if (!TextUtils.isEmpty(str)) {
                this.zza.zzl(str);
            }
        }
    }
}
