package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzeib implements Runnable {
    public final zzeic zza;
    public final zzeyq zzb;
    public final zzeye zzc;
    public final zzedq zzd;

    public zzeib(zzeic zzeic, zzeyq zzeyq, zzeye zzeye, zzedq zzedq) {
        this.zza = zzeic;
        this.zzb = zzeyq;
        this.zzc = zzeye;
        this.zzd = zzedq;
    }

    public final void run() {
        zzeic zzeic = this.zza;
        zzeie.zze(this.zzb, this.zzc, this.zzd);
    }
}
