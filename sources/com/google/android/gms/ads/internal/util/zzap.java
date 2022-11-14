package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzap implements DialogInterface.OnCancelListener {
    public final zzau zza;

    public zzap(zzau zzau) {
        this.zza = zzau;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.zza.zzb();
    }
}
