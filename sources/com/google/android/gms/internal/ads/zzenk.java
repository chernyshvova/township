package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzeqo;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzenk<S extends zzeqo<?>> {
    public final zzfqn<S> zza;
    public final long zzb;
    public final Clock zzc;

    public zzenk(zzfqn<S> zzfqn, long j, Clock clock) {
        this.zza = zzfqn;
        this.zzc = clock;
        this.zzb = clock.elapsedRealtime() + j;
    }

    public final boolean zza() {
        return this.zzb < this.zzc.elapsedRealtime();
    }
}
