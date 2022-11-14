package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzesn implements zzgjg<zzesl> {
    public final zzgju<zzbzv> zza;
    public final zzgju<ScheduledExecutorService> zzb;
    public final zzgju<Context> zzc;

    public zzesn(zzgju<zzbzv> zzgju, zzgju<ScheduledExecutorService> zzgju2, zzgju<Context> zzgju3) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzesl(new zzbzv(), this.zzb.zzb(), ((zzcou) this.zzc).zza(), (byte[]) null);
    }
}
