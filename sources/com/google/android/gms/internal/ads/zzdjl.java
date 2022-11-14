package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdjl implements zzgjg<Set<zzdhz<zzdke>>> {
    public final zzgju<zzdke> zza;

    public zzdjl(zzgju<zzdke> zzgju) {
        this.zza = zzgju;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set singleton = Collections.singleton(new zzdhz(this.zza.zzb(), zzche.zzf));
        zzgjp.zzb(singleton);
        return singleton;
    }
}
