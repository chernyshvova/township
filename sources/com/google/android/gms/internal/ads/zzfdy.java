package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzfdy implements Runnable {
    public final zzfdz zza;
    public final String zzb;

    public zzfdy(zzfdz zzfdz, String str) {
        this.zza = zzfdz;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zzc(this.zzb);
    }
}
