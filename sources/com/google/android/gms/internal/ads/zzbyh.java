package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbyh implements DialogInterface.OnClickListener {
    public final /* synthetic */ zzbyi zza;

    public zzbyh(zzbyi zzbyi) {
        this.zza = zzbyi;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzf("Operation denied by user.");
    }
}
