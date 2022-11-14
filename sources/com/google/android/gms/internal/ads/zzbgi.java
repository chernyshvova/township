package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public interface zzbgi extends IInterface {
    void zze() throws RemoteException;

    void zzf(float f) throws RemoteException;

    void zzg(String str) throws RemoteException;

    void zzh(boolean z) throws RemoteException;

    void zzi(IObjectWrapper iObjectWrapper, String str) throws RemoteException;

    void zzj(@Nullable String str, IObjectWrapper iObjectWrapper) throws RemoteException;

    float zzk() throws RemoteException;

    boolean zzl() throws RemoteException;

    String zzm() throws RemoteException;

    void zzn(@Nullable String str) throws RemoteException;

    void zzo(zzbvh zzbvh) throws RemoteException;

    void zzp(zzbrt zzbrt) throws RemoteException;

    List<zzbrm> zzq() throws RemoteException;

    void zzr(zzbip zzbip) throws RemoteException;

    void zzs() throws RemoteException;

    void zzt(zzbgu zzbgu) throws RemoteException;
}
