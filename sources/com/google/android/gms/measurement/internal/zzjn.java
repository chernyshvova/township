package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzjn implements Runnable {
    public final /* synthetic */ ComponentName zza;
    public final /* synthetic */ zzjl zzb;

    public zzjn(zzjl zzjl, ComponentName componentName) {
        this.zzb = zzjl;
        this.zza = componentName;
    }

    public final void run() {
        this.zzb.zza.zza(this.zza);
    }
}
