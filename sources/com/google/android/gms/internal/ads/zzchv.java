package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzchv implements Runnable {
    public final zzcie zza;
    public final int zzb;

    public zzchv(zzcie zzcie, int i) {
        this.zza = zzcie;
        this.zzb = i;
    }

    public final void run() {
        this.zza.zzr(this.zzb);
    }
}
