package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzdpu implements Runnable {
    public final zzdpw zza;

    public zzdpu(zzdpw zzdpw) {
        this.zza = zzdpw;
    }

    public final void run() {
        try {
            this.zza.zzc();
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }
}
