package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbic implements Runnable {
    public final /* synthetic */ zzbid zza;

    public zzbic(zzbid zzbid) {
        this.zza = zzbid;
    }

    public final void run() {
        if (this.zza.zza.zza != null) {
            try {
                this.zza.zza.zza.zzc(1);
            } catch (RemoteException e) {
                zzcgs.zzj("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
