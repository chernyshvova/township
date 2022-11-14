package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzewi implements zzfqa<zzdiw> {
    public final /* synthetic */ zzelf zza;
    public final /* synthetic */ zzdjt zzb;
    public final /* synthetic */ zzewj zzc;

    public zzewi(zzewj zzewj, zzelf zzelf, zzdjt zzdjt) {
        this.zzc = zzewj;
        this.zza = zzelf;
        this.zzb = zzdjt;
    }

    public final void zza(Throwable th) {
        zzbdd zzg = this.zzb.zzb().zzg(th);
        synchronized (this.zzc) {
            zzfqn unused = this.zzc.zzh = null;
            this.zzb.zza().zzbT(zzg);
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfC)).booleanValue()) {
                this.zzc.zzb.execute(new zzewg(this, zzg));
                this.zzc.zzb.execute(new zzewh(this, zzg));
            }
            zzezm.zza(zzg.zza, th, "InterstitialAdLoader.onFailure");
            this.zza.zza();
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdiw zzdiw = (zzdiw) obj;
        synchronized (this.zzc) {
            zzfqn unused = this.zzc.zzh = null;
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfC)).booleanValue()) {
                zzdfd zzo = zzdiw.zzo();
                zzo.zza(this.zzc.zzd);
                zzo.zzd(this.zzc.zze);
            }
            this.zza.zzb(zzdiw);
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfC)).booleanValue()) {
                this.zzc.zzb.execute(new zzewe(this));
                this.zzc.zzb.execute(new zzewf(this));
            }
        }
    }
}
