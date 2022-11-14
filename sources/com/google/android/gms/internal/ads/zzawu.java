package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzawu implements Runnable {
    public final /* synthetic */ View zza;
    public final /* synthetic */ zzawy zzb;

    public zzawu(zzawy zzawy, View view) {
        this.zzb = zzawy;
        this.zza = view;
    }

    public final void run() {
        this.zzb.zzb(this.zza);
    }
}
