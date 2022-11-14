package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbzo extends RemoteCreator<zzbzu> {
    public zzbzo() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public final /* bridge */ /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        if (queryLocalInterface instanceof zzbzu) {
            return (zzbzu) queryLocalInterface;
        }
        return new zzbzs(iBinder);
    }

    public final zzbzr zza(Activity activity) {
        zzbzr zzbzp;
        try {
            IBinder zze = ((zzbzu) getRemoteCreatorInstance(activity)).zze(ObjectWrapper.wrap(activity));
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            if (queryLocalInterface instanceof zzbzr) {
                zzbzp = (zzbzr) queryLocalInterface;
            } else {
                zzbzp = new zzbzp(zze);
            }
            return zzbzp;
        } catch (RemoteException e) {
            zzcgs.zzj("Could not create remote AdOverlay.", e);
            return null;
        } catch (RemoteCreator.RemoteCreatorException e2) {
            zzcgs.zzj("Could not create remote AdOverlay.", e2);
            return null;
        }
    }
}
