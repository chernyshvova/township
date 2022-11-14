package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbnh extends zzhs implements zzbnj {
    public zzbnh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
    }

    public final void zze(zzbmz zzbmz) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, zzbmz);
        zzbr(1, zza);
    }
}
