package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class zzcoi extends zzht implements zzcoj {
    public zzcoi() {
        super("com.google.android.gms.ads.measurement.IAppMeasurementProxy");
    }

    public final boolean zzbR(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzb((Bundle) zzhu.zzc(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                Bundle zzc = zzc((Bundle) zzhu.zzc(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                zzhu.zze(parcel2, zzc);
                return true;
            case 3:
                zzd(parcel.readString(), parcel.readString(), (Bundle) zzhu.zzc(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 4:
                zze(parcel.readString(), parcel.readString(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 5:
                Map zzf = zzf(parcel.readString(), parcel.readString(), zzhu.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeMap(zzf);
                return true;
            case 6:
                int zzg = zzg(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(zzg);
                return true;
            case 7:
                zzh((Bundle) zzhu.zzc(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 8:
                zzi(parcel.readString(), parcel.readString(), (Bundle) zzhu.zzc(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 9:
                List zzj = zzj(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeList(zzj);
                return true;
            case 10:
                String zzk = zzk();
                parcel2.writeNoException();
                parcel2.writeString(zzk);
                return true;
            case 11:
                String zzl = zzl();
                parcel2.writeNoException();
                parcel2.writeString(zzl);
                return true;
            case 12:
                long zzm = zzm();
                parcel2.writeNoException();
                parcel2.writeLong(zzm);
                return true;
            case 13:
                zzn(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 14:
                zzo(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 15:
                zzq(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 16:
                String zzr = zzr();
                parcel2.writeNoException();
                parcel2.writeString(zzr);
                return true;
            case 17:
                String zzs = zzs();
                parcel2.writeNoException();
                parcel2.writeString(zzs);
                return true;
            case 18:
                String zzt = zzt();
                parcel2.writeNoException();
                parcel2.writeString(zzt);
                return true;
            case 19:
                zzp((Bundle) zzhu.zzc(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
