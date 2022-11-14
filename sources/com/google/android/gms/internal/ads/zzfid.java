package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfid extends zzhs implements IInterface {
    public zzfid(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    public final zzfib zze(zzfhz zzfhz) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, zzfhz);
        Parcel zzbq = zzbq(1, zza);
        zzfib zzfib = (zzfib) zzhu.zzc(zzbq, zzfib.CREATOR);
        zzbq.recycle();
        return zzfib;
    }

    public final void zzf(zzfhw zzfhw) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, zzfhw);
        zzbr(2, zza);
    }

    public final zzfik zzg(zzfii zzfii) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, zzfii);
        Parcel zzbq = zzbq(3, zza);
        zzfik zzfik = (zzfik) zzhu.zzc(zzbq, zzfik.CREATOR);
        zzbq.recycle();
        return zzfik;
    }
}
