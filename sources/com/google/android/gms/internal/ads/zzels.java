package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzels implements zzeqp<zzelt> {
    public final Clock zza;
    public final zzeyw zzb;

    public zzels(Clock clock, zzeyw zzeyw) {
        this.zza = clock;
        this.zzb = zzeyw;
    }

    public final zzfqn<zzelt> zza() {
        return zzfqe.zza(new zzelt(this.zzb, this.zza.currentTimeMillis()));
    }
}
