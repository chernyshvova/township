package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public interface zzfed extends IInterface {
    boolean zze(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzf(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzg(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;

    @Nullable
    String zzh() throws RemoteException;

    void zzi(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzj(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;

    @Nullable
    IObjectWrapper zzk(String str, IObjectWrapper iObjectWrapper, String str2, String str3, @Nullable String str4, String str5) throws RemoteException;

    @Nullable
    IObjectWrapper zzl(String str, IObjectWrapper iObjectWrapper, String str2, String str3, @Nullable String str4, String str5, String str6, String str7, @Nullable String str8) throws RemoteException;

    @Nullable
    IObjectWrapper zzm(String str, IObjectWrapper iObjectWrapper, String str2, String str3, @Nullable String str4, String str5, String str6, String str7, @Nullable String str8) throws RemoteException;
}
