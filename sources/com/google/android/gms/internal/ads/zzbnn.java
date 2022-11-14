package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbnn extends zzhs implements zzbnp {
    public zzbnn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
    }

    public final void zze(zzbnc zzbnc) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, zzbnc);
        zzbr(1, zza);
    }
}
