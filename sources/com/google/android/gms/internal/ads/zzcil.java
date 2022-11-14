package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcil implements Runnable {
    public final /* synthetic */ zzcin zza;

    public zzcil(zzcin zzcin) {
        this.zza = zzcin;
    }

    public final void run() {
        this.zza.zzI("surfaceDestroyed", new String[0]);
    }
}
