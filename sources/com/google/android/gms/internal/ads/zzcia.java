package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcia implements Runnable {
    public final /* synthetic */ int zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ zzcie zzc;

    public zzcia(zzcie zzcie, int i, int i2) {
        this.zzc = zzcie;
        this.zza = i;
        this.zzb = i2;
    }

    public final void run() {
        if (this.zzc.zzs != null) {
            this.zzc.zzs.zzj(this.zza, this.zzb);
        }
    }
}
