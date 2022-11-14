package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbvl extends zzhs implements zzbvn {
    public zzbvl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public final void zze() throws RemoteException {
        zzbr(1, zza());
    }

    public final void zzf() throws RemoteException {
        zzbr(2, zza());
    }

    public final void zzg(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzbr(3, zza);
    }

    public final void zzh() throws RemoteException {
        zzbr(4, zza());
    }

    public final void zzi() throws RemoteException {
        zzbr(5, zza());
    }

    public final void zzj() throws RemoteException {
        zzbr(6, zza());
    }

    public final void zzk() throws RemoteException {
        zzbr(8, zza());
    }

    public final void zzl(String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbr(9, zza);
    }

    public final void zzm(zzbnc zzbnc, String str) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, zzbnc);
        zza.writeString(str);
        zzbr(10, zza);
    }

    public final void zzn() throws RemoteException {
        zzbr(11, zza());
    }

    public final void zzo() throws RemoteException {
        zzbr(13, zza());
    }

    public final void zzp(zzccm zzccm) throws RemoteException {
        throw null;
    }

    public final void zzq() throws RemoteException {
        zzbr(15, zza());
    }

    public final void zzr(zzccq zzccq) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, zzccq);
        zzbr(16, zza);
    }

    public final void zzs(int i) throws RemoteException {
        throw null;
    }

    public final void zzt() throws RemoteException {
        zzbr(18, zza());
    }

    public final void zzu() throws RemoteException {
        zzbr(20, zza());
    }

    public final void zzv(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzbr(21, zza);
    }

    public final void zzw(int i, String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zza.writeString(str);
        zzbr(22, zza);
    }

    public final void zzx(zzbdd zzbdd) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, zzbdd);
        zzbr(23, zza);
    }

    public final void zzy(zzbdd zzbdd) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, zzbdd);
        zzbr(24, zza);
    }
}
