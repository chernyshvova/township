package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzctt implements zzgjg<zzcts> {
    public final zzgju<zzbuq> zza;
    public final zzgju<zzcto> zzb;
    public final zzgju<Executor> zzc;
    public final zzgju<zzctn> zzd;
    public final zzgju<Clock> zze;

    public zzctt(zzgju<zzbuq> zzgju, zzgju<zzcto> zzgju2, zzgju<Executor> zzgju3, zzgju<zzctn> zzgju4, zzgju<Clock> zzgju5) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
        this.zzd = zzgju4;
        this.zze = zzgju5;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcts(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb(), this.zzd.zzb(), this.zze.zzb());
    }
}
