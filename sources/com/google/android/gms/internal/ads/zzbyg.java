package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.Intent;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbyg implements DialogInterface.OnClickListener {
    public final /* synthetic */ zzbyi zza;

    public zzbyg(zzbyi zzbyi) {
        this.zza = zzbyi;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent zzb = this.zza.zzb();
        zzs.zzc();
        zzr.zzP(this.zza.zzb, zzb);
    }
}
