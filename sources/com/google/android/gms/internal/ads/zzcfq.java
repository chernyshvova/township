package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class zzcfq extends zzht implements zzcfr {
    public static zzcfr zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalGeneratorCreator");
        if (queryLocalInterface instanceof zzcfr) {
            return (zzcfr) queryLocalInterface;
        }
        return new zzcfp(iBinder);
    }
}
