package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzccb extends zzhs implements IInterface {
    public zzccb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener");
    }

    public final void zze(zzcca zzcca, String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, zzcca);
        zza.writeString(str);
        zza.writeString(str2);
        zzbr(2, zza);
    }
}
