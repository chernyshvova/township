package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzduu {
    public final zzduz zza;
    public final Executor zzb;
    public final Map<String, String> zzc;

    public zzduu(zzduz zzduz, Executor executor) {
        this.zza = zzduz;
        this.zzc = zzduz.zza();
        this.zzb = executor;
    }

    public final zzdut zza() {
        zzdut zzdut = new zzdut(this);
        zzdut unused = zzdut.zzb.putAll(zzdut.zza.zzc);
        return zzdut;
    }
}
