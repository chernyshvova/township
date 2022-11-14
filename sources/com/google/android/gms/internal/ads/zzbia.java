package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbia extends RemoteCreator<zzbgj> {
    public zzbia() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    public final /* bridge */ /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
        if (queryLocalInterface instanceof zzbgj) {
            return (zzbgj) queryLocalInterface;
        }
        return new zzbgj(iBinder);
    }

    public final zzbgi zza(Context context) {
        zzbgi zzbgg;
        try {
            IBinder zze = ((zzbgj) getRemoteCreatorInstance(context)).zze(ObjectWrapper.wrap(context), 212104000);
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (queryLocalInterface instanceof zzbgi) {
                zzbgg = (zzbgi) queryLocalInterface;
            } else {
                zzbgg = new zzbgg(zze);
            }
            return zzbgg;
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzcgs.zzj("Could not get remote MobileAdsSettingManager.", e);
            return null;
        }
    }
}
