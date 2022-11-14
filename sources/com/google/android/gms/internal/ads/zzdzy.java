package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdzy implements zzgjg<zzdzx> {
    public final zzgju<Map<String, zzgju<zzdzz>>> zza;
    public final zzgju<zzfqo> zzb;
    public final zzgju<zzddw> zzc;

    public zzdzy(zzgju<Map<String, zzgju<zzdzz>>> zzgju, zzgju<zzfqo> zzgju2, zzgju<zzddw> zzgju3) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
    }

    /* renamed from: zza */
    public final zzdzx zzb() {
        Map zzd = ((zzgjn) this.zza).zzd();
        zzfqo zzfqo = zzche.zza;
        zzgjp.zzb(zzfqo);
        return new zzdzx(zzd, zzfqo, ((zzddx) this.zzc).zzb());
    }
}
