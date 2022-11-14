package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdvn implements zzgjg<Set<zzdhz<zzamt>>> {
    public final zzdvh zza;
    public final zzgju<zzdvr> zzb;
    public final zzgju<Executor> zzc;

    public zzdvn(zzdvh zzdvh, zzgju<zzdvr> zzgju, zzgju<Executor> zzgju2) {
        this.zza = zzdvh;
        this.zzb = zzgju;
        this.zzc = zzgju2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfqo zzfqo = zzche.zza;
        zzgjp.zzb(zzfqo);
        Set<zzdhz<zzamt>> zzf = zzdvh.zzf(this.zzb.zzb(), zzfqo);
        zzgjp.zzb(zzf);
        return zzf;
    }
}
