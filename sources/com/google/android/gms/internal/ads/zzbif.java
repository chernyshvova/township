package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbif implements Runnable {
    public final /* synthetic */ zzbig zza;

    public zzbif(zzbig zzbig) {
        this.zza = zzbig;
    }

    public final void run() {
        if (this.zza.zza != null) {
            try {
                this.zza.zza.zzc(1);
            } catch (RemoteException e) {
                zzcgs.zzj("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
