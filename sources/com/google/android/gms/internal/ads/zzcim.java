package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcim implements Runnable {
    public final /* synthetic */ boolean zza;
    public final /* synthetic */ zzcin zzb;

    public zzcim(zzcin zzcin, boolean z) {
        this.zzb = zzcin;
        this.zza = z;
    }

    public final void run() {
        this.zzb.zzI("windowVisibilityChanged", "isVisible", String.valueOf(this.zza));
    }
}
