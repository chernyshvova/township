package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzdls implements Runnable {
    public final zzdlv zza;
    public final zzdnu zzb;

    public zzdls(zzdlv zzdlv, zzdnu zzdnu) {
        this.zza = zzdlv;
        this.zzb = zzdnu;
    }

    public final void run() {
        this.zza.zzK(this.zzb);
    }
}
