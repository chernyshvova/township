package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzceo implements Runnable {
    public final zzcfb zza;
    public final zzcfa zzb;
    public final String zzc;

    public zzceo(zzcfb zzcfb, zzcfa zzcfa, String str) {
        this.zza = zzcfb;
        this.zzb = zzcfa;
        this.zzc = str;
    }

    public final void run() {
        this.zza.zzs(this.zzb, this.zzc);
    }
}
