package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdcn;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeio<AdT, AdapterT, ListenerT extends zzdcn> implements zzgjg<zzein<AdT, AdapterT, ListenerT>> {
    public final zzgju<zzfcx> zza;
    public final zzgju<zzfqo> zzb;
    public final zzgju<zzedp<AdapterT, ListenerT>> zzc;
    public final zzgju<zzedv<AdT, AdapterT, ListenerT>> zzd;

    public zzeio(zzgju<zzfcx> zzgju, zzgju<zzfqo> zzgju2, zzgju<zzedp<AdapterT, ListenerT>> zzgju3, zzgju<zzedv<AdT, AdapterT, ListenerT>> zzgju4) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
        this.zzd = zzgju4;
    }

    /* renamed from: zza */
    public final zzein<AdT, AdapterT, ListenerT> zzb() {
        return new zzein<>(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb(), this.zzd.zzb());
    }
}
