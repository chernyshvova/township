package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbdj extends RemoteCreator<zzbfs> {
    public zzcau zza;

    @VisibleForTesting
    public zzbdj() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public final /* bridge */ /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        if (queryLocalInterface instanceof zzbfs) {
            return (zzbfs) queryLocalInterface;
        }
        return new zzbfs(iBinder);
    }

    public final zzbfr zza(Context context, zzbdp zzbdp, String str, zzbvh zzbvh, int i) {
        zzbfr zzbfp;
        zzbfr zzbfp2;
        zzbjn.zza(context);
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzgG)).booleanValue()) {
            try {
                IBinder zze = ((zzbfs) zzcgw.zza(context, "com.google.android.gms.ads.ChimeraAdManagerCreatorImpl", zzbdi.zza)).zze(ObjectWrapper.wrap(context), zzbdp, str, zzbvh, 212104000, i);
                if (zze == null) {
                    return null;
                }
                IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
                if (queryLocalInterface instanceof zzbfr) {
                    zzbfp2 = (zzbfr) queryLocalInterface;
                } else {
                    zzbfp2 = new zzbfp(zze);
                }
                return zzbfp2;
            } catch (RemoteException | zzcgv | NullPointerException e) {
                zzcau zza2 = zzcas.zza(context);
                this.zza = zza2;
                zza2.zzd(e, "AdManagerCreator.newAdManagerByDynamiteLoader");
                zzcgs.zzl("#007 Could not call remote method.", e);
                return null;
            }
        } else {
            try {
                IBinder zze2 = ((zzbfs) getRemoteCreatorInstance(context)).zze(ObjectWrapper.wrap(context), zzbdp, str, zzbvh, 212104000, i);
                if (zze2 == null) {
                    return null;
                }
                IInterface queryLocalInterface2 = zze2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
                if (queryLocalInterface2 instanceof zzbfr) {
                    zzbfp = (zzbfr) queryLocalInterface2;
                } else {
                    zzbfp = new zzbfp(zze2);
                }
                return zzbfp;
            } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
                zzcgs.zze("Could not create remote AdManager.", e2);
                return null;
            }
        }
    }
}
