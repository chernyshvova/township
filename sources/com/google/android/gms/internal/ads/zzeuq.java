package com.google.android.gms.internal.ads;

import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeuq implements zzfqa<zzcvj> {
    public final /* synthetic */ zzelf zza;
    public final /* synthetic */ zzcwg zzb;
    public final /* synthetic */ zzeur zzc;

    public zzeuq(zzeur zzeur, zzelf zzelf, zzcwg zzcwg) {
        this.zzc = zzeur;
        this.zza = zzelf;
        this.zzb = zzcwg;
    }

    public final void zza(Throwable th) {
        zzbdd zzg = this.zzb.zzb().zzg(th);
        synchronized (this.zzc) {
            zzfqn unused = this.zzc.zzj = null;
            this.zzb.zza().zzbT(zzg);
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfA)).booleanValue()) {
                this.zzc.zzb.execute(new zzeup(this, zzg));
            }
            this.zzc.zzh.zzd(60);
            zzezm.zza(zzg.zza, th, "BannerAdLoader.onFailure");
            this.zza.zza();
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcvj zzcvj = (zzcvj) obj;
        synchronized (this.zzc) {
            zzfqn unused = this.zzc.zzj = null;
            this.zzc.zzf.removeAllViews();
            if (zzcvj.zza() != null) {
                ViewParent parent = zzcvj.zza().getParent();
                if (parent instanceof ViewGroup) {
                    String str = "";
                    if (zzcvj.zzm() != null) {
                        str = zzcvj.zzm().zze();
                    }
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 78);
                    sb.append("Banner view provided from ");
                    sb.append(str);
                    sb.append(" already has a parent view. Removing its old parent.");
                    zzcgs.zzi(sb.toString());
                    ((ViewGroup) parent).removeView(zzcvj.zza());
                }
            }
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfA)).booleanValue()) {
                zzdfd zzo = zzcvj.zzo();
                zzo.zza(this.zzc.zzd);
                zzo.zzb(this.zzc.zze);
            }
            this.zzc.zzf.addView(zzcvj.zza());
            this.zza.zzb(zzcvj);
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfA)).booleanValue()) {
                Executor zzo2 = this.zzc.zzb;
                zzekq zzn = this.zzc.zzd;
                zzn.getClass();
                zzo2.execute(zzeuo.zza(zzn));
            }
            this.zzc.zzh.zzd(zzcvj.zzg());
        }
    }
}
