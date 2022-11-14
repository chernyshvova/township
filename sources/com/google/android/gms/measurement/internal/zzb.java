package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzb implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ zza zzc;

    public zzb(zza zza2, String str, long j) {
        this.zzc = zza2;
        this.zza = str;
        this.zzb = j;
    }

    public final void run() {
        this.zzc.zzd(this.zza, this.zzb);
    }
}
