package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbvu extends zzhs implements zzbvw {
    public zzbvu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
    }

    public final float zzA() throws RemoteException {
        Parcel zzbq = zzbq(24, zza());
        float readFloat = zzbq.readFloat();
        zzbq.recycle();
        return readFloat;
    }

    public final float zzB() throws RemoteException {
        Parcel zzbq = zzbq(25, zza());
        float readFloat = zzbq.readFloat();
        zzbq.recycle();
        return readFloat;
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

    public final double zzk() throws RemoteException {
        Parcel zzbq = zzbq(8, zza());
        double readDouble = zzbq.readDouble();
        zzbq.recycle();
        return readDouble;
    }

    public final String zzl() throws RemoteException {
        Parcel zzbq = zzbq(9, zza());
        String readString = zzbq.readString();
        zzbq.recycle();
        return readString;
    }

    public final String zzm() throws RemoteException {
        Parcel zzbq = zzbq(10, zza());
        String readString = zzbq.readString();
        zzbq.recycle();
        return readString;
    }

    public final zzbhg zzn() throws RemoteException {
        Parcel zzbq = zzbq(11, zza());
        zzbhg zzb = zzbhf.zzb(zzbq.readStrongBinder());
        zzbq.recycle();
        return zzb;
    }

    public final zzbma zzo() throws RemoteException {
        Parcel zzbq = zzbq(12, zza());
        zzbma zzj = zzblz.zzj(zzbq.readStrongBinder());
        zzbq.recycle();
        return zzj;
    }

    public final IObjectWrapper zzp() throws RemoteException {
        return GeneratedOutlineSupport.outline8(zzbq(13, zza()));
    }

    public final IObjectWrapper zzq() throws RemoteException {
        return GeneratedOutlineSupport.outline8(zzbq(14, zza()));
    }

    public final IObjectWrapper zzr() throws RemoteException {
        return GeneratedOutlineSupport.outline8(zzbq(15, zza()));
    }

    public final Bundle zzs() throws RemoteException {
        Parcel zzbq = zzbq(16, zza());
        Bundle bundle = (Bundle) zzhu.zzc(zzbq, Bundle.CREATOR);
        zzbq.recycle();
        return bundle;
    }

    public final boolean zzt() throws RemoteException {
        Parcel zzbq = zzbq(17, zza());
        boolean zza = zzhu.zza(zzbq);
        zzbq.recycle();
        return zza;
    }

    public final boolean zzu() throws RemoteException {
        Parcel zzbq = zzbq(18, zza());
        boolean zza = zzhu.zza(zzbq);
        zzbq.recycle();
        return zza;
    }

    public final void zzv() throws RemoteException {
        zzbr(19, zza());
    }

    public final void zzw(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzbr(20, zza);
    }

    public final void zzx(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzhu.zzf(zza, iObjectWrapper2);
        zzhu.zzf(zza, iObjectWrapper3);
        zzbr(21, zza);
    }

    public final void zzy(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzbr(22, zza);
    }

    public final float zzz() throws RemoteException {
        Parcel zzbq = zzbq(23, zza());
        float readFloat = zzbq.readFloat();
        zzbq.recycle();
        return readFloat;
    }
}
