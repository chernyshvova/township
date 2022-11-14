package com.google.android.gms.internal.ads;

import android.view.ViewGroup;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzdmx implements Runnable {
    public final zzdmz zza;
    public final ViewGroup zzb;

    public zzdmx(zzdmz zzdmz, ViewGroup viewGroup) {
        this.zza = zzdmz;
        this.zzb = viewGroup;
    }

    public final void run() {
        this.zza.zze(this.zzb);
    }
}
