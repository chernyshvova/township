package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzduy implements zzgjg<zzdux> {
    public final zzgju<zzduq> zza;
    public final zzgju<Set<zzduw>> zzb;
    public final zzgju<Clock> zzc;

    public zzduy(zzgju<zzduq> zzgju, zzgju<Set<zzduw>> zzgju2, zzgju<Clock> zzgju3) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdux(this.zza.zzb(), ((zzgjs) this.zzb).zzb(), this.zzc.zzb());
    }
}
