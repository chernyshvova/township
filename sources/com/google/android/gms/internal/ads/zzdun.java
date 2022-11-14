package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdun implements zzgjg<zzdhz<zzfcy>> {
    public final zzgju<zzdux> zza;
    public final zzgju<Executor> zzb;
    public final zzgju<zzebs> zzc;

    public zzdun(zzgju<zzdux> zzgju, zzgju<Executor> zzgju2, zzgju<zzebs> zzgju3) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzdux zzb2 = this.zza.zzb();
        zzfqo zzfqo = zzche.zza;
        zzgjp.zzb(zzfqo);
        zzebs zzb3 = this.zzc.zzb();
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfU)).booleanValue()) {
            return new zzdhz(zzb3, zzfqo);
        }
        return new zzdhz(zzb2, zzfqo);
    }
}
