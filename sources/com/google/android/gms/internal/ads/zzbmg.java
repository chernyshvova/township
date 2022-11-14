package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbmg extends zzhs implements zzbmi {
    public zzbmg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    public final IObjectWrapper zzb() throws RemoteException {
        return GeneratedOutlineSupport.outline8(zzbq(1, zza()));
    }

    public final Uri zzc() throws RemoteException {
        Parcel zzbq = zzbq(2, zza());
        Uri uri = (Uri) zzhu.zzc(zzbq, Uri.CREATOR);
        zzbq.recycle();
        return uri;
    }

    public final double zzd() throws RemoteException {
        Parcel zzbq = zzbq(3, zza());
        double readDouble = zzbq.readDouble();
        zzbq.recycle();
        return readDouble;
    }

    public final int zze() throws RemoteException {
        Parcel zzbq = zzbq(4, zza());
        int readInt = zzbq.readInt();
        zzbq.recycle();
        return readInt;
    }

    public final int zzf() throws RemoteException {
        Parcel zzbq = zzbq(5, zza());
        int readInt = zzbq.readInt();
        zzbq.recycle();
        return readInt;
    }
}
