package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzfeb extends zzhs implements zzfed {
    public zzfeb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.omid.IOmid");
    }

    public final boolean zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        Parcel zzbq = zzbq(2, zza);
        boolean zza2 = zzhu.zza(zzbq);
        zzbq.recycle();
        return zza2;
    }

    public final void zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzbr(4, zza);
    }

    public final void zzg(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzhu.zzf(zza, iObjectWrapper2);
        zzbr(5, zza);
    }

    public final String zzh() throws RemoteException {
        Parcel zzbq = zzbq(6, zza());
        String readString = zzbq.readString();
        zzbq.recycle();
        return readString;
    }

    public final void zzi(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzbr(7, zza);
    }

    public final void zzj(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzhu.zzf(zza, iObjectWrapper2);
        zzbr(8, zza);
    }

    public final IObjectWrapper zzk(String str, IObjectWrapper iObjectWrapper, String str2, String str3, String str4, String str5) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzhu.zzf(zza, iObjectWrapper);
        zza.writeString("");
        zza.writeString("javascript");
        zza.writeString(str4);
        zza.writeString(str5);
        return GeneratedOutlineSupport.outline8(zzbq(9, zza));
    }

    public final IObjectWrapper zzl(String str, IObjectWrapper iObjectWrapper, String str2, String str3, String str4, String str5, String str6, String str7, String str8) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzhu.zzf(zza, iObjectWrapper);
        zza.writeString("");
        zza.writeString("javascript");
        zza.writeString(str4);
        zza.writeString(str5);
        zza.writeString(str6);
        zza.writeString(str7);
        zza.writeString(str8);
        return GeneratedOutlineSupport.outline8(zzbq(10, zza));
    }

    public final IObjectWrapper zzm(String str, IObjectWrapper iObjectWrapper, String str2, String str3, String str4, String str5, String str6, String str7, String str8) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzhu.zzf(zza, iObjectWrapper);
        zza.writeString("");
        zza.writeString("javascript");
        zza.writeString(str4);
        zza.writeString("Google");
        zza.writeString(str6);
        zza.writeString(str7);
        zza.writeString(str8);
        return GeneratedOutlineSupport.outline8(zzbq(11, zza));
    }
}
