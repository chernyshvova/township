package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbkg extends zzhs implements zzbki {
    public zzbkg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
    }

    public final void zze(zzbkf zzbkf) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, zzbkf);
        zzbr(1, zza);
    }
}
