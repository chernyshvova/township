package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final /* synthetic */ class zzbil implements Runnable {
    public final zzcda zza;

    public zzbil(zzcda zzcda) {
        this.zza = zzcda;
    }

    public final void run() {
        zzcda zzcda = this.zza;
        if (zzcda != null) {
            try {
                zzcda.zzf(1);
            } catch (RemoteException e) {
                zzcgs.zzl("#007 Could not call remote method.", e);
            }
        }
    }
}
