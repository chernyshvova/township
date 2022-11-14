package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzakk implements Runnable {
    public final zzakp zza;
    public final zzakm zzb;

    public zzakk(zzakp zzakp, zzakm zzakm) {
        this.zza = zzakp;
        this.zzb = zzakm;
    }

    public final void run() {
        this.zzb.zza(this.zza.zzc());
    }
}
