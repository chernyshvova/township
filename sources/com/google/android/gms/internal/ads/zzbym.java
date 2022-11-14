package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbym implements DialogInterface.OnClickListener {
    public final /* synthetic */ zzbyn zza;

    public zzbym(zzbyn zzbyn) {
        this.zza = zzbyn;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzf("User canceled the download.");
    }
}
