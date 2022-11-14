package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzdqu;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzp implements Runnable {
    public final zzt zza;
    public final zzdqu[] zzb;

    public zzp(zzt zzt, zzdqu[] zzdquArr) {
        this.zza = zzt;
        this.zzb = zzdquArr;
    }

    public final void run() {
        this.zza.zzd(this.zzb);
    }
}
