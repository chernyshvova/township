package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbmd extends zzhs implements zzbmf {
    public zzbmd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    public final float zze() throws RemoteException {
        Parcel zzbq = zzbq(2, zza());
        float readFloat = zzbq.readFloat();
        zzbq.recycle();
        return readFloat;
    }

    public final void zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzbr(3, zza);
    }

    public final IObjectWrapper zzg() throws RemoteException {
        return GeneratedOutlineSupport.outline8(zzbq(4, zza()));
    }

    public final float zzh() throws RemoteException {
        Parcel zzbq = zzbq(5, zza());
        float readFloat = zzbq.readFloat();
        zzbq.recycle();
        return readFloat;
    }

    public final float zzi() throws RemoteException {
        Parcel zzbq = zzbq(6, zza());
        float readFloat = zzbq.readFloat();
        zzbq.recycle();
        return readFloat;
    }

    public final zzbhg zzj() throws RemoteException {
        Parcel zzbq = zzbq(7, zza());
        zzbhg zzb = zzbhf.zzb(zzbq.readStrongBinder());
        zzbq.recycle();
        return zzb;
    }

    public final boolean zzk() throws RemoteException {
        Parcel zzbq = zzbq(8, zza());
        boolean zza = zzhu.zza(zzbq);
        zzbq.recycle();
        return zza;
    }

    public final void zzl(zzbnq zzbnq) throws RemoteException {
        throw null;
    }
}
