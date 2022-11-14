package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbye implements Runnable {
    public final /* synthetic */ AdOverlayInfoParcel zza;
    public final /* synthetic */ zzbyf zzb;

    public zzbye(zzbyf zzbyf, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zzb = zzbyf;
        this.zza = adOverlayInfoParcel;
    }

    public final void run() {
        zzs.zzb();
        zzm.zza(this.zzb.zza, this.zza, true);
    }
}
