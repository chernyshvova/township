package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzboi extends RemoteCreator<zzbmv> {
    @VisibleForTesting
    public zzboi() {
        super("com.google.android.gms.ads.NativeAdViewHolderDelegateCreatorImpl");
    }

    public final /* bridge */ /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegateCreator");
        if (queryLocalInterface instanceof zzbmv) {
            return (zzbmv) queryLocalInterface;
        }
        return new zzbmt(iBinder);
    }

    public final zzbms zza(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        zzbms zzbmq;
        try {
            IBinder zze = ((zzbmv) getRemoteCreatorInstance(view.getContext())).zze(ObjectWrapper.wrap(view), ObjectWrapper.wrap(hashMap), ObjectWrapper.wrap(hashMap2));
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
            if (queryLocalInterface instanceof zzbms) {
                zzbmq = (zzbms) queryLocalInterface;
            } else {
                zzbmq = new zzbmq(zze);
            }
            return zzbmq;
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzcgs.zzj("Could not create remote NativeAdViewHolderDelegate.", e);
            return null;
        }
    }
}
