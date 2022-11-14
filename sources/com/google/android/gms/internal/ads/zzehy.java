package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzehy implements zzedn<zzdrj> {
    public final Context zza;
    public final zzdsf zzb;
    public final zzdro zzc;
    public final zzeyw zzd;
    public final Executor zze;
    public final zzcgy zzf;
    public final zzbpv zzg;
    public final boolean zzh = ((Boolean) zzbex.zzc().zzb(zzbjn.zzga)).booleanValue();

    public zzehy(Context context, zzcgy zzcgy, zzeyw zzeyw, Executor executor, zzdro zzdro, zzdsf zzdsf, zzbpv zzbpv) {
        this.zza = context;
        this.zzd = zzeyw;
        this.zzc = zzdro;
        this.zze = executor;
        this.zzf = zzcgy;
        this.zzb = zzdsf;
        this.zzg = zzbpv;
    }

    public final boolean zza(zzeyq zzeyq, zzeye zzeye) {
        zzeyj zzeyj = zzeye.zzs;
        return (zzeyj == null || zzeyj.zza == null) ? false : true;
    }

    public final zzfqn<zzdrj> zzb(zzeyq zzeyq, zzeye zzeye) {
        zzdsj zzdsj = new zzdsj();
        zzfqn<zzdrj> zzi = zzfqe.zzi(zzfqe.zza(null), new zzehr(this, zzeye, zzeyq, zzdsj), this.zze);
        zzi.zze(zzehs.zza(zzdsj), this.zze);
        return zzi;
    }

    public final /* synthetic */ zzfqn zzc(zzeye zzeye, zzeyq zzeyq, zzdsj zzdsj, Object obj) throws Exception {
        zzeye zzeye2 = zzeye;
        zzeyq zzeyq2 = zzeyq;
        zzcmr zza2 = this.zzb.zza(this.zzd.zze, zzeye2, zzeyq2.zzb.zzb);
        zza2.zzav(zzeye2.zzR);
        zzdsj.zza(this.zza, (View) zza2);
        zzchj zzchj = new zzchj();
        zzdro zzdro = this.zzc;
        zzcxx zzcxx = new zzcxx(zzeyq2, zzeye2, (String) null);
        zzehx zzehx = r1;
        zzehx zzehx2 = new zzehx(this.zza, this.zzb, this.zzd, this.zzf, zzeye, zzchj, zza2, this.zzg, this.zzh);
        zzdrk zze2 = zzdro.zze(zzcxx, new zzdrl(zzehx, zza2));
        zzchj.zzc(zze2);
        zzbqi.zzb(zza2, zze2.zzk());
        zze2.zzd().zzh(new zzeht(zza2), zzche.zzf);
        zze2.zzl().zzi(zza2, true, this.zzh ? this.zzg : null);
        zze2.zzl();
        zzeye zzeye3 = zzeye;
        zzeyj zzeyj = zzeye3.zzs;
        return zzfqe.zzj(zzdse.zzj(zza2, zzeyj.zzb, zzeyj.zza), new zzehu(this, zza2, zzeye3, zze2), this.zze);
    }
}
