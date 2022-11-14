package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeeg implements zzedn<zzcus> {
    public final zzcum zza;
    public final Context zzb;
    public final zzdsf zzc;
    public final Executor zzd;

    public zzeeg(zzcum zzcum, Context context, Executor executor, zzdsf zzdsf) {
        this.zzb = context;
        this.zza = zzcum;
        this.zzd = executor;
        this.zzc = zzdsf;
    }

    public final boolean zza(zzeyq zzeyq, zzeye zzeye) {
        zzeyj zzeyj = zzeye.zzs;
        return (zzeyj == null || zzeyj.zza == null) ? false : true;
    }

    public final zzfqn<zzcus> zzb(zzeyq zzeyq, zzeye zzeye) {
        return zzfqe.zzi(zzfqe.zza(null), new zzeed(this, zzeyq, zzeye), this.zzd);
    }

    public final /* synthetic */ zzfqn zzc(zzeyq zzeyq, zzeye zzeye, Object obj) throws Exception {
        zzbdp zzb2 = zzeza.zzb(this.zzb, zzeye.zzu);
        zzcmr zza2 = this.zzc.zza(zzb2, zzeye, zzeyq.zzb.zzb);
        zzcuf zze = this.zza.zze(new zzcxx(zzeyq, zzeye, (String) null), new zzcug((View) zza2, zza2, zzeza.zzc(zzb2), zzeye.zzV, zzeye.zzZ, zzeye.zzK));
        zze.zzi().zzi(zza2, false, (zzbpv) null);
        zze.zzd().zzh(new zzeee(zza2), zzche.zzf);
        zze.zzi();
        zzeyj zzeyj = zzeye.zzs;
        return zzfqe.zzj(zzdse.zzj(zza2, zzeyj.zzb, zzeyj.zza), new zzeef(zze), zzche.zzf);
    }
}
