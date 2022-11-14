package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzefg implements zzfqa<zzcvj> {
    public final /* synthetic */ zzefh zza;

    public zzefg(zzefh zzefh) {
        this.zza = zzefh;
    }

    public final void zza(Throwable th) {
        zzbdd zzg = this.zza.zza.zzb().zzg(th);
        this.zza.zzd.zzbT(zzg);
        zzezm.zza(zzg.zza, th, "DelayedBannerAd.onFailure");
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        ((zzcvj) obj).zzS();
    }
}
