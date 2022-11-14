package com.google.android.gms.internal.ads;

import android.graphics.Rect;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzdpm implements zzavz {
    public final zzcmr zza;

    public zzdpm(zzcmr zzcmr) {
        this.zza = zzcmr;
    }

    public final void zzc(zzavy zzavy) {
        zzcof zzR = this.zza.zzR();
        Rect rect = zzavy.zzd;
        zzR.zza(rect.left, rect.top, false);
    }
}
