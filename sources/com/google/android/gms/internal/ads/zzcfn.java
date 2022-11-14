package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class zzcfn extends zzht implements zzcfo {
    public zzcfn() {
        super("com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    public static zzcfo zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalGenerator");
        if (queryLocalInterface instanceof zzcfo) {
            return (zzcfo) queryLocalInterface;
        }
        return new zzcfm(iBinder);
    }

    public final boolean zzbR(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzcfl zzcfl = null;
        switch (i) {
            case 1:
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzcfs zzcfs = (zzcfs) zzhu.zzc(parcel, zzcfs.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalCallback");
                    if (queryLocalInterface instanceof zzcfl) {
                        zzcfl = (zzcfl) queryLocalInterface;
                    } else {
                        zzcfl = new zzcfj(readStrongBinder);
                    }
                }
                zze(asInterface, zzcfs, zzcfl);
                parcel2.writeNoException();
                return true;
            case 2:
                zzf(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 3:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                parcel2.writeNoException();
                zzhu.zzf(parcel2, (IInterface) null);
                return true;
            case 4:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                parcel2.writeNoException();
                zzhu.zzf(parcel2, (IInterface) null);
                return true;
            case 5:
                zzg(parcel.createTypedArrayList(Uri.CREATOR), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzcaf.zzb(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 6:
                zzh(parcel.createTypedArrayList(Uri.CREATOR), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzcaf.zzb(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 7:
                zzi((zzcan) zzhu.zzc(parcel, zzcan.CREATOR));
                parcel2.writeNoException();
                return true;
            case 8:
                zzj(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
