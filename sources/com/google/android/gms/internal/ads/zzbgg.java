package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbgg extends zzhs implements zzbgi {
    public zzbgg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    public final void zze() throws RemoteException {
        zzbr(1, zza());
    }

    public final void zzf(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zzbr(2, zza);
    }

    public final void zzg(String str) throws RemoteException {
        throw null;
    }

    public final void zzh(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzb(zza, z);
        zzbr(4, zza);
    }

    public final void zzi(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zza.writeString(str);
        zzbr(5, zza);
    }

    public final void zzj(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zza.writeString((String) null);
        zzhu.zzf(zza, iObjectWrapper);
        zzbr(6, zza);
    }

    public final float zzk() throws RemoteException {
        Parcel zzbq = zzbq(7, zza());
        float readFloat = zzbq.readFloat();
        zzbq.recycle();
        return readFloat;
    }

    public final boolean zzl() throws RemoteException {
        Parcel zzbq = zzbq(8, zza());
        boolean zza = zzhu.zza(zzbq);
        zzbq.recycle();
        return zza;
    }

    public final String zzm() throws RemoteException {
        Parcel zzbq = zzbq(9, zza());
        String readString = zzbq.readString();
        zzbq.recycle();
        return readString;
    }

    public final void zzn(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzbr(10, zza);
    }

    public final void zzo(zzbvh zzbvh) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, zzbvh);
        zzbr(11, zza);
    }

    public final void zzp(zzbrt zzbrt) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, zzbrt);
        zzbr(12, zza);
    }

    public final List<zzbrm> zzq() throws RemoteException {
        Parcel zzbq = zzbq(13, zza());
        ArrayList<zzbrm> createTypedArrayList = zzbq.createTypedArrayList(zzbrm.CREATOR);
        zzbq.recycle();
        return createTypedArrayList;
    }

    public final void zzr(zzbip zzbip) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, zzbip);
        zzbr(14, zza);
    }

    public final void zzs() throws RemoteException {
        zzbr(15, zza());
    }

    public final void zzt(zzbgu zzbgu) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, zzbgu);
        zzbr(16, zza);
    }
}
