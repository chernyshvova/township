package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzamj implements Runnable {
    public final zzamm zza;
    public final String zzb;

    public zzamj(zzamm zzamm, String str) {
        this.zza = zzamm;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zzm(this.zzb);
    }
}
