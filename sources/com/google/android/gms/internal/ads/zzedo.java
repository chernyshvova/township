package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzedo<DelegateT, AdapterT> implements zzedn<AdapterT> {
    @VisibleForTesting
    public final zzedn<DelegateT> zza;
    public final zzfju<DelegateT, AdapterT> zzb;

    public zzedo(zzedn<DelegateT> zzedn, zzfju<DelegateT, AdapterT> zzfju) {
        this.zza = zzedn;
        this.zzb = zzfju;
    }

    public final boolean zza(zzeyq zzeyq, zzeye zzeye) {
        return this.zza.zza(zzeyq, zzeye);
    }

    public final zzfqn<AdapterT> zzb(zzeyq zzeyq, zzeye zzeye) {
        return zzfqe.zzj(this.zza.zzb(zzeyq, zzeye), this.zzb, zzche.zza);
    }
}
