package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzelx implements zzeqp {
    public final zzfqn<String> zza;
    public final Executor zzb;

    public zzelx(zzfqn<String> zzfqn, Executor executor) {
        this.zza = zzfqn;
        this.zzb = executor;
    }

    public final zzfqn zza() {
        return zzfqe.zzi(this.zza, zzelv.zza, this.zzb);
    }
}
