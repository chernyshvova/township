package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.video.VideoCapabilities;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public interface zzav extends IInterface {
    void zzb(int i, String str) throws RemoteException;

    void zzc(DataHolder dataHolder) throws RemoteException;

    void zzd(int i) throws RemoteException;

    void zze(int i, Bundle bundle) throws RemoteException;

    void zzf(DataHolder dataHolder) throws RemoteException;

    void zzg(DataHolder dataHolder) throws RemoteException;

    void zzh(DataHolder dataHolder, DataHolder dataHolder2) throws RemoteException;

    void zzi(DataHolder dataHolder) throws RemoteException;

    void zzj(DataHolder dataHolder) throws RemoteException;

    void zzk(DataHolder dataHolder) throws RemoteException;

    void zzl(DataHolder dataHolder) throws RemoteException;

    void zzm(DataHolder dataHolder) throws RemoteException;

    void zzn(Status status, @Nullable String str) throws RemoteException;

    void zzo() throws RemoteException;

    void zzp(DataHolder dataHolder) throws RemoteException;

    void zzq(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) throws RemoteException;

    void zzr(int i, String str) throws RemoteException;

    void zzs(DataHolder dataHolder, Contents contents) throws RemoteException;

    void zzt(DataHolder dataHolder) throws RemoteException;

    void zzu(int i, boolean z) throws RemoteException;

    void zzv(int i, VideoCapabilities videoCapabilities) throws RemoteException;
}
