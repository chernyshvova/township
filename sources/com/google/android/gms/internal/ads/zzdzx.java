package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdzx implements zzdzz {
    public final Map<String, zzgju<zzdzz>> zza;
    public final zzfqo zzb;
    public final zzddw zzc;

    public zzdzx(Map<String, zzgju<zzdzz>> map, zzfqo zzfqo, zzddw zzddw) {
        this.zza = map;
        this.zzb = zzfqo;
        this.zzc = zzddw;
    }

    public final zzfqn<zzeyq> zza(zzcbk zzcbk) {
        this.zzc.zzj(zzcbk);
        zzfqn<zzeyq> zzc2 = zzfqe.zzc(new zzdxy(3));
        for (String trim : ((String) zzbex.zzc().zzb(zzbjn.zzfD)).split(",")) {
            zzgju zzgju = this.zza.get(trim.trim());
            if (zzgju != null) {
                zzc2 = zzfqe.zzg(zzc2, zzdxy.class, new zzdzv(zzgju, zzcbk), this.zzb);
            }
        }
        zzfqe.zzp(zzc2, new zzdzw(this), zzche.zzf);
        return zzc2;
    }
}
