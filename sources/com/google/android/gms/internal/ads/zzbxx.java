package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbxx implements SignalCallbacks {
    public final /* synthetic */ zzbxr zza;

    public zzbxx(zzbxz zzbxz, zzbxr zzbxr) {
        this.zza = zzbxr;
    }

    public final void onFailure(AdError adError) {
        try {
            this.zza.zzg(adError.zza());
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
        }
    }

    public final void onSuccess(String str) {
        try {
            this.zza.zze(str);
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
        }
    }

    public final void onFailure(String str) {
        try {
            this.zza.zzf(str);
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
        }
    }
}
