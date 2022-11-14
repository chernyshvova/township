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
public final class zzbvt extends zzhs implements IInterface {
    public zzbvt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
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

    public final String zzj() throws RemoteException {
        Parcel zzbq = zzbq(7, zza());
        String readString = zzbq.readString();
        zzbq.recycle();
        return readString;
    }

    public final void zzk() throws RemoteException {
        zzbr(8, zza());
    }

    public final void zzl(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzbr(9, zza);
    }

    public final void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzbr(10, zza);
    }

    public final boolean zzn() throws RemoteException {
        Parcel zzbq = zzbq(11, zza());
        boolean zza = zzhu.zza(zzbq);
        zzbq.recycle();
        return zza;
    }

    public final boolean zzo() throws RemoteException {
        Parcel zzbq = zzbq(12, zza());
        boolean zza = zzhu.zza(zzbq);
        zzbq.recycle();
        return zza;
    }

    public final Bundle zzp() throws RemoteException {
        Parcel zzbq = zzbq(13, zza());
        Bundle bundle = (Bundle) zzhu.zzc(zzbq, Bundle.CREATOR);
        zzbq.recycle();
        return bundle;
    }

    public final void zzq(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzbr(14, zza);
    }

    public final IObjectWrapper zzr() throws RemoteException {
        return GeneratedOutlineSupport.outline8(zzbq(15, zza()));
    }

    public final zzbhg zzs() throws RemoteException {
        Parcel zzbq = zzbq(16, zza());
        zzbhg zzb = zzbhf.zzb(zzbq.readStrongBinder());
        zzbq.recycle();
        return zzb;
    }

    public final zzbma zzt() throws RemoteException {
        Parcel zzbq = zzbq(19, zza());
        zzbma zzj = zzblz.zzj(zzbq.readStrongBinder());
        zzbq.recycle();
        return zzj;
    }

    public final IObjectWrapper zzu() throws RemoteException {
        return GeneratedOutlineSupport.outline8(zzbq(20, zza()));
    }

    public final IObjectWrapper zzv() throws RemoteException {
        return GeneratedOutlineSupport.outline8(zzbq(21, zza()));
    }

    public final void zzw(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzhu.zzf(zza, iObjectWrapper2);
        zzhu.zzf(zza, iObjectWrapper3);
        zzbr(22, zza);
    }
}
