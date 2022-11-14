package com.google.android.gms.games.internal;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.facebook.ads.AdError;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.internal.games_v2.zza;
import com.google.android.gms.internal.games_v2.zzc;
import com.playrix.gplay.GoogleGameCenter;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzay extends zza implements IInterface {
    public zzay(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.games.internal.IGamesService");
    }

    public final void zzA(zzav zzav, int i) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzav);
        zza.writeInt(i);
        zzc(22016, zza);
    }

    public final void zzB(zzav zzav, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzav);
        zzc.zzb(zza, z);
        zzc(AdError.MEDIAVIEW_MISSING_ERROR_CODE, zza);
    }

    public final void zzC(zzav zzav, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzav);
        zzc.zzb(zza, z);
        zzc(12016, zza);
    }

    public final void zzD(zzav zzav, boolean z, String[] strArr) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzav);
        zzc.zzb(zza, z);
        zza.writeStringArray(strArr);
        zzc(12031, zza);
    }

    public final void zzE(zzav zzav, String str, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzav);
        zza.writeString(str);
        zzc.zzb(zza, z);
        zzc(6504, zza);
    }

    public final void zzF(zzav zzav, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzav);
        zzc.zzb(zza, z);
        zzc(6503, zza);
    }

    public final void zzG(zzav zzav, Bundle bundle, int i, int i2) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzav);
        zzc.zzc(zza, bundle);
        zza.writeInt(i);
        zza.writeInt(i2);
        zzc(5021, zza);
    }

    public final void zzH(zzav zzav, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzav);
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeInt(i2);
        zza.writeInt(i3);
        zzc.zzb(zza, z);
        zzc(5020, zza);
    }

    public final void zzI(zzav zzav, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzav);
        zzc.zzb(zza, z);
        zzc(17001, zza);
    }

    public final void zzJ(zzav zzav, String str, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzav);
        zza.writeString(str);
        zzc.zzb(zza, z);
        zzc(13006, zza);
    }

    public final void zzK(zzav zzav, String str, int i, boolean z, boolean z2) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzav);
        zza.writeString(str);
        zza.writeInt(i);
        zzc.zzb(zza, z);
        zzc.zzb(zza, z2);
        zzc(9020, zza);
    }

    public final void zzL(zzav zzav, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzav);
        zzc.zzb(zza, z);
        zzc(12002, zza);
    }

    public final void zzM(zzav zzav, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzav);
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeInt(i2);
        zza.writeInt(i3);
        zzc.zzb(zza, z);
        zzc(5019, zza);
    }

    public final void zzN(zzav zzav, String str, boolean z, int i) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzav);
        zza.writeString(str);
        zzc.zzb(zza, z);
        zza.writeInt(i);
        zzc(15001, zza);
    }

    public final void zzO(zzav zzav, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzav);
        zza.writeLong(j);
        zzc(22026, zza);
    }

    public final void zzP(zzax zzax, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzax);
        zza.writeLong(j);
        zzc(15501, zza);
    }

    public final void zzQ(zzav zzav, String str, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzav);
        zza.writeString(str);
        zzc.zzb(zza, z);
        zzc(27003, zza);
    }

    public final void zzR(zzav zzav, String str, String str2, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzav);
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zzc(zza, snapshotMetadataChangeEntity);
        zzc.zzc(zza, contents);
        zzc(12033, zza);
    }

    public final void zzS(zzav zzav, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzav);
        zza.writeString(str);
        zza.writeStrongBinder(iBinder);
        zzc.zzc(zza, bundle);
        zzc(5023, zza);
    }

    public final void zzT(zzav zzav, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzav);
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeStrongBinder(iBinder);
        zzc.zzc(zza, bundle);
        zzc(AdError.CLEAR_TEXT_SUPPORT_NOT_ALLOWED, zza);
    }

    public final void zzU(IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeStrongBinder(iBinder);
        zzc.zzc(zza, bundle);
        zzc(5005, zza);
    }

    public final void zzV(zzav zzav) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzav);
        zzc(5002, zza);
    }

    public final void zzW(zzav zzav, String str, long j, String str2) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzav);
        zza.writeString(str);
        zza.writeLong(j);
        zza.writeString(str2);
        zzc(AdError.LOAD_CALLED_WHILE_SHOWING_AD, zza);
    }

    public final void zzX(zzav zzav, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzav);
        zza.writeString(str);
        zza.writeStrongBinder(iBinder);
        zzc.zzc(zza, bundle);
        zzc(5024, zza);
    }

    public final void zzY(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzc(22027, zza);
    }

    public final boolean zzZ() throws RemoteException {
        Parcel zzb = zzb(22030, zza());
        boolean zzf = zzc.zzf(zzb);
        zzb.recycle();
        return zzf;
    }

    public final int zzd() throws RemoteException {
        Parcel zzb = zzb(12036, zza());
        int readInt = zzb.readInt();
        zzb.recycle();
        return readInt;
    }

    public final int zze() throws RemoteException {
        Parcel zzb = zzb(12035, zza());
        int readInt = zzb.readInt();
        zzb.recycle();
        return readInt;
    }

    public final PendingIntent zzf() throws RemoteException {
        Parcel zzb = zzb(25015, zza());
        PendingIntent pendingIntent = (PendingIntent) zzc.zza(zzb, PendingIntent.CREATOR);
        zzb.recycle();
        return pendingIntent;
    }

    public final Intent zzg() throws RemoteException {
        Parcel zzb = zzb(9005, zza());
        Intent intent = (Intent) zzc.zza(zzb, Intent.CREATOR);
        zzb.recycle();
        return intent;
    }

    public final Intent zzh() throws RemoteException {
        Parcel zzb = zzb(GoogleGameCenter.REQUEST_CODE_SHOW_ACHIEVEMENTS, zza());
        Intent intent = (Intent) zzc.zza(zzb, Intent.CREATOR);
        zzb.recycle();
        return intent;
    }

    public final Intent zzi(PlayerEntity playerEntity) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, playerEntity);
        Parcel zzb = zzb(15503, zza);
        Intent intent = (Intent) zzc.zza(zzb, Intent.CREATOR);
        zzb.recycle();
        return intent;
    }

    public final Intent zzj(String str, String str2, String str3) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeString(str3);
        Parcel zzb = zzb(25016, zza);
        Intent intent = (Intent) zzc.zza(zzb, Intent.CREATOR);
        zzb.recycle();
        return intent;
    }

    public final Intent zzk(String str, int i, int i2) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeInt(i2);
        Parcel zzb = zzb(18001, zza);
        Intent intent = (Intent) zzc.zza(zzb, Intent.CREATOR);
        zzb.recycle();
        return intent;
    }

    public final Intent zzl() throws RemoteException {
        Parcel zzb = zzb(9010, zza());
        Intent intent = (Intent) zzc.zza(zzb, Intent.CREATOR);
        zzb.recycle();
        return intent;
    }

    public final Intent zzm(String str, boolean z, boolean z2, int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zzb(zza, z);
        zzc.zzb(zza, z2);
        zza.writeInt(i);
        Parcel zzb = zzb(12001, zza);
        Intent intent = (Intent) zzc.zza(zzb, Intent.CREATOR);
        zzb.recycle();
        return intent;
    }

    public final Intent zzn() throws RemoteException {
        Parcel zzb = zzb(19002, zza());
        Intent intent = (Intent) zzc.zza(zzb, Intent.CREATOR);
        zzb.recycle();
        return intent;
    }

    public final DataHolder zzo() throws RemoteException {
        Parcel zzb = zzb(5013, zza());
        DataHolder dataHolder = (DataHolder) zzc.zza(zzb, DataHolder.CREATOR);
        zzb.recycle();
        return dataHolder;
    }

    public final String zzp() throws RemoteException {
        Parcel zzb = zzb(5012, zza());
        String readString = zzb.readString();
        zzb.recycle();
        return readString;
    }

    public final void zzq() throws RemoteException {
        zzc(5006, zza());
    }

    public final void zzr(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzc(5001, zza);
    }

    public final void zzs(zzav zzav, String str, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzav);
        zza.writeString(str);
        zzc.zzc(zza, snapshotMetadataChangeEntity);
        zzc.zzc(zza, contents);
        zzc(12007, zza);
    }

    public final void zzt(zzav zzav, String str) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzav);
        zza.writeString(str);
        zzc(12020, zza);
    }

    public final void zzu(Contents contents) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, contents);
        zzc(12019, zza);
    }

    public final void zzv(zzav zzav) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzav);
        zzc(22028, zza);
    }

    public final void zzw(zzav zzav, String str, String str2, int i, int i2) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzav);
        zza.writeString((String) null);
        zza.writeString(str2);
        zza.writeInt(i);
        zza.writeInt(i2);
        zzc(8001, zza);
    }

    public final void zzx(zzav zzav) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzav);
        zzc(21007, zza);
    }

    public final void zzy(zzav zzav, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzav);
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeStrongBinder(iBinder);
        zzc.zzc(zza, bundle);
        zzc(5025, zza);
    }

    public final void zzz(String str, int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeInt(i);
        zzc(12017, zza);
    }
}
