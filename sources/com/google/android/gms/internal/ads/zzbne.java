package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbne extends zzhs implements zzbng {
    public zzbne(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
    }

    public final void zze(zzbmx zzbmx) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, zzbmx);
        zzbr(1, zza);
    }
}
