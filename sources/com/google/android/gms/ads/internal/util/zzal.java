package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzal implements DialogInterface.OnClickListener {
    public final zzau zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;

    public zzal(zzau zzau, int i, int i2, int i3, int i4, int i5) {
        this.zza = zzau;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = i5;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzq(this.zzb, this.zzc, this.zzd, this.zze, this.zzf, dialogInterface, i);
    }
}
