package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzcji implements Runnable {
    public final zzcjq zza;
    public final String zzb;

    public zzcji(zzcjq zzcjq, String str) {
        this.zza = zzcjq;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zzO(this.zzb);
    }
}
