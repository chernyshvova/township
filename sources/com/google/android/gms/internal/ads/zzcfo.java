package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public interface zzcfo extends IInterface {
    void zze(IObjectWrapper iObjectWrapper, zzcfs zzcfs, zzcfl zzcfl) throws RemoteException;

    void zzf(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzg(List<Uri> list, IObjectWrapper iObjectWrapper, zzcag zzcag) throws RemoteException;

    void zzh(List<Uri> list, IObjectWrapper iObjectWrapper, zzcag zzcag) throws RemoteException;

    void zzi(zzcan zzcan) throws RemoteException;

    void zzj(IObjectWrapper iObjectWrapper) throws RemoteException;
}
