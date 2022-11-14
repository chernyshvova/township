package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdps implements zzgjg<zzdpq> {
    public final zzgju<Executor> zza;
    public final zzgju<zzcuc> zzb;
    public final zzgju<zzdib> zzc;

    public zzdps(zzgju<Executor> zzgju, zzgju<zzcuc> zzgju2, zzgju<zzdib> zzgju3) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdpq(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb());
    }
}
