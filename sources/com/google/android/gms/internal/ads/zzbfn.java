package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public interface zzbfn extends IInterface {
    zzbfk zze() throws RemoteException;

    void zzf(zzbfe zzbfe) throws RemoteException;

    void zzg(zzbng zzbng) throws RemoteException;

    void zzh(zzbnj zzbnj) throws RemoteException;

    void zzi(String str, zzbnp zzbnp, @Nullable zzbnm zzbnm) throws RemoteException;

    void zzj(zzblw zzblw) throws RemoteException;

    void zzk(zzbnt zzbnt, zzbdp zzbdp) throws RemoteException;

    void zzl(PublisherAdViewOptions publisherAdViewOptions) throws RemoteException;

    void zzm(zzbnw zzbnw) throws RemoteException;

    void zzn(zzbry zzbry) throws RemoteException;

    void zzo(zzbsh zzbsh) throws RemoteException;

    void zzp(AdManagerAdViewOptions adManagerAdViewOptions) throws RemoteException;

    void zzq(zzbgc zzbgc) throws RemoteException;
}
