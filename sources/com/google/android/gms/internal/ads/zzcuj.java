package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcuj implements zzgjg<Set<zzdhz<zzavz>>> {
    public final zzcug zza;
    public final zzgju<zzcxa> zzb;

    public zzcuj(zzcug zzcug, zzgju<zzcxa> zzgju) {
        this.zza = zzcug;
        this.zzb = zzgju;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set singleton = Collections.singleton(new zzdhz(this.zzb.zzb(), zzche.zzf));
        zzgjp.zzb(singleton);
        return singleton;
    }
}
