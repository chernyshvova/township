package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzebc implements zzgjg<zzebb> {
    public final zzgju<Context> zza;
    public final zzgju<Executor> zzb;
    public final zzgju<zzcbw> zzc;
    public final zzgju<zzcsd> zzd;
    public final zzgju<zzcbv> zze;
    public final zzgju<HashMap<String, zzeay>> zzf;
    public final zzgju<zzebg> zzg;

    public zzebc(zzgju<Context> zzgju, zzgju<Executor> zzgju2, zzgju<zzcbw> zzgju3, zzgju<zzcsd> zzgju4, zzgju<zzcbv> zzgju5, zzgju<HashMap<String, zzeay>> zzgju6, zzgju<zzebg> zzgju7) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
        this.zzd = zzgju4;
        this.zze = zzgju5;
        this.zzf = zzgju6;
        this.zzg = zzgju7;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzebb(((zzcou) this.zza).zza(), this.zzb.zzb(), new zzcbw(), ((zzcpa) this.zzd).zzb(), ((zzcpl) this.zze).zzb(), this.zzf.zzb(), new zzebg(), (zzebg) null);
    }
}
