package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdsp {
    @GuardedBy("this")
    public final Map<String, zzdso> zza = new HashMap();

    public final synchronized void zza(String str, zzezn zzezn) {
        if (!this.zza.containsKey(str)) {
            try {
                this.zza.put(str, new zzdso(str, zzezn.zzz(), zzezn.zzA()));
            } catch (zzezb unused) {
            }
        }
    }

    public final synchronized void zzb(String str, zzbxo zzbxo) {
        if (!this.zza.containsKey(str)) {
            try {
                this.zza.put(str, new zzdso(str, zzbxo.zzf(), zzbxo.zzg()));
            } catch (Throwable unused) {
            }
        }
    }

    @Nullable
    public final synchronized zzdso zzc(String str) {
        return this.zza.get(str);
    }

    @Nullable
    public final zzdso zzd(List<String> list) {
        for (String zzc : list) {
            zzdso zzc2 = zzc(zzc);
            if (zzc2 != null) {
                return zzc2;
            }
        }
        return null;
    }
}
