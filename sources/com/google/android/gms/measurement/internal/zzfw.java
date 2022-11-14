package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzfw implements Runnable {
    public final /* synthetic */ zzgy zza;
    public final /* synthetic */ zzfu zzb;

    public zzfw(zzfu zzfu, zzgy zzgy) {
        this.zzb = zzfu;
        this.zza = zzgy;
    }

    public final void run() {
        this.zzb.zza(this.zza);
        this.zzb.zza(this.zza.zzg);
    }
}
