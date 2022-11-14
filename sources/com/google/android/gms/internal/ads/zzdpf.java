package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdpf implements zzgjg<zzdpe> {
    public final zzgju<Executor> zza;
    public final zzgju<zzdoz> zzb;

    public zzdpf(zzgju<Executor> zzgju, zzgju<zzdoz> zzgju2) {
        this.zza = zzgju;
        this.zzb = zzgju2;
    }

    /* renamed from: zza */
    public final zzdpe zzb() {
        zzfqo zzfqo = zzche.zza;
        zzgjp.zzb(zzfqo);
        return new zzdpe(zzfqo, ((zzdpa) this.zzb).zzb());
    }
}
