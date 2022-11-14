package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzefv implements zzgjg<zzefu> {
    public final zzgju<Context> zza;
    public final zzgju<zzcgy> zzb;
    public final zzgju<zzdjt> zzc;
    public final zzgju<Executor> zzd;

    public zzefv(zzgju<Context> zzgju, zzgju<zzcgy> zzgju2, zzgju<zzdjt> zzgju3, zzgju<Executor> zzgju4) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
        this.zzd = zzgju4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfqo zzfqo = zzche.zza;
        zzgjp.zzb(zzfqo);
        return new zzefu(this.zza.zzb(), ((zzcpd) this.zzb).zza(), this.zzc.zzb(), zzfqo);
    }
}
