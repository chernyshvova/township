package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbnk extends zzhs implements zzbnm {
    public zzbnk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
    }

    public final void zze(zzbnc zzbnc, String str) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, zzbnc);
        zza.writeString(str);
        zzbr(1, zza);
    }
}
