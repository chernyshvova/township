package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzeao implements Callable {
    public final zzfqn zza;
    public final zzfqn zzb;

    public zzeao(zzfqn zzfqn, zzfqn zzfqn2) {
        this.zza = zzfqn;
        this.zzb = zzfqn2;
    }

    public final Object call() {
        zzfqn zzfqn = this.zza;
        zzfqn zzfqn2 = this.zzb;
        return new zzeba((zzebe) zzfqn.get(), ((zzeay) zzfqn2.get()).zzb, ((zzeay) zzfqn2.get()).zza);
    }
}
