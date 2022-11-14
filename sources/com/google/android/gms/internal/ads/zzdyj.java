package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdyj implements zzgjg<zzdhz<zzddy>> {
    public final zzgju<zzdzt> zza;
    public final zzgju<Executor> zzb;

    public zzdyj(zzgju<zzdzt> zzgju, zzgju<Executor> zzgju2) {
        this.zza = zzgju;
        this.zzb = zzgju2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzdzt zza2 = ((zzdzu) this.zza).zzb();
        zzfqo zzfqo = zzche.zza;
        zzgjp.zzb(zzfqo);
        return new zzdhz(zza2, zzfqo);
    }
}
