package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcww implements zzgjg<zzcwr> {
    public final zzgju<zzcxh> zza;
    public final zzgju<zzbnz> zzb;
    public final zzgju<Runnable> zzc;
    public final zzgju<Executor> zzd;

    public zzcww(zzgju<zzcxh> zzgju, zzgju<zzbnz> zzgju2, zzgju<Runnable> zzgju3, zzgju<Executor> zzgju4) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
        this.zzd = zzgju4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcwr(((zzczd) this.zza).zzb(), ((zzcwv) this.zzb).zza(), ((zzcwu) this.zzc).zza(), this.zzd.zzb());
    }
}
