package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class zzamr extends zzht implements zzams {
    public static zzams zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.clearcut.IClearcut");
        if (queryLocalInterface instanceof zzams) {
            return (zzams) queryLocalInterface;
        }
        return new zzamq(iBinder);
    }
}
