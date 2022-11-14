package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzdvb {
    public final String zza = zzbkv.zzb.zze();
    public final Map<String, String> zzb = new HashMap();
    public final Executor zzc;
    public final zzcgx zzd;
    public final boolean zze;
    public final zzfdr zzf;

    public zzdvb(Executor executor, zzcgx zzcgx, zzfdr zzfdr) {
        this.zzc = executor;
        this.zzd = zzcgx;
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzbj)).booleanValue()) {
            this.zze = ((Boolean) zzbex.zzc().zzb(zzbjn.zzbm)).booleanValue();
        } else {
            this.zze = ((double) zzbev.zze().nextFloat()) <= zzbkv.zza.zze().doubleValue();
        }
        this.zzf = zzfdr;
    }

    public final void zzb(Map<String, String> map) {
        String zza2 = this.zzf.zza(map);
        if (this.zze) {
            this.zzc.execute(new zzdva(this, zza2));
        }
        zze.zza(zza2);
    }

    public final String zzc(Map<String, String> map) {
        return this.zzf.zza(map);
    }
}
