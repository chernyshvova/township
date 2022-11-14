package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final /* synthetic */ class zzcap implements Runnable {
    public final zzcgx zza;
    public final String zzb;

    public zzcap(zzcgx zzcgx, String str) {
        this.zza = zzcgx;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zza(this.zzb);
    }
}
