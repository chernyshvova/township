package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdub implements zzgjg<Set<zzdhz<zzfcy>>> {
    public final zzgju<String> zza;
    public final zzgju<Context> zzb;
    public final zzgju<Executor> zzc;
    public final zzgju<Map<zzfcr, zzdud>> zzd;

    public zzdub(zzgju<String> zzgju, zzgju<Context> zzgju2, zzgju<Executor> zzgju3, zzgju<Map<zzfcr, zzdud>> zzgju4) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
        this.zzd = zzgju4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        String zza2 = ((zzesr) this.zza).zza();
        Context zza3 = ((zzcou) this.zzb).zza();
        zzfqo zzfqo = zzche.zza;
        zzgjp.zzb(zzfqo);
        Map zzd2 = ((zzgjk) this.zzd).zzb();
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzdi)).booleanValue()) {
            zzayx zzayx = new zzayx(new zzazd(zza3));
            zzayx.zzc(new zzduc(zza2));
            set = Collections.singleton(new zzdhz(new zzdue(zzayx, zzd2), zzfqo));
        } else {
            set = Collections.emptySet();
        }
        zzgjp.zzb(set);
        return set;
    }
}
