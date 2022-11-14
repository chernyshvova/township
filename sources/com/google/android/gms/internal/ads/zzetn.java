package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzetn implements zzfqa {
    public final /* synthetic */ zzelf zza;
    public final /* synthetic */ zzeto zzb;
    public final /* synthetic */ zzetp zzc;

    public zzetn(zzetp zzetp, zzelf zzelf, zzeto zzeto) {
        this.zzc = zzetp;
        this.zza = zzelf;
        this.zzb = zzeto;
    }

    public final void zza(Throwable th) {
        zzbdd zzbdd;
        zzcur zzcur = (zzcur) this.zzc.zze.zzd();
        if (zzcur == null) {
            zzbdd = zzezr.zzb(th, (zzeds) null);
        } else {
            zzbdd = zzcur.zzc().zzg(th);
        }
        synchronized (this.zzc) {
            zzfqn unused = this.zzc.zzh = null;
            if (zzcur != null) {
                zzcur.zzb().zzbT(zzbdd);
                if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfB)).booleanValue()) {
                    this.zzc.zzc.execute(new zzetm(this, zzbdd));
                }
            } else {
                this.zzc.zzd.zzbT(zzbdd);
                ((zzcur) this.zzc.zzk(this.zzb).zzf()).zzc().zzd().zzp();
            }
            zzezm.zza(zzbdd.zza, th, "AppOpenAdLoader.onFailure");
            this.zza.zza();
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcxi zzcxi = (zzcxi) obj;
        synchronized (this.zzc) {
            zzfqn unused = this.zzc.zzh = null;
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfB)).booleanValue()) {
                zzcxi.zzo().zzc(this.zzc.zzd);
            }
            this.zza.zzb(zzcxi);
        }
    }
}
