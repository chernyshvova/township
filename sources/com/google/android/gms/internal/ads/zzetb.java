package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzetb implements zzgjg<zzeta> {
    public final zzgju<Context> zza;
    public final zzgju<Executor> zzb;
    public final zzgju<zzcop> zzc;
    public final zzgju<zzevv<zzcum, zzcus>> zzd;
    public final zzgju<zzeud> zze;
    public final zzgju<zzeyv> zzf;

    public zzetb(zzgju<Context> zzgju, zzgju<Executor> zzgju2, zzgju<zzcop> zzgju3, zzgju<zzevv<zzcum, zzcus>> zzgju4, zzgju<zzeud> zzgju5, zzgju<zzeyv> zzgju6) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
        this.zzd = zzgju4;
        this.zze = zzgju5;
        this.zzf = zzgju6;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzeta(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb(), ((zzevz) this.zzd).zzb(), this.zze.zzb(), new zzeyv());
    }
}
