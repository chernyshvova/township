package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzao implements DialogInterface.OnClickListener {
    public final zzau zza;
    public final AtomicInteger zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;

    public zzao(zzau zzau, AtomicInteger atomicInteger, int i, int i2, int i3) {
        this.zza = zzau;
        this.zzb = atomicInteger;
        this.zzc = i;
        this.zzd = i2;
        this.zze = i3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzp(this.zzb, this.zzc, this.zzd, this.zze, dialogInterface, i);
    }
}
