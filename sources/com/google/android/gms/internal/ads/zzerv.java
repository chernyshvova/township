package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzerv implements zzgjg<zzert> {
    public final zzgju<zzcfw> zza;
    public final zzgju<Integer> zzb;
    public final zzgju<Context> zzc;
    public final zzgju<zzcgd> zzd;
    public final zzgju<ScheduledExecutorService> zze;
    public final zzgju<Executor> zzf;

    public zzerv(zzgju<zzcfw> zzgju, zzgju<Integer> zzgju2, zzgju<Context> zzgju3, zzgju<zzcgd> zzgju4, zzgju<ScheduledExecutorService> zzgju5, zzgju<Executor> zzgju6) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
        this.zzd = zzgju4;
        this.zze = zzgju5;
        this.zzf = zzgju6;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfqo zzfqo = zzche.zza;
        zzgjp.zzb(zzfqo);
        return new zzert(new zzcfw(), ((zzesq) this.zzb).zzb().intValue(), ((zzcou) this.zzc).zza(), this.zzd.zzb(), this.zze.zzb(), zzfqo, (byte[]) null);
    }
}
