package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class zzbzq extends zzht implements zzbzr {
    public zzbzq() {
        super("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    public static zzbzr zzF(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
        if (queryLocalInterface instanceof zzbzr) {
            return (zzbzr) queryLocalInterface;
        }
        return new zzbzp(iBinder);
    }

    public final boolean zzbR(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzh((Bundle) zzhu.zzc(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                parcel2.writeNoException();
                return true;
            case 3:
                zzj();
                parcel2.writeNoException();
                return true;
            case 4:
                zzk();
                parcel2.writeNoException();
                return true;
            case 5:
                zzl();
                parcel2.writeNoException();
                return true;
            case 6:
                Bundle bundle = (Bundle) zzhu.zzc(parcel, Bundle.CREATOR);
                zzo(bundle);
                parcel2.writeNoException();
                zzhu.zze(parcel2, bundle);
                return true;
            case 7:
                zzp();
                parcel2.writeNoException();
                return true;
            case 8:
                zzq();
                parcel2.writeNoException();
                return true;
            case 9:
                zzs();
                parcel2.writeNoException();
                return true;
            case 10:
                zze();
                parcel2.writeNoException();
                return true;
            case 11:
                boolean zzg = zzg();
                parcel2.writeNoException();
                zzhu.zzb(parcel2, zzg);
                return true;
            case 12:
                parcel.readInt();
                parcel.readInt();
                Intent intent = (Intent) zzhu.zzc(parcel, Intent.CREATOR);
                parcel2.writeNoException();
                return true;
            case 13:
                zzn(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 14:
                zzf();
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
