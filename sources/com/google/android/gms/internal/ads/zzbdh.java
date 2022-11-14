package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbdh extends RemoteCreator<zzbfo> {
    public zzbdh() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    public final /* bridge */ /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
        if (queryLocalInterface instanceof zzbfo) {
            return (zzbfo) queryLocalInterface;
        }
        return new zzbfo(iBinder);
    }

    public final zzbfn zza(Context context, String str, zzbvh zzbvh) {
        zzbfn zzbfl;
        try {
            IBinder zze = ((zzbfo) getRemoteCreatorInstance(context)).zze(ObjectWrapper.wrap(context), str, zzbvh, 212104000);
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (queryLocalInterface instanceof zzbfn) {
                zzbfl = (zzbfn) queryLocalInterface;
            } else {
                zzbfl = new zzbfl(zze);
            }
            return zzbfl;
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzcgs.zzj("Could not create remote builder for AdLoader.", e);
            return null;
        }
    }
}
