package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzefh implements zzedn<zzcvj> {
    public final zzcwg zza;
    public final zzeeo zzb;
    public final zzfqo zzc;
    public final zzdbf zzd;
    public final ScheduledExecutorService zze;

    public zzefh(zzcwg zzcwg, zzeeo zzeeo, zzdbf zzdbf, ScheduledExecutorService scheduledExecutorService, zzfqo zzfqo) {
        this.zza = zzcwg;
        this.zzb = zzeeo;
        this.zzd = zzdbf;
        this.zze = scheduledExecutorService;
        this.zzc = zzfqo;
    }

    public final boolean zza(zzeyq zzeyq, zzeye zzeye) {
        return zzeyq.zza.zza.zza() != null && this.zzb.zza(zzeyq, zzeye);
    }

    public final zzfqn<zzcvj> zzb(zzeyq zzeyq, zzeye zzeye) {
        return this.zzc.zzb(new zzefe(this, zzeyq, zzeye));
    }

    public final /* synthetic */ zzcvj zzc(zzeyq zzeyq, zzeye zzeye) throws Exception {
        return this.zza.zze(new zzcxx(zzeyq, zzeye, (String) null), new zzcwt(zzeyq.zza.zza.zza(), new zzeff(this, zzeyq, zzeye))).zza();
    }

    public final /* synthetic */ void zzd(zzeyq zzeyq, zzeye zzeye) {
        zzfqe.zzp(zzfqe.zzh(this.zzb.zzb(zzeyq, zzeye), (long) zzeye.zzN, TimeUnit.SECONDS, this.zze), new zzefg(this), this.zzc);
    }
}
