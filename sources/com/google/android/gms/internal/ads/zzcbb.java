package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzcbb extends zzht implements zzcbc {
    public zzcbb() {
        super("com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    public final boolean zzbR(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzcbg zzcbg = null;
        if (i == 1) {
            zzcaw zzcaw = (zzcaw) zzhu.zzc(parcel, zzcaw.CREATOR);
            parcel2.writeNoException();
            zzhu.zze(parcel2, (Parcelable) null);
        } else if (i == 2) {
            zzcaw zzcaw2 = (zzcaw) zzhu.zzc(parcel, zzcaw.CREATOR);
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder != null) {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
                if (queryLocalInterface instanceof zzcbd) {
                    zzcbd zzcbd = (zzcbd) queryLocalInterface;
                } else {
                    new zzcbd(readStrongBinder);
                }
            }
            parcel2.writeNoException();
        } else if (i == 4) {
            zzcbk zzcbk = (zzcbk) zzhu.zzc(parcel, zzcbk.CREATOR);
            IBinder readStrongBinder2 = parcel.readStrongBinder();
            if (readStrongBinder2 != null) {
                IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                if (queryLocalInterface2 instanceof zzcbg) {
                    zzcbg = (zzcbg) queryLocalInterface2;
                } else {
                    zzcbg = new zzcbe(readStrongBinder2);
                }
            }
            zze(zzcbk, zzcbg);
            parcel2.writeNoException();
        } else if (i == 5) {
            zzcbk zzcbk2 = (zzcbk) zzhu.zzc(parcel, zzcbk.CREATOR);
            IBinder readStrongBinder3 = parcel.readStrongBinder();
            if (readStrongBinder3 != null) {
                IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                if (queryLocalInterface3 instanceof zzcbg) {
                    zzcbg = (zzcbg) queryLocalInterface3;
                } else {
                    zzcbg = new zzcbe(readStrongBinder3);
                }
            }
            zzf(zzcbk2, zzcbg);
            parcel2.writeNoException();
        } else if (i == 6) {
            zzcbk zzcbk3 = (zzcbk) zzhu.zzc(parcel, zzcbk.CREATOR);
            IBinder readStrongBinder4 = parcel.readStrongBinder();
            if (readStrongBinder4 != null) {
                IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                if (queryLocalInterface4 instanceof zzcbg) {
                    zzcbg = (zzcbg) queryLocalInterface4;
                } else {
                    zzcbg = new zzcbe(readStrongBinder4);
                }
            }
            zzg(zzcbk3, zzcbg);
            parcel2.writeNoException();
        } else if (i != 7) {
            return false;
        } else {
            String readString = parcel.readString();
            IBinder readStrongBinder5 = parcel.readStrongBinder();
            if (readStrongBinder5 != null) {
                IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                if (queryLocalInterface5 instanceof zzcbg) {
                    zzcbg = (zzcbg) queryLocalInterface5;
                } else {
                    zzcbg = new zzcbe(readStrongBinder5);
                }
            }
            zzh(readString, zzcbg);
            parcel2.writeNoException();
        }
        return true;
    }
}
