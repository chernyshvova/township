package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbyd implements zzo {
    public final /* synthetic */ zzbyf zza;

    public zzbyd(zzbyf zzbyf) {
        this.zza = zzbyf;
    }

    public final void zzbE() {
        zzcgs.zzd("Opening AdMobCustomTabsAdapter overlay.");
        this.zza.zzb.onAdOpened(this.zza);
    }

    public final void zzbH() {
        zzcgs.zzd("Delay close AdMobCustomTabsAdapter overlay.");
    }

    public final void zzbI() {
    }

    public final void zzbJ() {
        zzcgs.zzd("AdMobCustomTabsAdapter overlay is paused.");
    }

    public final void zzbK(int i) {
        zzcgs.zzd("AdMobCustomTabsAdapter overlay is closed.");
        this.zza.zzb.onAdClosed(this.zza);
    }

    public final void zzca() {
        zzcgs.zzd("AdMobCustomTabsAdapter overlay is resumed.");
    }
}
