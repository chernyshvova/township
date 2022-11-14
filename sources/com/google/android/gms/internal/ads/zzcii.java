package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzcii implements Runnable {
    public final zzcig zza;

    public zzcii(zzcig zzcig) {
        this.zza = zzcig;
    }

    public static Runnable zza(zzcig zzcig) {
        return new zzcii(zzcig);
    }

    public final void run() {
        this.zza.zzd();
    }
}
