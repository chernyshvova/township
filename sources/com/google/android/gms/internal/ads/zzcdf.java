package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzcdf {
    public static final zzcct zza(Context context, String str, zzbvh zzbvh) {
        zzcct zzccr;
        try {
            IBinder zze = ((zzccx) zzcgw.zza(context, "com.google.android.gms.ads.rewarded.ChimeraRewardedAdCreatorImpl", zzcde.zza)).zze(ObjectWrapper.wrap(context), str, zzbvh, 212104000);
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
            if (queryLocalInterface instanceof zzcct) {
                zzccr = (zzcct) queryLocalInterface;
            } else {
                zzccr = new zzccr(zze);
            }
            return zzccr;
        } catch (RemoteException | zzcgv e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
            return null;
        }
    }
}
