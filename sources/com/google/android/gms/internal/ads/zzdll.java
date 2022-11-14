package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdll implements zzgjg<zzcuc> {
    public final zzgju<zzavv> zza;
    public final zzgju<Executor> zzb;
    public final zzgju<Context> zzc;
    public final zzgju<Clock> zzd;

    public zzdll(zzgju<zzavv> zzgju, zzgju<Executor> zzgju2, zzgju<Context> zzgju3, zzgju<Clock> zzgju4) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
        this.zzd = zzgju4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcuc(this.zzb.zzb(), new zzcto(this.zzc.zzb(), this.zza.zzb()), this.zzd.zzb());
    }
}
