package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzcdb extends zzhs implements IInterface {
    public zzcdb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener");
    }

    public final void zze(zzccq zzccq, String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, zzccq);
        zza.writeString(str);
        zza.writeString(str2);
        zzbr(2, zza);
    }
}
