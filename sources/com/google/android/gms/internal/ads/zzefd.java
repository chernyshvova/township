package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzefd implements zzgjg<zzefc> {
    public final zzgju<Context> zza;
    public final zzgju<Executor> zzb;
    public final zzgju<zzdjt> zzc;
    public final zzgju<zzeyd> zzd;

    public zzefd(zzgju<Context> zzgju, zzgju<Executor> zzgju2, zzgju<zzdjt> zzgju3, zzgju<zzeyd> zzgju4) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
        this.zzd = zzgju4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzefc(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb(), this.zzd.zzb());
    }
}
