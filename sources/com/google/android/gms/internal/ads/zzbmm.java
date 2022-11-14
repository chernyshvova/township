package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public interface zzbmm extends IInterface {
    void zzb(String str, IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzbM(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzbN(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzbO(@Nullable zzbmf zzbmf) throws RemoteException;

    IObjectWrapper zzc(String str) throws RemoteException;

    void zzd(@Nullable IObjectWrapper iObjectWrapper) throws RemoteException;

    void zze() throws RemoteException;

    void zzf(IObjectWrapper iObjectWrapper, int i) throws RemoteException;

    void zzg(IObjectWrapper iObjectWrapper) throws RemoteException;
}
