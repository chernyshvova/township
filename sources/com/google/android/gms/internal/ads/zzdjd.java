package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdjd implements zzgjg<Set<zzdhz<zzdfq>>> {
    public final zzdja zza;
    public final zzgju<zzdad> zzb;

    public zzdjd(zzdja zzdja, zzgju<zzdad> zzgju) {
        this.zza = zzdja;
        this.zzb = zzgju;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set singleton = Collections.singleton(new zzdhz(this.zzb.zzb(), zzche.zzf));
        zzgjp.zzb(singleton);
        return singleton;
    }
}
