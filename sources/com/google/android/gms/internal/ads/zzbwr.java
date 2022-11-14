package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbwr implements Runnable {
    public final /* synthetic */ zzbwx zza;

    public zzbwr(zzbwx zzbwx) {
        this.zza = zzbwx;
    }

    public final void run() {
        try {
            this.zza.zza.zzh();
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }
}
