package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzefb implements zzdkb {
    public final zzchj zza;

    public zzefb(zzchj zzchj) {
        this.zza = zzchj;
    }

    public final void zza(boolean z, Context context, zzdbq zzdbq) {
        zzchj zzchj = this.zza;
        try {
            zzs.zzb();
            zzm.zza(context, (AdOverlayInfoParcel) zzchj.get(), true);
        } catch (Exception unused) {
        }
    }
}
