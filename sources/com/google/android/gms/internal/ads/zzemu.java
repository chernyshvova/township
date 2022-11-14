package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzemu implements zzeqp<zzeqo<Bundle>> {
    public final Executor zza;
    public final zzcgd zzb;

    public zzemu(Executor executor, zzcgd zzcgd) {
        this.zza = executor;
        this.zzb = zzcgd;
    }

    public final zzfqn<zzeqo<Bundle>> zza() {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzbK)).booleanValue()) {
            return zzfqe.zza(null);
        }
        return zzfqe.zzj(this.zzb.zzn(), zzems.zza, this.zza);
    }
}
