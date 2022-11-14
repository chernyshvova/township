package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzaq implements DialogInterface.OnClickListener {
    public final zzau zza;
    public final String zzb;

    public zzaq(zzau zzau, String str) {
        this.zza = zzau;
        this.zzb = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzo(this.zzb, dialogInterface, i);
    }
}
