package com.google.android.gms.internal.games_v2;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public abstract class zzac extends zzb implements zzad {
    public zzac() {
        super("com.google.android.gms.games.internal.connect.IGamesConnectCallbacks");
    }

    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 2) {
            return false;
        }
        zzb((Status) zzc.zza(parcel, Status.CREATOR), (zzaa) zzc.zza(parcel, zzaa.CREATOR));
        return true;
    }
}
