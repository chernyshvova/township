package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzboh extends RemoteCreator<zzbmp> {
    @VisibleForTesting
    public zzboh() {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    public final /* bridge */ /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
        if (queryLocalInterface instanceof zzbmp) {
            return (zzbmp) queryLocalInterface;
        }
        return new zzbmn(iBinder);
    }

    public final zzbmm zza(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        zzbmm zzbmk;
        try {
            IBinder zze = ((zzbmp) getRemoteCreatorInstance(context)).zze(ObjectWrapper.wrap(context), ObjectWrapper.wrap(frameLayout), ObjectWrapper.wrap(frameLayout2), 212104000);
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
            if (queryLocalInterface instanceof zzbmm) {
                zzbmk = (zzbmm) queryLocalInterface;
            } else {
                zzbmk = new zzbmk(zze);
            }
            return zzbmk;
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzcgs.zzj("Could not create remote NativeAdViewDelegate.", e);
            return null;
        }
    }
}
