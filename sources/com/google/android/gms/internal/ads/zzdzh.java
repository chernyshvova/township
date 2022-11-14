package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdzh implements zzgjg<zzdzg> {
    public final zzgju<zzcop> zza;
    public final zzgju<Context> zzb;
    public final zzgju<zzcgy> zzc;
    public final zzgju<zzeyw> zzd;
    public final zzgju<Executor> zze;
    public final zzgju<String> zzf;

    public zzdzh(zzgju<zzcop> zzgju, zzgju<Context> zzgju2, zzgju<zzcgy> zzgju3, zzgju<zzeyw> zzgju4, zzgju<Executor> zzgju5, zzgju<String> zzgju6) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
        this.zzd = zzgju4;
        this.zze = zzgju5;
        this.zzf = zzgju6;
    }

    /* renamed from: zza */
    public final zzdzg zzb() {
        Context zza2 = ((zzfaa) this.zzb).zza();
        zzcgy zza3 = ((zzcpd) this.zzc).zza();
        zzeyw zza4 = ((zzdau) this.zzd).zza();
        zzfqo zzfqo = zzche.zza;
        zzgjp.zzb(zzfqo);
        return new zzdzg(this.zza.zzb(), zza2, zza3, zza4, zzfqo, this.zzf.zzb());
    }
}
