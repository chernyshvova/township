package com.google.android.gms.games.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.games_v2.zzan;
import com.google.android.gms.internal.games_v2.zzb;
import com.google.android.gms.internal.games_v2.zzc;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public abstract class zzaw extends zzb implements zzax {
    public zzaw() {
        super("com.google.android.gms.games.internal.IGamesClient");
    }

    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1001) {
            return false;
        }
        zzan zzb = zzb();
        parcel2.writeNoException();
        zzc.zzd(parcel2, zzb);
        return true;
    }
}
