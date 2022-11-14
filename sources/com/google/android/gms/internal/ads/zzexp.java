package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzexp implements zzfqa<zzdrj> {
    public final /* synthetic */ zzelf zza;
    public final /* synthetic */ zzexq zzb;
    public final /* synthetic */ zzexr zzc;

    public zzexp(zzexr zzexr, zzelf zzelf, zzexq zzexq) {
        this.zzc = zzexr;
        this.zza = zzelf;
        this.zzb = zzexq;
    }

    public final void zza(Throwable th) {
        zzbdd zzbdd;
        zzdro zzdro = (zzdro) this.zzc.zze.zzd();
        if (zzdro == null) {
            zzbdd = zzezr.zzb(th, (zzeds) null);
        } else {
            zzbdd = zzdro.zzc().zzg(th);
        }
        synchronized (this.zzc) {
            if (zzdro != null) {
                zzdro.zzb().zzbT(zzbdd);
                this.zzc.zzb.execute(new zzexo(this, zzbdd));
            } else {
                this.zzc.zzd.zzbT(zzbdd);
                this.zzc.zzh(this.zzb).zza().zzc().zzd().zzp();
            }
            zzezm.zza(zzbdd.zza, th, "RewardedAdLoader.onFailure");
            this.zza.zza();
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdrj zzdrj = (zzdrj) obj;
        synchronized (this.zzc) {
            zzdrj.zzo().zzd(this.zzc.zzd);
            this.zza.zzb(zzdrj);
            Executor zze = this.zzc.zzb;
            zzexi zzd = this.zzc.zzd;
            zzd.getClass();
            zze.execute(zzexn.zza(zzd));
            this.zzc.zzd.zzl();
        }
    }
}
