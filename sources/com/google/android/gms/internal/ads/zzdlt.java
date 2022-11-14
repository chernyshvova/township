package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzdlt implements Runnable {
    public final zzdlv zza;
    public final boolean zzb;

    public zzdlt(zzdlv zzdlv, boolean z) {
        this.zza = zzdlv;
        this.zzb = z;
    }

    public final void run() {
        this.zza.zzJ(this.zzb);
    }
}
