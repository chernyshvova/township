package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdtm implements zzgjg<Set<zzdhz<zzfcy>>> {
    public final zzgju<Executor> zza;
    public final zzgju<zzdue> zzb;

    public zzdtm(zzgju<Executor> zzgju, zzgju<zzdue> zzgju2) {
        this.zza = zzgju;
        this.zzb = zzgju2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        zzfqo zzfqo = zzche.zza;
        zzgjp.zzb(zzfqo);
        zzdue zza2 = ((zzduf) this.zzb).zzb();
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzdi)).booleanValue()) {
            set = Collections.singleton(new zzdhz(zza2, zzfqo));
        } else {
            set = Collections.emptySet();
        }
        zzgjp.zzb(set);
        return set;
    }
}
