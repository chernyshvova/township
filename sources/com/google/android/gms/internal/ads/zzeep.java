package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzau;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeep implements zzgjg<zzeeo> {
    public final zzgju<zzcwg> zza;
    public final zzgju<Context> zzb;
    public final zzgju<Executor> zzc;
    public final zzgju<zzdsf> zzd;
    public final zzgju<zzeyw> zze;
    public final zzgju<zzfju<zzeye, zzau>> zzf;

    public zzeep(zzgju<zzcwg> zzgju, zzgju<Context> zzgju2, zzgju<Executor> zzgju3, zzgju<zzdsf> zzgju4, zzgju<zzeyw> zzgju5, zzgju<zzfju<zzeye, zzau>> zzgju6) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
        this.zzd = zzgju4;
        this.zze = zzgju5;
        this.zzf = zzgju6;
    }

    /* renamed from: zza */
    public final zzeeo zzb() {
        return new zzeeo(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb(), this.zzd.zzb(), ((zzdau) this.zze).zza(), this.zzf.zzb());
    }
}
