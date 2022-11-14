package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final /* synthetic */ class zzfy implements Runnable {
    public final zzfz zza;
    public final zzn zzb;
    public final Bundle zzc;

    public zzfy(zzfz zzfz, zzn zzn, Bundle bundle) {
        this.zza = zzfz;
        this.zzb = zzn;
        this.zzc = bundle;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc);
    }
}
