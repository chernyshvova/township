package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzau;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeeo implements zzedn<zzcvj> {
    public final zzcwg zza;
    public final Context zzb;
    public final zzdsf zzc;
    public final zzeyw zzd;
    public final Executor zze;
    public final zzfju<zzeye, zzau> zzf;

    public zzeeo(zzcwg zzcwg, Context context, Executor executor, zzdsf zzdsf, zzeyw zzeyw, zzfju<zzeye, zzau> zzfju) {
        this.zzb = context;
        this.zza = zzcwg;
        this.zze = executor;
        this.zzc = zzdsf;
        this.zzd = zzeyw;
        this.zzf = zzfju;
    }

    public final boolean zza(zzeyq zzeyq, zzeye zzeye) {
        zzeyj zzeyj = zzeye.zzs;
        return (zzeyj == null || zzeyj.zza == null) ? false : true;
    }

    public final zzfqn<zzcvj> zzb(zzeyq zzeyq, zzeye zzeye) {
        return zzfqe.zzi(zzfqe.zza(null), new zzeei(this, zzeyq, zzeye), this.zze);
    }

    public final /* synthetic */ void zzc(zzcmr zzcmr) {
        zzcmr.zzL();
        zzcnn zzh = zzcmr.zzh();
        zzbiv zzbiv = this.zzd.zza;
        if (zzbiv != null && zzh != null) {
            zzh.zzc(zzbiv);
        }
    }

    public final /* synthetic */ zzfqn zzd(zzeyq zzeyq, zzeye zzeye, Object obj) throws Exception {
        View view;
        zzbdp zzb2 = zzeza.zzb(this.zzb, zzeye.zzu);
        zzcmr zza2 = this.zzc.zza(zzb2, zzeye, zzeyq.zzb.zzb);
        zza2.zzav(zzeye.zzR);
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzfn)).booleanValue() || !zzeye.zzac) {
            view = new zzdsi(this.zzb, (View) zza2, this.zzf.apply(zzeye));
        } else {
            view = zzcwx.zza(this.zzb, (View) zza2, zzeye);
        }
        zzcvk zzd2 = this.zza.zzd(new zzcxx(zzeyq, zzeye, (String) null), new zzcvq(view, zza2, zzeej.zzb(zza2), zzeza.zzc(zzb2)));
        zzd2.zzi().zzi(zza2, false, (zzbpv) null);
        zzd2.zzd().zzh(new zzeek(zza2), zzche.zzf);
        zzd2.zzi();
        zzeyj zzeyj = zzeye.zzs;
        zzfqn<?> zzj = zzdse.zzj(zza2, zzeyj.zzb, zzeyj.zza);
        if (zzeye.zzI) {
            zzj.zze(zzeel.zza(zza2), this.zze);
        }
        zzj.zze(new zzeem(this, zza2), this.zze);
        return zzfqe.zzj(zzj, new zzeen(zzd2), zzche.zzf);
    }
}
