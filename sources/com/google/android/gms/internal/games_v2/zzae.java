package com.google.android.gms.internal.games_v2;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzae extends zza implements IInterface {
    public zzae(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.games.internal.connect.IGamesConnectService");
    }

    public final void zzd(zzad zzad, zzy zzy) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzad);
        zzc.zzc(zza, zzy);
        zzc(2, zza);
    }
}
