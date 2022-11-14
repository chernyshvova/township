package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcmv implements View.OnAttachStateChangeListener {
    public final /* synthetic */ zzcdz zza;
    public final /* synthetic */ zzcmy zzb;

    public zzcmv(zzcmy zzcmy, zzcdz zzcdz) {
        this.zzb = zzcmy;
        this.zza = zzcdz;
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzb.zzL(view, this.zza, 10);
    }

    public final void onViewDetachedFromWindow(View view) {
    }
}
