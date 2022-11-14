package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzs;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcbq implements Callable<zzcbp> {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ zzcbs zzb;

    public zzcbq(zzcbs zzcbs, Context context) {
        this.zzb = zzcbs;
        this.zza = context;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzcbp zzcbp;
        zzcbr zzcbr = (zzcbr) this.zzb.zza.get(this.zza);
        if (zzcbr != null) {
            if (zzbks.zza.zze().longValue() + zzcbr.zza >= zzs.zzj().currentTimeMillis()) {
                zzcbp = new zzcbo(this.zza, zzcbr.zzb).zza();
                this.zzb.zza.put(this.zza, new zzcbr(this.zzb, zzcbp));
                return zzcbp;
            }
        }
        zzcbp = new zzcbo(this.zza).zza();
        this.zzb.zza.put(this.zza, new zzcbr(this.zzb, zzcbp));
        return zzcbp;
    }
}
