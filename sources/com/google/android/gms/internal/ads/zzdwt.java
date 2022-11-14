package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzdwt implements Runnable {
    public final zzdwu zza;
    public final String zzb;

    public zzdwt(zzdwu zzdwu, String str) {
        this.zza = zzdwu;
        this.zzb = str;
    }

    public final void run() {
        zzdwu zzdwu = this.zza;
        zzdww.zzq(zzdwu.zza, this.zzb);
    }
}
