package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbxm extends zzhs implements zzbxo {
    public zzbxm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public final void zze(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzbdp zzbdp, zzbxr zzbxr) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zza.writeString(str);
        zzhu.zzd(zza, bundle);
        zzhu.zzd(zza, bundle2);
        zzhu.zzd(zza, zzbdp);
        zzhu.zzf(zza, zzbxr);
        zzbr(1, zza);
    }

    public final zzbyb zzf() throws RemoteException {
        Parcel zzbq = zzbq(2, zza());
        zzbyb zzbyb = (zzbyb) zzhu.zzc(zzbq, zzbyb.CREATOR);
        zzbq.recycle();
        return zzbyb;
    }

    public final zzbyb zzg() throws RemoteException {
        Parcel zzbq = zzbq(3, zza());
        zzbyb zzbyb = (zzbyb) zzhu.zzc(zzbq, zzbyb.CREATOR);
        zzbq.recycle();
        return zzbyb;
    }

    public final zzbhg zzh() throws RemoteException {
        Parcel zzbq = zzbq(5, zza());
        zzbhg zzb = zzbhf.zzb(zzbq.readStrongBinder());
        zzbq.recycle();
        return zzb;
    }

    public final void zzi(String str, String str2, zzbdk zzbdk, IObjectWrapper iObjectWrapper, zzbxc zzbxc, zzbvn zzbvn, zzbdp zzbdp) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzhu.zzd(zza, zzbdk);
        zzhu.zzf(zza, iObjectWrapper);
        zzhu.zzf(zza, zzbxc);
        zzhu.zzf(zza, zzbvn);
        zzhu.zzd(zza, zzbdp);
        zzbr(13, zza);
    }

    public final void zzj(String str, String str2, zzbdk zzbdk, IObjectWrapper iObjectWrapper, zzbxf zzbxf, zzbvn zzbvn) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzhu.zzd(zza, zzbdk);
        zzhu.zzf(zza, iObjectWrapper);
        zzhu.zzf(zza, zzbxf);
        zzhu.zzf(zza, zzbvn);
        zzbr(14, zza);
    }

    public final boolean zzk(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        Parcel zzbq = zzbq(15, zza);
        boolean zza2 = zzhu.zza(zzbq);
        zzbq.recycle();
        return zza2;
    }

    public final void zzl(String str, String str2, zzbdk zzbdk, IObjectWrapper iObjectWrapper, zzbxl zzbxl, zzbvn zzbvn) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzhu.zzd(zza, zzbdk);
        zzhu.zzf(zza, iObjectWrapper);
        zzhu.zzf(zza, zzbxl);
        zzhu.zzf(zza, zzbvn);
        zzbr(16, zza);
    }

    public final boolean zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        Parcel zzbq = zzbq(17, zza);
        boolean zza2 = zzhu.zza(zzbq);
        zzbq.recycle();
        return zza2;
    }

    public final void zzn(String str, String str2, zzbdk zzbdk, IObjectWrapper iObjectWrapper, zzbxi zzbxi, zzbvn zzbvn) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzhu.zzd(zza, zzbdk);
        zzhu.zzf(zza, iObjectWrapper);
        zzhu.zzf(zza, zzbxi);
        zzhu.zzf(zza, zzbvn);
        zzbr(18, zza);
    }

    public final void zzo(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzbr(19, zza);
    }

    public final void zzp(String str, String str2, zzbdk zzbdk, IObjectWrapper iObjectWrapper, zzbxl zzbxl, zzbvn zzbvn) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzhu.zzd(zza, zzbdk);
        zzhu.zzf(zza, iObjectWrapper);
        zzhu.zzf(zza, zzbxl);
        zzhu.zzf(zza, zzbvn);
        zzbr(20, zza);
    }

    public final void zzq(String str, String str2, zzbdk zzbdk, IObjectWrapper iObjectWrapper, zzbxc zzbxc, zzbvn zzbvn, zzbdp zzbdp) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzhu.zzd(zza, zzbdk);
        zzhu.zzf(zza, iObjectWrapper);
        zzhu.zzf(zza, zzbxc);
        zzhu.zzf(zza, zzbvn);
        zzhu.zzd(zza, zzbdp);
        zzbr(21, zza);
    }

    public final void zzr(String str, String str2, zzbdk zzbdk, IObjectWrapper iObjectWrapper, zzbxi zzbxi, zzbvn zzbvn, zzblw zzblw) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzhu.zzd(zza, zzbdk);
        zzhu.zzf(zza, iObjectWrapper);
        zzhu.zzf(zza, zzbxi);
        zzhu.zzf(zza, zzbvn);
        zzhu.zzd(zza, zzblw);
        zzbr(22, zza);
    }
}
