package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzerg implements zzgjg<zzere> {
    public final zzgju<zzcfw> zza;
    public final zzgju<Context> zzb;
    public final zzgju<ScheduledExecutorService> zzc;
    public final zzgju<Executor> zzd;
    public final zzgju<Integer> zze;

    public zzerg(zzgju<zzcfw> zzgju, zzgju<Context> zzgju2, zzgju<ScheduledExecutorService> zzgju3, zzgju<Executor> zzgju4, zzgju<Integer> zzgju5) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
        this.zzd = zzgju4;
        this.zze = zzgju5;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfqo zzfqo = zzche.zza;
        zzgjp.zzb(zzfqo);
        return new zzere(new zzcfw(), ((zzcou) this.zzb).zza(), this.zzc.zzb(), zzfqo, ((zzesq) this.zze).zzb().intValue(), (byte[]) null);
    }
}
