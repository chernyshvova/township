package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzdva implements Runnable {
    public final zzdvb zza;
    public final String zzb;

    public zzdva(zzdvb zzdvb, String str) {
        this.zza = zzdvb;
        this.zzb = str;
    }

    public final void run() {
        zzdvb zzdvb = this.zza;
        zzdvb.zzd.zza(this.zzb);
    }
}
