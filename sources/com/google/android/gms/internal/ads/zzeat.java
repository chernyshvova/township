package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzeat implements Callable {
    public final zzebb zza;
    public final zzfqn zzb;
    public final zzfqn zzc;

    public zzeat(zzebb zzebb, zzfqn zzfqn, zzfqn zzfqn2) {
        this.zza = zzebb;
        this.zzb = zzfqn;
        this.zzc = zzfqn2;
    }

    public final Object call() {
        return this.zza.zzj(this.zzb, this.zzc);
    }
}
