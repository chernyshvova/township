package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbrr extends zzhs implements zzbrt {
    public zzbrr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.initialization.IInitializationCallback");
    }

    public final void zzb(List<zzbrm> list) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzbr(1, zza);
    }
}
