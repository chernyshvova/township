package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzefq implements zzedn<zzdiw> {
    public final Context zza;
    public final zzdsf zzb;
    public final zzdjt zzc;
    public final zzeyw zzd;
    public final Executor zze;
    public final zzcgy zzf;
    public final zzbpv zzg;
    public final boolean zzh = ((Boolean) zzbex.zzc().zzb(zzbjn.zzga)).booleanValue();

    public zzefq(Context context, zzcgy zzcgy, zzeyw zzeyw, Executor executor, zzdjt zzdjt, zzdsf zzdsf, zzbpv zzbpv) {
        this.zza = context;
        this.zzd = zzeyw;
        this.zzc = zzdjt;
        this.zze = executor;
        this.zzf = zzcgy;
        this.zzb = zzdsf;
        this.zzg = zzbpv;
    }

    public final boolean zza(zzeyq zzeyq, zzeye zzeye) {
        zzeyj zzeyj = zzeye.zzs;
        return (zzeyj == null || zzeyj.zza == null) ? false : true;
    }

    public final zzfqn<zzdiw> zzb(zzeyq zzeyq, zzeye zzeye) {
        zzdsj zzdsj = new zzdsj();
        zzfqn<zzdiw> zzi = zzfqe.zzi(zzfqe.zza(null), new zzefl(this, zzeye, zzeyq, zzdsj), this.zze);
        zzi.zze(zzefm.zza(zzdsj), this.zze);
        return zzi;
    }

    public final /* synthetic */ zzfqn zzc(zzeye zzeye, zzeyq zzeyq, zzdsj zzdsj, Object obj) throws Exception {
        zzeye zzeye2 = zzeye;
        zzeyq zzeyq2 = zzeyq;
        zzcmr zza2 = this.zzb.zza(this.zzd.zze, zzeye2, zzeyq2.zzb.zzb);
        zza2.zzav(zzeye2.zzR);
        zzdsj.zza(this.zza, (View) zza2);
        zzchj zzchj = new zzchj();
        zzdjt zzdjt = this.zzc;
        zzcxx zzcxx = new zzcxx(zzeyq2, zzeye2, (String) null);
        zzefp zzefp = r1;
        zzefp zzefp2 = new zzefp(this.zza, this.zzf, zzchj, zzeye, zza2, this.zzd, this.zzh, this.zzg);
        zzdix zzc2 = zzdjt.zzc(zzcxx, new zzdja(zzefp, zza2));
        zzchj.zzc(zzc2);
        zzc2.zzd().zzh(new zzefn(zza2), zzche.zzf);
        zzc2.zzk().zzi(zza2, true, this.zzh ? this.zzg : null);
        zzc2.zzk();
        zzeye zzeye3 = zzeye;
        zzeyj zzeyj = zzeye3.zzs;
        return zzfqe.zzj(zzdse.zzj(zza2, zzeyj.zzb, zzeyj.zza), new zzefo(this, zza2, zzeye3, zzc2), this.zze);
    }
}
