package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeet implements zzgjg<zzees> {
    public final zzgju<Context> zza;
    public final zzgju<zzcwg> zzb;
    public final zzgju<Executor> zzc;

    public zzeet(zzgju<Context> zzgju, zzgju<zzcwg> zzgju2, zzgju<Executor> zzgju3) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzees(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb());
    }
}
