package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class zzbmy extends zzht implements zzbmz {
    public zzbmy() {
        super("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
    }

    public final boolean zzbR(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 2:
                IObjectWrapper zzb = zzb();
                parcel2.writeNoException();
                zzhu.zzf(parcel2, zzb);
                return true;
            case 3:
                String zzc = zzc();
                parcel2.writeNoException();
                parcel2.writeString(zzc);
                return true;
            case 4:
                List zzd = zzd();
                parcel2.writeNoException();
                parcel2.writeList(zzd);
                return true;
            case 5:
                String zze = zze();
                parcel2.writeNoException();
                parcel2.writeString(zze);
                return true;
            case 6:
                zzbmi zzf = zzf();
                parcel2.writeNoException();
                zzhu.zzf(parcel2, zzf);
                return true;
            case 7:
                String zzg = zzg();
                parcel2.writeNoException();
                parcel2.writeString(zzg);
                return true;
            case 8:
                String zzh = zzh();
                parcel2.writeNoException();
                parcel2.writeString(zzh);
                return true;
            case 9:
                Bundle zzi = zzi();
                parcel2.writeNoException();
                zzhu.zze(parcel2, zzi);
                return true;
            case 10:
                zzj();
                parcel2.writeNoException();
                return true;
            case 11:
                zzbhg zzk = zzk();
                parcel2.writeNoException();
                zzhu.zzf(parcel2, zzk);
                return true;
            case 12:
                zzl((Bundle) zzhu.zzc(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                boolean zzm = zzm((Bundle) zzhu.zzc(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                zzhu.zzb(parcel2, zzm);
                return true;
            case 14:
                zzn((Bundle) zzhu.zzc(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 15:
                zzbma zzo = zzo();
                parcel2.writeNoException();
                zzhu.zzf(parcel2, zzo);
                return true;
            case 16:
                IObjectWrapper zzp = zzp();
                parcel2.writeNoException();
                zzhu.zzf(parcel2, zzp);
                return true;
            case 17:
                String zzq = zzq();
                parcel2.writeNoException();
                parcel2.writeString(zzq);
                return true;
            default:
                return false;
        }
    }
}
