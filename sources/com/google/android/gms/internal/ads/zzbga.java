package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class zzbga extends zzht implements zzbgb {
    public zzbga() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    public final boolean zzbR(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzbfr zzb = zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzbdp) zzhu.zzc(parcel, zzbdp.CREATOR), parcel.readString(), zzbvg.zzg(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzhu.zzf(parcel2, zzb);
                return true;
            case 2:
                zzbfr zzc = zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzbdp) zzhu.zzc(parcel, zzbdp.CREATOR), parcel.readString(), zzbvg.zzg(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzhu.zzf(parcel2, zzc);
                return true;
            case 3:
                zzbfn zzd = zzd(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), zzbvg.zzg(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzhu.zzf(parcel2, zzd);
                return true;
            case 4:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                parcel2.writeNoException();
                zzhu.zzf(parcel2, (IInterface) null);
                return true;
            case 5:
                zzbmm zze = zze(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzhu.zzf(parcel2, zze);
                return true;
            case 6:
                zzccd zzf = zzf(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzbvg.zzg(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzhu.zzf(parcel2, zzf);
                return true;
            case 7:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                parcel2.writeNoException();
                zzhu.zzf(parcel2, (IInterface) null);
                return true;
            case 8:
                zzbzr zzg = zzg(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzhu.zzf(parcel2, zzg);
                return true;
            case 9:
                zzbgi zzh = zzh(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzhu.zzf(parcel2, zzh);
                return true;
            case 10:
                zzbfr zzi = zzi(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzbdp) zzhu.zzc(parcel, zzbdp.CREATOR), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                zzhu.zzf(parcel2, zzi);
                return true;
            case 11:
                zzbms zzj = zzj(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzhu.zzf(parcel2, zzj);
                return true;
            case 12:
                zzcct zzk = zzk(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), zzbvg.zzg(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzhu.zzf(parcel2, zzk);
                return true;
            case 13:
                zzbfr zzl = zzl(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzbdp) zzhu.zzc(parcel, zzbdp.CREATOR), parcel.readString(), zzbvg.zzg(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzhu.zzf(parcel2, zzl);
                return true;
            case 14:
                zzcfo zzm = zzm(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzbvg.zzg(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzhu.zzf(parcel2, zzm);
                return true;
            case 15:
                zzbzf zzn = zzn(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzbvg.zzg(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzhu.zzf(parcel2, zzn);
                return true;
            case 16:
                zzbqq zzo = zzo(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzbvg.zzg(parcel.readStrongBinder()), parcel.readInt(), zzbqm.zzc(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzhu.zzf(parcel2, zzo);
                return true;
            default:
                return false;
        }
    }
}
