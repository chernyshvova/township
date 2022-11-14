package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzdlr implements Runnable {
    public final zzdlv zza;
    public final zzdnu zzb;

    public zzdlr(zzdlv zzdlv, zzdnu zzdnu) {
        this.zza = zzdlv;
        this.zzb = zzdnu;
    }

    public final void run() {
        this.zza.zzL(this.zzb);
    }
}
