package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdog implements zzgjg<zzdhz<VideoController.VideoLifecycleCallbacks>> {
    public final zzdnz zza;
    public final zzgju<zzdre> zzb;
    public final zzgju<Executor> zzc;

    public zzdog(zzdnz zzdnz, zzgju<zzdre> zzgju, zzgju<Executor> zzgju2) {
        this.zza = zzdnz;
        this.zzb = zzgju;
        this.zzc = zzgju2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdhz(((zzdrf) this.zzb).zzb(), this.zzc.zzb());
    }
}
