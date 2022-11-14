package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzavq implements Runnable {
    public final /* synthetic */ int zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ int zzc;
    public final /* synthetic */ float zzd;
    public final /* synthetic */ zzavt zze;

    public zzavq(zzavt zzavt, int i, int i2, int i3, float f) {
        this.zze = zzavt;
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = f;
    }

    public final void run() {
        this.zze.zzb.zzn(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
