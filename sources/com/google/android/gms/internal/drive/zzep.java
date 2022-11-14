package com.google.android.gms.internal.drive;

import android.content.IntentSender;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzep extends zza implements zzeo {
    public zzep(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.drive.internal.IDriveService");
    }

    public final void zza(zzek zzek, zzeq zzeq) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzek);
        zzc.zza(zza, (IInterface) zzeq);
        zzb(1, zza);
    }

    public final void zzb(zzeq zzeq) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzeq);
        zzb(35, zza);
    }

    public final void zza(zzgq zzgq, zzeq zzeq) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzgq);
        zzc.zza(zza, (IInterface) zzeq);
        zzb(2, zza);
    }

    public final void zza(zzhf zzhf, zzeq zzeq) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzhf);
        zzc.zza(zza, (IInterface) zzeq);
        zzb(3, zza);
    }

    public final void zza(zzr zzr, zzeq zzeq) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzr);
        zzc.zza(zza, (IInterface) zzeq);
        zzb(4, zza);
    }

    public final void zza(zzw zzw, zzeq zzeq) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzw);
        zzc.zza(zza, (IInterface) zzeq);
        zzb(5, zza);
    }

    public final void zza(zzy zzy, zzeq zzeq) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzy);
        zzc.zza(zza, (IInterface) zzeq);
        zzb(6, zza);
    }

    public final zzec zza(zzgj zzgj, zzeq zzeq) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzgj);
        zzc.zza(zza, (IInterface) zzeq);
        Parcel zza2 = zza(7, zza);
        zzec zzec = (zzec) zzc.zza(zza2, zzec.CREATOR);
        zza2.recycle();
        return zzec;
    }

    public final void zza(zzo zzo, zzeq zzeq) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzo);
        zzc.zza(zza, (IInterface) zzeq);
        zzb(8, zza);
    }

    public final void zza(zzeq zzeq) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzeq);
        zzb(9, zza);
    }

    public final IntentSender zza(zzgm zzgm) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzgm);
        Parcel zza2 = zza(10, zza);
        IntentSender intentSender = (IntentSender) zzc.zza(zza2, IntentSender.CREATOR);
        zza2.recycle();
        return intentSender;
    }

    public final IntentSender zza(zzu zzu) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzu);
        Parcel zza2 = zza(11, zza);
        IntentSender intentSender = (IntentSender) zzc.zza(zza2, IntentSender.CREATOR);
        zza2.recycle();
        return intentSender;
    }

    public final void zza(zzex zzex, zzeq zzeq) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzex);
        zzc.zza(zza, (IInterface) zzeq);
        zzb(13, zza);
    }

    public final void zza(zzj zzj, zzes zzes, String str, zzeq zzeq) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzj);
        zzc.zza(zza, (IInterface) zzes);
        zza.writeString((String) null);
        zzc.zza(zza, (IInterface) zzeq);
        zzb(14, zza);
    }

    public final void zza(zzgs zzgs, zzes zzes, String str, zzeq zzeq) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzgs);
        zzc.zza(zza, (IInterface) zzes);
        zza.writeString((String) null);
        zzc.zza(zza, (IInterface) zzeq);
        zzb(15, zza);
    }

    public final void zza(zzad zzad) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzad);
        zzb(16, zza);
    }

    public final void zza(zzhb zzhb, zzeq zzeq) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzhb);
        zzc.zza(zza, (IInterface) zzeq);
        zzb(17, zza);
    }

    public final void zza(zzm zzm, zzeq zzeq) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzm);
        zzc.zza(zza, (IInterface) zzeq);
        zzb(18, zza);
    }

    public final void zza(zzab zzab, zzeq zzeq) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzab);
        zzc.zza(zza, (IInterface) zzeq);
        zzb(24, zza);
    }

    public final void zza(zzgw zzgw, zzeq zzeq) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzgw);
        zzc.zza(zza, (IInterface) zzeq);
        zzb(28, zza);
    }

    public final void zza(zzgu zzgu, zzeq zzeq) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzgu);
        zzc.zza(zza, (IInterface) zzeq);
        zzb(36, zza);
    }

    public final void zza(zzhd zzhd, zzeq zzeq) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzhd);
        zzc.zza(zza, (IInterface) zzeq);
        zzb(38, zza);
    }
}
