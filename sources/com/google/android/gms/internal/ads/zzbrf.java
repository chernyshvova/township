package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbrf extends zzhs implements IInterface {
    public zzbrf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
    }

    public final void zze(zzbqz zzbqz, zzbre zzbre) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, zzbqz);
        zzhu.zzf(zza, zzbre);
        zzbs(2, zza);
    }
}
