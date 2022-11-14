package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdut {
    public final /* synthetic */ zzduu zza;
    public final Map<String, String> zzb = new ConcurrentHashMap();

    @VisibleForTesting
    public zzdut(zzduu zzduu) {
        this.zza = zzduu;
    }

    public final zzdut zza(zzeyh zzeyh) {
        this.zzb.put("gqi", zzeyh.zzb);
        return this;
    }

    public final zzdut zzb(zzeye zzeye) {
        this.zzb.put("aai", zzeye.zzw);
        return this;
    }

    public final zzdut zzc(String str, String str2) {
        this.zzb.put(str, str2);
        return this;
    }

    public final void zzd() {
        this.zza.zzb.execute(new zzdus(this));
    }

    public final String zze() {
        return this.zza.zza.zzc(this.zzb);
    }

    public final /* synthetic */ void zzf() {
        this.zza.zza.zzb(this.zzb);
    }
}
