package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzhp implements Runnable {
    public final /* synthetic */ Bundle zza;
    public final /* synthetic */ zzhb zzb;

    public zzhp(zzhb zzhb, Bundle bundle) {
        this.zzb = zzhb;
        this.zza = bundle;
    }

    public final void run() {
        this.zzb.zzd(this.zza);
    }
}
