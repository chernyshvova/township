package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AdManagerAdView;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbon implements Runnable {
    public final /* synthetic */ AdManagerAdView zza;
    public final /* synthetic */ zzbfr zzb;
    public final /* synthetic */ zzboo zzc;

    public zzbon(zzboo zzboo, AdManagerAdView adManagerAdView, zzbfr zzbfr) {
        this.zzc = zzboo;
        this.zza = adManagerAdView;
        this.zzb = zzbfr;
    }

    public final void run() {
        if (this.zza.zza(this.zzb)) {
            this.zzc.zza.onAdManagerAdViewLoaded(this.zza);
        } else {
            zzcgs.zzi("Could not bind.");
        }
    }
}
