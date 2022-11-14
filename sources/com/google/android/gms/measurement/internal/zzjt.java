package com.google.android.gms.measurement.internal;

import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final /* synthetic */ class zzjt implements Runnable {
    public final zzjq zza;
    public final int zzb;
    public final zzeq zzc;
    public final Intent zzd;

    public zzjt(zzjq zzjq, int i, zzeq zzeq, Intent intent) {
        this.zza = zzjq;
        this.zzb = i;
        this.zzc = zzeq;
        this.zzd = intent;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc, this.zzd);
    }
}
