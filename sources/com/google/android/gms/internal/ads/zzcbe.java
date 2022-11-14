package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzbb;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcbe extends zzhs implements zzcbg {
    public zzcbe(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    public final void zze(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, parcelFileDescriptor);
        zzbr(1, zza);
    }

    public final void zzf(zzbb zzbb) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, zzbb);
        zzbr(2, zza);
    }
}
