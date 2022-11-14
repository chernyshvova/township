package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbnu extends zzhs implements zzbnw {
    public zzbnu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
    }

    public final void zze(zzbof zzbof) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, zzbof);
        zzbr(1, zza);
    }
}
