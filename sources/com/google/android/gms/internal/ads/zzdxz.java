package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzdxz implements Callable {
    public final zzdyc zza;
    public final zzcbk zzb;

    public zzdxz(zzdyc zzdyc, zzcbk zzcbk) {
        this.zza = zzdyc;
        this.zzb = zzcbk;
    }

    public final Object call() {
        return this.zza.zzc(this.zzb);
    }
}
