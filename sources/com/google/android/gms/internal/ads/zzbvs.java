package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbvs extends zzhs implements IInterface {
    public zzbvs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
    }

    public final String zze() throws RemoteException {
        Parcel zzbq = zzbq(2, zza());
        String readString = zzbq.readString();
        zzbq.recycle();
        return readString;
    }

    public final List zzf() throws RemoteException {
        Parcel zzbq = zzbq(3, zza());
        ArrayList zzg = zzhu.zzg(zzbq);
        zzbq.recycle();
        return zzg;
    }

    public final String zzg() throws RemoteException {
        Parcel zzbq = zzbq(4, zza());
        String readString = zzbq.readString();
        zzbq.recycle();
        return readString;
    }

    public final zzbmi zzh() throws RemoteException {
        Parcel zzbq = zzbq(5, zza());
        zzbmi zzg = zzbmh.zzg(zzbq.readStrongBinder());
        zzbq.recycle();
        return zzg;
    }

    public final String zzi() throws RemoteException {
        Parcel zzbq = zzbq(6, zza());
        String readString = zzbq.readString();
        zzbq.recycle();
        return readString;
    }

    public final double zzj() throws RemoteException {
        Parcel zzbq = zzbq(7, zza());
        double readDouble = zzbq.readDouble();
        zzbq.recycle();
        return readDouble;
    }

    public final String zzk() throws RemoteException {
        Parcel zzbq = zzbq(8, zza());
        String readString = zzbq.readString();
        zzbq.recycle();
        return readString;
    }

    public final String zzl() throws RemoteException {
        Parcel zzbq = zzbq(9, zza());
        String readString = zzbq.readString();
        zzbq.recycle();
        return readString;
    }

    public final void zzm() throws RemoteException {
        zzbr(10, zza());
    }

    public final void zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzbr(11, zza);
    }

    public final void zzo(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzbr(12, zza);
    }

    public final boolean zzp() throws RemoteException {
        Parcel zzbq = zzbq(13, zza());
        boolean zza = zzhu.zza(zzbq);
        zzbq.recycle();
        return zza;
    }

    public final boolean zzq() throws RemoteException {
        Parcel zzbq = zzbq(14, zza());
        boolean zza = zzhu.zza(zzbq);
        zzbq.recycle();
        return zza;
    }

    public final Bundle zzr() throws RemoteException {
        Parcel zzbq = zzbq(15, zza());
        Bundle bundle = (Bundle) zzhu.zzc(zzbq, Bundle.CREATOR);
        zzbq.recycle();
        return bundle;
    }

    public final void zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzbr(16, zza);
    }

    public final zzbhg zzt() throws RemoteException {
        Parcel zzbq = zzbq(17, zza());
        zzbhg zzb = zzbhf.zzb(zzbq.readStrongBinder());
        zzbq.recycle();
        return zzb;
    }

    public final IObjectWrapper zzu() throws RemoteException {
        return GeneratedOutlineSupport.outline8(zzbq(18, zza()));
    }

    public final zzbma zzv() throws RemoteException {
        Parcel zzbq = zzbq(19, zza());
        zzbma zzj = zzblz.zzj(zzbq.readStrongBinder());
        zzbq.recycle();
        return zzj;
    }

    public final IObjectWrapper zzw() throws RemoteException {
        return GeneratedOutlineSupport.outline8(zzbq(20, zza()));
    }

    public final IObjectWrapper zzx() throws RemoteException {
        return GeneratedOutlineSupport.outline8(zzbq(21, zza()));
    }

    public final void zzy(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzhu.zzf(zza, iObjectWrapper2);
        zzhu.zzf(zza, iObjectWrapper3);
        zzbr(22, zza);
    }
}
