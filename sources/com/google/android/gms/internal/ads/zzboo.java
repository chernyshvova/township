package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.formats.OnAdManagerAdViewLoadedListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzboo extends zzbns {
    public final OnAdManagerAdViewLoadedListener zza;

    public zzboo(OnAdManagerAdViewLoadedListener onAdManagerAdViewLoadedListener) {
        this.zza = onAdManagerAdViewLoadedListener;
    }

    public final void zze(zzbfr zzbfr, IObjectWrapper iObjectWrapper) {
        if (zzbfr != null && iObjectWrapper != null) {
            AdManagerAdView adManagerAdView = new AdManagerAdView((Context) ObjectWrapper.unwrap(iObjectWrapper));
            AppEventListener appEventListener = null;
            try {
                if (zzbfr.zzw() instanceof zzbdf) {
                    zzbdf zzbdf = (zzbdf) zzbfr.zzw();
                    adManagerAdView.setAdListener(zzbdf != null ? zzbdf.zzj() : null);
                }
            } catch (RemoteException e) {
                zzcgs.zzg("", e);
            }
            try {
                if (zzbfr.zzv() instanceof zzawn) {
                    zzawn zzawn = (zzawn) zzbfr.zzv();
                    if (zzawn != null) {
                        appEventListener = zzawn.zzc();
                    }
                    adManagerAdView.setAppEventListener(appEventListener);
                }
            } catch (RemoteException e2) {
                zzcgs.zzg("", e2);
            }
            zzcgl.zza.post(new zzbon(this, adManagerAdView, zzbfr));
        }
    }
}
