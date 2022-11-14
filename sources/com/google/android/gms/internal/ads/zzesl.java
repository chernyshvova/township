package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzesl implements zzeqp<zzesm> {
    public final ScheduledExecutorService zza;
    public final Context zzb;
    public final zzbzv zzc;

    public zzesl(zzbzv zzbzv, ScheduledExecutorService scheduledExecutorService, Context context, byte[] bArr) {
        this.zzc = zzbzv;
        this.zza = scheduledExecutorService;
        this.zzb = context;
    }

    public final zzfqn<zzesm> zza() {
        return zzfqe.zzj(zzfqe.zzh(zzfqe.zza(new Bundle()), ((Long) zzbex.zzc().zzb(zzbjn.zzct)).longValue(), TimeUnit.MILLISECONDS, this.zza), zzesk.zza, zzche.zza);
    }
}
