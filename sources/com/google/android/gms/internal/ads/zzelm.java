package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzelm implements zzfqa<zzcxi> {
    public final /* synthetic */ zzelf zza;
    public final /* synthetic */ zzdkp zzb;
    public final /* synthetic */ zzeln zzc;

    public zzelm(zzeln zzeln, zzelf zzelf, zzdkp zzdkp) {
        this.zzc = zzeln;
        this.zza = zzelf;
        this.zzb = zzdkp;
    }

    public final void zza(Throwable th) {
        zzbdd zzg = this.zzb.zza().zzg(th);
        this.zzb.zzb().zzbT(zzg);
        this.zzc.zzb.zze().execute(new zzell(this, zzg));
        zzezm.zza(zzg.zza, th, "NativeAdLoader.onFailure");
        this.zza.zza();
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcxi zzcxi = (zzcxi) obj;
        synchronized (this.zzc) {
            zzcxi.zzo().zza(this.zzc.zzd.zzc());
            this.zza.zzb(zzcxi);
            this.zzc.zzb.zze().execute(new zzelk(this));
        }
    }
}
