package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzdwl implements Runnable {
    public final zzdww zza;
    public final zzbrt zzb;

    public zzdwl(zzdww zzdww, zzbrt zzbrt) {
        this.zza = zzdww;
        this.zzb = zzbrt;
    }

    public final void run() {
        zzdww zzdww = this.zza;
        try {
            this.zzb.zzb(zzdww.zzd());
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
        }
    }
}
