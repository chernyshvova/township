package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzeff implements Runnable {
    public final zzefh zza;
    public final zzeyq zzb;
    public final zzeye zzc;

    public zzeff(zzefh zzefh, zzeyq zzeyq, zzeye zzeye) {
        this.zza = zzefh;
        this.zzb = zzeyq;
        this.zzc = zzeye;
    }

    public final void run() {
        this.zza.zzd(this.zzb, this.zzc);
    }
}
