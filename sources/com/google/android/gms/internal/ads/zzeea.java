package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeea implements zzedn<zzcvc> {
    public final zzcux zza;
    public final Context zzb;
    public final zzdsf zzc;
    public final zzeyw zzd;
    public final Executor zze;
    public final zzcgy zzf;
    public final zzbpv zzg;
    public final boolean zzh = ((Boolean) zzbex.zzc().zzb(zzbjn.zzga)).booleanValue();

    public zzeea(zzcux zzcux, Context context, Executor executor, zzdsf zzdsf, zzeyw zzeyw, zzcgy zzcgy, zzbpv zzbpv) {
        this.zzb = context;
        this.zza = zzcux;
        this.zze = executor;
        this.zzc = zzdsf;
        this.zzd = zzeyw;
        this.zzf = zzcgy;
        this.zzg = zzbpv;
    }

    public final boolean zza(zzeyq zzeyq, zzeye zzeye) {
        zzeyj zzeyj = zzeye.zzs;
        return (zzeyj == null || zzeyj.zza == null) ? false : true;
    }

    public final zzfqn<zzcvc> zzb(zzeyq zzeyq, zzeye zzeye) {
        zzdsj zzdsj = new zzdsj();
        zzfqn<zzcvc> zzi = zzfqe.zzi(zzfqe.zza(null), new zzedw(this, zzeye, zzeyq, zzdsj), this.zze);
        zzi.zze(zzedx.zza(zzdsj), this.zze);
        return zzi;
    }

    public final /* synthetic */ zzfqn zzc(zzeye zzeye, zzeyq zzeyq, zzdsj zzdsj, Object obj) throws Exception {
        zzeye zzeye2 = zzeye;
        zzeyq zzeyq2 = zzeyq;
        zzcmr zza2 = this.zzc.zza(this.zzd.zze, zzeye2, zzeyq2.zzb.zzb);
        zza2.zzav(zzeye2.zzR);
        zzdsj.zza(this.zzb, (View) zza2);
        zzchj zzchj = new zzchj();
        zzcux zzcux = this.zza;
        zzcxx zzcxx = new zzcxx(zzeyq2, zzeye2, (String) null);
        zzeec zzeec = r1;
        zzeec zzeec2 = new zzeec(this.zzf, zzchj, zzeye, zza2, this.zzd, this.zzh, this.zzg);
        zzcuu zze2 = zzcux.zze(zzcxx, new zzdja(zzeec, zza2), new zzcuv(zzeye2.zzV));
        zze2.zzi().zzi(zza2, false, this.zzh ? this.zzg : null);
        zzchj.zzc(zze2);
        zze2.zzd().zzh(new zzedy(zza2), zzche.zzf);
        zze2.zzi();
        zzeyj zzeyj = zzeye2.zzs;
        return zzfqe.zzj(zzdse.zzj(zza2, zzeyj.zzb, zzeyj.zza), new zzedz(this, zza2, zzeye2, zze2), this.zze);
    }
}
