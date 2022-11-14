package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzesd implements Callable {
    public final zzfqn zza;
    public final zzfqn zzb;

    public zzesd(zzfqn zzfqn, zzfqn zzfqn2) {
        this.zza = zzfqn;
        this.zzb = zzfqn2;
    }

    public final Object call() {
        return new zzesf((String) this.zza.get(), (String) this.zzb.get());
    }
}
