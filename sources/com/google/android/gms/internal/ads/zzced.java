package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzced implements zzgjg<zzcec> {
    public final zzgju<Clock> zza;
    public final zzgju<zzg> zzb;
    public final zzgju<zzcfb> zzc;

    public zzced(zzgju<Clock> zzgju, zzgju<zzg> zzgju2, zzgju<zzcfb> zzgju3) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcec(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb());
    }
}
