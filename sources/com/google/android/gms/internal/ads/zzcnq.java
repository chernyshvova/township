package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzcnq implements Runnable {
    public final zzcns zza;
    public final String zzb;

    public zzcnq(zzcns zzcns, String str) {
        this.zza = zzcns;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zza(this.zzb);
    }
}
