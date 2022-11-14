package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class zzbvv extends zzht implements zzbvw {
    public zzbvv() {
        super("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
    }

    public static zzbvw zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
        if (queryLocalInterface instanceof zzbvw) {
            return (zzbvw) queryLocalInterface;
        }
        return new zzbvu(iBinder);
    }

    public final boolean zzbR(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 2:
                String zze = zze();
                parcel2.writeNoException();
                parcel2.writeString(zze);
                return true;
            case 3:
                List zzf = zzf();
                parcel2.writeNoException();
                parcel2.writeList(zzf);
                return true;
            case 4:
                String zzg = zzg();
                parcel2.writeNoException();
                parcel2.writeString(zzg);
                return true;
            case 5:
                zzbmi zzh = zzh();
                parcel2.writeNoException();
                zzhu.zzf(parcel2, zzh);
                return true;
            case 6:
                String zzi = zzi();
                parcel2.writeNoException();
                parcel2.writeString(zzi);
                return true;
            case 7:
                String zzj = zzj();
                parcel2.writeNoException();
                parcel2.writeString(zzj);
                return true;
            case 8:
                double zzk = zzk();
                parcel2.writeNoException();
                parcel2.writeDouble(zzk);
                return true;
            case 9:
                String zzl = zzl();
                parcel2.writeNoException();
                parcel2.writeString(zzl);
                return true;
            case 10:
                String zzm = zzm();
                parcel2.writeNoException();
                parcel2.writeString(zzm);
                return true;
            case 11:
                zzbhg zzn = zzn();
                parcel2.writeNoException();
                zzhu.zzf(parcel2, zzn);
                return true;
            case 12:
                parcel2.writeNoException();
                zzhu.zzf(parcel2, (IInterface) null);
                return true;
            case 13:
                IObjectWrapper zzp = zzp();
                parcel2.writeNoException();
                zzhu.zzf(parcel2, zzp);
                return true;
            case 14:
                IObjectWrapper zzq = zzq();
                parcel2.writeNoException();
                zzhu.zzf(parcel2, zzq);
                return true;
            case 15:
                IObjectWrapper zzr = zzr();
                parcel2.writeNoException();
                zzhu.zzf(parcel2, zzr);
                return true;
            case 16:
                Bundle zzs = zzs();
                parcel2.writeNoException();
                zzhu.zze(parcel2, zzs);
                return true;
            case 17:
                boolean zzt = zzt();
                parcel2.writeNoException();
                zzhu.zzb(parcel2, zzt);
                return true;
            case 18:
                boolean zzu = zzu();
                parcel2.writeNoException();
                zzhu.zzb(parcel2, zzu);
                return true;
            case 19:
                zzv();
                parcel2.writeNoException();
                return true;
            case 20:
                zzw(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 21:
                zzx(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 22:
                zzy(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 23:
                float zzz = zzz();
                parcel2.writeNoException();
                parcel2.writeFloat(zzz);
                return true;
            case 24:
                float zzA = zzA();
                parcel2.writeNoException();
                parcel2.writeFloat(zzA);
                return true;
            case 25:
                float zzB = zzB();
                parcel2.writeNoException();
                parcel2.writeFloat(zzB);
                return true;
            default:
                return false;
        }
    }
}
