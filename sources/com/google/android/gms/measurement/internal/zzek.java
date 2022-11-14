package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zza;
import com.google.android.gms.internal.measurement.zzb;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzek extends zza implements zzei {
    public zzek(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public final void zza(zzaq zzaq, zzn zzn) throws RemoteException {
        Parcel a_ = mo30042a_();
        zzb.zza(a_, (Parcelable) zzaq);
        zzb.zza(a_, (Parcelable) zzn);
        zzb(1, a_);
    }

    public final void zzb(zzn zzn) throws RemoteException {
        Parcel a_ = mo30042a_();
        zzb.zza(a_, (Parcelable) zzn);
        zzb(6, a_);
    }

    public final String zzc(zzn zzn) throws RemoteException {
        Parcel a_ = mo30042a_();
        zzb.zza(a_, (Parcelable) zzn);
        Parcel zza = zza(11, a_);
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final void zzd(zzn zzn) throws RemoteException {
        Parcel a_ = mo30042a_();
        zzb.zza(a_, (Parcelable) zzn);
        zzb(18, a_);
    }

    public final void zze(zzn zzn) throws RemoteException {
        Parcel a_ = mo30042a_();
        zzb.zza(a_, (Parcelable) zzn);
        zzb(20, a_);
    }

    public final void zza(zzku zzku, zzn zzn) throws RemoteException {
        Parcel a_ = mo30042a_();
        zzb.zza(a_, (Parcelable) zzku);
        zzb.zza(a_, (Parcelable) zzn);
        zzb(2, a_);
    }

    public final void zza(zzn zzn) throws RemoteException {
        Parcel a_ = mo30042a_();
        zzb.zza(a_, (Parcelable) zzn);
        zzb(4, a_);
    }

    public final void zza(zzaq zzaq, String str, String str2) throws RemoteException {
        Parcel a_ = mo30042a_();
        zzb.zza(a_, (Parcelable) zzaq);
        a_.writeString(str);
        a_.writeString(str2);
        zzb(5, a_);
    }

    public final List<zzku> zza(zzn zzn, boolean z) throws RemoteException {
        Parcel a_ = mo30042a_();
        zzb.zza(a_, (Parcelable) zzn);
        zzb.zza(a_, z);
        Parcel zza = zza(7, a_);
        ArrayList<zzku> createTypedArrayList = zza.createTypedArrayList(zzku.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final byte[] zza(zzaq zzaq, String str) throws RemoteException {
        Parcel a_ = mo30042a_();
        zzb.zza(a_, (Parcelable) zzaq);
        a_.writeString(str);
        Parcel zza = zza(9, a_);
        byte[] createByteArray = zza.createByteArray();
        zza.recycle();
        return createByteArray;
    }

    public final void zza(long j, String str, String str2, String str3) throws RemoteException {
        Parcel a_ = mo30042a_();
        a_.writeLong(j);
        a_.writeString(str);
        a_.writeString(str2);
        a_.writeString(str3);
        zzb(10, a_);
    }

    public final void zza(zzz zzz, zzn zzn) throws RemoteException {
        Parcel a_ = mo30042a_();
        zzb.zza(a_, (Parcelable) zzz);
        zzb.zza(a_, (Parcelable) zzn);
        zzb(12, a_);
    }

    public final void zza(zzz zzz) throws RemoteException {
        Parcel a_ = mo30042a_();
        zzb.zza(a_, (Parcelable) zzz);
        zzb(13, a_);
    }

    public final List<zzku> zza(String str, String str2, boolean z, zzn zzn) throws RemoteException {
        Parcel a_ = mo30042a_();
        a_.writeString(str);
        a_.writeString(str2);
        zzb.zza(a_, z);
        zzb.zza(a_, (Parcelable) zzn);
        Parcel zza = zza(14, a_);
        ArrayList<zzku> createTypedArrayList = zza.createTypedArrayList(zzku.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final List<zzku> zza(String str, String str2, String str3, boolean z) throws RemoteException {
        Parcel a_ = mo30042a_();
        a_.writeString(str);
        a_.writeString(str2);
        a_.writeString(str3);
        zzb.zza(a_, z);
        Parcel zza = zza(15, a_);
        ArrayList<zzku> createTypedArrayList = zza.createTypedArrayList(zzku.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final List<zzz> zza(String str, String str2, zzn zzn) throws RemoteException {
        Parcel a_ = mo30042a_();
        a_.writeString(str);
        a_.writeString(str2);
        zzb.zza(a_, (Parcelable) zzn);
        Parcel zza = zza(16, a_);
        ArrayList<zzz> createTypedArrayList = zza.createTypedArrayList(zzz.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final List<zzz> zza(String str, String str2, String str3) throws RemoteException {
        Parcel a_ = mo30042a_();
        a_.writeString(str);
        a_.writeString(str2);
        a_.writeString(str3);
        Parcel zza = zza(17, a_);
        ArrayList<zzz> createTypedArrayList = zza.createTypedArrayList(zzz.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final void zza(Bundle bundle, zzn zzn) throws RemoteException {
        Parcel a_ = mo30042a_();
        zzb.zza(a_, (Parcelable) bundle);
        zzb.zza(a_, (Parcelable) zzn);
        zzb(19, a_);
    }
}
