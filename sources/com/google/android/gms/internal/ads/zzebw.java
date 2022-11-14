package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzebw implements zzgjg<zzdhz<zzfcy>> {
    public final zzgju<zzeci> zza;
    public final zzgju<Executor> zzb;

    public zzebw(zzgju<zzeci> zzgju, zzgju<Executor> zzgju2) {
        this.zza = zzgju;
        this.zzb = zzgju2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzeci zza2 = ((zzecj) this.zza).zzb();
        zzfqo zzfqo = zzche.zza;
        zzgjp.zzb(zzfqo);
        return new zzdhz(zza2, zzfqo);
    }
}
