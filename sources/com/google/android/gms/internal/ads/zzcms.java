package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzcms implements Runnable {
    public final zzcmy zza;
    public final View zzb;
    public final zzcdz zzc;
    public final int zzd;

    public zzcms(zzcmy zzcmy, View view, zzcdz zzcdz, int i) {
        this.zza = zzcmy;
        this.zzb = view;
        this.zzc = zzcdz;
        this.zzd = i;
    }

    public final void run() {
        this.zza.zzH(this.zzb, this.zzc, this.zzd);
    }
}
