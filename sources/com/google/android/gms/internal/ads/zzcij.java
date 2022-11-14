package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzcij implements Runnable {
    public final zzcin zza;
    public final boolean zzb;

    public zzcij(zzcin zzcin, boolean z) {
        this.zza = zzcin;
        this.zzb = z;
    }

    public final void run() {
        this.zza.zzF(this.zzb);
    }
}
