package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdvc implements zzgjg<zzduz> {
    public final zzgju<Executor> zza;
    public final zzgju<zzcgx> zzb;
    public final zzgju<zzfdp> zzc;
    public final zzgju<zzfdr> zzd;

    public zzdvc(zzgju<Executor> zzgju, zzgju<zzcgx> zzgju2, zzgju<zzfdp> zzgju3, zzgju<zzfdr> zzgju4) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
        this.zzd = zzgju4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfqo zzfqo = zzche.zza;
        zzgjp.zzb(zzfqo);
        return new zzduz(zzfqo, this.zzb.zzb(), ((zzfdq) this.zzc).zzb(), new zzfdr());
    }
}
