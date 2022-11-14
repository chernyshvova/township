package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcox implements zzgjg<Set<zzdhz<zzdhn>>> {
    public final zzgju<zzebn> zza;
    public final zzgju<Executor> zzb;

    public zzcox(zzgju<zzebn> zzgju, zzgju<Executor> zzgju2) {
        this.zza = zzgju;
        this.zzb = zzgju2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        zzebn zzb2 = this.zza.zzb();
        zzfqo zzfqo = zzche.zza;
        zzgjp.zzb(zzfqo);
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzbo)).booleanValue()) {
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfU)).booleanValue()) {
                set = Collections.singleton(new zzdhz(zzb2, zzfqo));
                zzgjp.zzb(set);
                return set;
            }
        }
        set = Collections.emptySet();
        zzgjp.zzb(set);
        return set;
    }
}
