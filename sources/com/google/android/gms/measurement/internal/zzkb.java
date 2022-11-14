package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzkb implements Runnable {
    public long zza;
    public long zzb;
    public final /* synthetic */ zzjy zzc;

    public zzkb(zzjy zzjy, long j, long j2) {
        this.zzc = zzjy;
        this.zza = j;
        this.zzb = j2;
    }

    public final void run() {
        this.zzc.zza.zzp().zza((Runnable) new zzka(this));
    }
}
