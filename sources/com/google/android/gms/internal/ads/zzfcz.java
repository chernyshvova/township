package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfcz implements zzgjg<zzfcx> {
    public final zzgju<zzfqo> zza;
    public final zzgju<ScheduledExecutorService> zzb;
    public final zzgju<zzfcw> zzc;

    public zzfcz(zzgju<zzfqo> zzgju, zzgju<ScheduledExecutorService> zzgju2, zzgju<zzfcw> zzgju3) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfqo zzfqo = zzche.zza;
        zzgjp.zzb(zzfqo);
        return new zzfcx(zzfqo, this.zzb.zzb(), ((zzfda) this.zzc).zzb());
    }
}
