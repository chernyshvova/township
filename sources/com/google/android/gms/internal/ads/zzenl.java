package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzeqo;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzenl<S extends zzeqo> implements zzeqp<S> {
    public final AtomicReference<zzenk<S>> zza = new AtomicReference<>();
    public final Clock zzb;
    public final zzeqp<S> zzc;
    public final long zzd;

    public zzenl(zzeqp<S> zzeqp, long j, Clock clock) {
        this.zzb = clock;
        this.zzc = zzeqp;
        this.zzd = j;
    }

    public final zzfqn<S> zza() {
        zzenk zzenk = this.zza.get();
        if (zzenk == null || zzenk.zza()) {
            zzenk = new zzenk(this.zzc.zza(), this.zzd, this.zzb);
            this.zza.set(zzenk);
        }
        return zzenk.zza;
    }
}
