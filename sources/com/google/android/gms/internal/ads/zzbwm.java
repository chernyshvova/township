package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbwm implements Runnable {
    public final /* synthetic */ zzbwx zza;

    public zzbwm(zzbwx zzbwx) {
        this.zza = zzbwx;
    }

    public final void run() {
        try {
            this.zza.zza.zzi();
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }
}
